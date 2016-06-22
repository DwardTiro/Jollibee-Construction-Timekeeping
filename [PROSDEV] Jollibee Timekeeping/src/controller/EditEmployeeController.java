package controller;

import gui.MainFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditEmployeeController implements Listen, PanelChanger{

    private static final EditEmployeeController editEmployeeController =  new EditEmployeeController();
    private final MainFrame mainFrame;
    
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
                            Float.parseFloat(mainFrame.getTextFieldEditEmployeeSalary().toString()))){
                        // success: notify user
                    } else{
                        // failure: notify user
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    @Override
    public void showPanel() {
        
    }
    
    // returns true if successful in editing employee, false if there is a similar IDNumber in database
    private boolean tryEditEmployee(int IDNumber, String lastName, String firstName, String middleName, float salary){
        boolean tryEdit = false;
        
        // logic here
        
        return tryEdit;
    }
}
