
package controller;

import gui.MainFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddEmployeeController implements Listen, PanelChanger{

    private static final AddEmployeeController addEmployeeController = new AddEmployeeController();
    private final MainFrame mainFrame;
    
    private AddEmployeeController(){
        mainFrame = MainFrame.getInstance();
        
        addListeners();
    }
    
    public static AddEmployeeController getInstance(){
        return AddEmployeeController.addEmployeeController;
    }
    
    @Override
    public final void addListeners() {
        mainFrame.getButtonAddEmployee().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!mainFrame.getTextFieldAddEmployeeIDNumber().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeLastName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeFirstName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeMiddleName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeSalary().getText().isEmpty()){
                    
                    if(tryAddEmployee(Integer.parseInt(mainFrame.getTextFieldAddEmployeeIDNumber().getText()),
                            mainFrame.getTextFieldAddEmployeeLastName().getText(),
                            mainFrame.getTextFieldAddEmployeeFirstName().getText(),
                            mainFrame.getTextFieldAddEmployeeMiddleName().getText(),
                            Float.parseFloat(mainFrame.getTextFieldAddEmployeeSalary().toString()))){
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
    
    // returns true if successful in adding employee, false if there is a similar IDNumber in database
    private boolean tryAddEmployee(int IDNumber, String lastName, String firstName, String middleName, float salary){
        boolean tryAdd = false;
        
        // logic here
        
        return tryAdd;
    }
}
