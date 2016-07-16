
package controller;

import gui.MainFrame;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.AdminModel;

public class NavigationController implements Listen{

    private static final NavigationController navigationController = new NavigationController();

    private final MainFrame mainFrame = MainFrame.getInstance();
    
    private final LoginController loginController = LoginController.getInstance();
    private final HeaderController headerController = HeaderController.getInstance();
    private final WelcomeController welcomeController = WelcomeController.getInstance();
    private final AddEmployeeController addEmployeeController = AddEmployeeController.getInstance();
    private final EditEmployeeController editEmployeeController = EditEmployeeController.getInstance();
    private final ViewEmployeeController viewEmployeeController = ViewEmployeeController.getInstance();
    private final ManageEmployeeController manageEmployeeController = ManageEmployeeController.getInstance();
    private final ManageProjectContoller manageProjectContoller = ManageProjectContoller.getInstance();
    private final ViewProjectController viewProjectController = ViewProjectController.getInstance();
    private final ComputeSalaryController computeSalaryController = ComputeSalaryController.getInstance();
    
    private AdminModel admin; 
    
    private final Cursor DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
    private final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
    
    private NavigationController(){
        admin = null;
        addListeners();
    }
    
    public static NavigationController getInstance(){
        return NavigationController.navigationController;
    }
    
    @Override
    public final void addListeners() {
        mainFrame.getSidePanelLabelProjectWatch().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                welcomeController.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelProjectWatch().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Project Watch Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelProjectWatch().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Project Watch.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
        
        mainFrame.getSidePanelLabelAddEmployee().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                addEmployeeController.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelAddEmployee().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Employee Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelAddEmployee().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Employee.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
        
        mainFrame.getSidePanelLabelManageEmployee().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                manageEmployeeController.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelManageEmployee().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Employee Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelManageEmployee().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Employee.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
        
        mainFrame.getSidePanelLabelManageProject().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                manageProjectContoller.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelManageProject().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Project Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelManageProject().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Project.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
        
        mainFrame.getSidePanelLabelComputeSalary().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                computeSalaryController.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelComputeSalary().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Compute Salary Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelComputeSalary().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Compute Salary.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
        
        mainFrame.getSidePanelLabelLogout().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                loginController.showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getSidePanelLabelLogout().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Admin Hover.png")));
                mainFrame.setCursor(HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getSidePanelLabelLogout().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Admin.png")));
                mainFrame.setCursor(DEFAULT_CURSOR);
            }
        
        });
    }
    
    public AdminModel getAdmin(){
        return admin;
    }
    
    public void setAdmin(AdminModel admin){
        this.admin = admin;
    }
    
}
