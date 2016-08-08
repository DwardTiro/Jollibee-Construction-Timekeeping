package controller;

import gui.MainFrame;
import gui.PopBox;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Employee;

public class AddEmployeeController implements Listen, PanelChanger {

    private static final AddEmployeeController addEmployeeController = new AddEmployeeController();
    private final MainFrame mainFrame;

    private final String PANEL_NAME = "addEmployeePanel";

    private AddEmployeeController() {
        mainFrame = MainFrame.getInstance();

        addListeners();
    }

    public static AddEmployeeController getInstance() {
        return AddEmployeeController.addEmployeeController;
    }

    @Override
    public final void addListeners() {
        mainFrame.getButtonAddEmployee().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    String salary_value = mainFrame.getTextFieldAddEmployeeSalary().getText();

                    if (!mainFrame.getTextFieldAddEmployeeIDNumber().getText().isEmpty()
                            && !mainFrame.getTextFieldAddEmployeeLastName().getText().isEmpty()
                            && !mainFrame.getTextFieldAddEmployeeFirstName().getText().isEmpty()
                            && !mainFrame.getTextFieldAddEmployeeMiddleName().getText().isEmpty()
                            && !mainFrame.getTextFieldAddEmployeeSalary().getText().isEmpty()) {

                        if (tryAddEmployee(Integer.parseInt(mainFrame.getTextFieldAddEmployeeIDNumber().getText()),
                                mainFrame.getTextFieldAddEmployeeLastName().getText(),
                                mainFrame.getTextFieldAddEmployeeFirstName().getText(),
                                mainFrame.getTextFieldAddEmployeeMiddleName().getText(),
                                Double.valueOf(salary_value))) {
                            // success: notify user
                            PopBox.infoBox("Employee Added!", "");

                        } else {
                            // failure: notify user
                            PopBox.infoBox("Failed to add employee!", "");
                        }
                    }

                } catch (Exception ex) {
                    PopBox.infoBox("Failed to add employee!", "");
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

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
    }

    // returns true if successful in adding employee, false if there is a similar IDNumber in database
    private boolean tryAddEmployee(int IDNumber, String lastName, String firstName, String middleName, double salary) throws SQLException {
        boolean tryAdd = false;

        String mySQL_string = Employee.getAddEmployeeStatement();

        if (salary > 0) {

            /*
             PreparedStatement ps = DbConnection.getConnection().prepareStatement(mySQL_string);
             ps.setInt(1, IDNumber);
             ps.setString(2, firstName);
             ps.setString(3, lastName);
             ps.setString(4,middleName);
             ps.setDouble(5, salary);
             */
            Employee.addDB(IDNumber, firstName, lastName, middleName, salary);
            tryAdd = true;

        }

        // logic here
        return tryAdd;
    }
}
