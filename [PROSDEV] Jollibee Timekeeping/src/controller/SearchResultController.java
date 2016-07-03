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

/**
 *
 * @author Jet
 */
public class SearchResultController implements Listen, PanelChanger{

    private static final SearchResultController controller = new SearchResultController();
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    private final String PANEL_NAME = "searchResultPanel";
    private ArrayList<Employee> employee_list;
             
    public SearchResultController(){
        mainFrame = MainFrame.getInstance(); 
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout =(CardLayout) mainCardPanel.getLayout();
        addListeners();
    }
    
    public void setModel(ArrayList<Employee> emplist){
        this.employee_list = emplist;
    }
    
    public static SearchResultController getInstance(){
        return controller;
    }
    
    @Override
    public void addListeners() {
        
        mainFrame.getViewEmployeeButton().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
              //System.out.println("CLICK! "+mainFrame.getSearchLists().getSelectedValue().toString());
              if(mainFrame.getSearchLists().getSelectedValue()!= null){
                Employee selected = (Employee) mainFrame.getSearchLists().getSelectedValue();
                ViewEmployeeController.getInstance().setViewID(selected.getID());
                ViewEmployeeController.getInstance().showPanel();  
              }

            } 
        });
        
    }

    @Override
    public void showPanel(){
        System.out.println("Here!!!");
        DefaultListModel listModel = new DefaultListModel();
        for(Employee emp: this.employee_list){
            listModel.addElement(emp);
        }
        mainFrame.getSearchLists().setModel(listModel);
        mainLayout.show(mainCardPanel, PANEL_NAME);
        
    }
    
    
    
    
    
}