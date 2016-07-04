/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import model.Employee;
import model.Project;
import controller.AssignProjectController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.PopBox;
/**
 *
 * @author owner
 */
public class AssignProjectController implements Listen, PanelChanger {
    private static final AssignProjectController controller = new AssignProjectController();
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    private final String PANEL_NAME = "assignProjectPanel";
    private ArrayList<Project> proj_list;
    private Employee employee;
    private int viewID;
    
    
    public AssignProjectController(){
        mainFrame = MainFrame.getInstance(); 
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout =(CardLayout) mainCardPanel.getLayout();
        addListeners();
    }
    
    public static AssignProjectController getInstance(){
        return controller;
    }
    
    public int getID(){
        return this.viewID;
    }
    
    public void setViewID(int id){
        this.viewID = id;
    }
    
    public void setModel(ArrayList<Project> projlist){
        this.proj_list = projlist;
    }
    
    @Override
    public final void addListeners(){
        mainFrame.getAssignButton().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
              System.out.println("WE HERE MATE");
              if(mainFrame.getProjLists().getSelectedValue()!= null){
                Project selected = (Project) mainFrame.getProjLists().getSelectedValue();
                //update db
                try{
                    employee.updateProject(selected.getID());
                    System.out.println("Update done");
                    //PopBox.infoBox("Project Assignment Successful", PANEL_NAME);
                }catch(SQLException ex){
                    Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              }

            } 
        });
    }
    
    @Override
    public void showPanel(){
        try{
            employee = Employee.getEmployeeByID(getID());
            System.out.println(employee.getLname());
            mainFrame.setAssignProjectLabel("Assign Project to "+employee.getFname()+" "+employee.getLname());
            
            DefaultListModel listModel = new DefaultListModel();
            setModel(Project.getProjectList());
            
            for(Project proj: this.proj_list){
                System.out.println(proj.getID()+" "+proj.getName());
                listModel.addElement(proj);
            }
            
            mainFrame.getProjLists().setModel(listModel);
            mainLayout.show(mainCardPanel, PANEL_NAME);
        }catch (SQLException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
