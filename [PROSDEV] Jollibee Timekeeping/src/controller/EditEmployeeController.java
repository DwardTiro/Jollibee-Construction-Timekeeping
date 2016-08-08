package controller;

import gui.EditEmployeeChangesPanel;
import gui.MainFrame;
import gui.PopBox;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminModel;
import model.CalendarModel;
import model.Employee;
import model.EmployeeDetailsAuditTrail;

public class EditEmployeeController implements Listen, PanelChanger {

    private static final EditEmployeeController editEmployeeController = new EditEmployeeController();
    private final MainFrame mainFrame;

    private final String PANEL_NAME = "editEmployeePanel";

    private ArrayList<EmployeeDetailsAuditTrail> auditTrails;
    private ArrayList<EditEmployeeChangesPanel> auditTrailPanels;

    private int viewID;

    private EditEmployeeController() {
        mainFrame = MainFrame.getInstance();

        auditTrails = new ArrayList<>();
        auditTrailPanels = new ArrayList<>();

        addListeners();
    }

    public static EditEmployeeController getInstance() {
        return EditEmployeeController.editEmployeeController;
    }

    @Override
    public final void addListeners() {
        mainFrame.getButtonEditEmployeeSaveChanges().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    if (!mainFrame.getTextFieldEditEmployeeIDNumber().getText().isEmpty()
                            && !mainFrame.getTextFieldEditEmployeeLastName().getText().isEmpty()
                            && !mainFrame.getTextFieldEditEmployeeFirstName().getText().isEmpty()
                            && !mainFrame.getTextFieldEditEmployeeMiddleName().getText().isEmpty()
                            && !mainFrame.getTextFieldEditEmployeeSalary().getText().isEmpty()) {

                        if (tryEditEmployee(Integer.parseInt(mainFrame.getTextFieldEditEmployeeIDNumber().getText()),
                                mainFrame.getTextFieldEditEmployeeLastName().getText(),
                                mainFrame.getTextFieldEditEmployeeFirstName().getText(),
                                mainFrame.getTextFieldEditEmployeeMiddleName().getText(),
                                Double.parseDouble(mainFrame.getTextFieldEditEmployeeSalary().getText()))) {
                            // success: notify user
                            ViewEmployeeController.getInstance().setViewID(viewID);
                            ViewEmployeeController.getInstance().showPanel();

                        } else {
                            refreshView();
                            PopBox.infoBox("Unable to edit", "");
                        }
                    }

                } catch (Exception ex) {
                    refreshView();
                    PopBox.infoBox("Unable to edit", "");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public void setViewID(int id) {
        this.viewID = id;
    }

    public void refreshView() {
        try {
            Employee toShow = Employee.getEmployeeByID(this.viewID);
            mainFrame.getTextFieldEditEmployeeIDNumber().setText(toShow.getIdNumber() + "");
            mainFrame.getTextFieldEditEmployeeFirstName().setText(toShow.getFname());
            mainFrame.getTextFieldEditEmployeeMiddleName().setText(toShow.getMname());
            mainFrame.getTextFieldEditEmployeeLastName().setText(toShow.getLname());
            mainFrame.getTextFieldEditEmployeeSalary().setText(toShow.getSalary() + "");

        } catch (SQLException ex) {
            Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void showPanel() {
        refreshView();
        CardLayout layout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        layout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);

        addAuditTrails();
    }

    private void addAuditTrails() {
        auditTrails = EmployeeDetailsAuditTrail.getEmployeeDetailsAuditTrailOfEmployee(viewID);

        auditTrailPanels = new ArrayList<>();
        int len = auditTrails.size();
        for (int i = 0; i < len; i++) {
            EditEmployeeChangesPanel panel = new EditEmployeeChangesPanel(auditTrails.get(i).getAttribute(), auditTrails.get(i).getOldValue(), auditTrails.get(i).getNewValue(), auditTrails.get(i).getDate(), auditTrails.get(i).getTime(), AdminModel.getAdminNameByID(auditTrails.get(i).getAdminID()));
            auditTrailPanels.add(panel);
            mainFrame.getPanelEditEmployeeChangesContainer().add(panel);
        }

        mainFrame.getPanelEditEmployeeChangesContainer().setPreferredSize(new Dimension(EditEmployeeChangesPanel.PANEL_WIDTH, EditEmployeeChangesPanel.PANEL_HEIGHT * len));

    }

    // returns true if successful in editing employee, false if there is a similar IDNumber in database
    private boolean tryEditEmployee(int IDNumber, String lastName, String firstName, String middleName, Double salary) throws SQLException, ParseException {
        boolean tryEdit = false;

        
            // for audit trail
            Employee curEmployee = Employee.getEmployeeByID(viewID);
            EmployeeDetailsAuditTrail audit;

            Date dateNow = new SimpleDateFormat("yyyy/MM/dd").parse(CalendarModel.getInstance().getYearToday() + "/" + CalendarModel.getInstance().getMonthToday() + "/" + CalendarModel.getInstance().getDayToday());

            DateFormat timeFormat = new SimpleDateFormat("h:mm a");
            Date timeNow = new Date();
            timeFormat.format(timeNow);

            if (!curEmployee.getFname().equalsIgnoreCase(firstName)) {
                audit = new EmployeeDetailsAuditTrail(curEmployee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_FIRST_NAME, curEmployee.getFname(), firstName, dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                audit.addAuditTrail();
            }
            if (!curEmployee.getLname().equalsIgnoreCase(lastName)) {
                audit = new EmployeeDetailsAuditTrail(curEmployee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_LAST_NAME, curEmployee.getLname(), lastName, dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                audit.addAuditTrail();
            }
            if (!curEmployee.getMname().equalsIgnoreCase(middleName)) {
                audit = new EmployeeDetailsAuditTrail(curEmployee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_MIDDLE_NAME, curEmployee.getMname(), middleName, dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                audit.addAuditTrail();
            }
            if (curEmployee.getSalary() != salary) {
                audit = new EmployeeDetailsAuditTrail(curEmployee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_SALARY, String.valueOf(curEmployee.getSalary()), String.valueOf(salary), dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                audit.addAuditTrail();
            }

            Employee.editEmployee(IDNumber, firstName, lastName, middleName, salary);
            tryEdit = true;



        // logic here
        return tryEdit;
    }
}
