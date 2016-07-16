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

public class EditEmployeeController implements Listen, PanelChanger{

    private static final EditEmployeeController editEmployeeController =  new EditEmployeeController();
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "editEmployeePanel";
    
    private int viewID;
    
    
    private EditEmployeeController(){
        mainFrame = MainFrame.getInstance();
        addListeners();
    }
    
    public static EditEmployeeController getInstance(){
        return EditEmployeeController.editEmployeeController;
    }
    
    @Override
    public final void addListeners() {
        mainFrame.getButtonEditEmployeeSaveChanges().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!mainFrame.getTextFieldEditEmployeeIDNumber().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeLastName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeFirstName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeMiddleName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeSalary().getText().isEmpty()){
                    
                    if(tryEditEmployee(Integer.parseInt(mainFrame.getTextFieldEditEmployeeIDNumber().getText()),
                            mainFrame.getTextFieldEditEmployeeLastName().getText(),
                            mainFrame.getTextFieldEditEmployeeFirstName().getText(),
                            mainFrame.getTextFieldEditEmployeeMiddleName().getText(),
                            Double.parseDouble(mainFrame.getTextFieldEditEmployeeSalary().getText()))){
                        // success: notify user
                        ViewEmployeeController.getInstance().setViewID(viewID);
                        ViewEmployeeController.getInstance().showPanel();
                        
                    } else{
                        refreshView();
                        PopBox.infoBox("Unable to edit", "");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

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
    
    public void setViewID(int id){
        this.viewID = id;
    }
    
    public void refreshView(){
        try {
            Employee toShow = Employee.getEmployeeByID(this.viewID);
            mainFrame.getTextFieldEditEmployeeIDNumber().setText(toShow.getIdNumber()+"");
            mainFrame.getTextFieldEditEmployeeFirstName().setText(toShow.getFname());
            mainFrame.getTextFieldEditEmployeeMiddleName().setText(toShow.getMname());
            mainFrame.getTextFieldEditEmployeeLastName().setText(toShow.getLname());
            mainFrame.getTextFieldEditEmployeeSalary().setText(toShow.getSalary()+"");
                          
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void showPanel() {
        refreshView();
        CardLayout layout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        layout.show(mainFrame.getMainPanelCardPanel(),PANEL_NAME);
    }
    
    // returns true if successful in editing employee, false if there is a similar IDNumber in database
    private boolean tryEditEmployee(int IDNumber, String lastName, String firstName, String middleName, Double salary){
        boolean tryEdit = false;
        
        try {    
            Employee.editEmployee(IDNumber, firstName, lastName, middleName, salary);
            tryEdit = true;
        } catch (SQLException ex) {
            
            Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // logic here
        return tryEdit;
    }
}
