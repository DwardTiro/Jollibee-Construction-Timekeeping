/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.MainFrame;
import gui.SearchResultsPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Employee;

/**
 *
 * @author Jet
 */
public class SearchResultController implements PanelChanger {

    private static final SearchResultController controller = new SearchResultController();

    private final String PANEL_NAME = "searchResultsScrollPane";
    
    private final Color COLOR_RED = new Color(231,28,35);
    private final Color COLOR_GRAY = new Color(51,51,51);
    
    //private static final AssignProjectController controller2 = new AssignProjectController();
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    //private final String PANEL_NAME = "searchResultPanel";
    //private final String PANEL2_NAME = "assignProjectPanel";
    private ArrayList<Employee> employee_list;

    public SearchResultController() {
        mainFrame = MainFrame.getInstance();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout = (CardLayout) mainCardPanel.getLayout();
    }

    public void setModel(ArrayList<Employee> emplist) {
        this.employee_list = emplist;
    }

    public static SearchResultController getInstance() {
        return controller;
    }

    public final void addListeners(ArrayList<SearchResultsPanel> resultsPanels, ArrayList<Employee> empList){
        
        for(int i = 0; i < resultsPanels.size(); i++){
            final JLabel label = resultsPanels.get(i).getLabelName();
            final Employee emp = empList.get(i);
            resultsPanels.get(i).getLabelName().addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    ViewEmployeeController.getInstance().setViewID(emp.getEmpID());
                    ViewEmployeeController.getInstance().showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(COLOR_RED);
                    mainFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(COLOR_GRAY);
                    mainFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }
            });
        }
    }

    @Override
    public void showPanel() {
        /*
        DefaultListModel listModel = new DefaultListModel();
        for (Employee emp : this.employee_list) {
            listModel.addElement(emp);
        }
        mainFrame.getSearchLists().setModel(listModel);
        */
        mainLayout.show(mainCardPanel, PANEL_NAME);
    }
}
