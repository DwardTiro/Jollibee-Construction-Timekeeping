
package controller;

import gui.MainFrame;
import gui.ViewProjectMemberListItemPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import model.CalendarModel;
import model.Employee;
import model.Project;

public class ViewProjectController implements Listen, PanelChanger{

    private final static ViewProjectController viewProjectController = new ViewProjectController();
    
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "viewProjectScrollPane";
    
    private Project project;
    
    private ArrayList<Employee> projectMembers;
    private ArrayList<ViewProjectMemberListItemPanel> panelMembers;
    
    private ViewProjectController(){
        mainFrame = MainFrame.getInstance();
        
        project = null;
        projectMembers = new ArrayList<>();
        panelMembers = new ArrayList<>();
    }
    
    public static ViewProjectController getInstance(){
        return ViewProjectController.viewProjectController;
    }
    
    @Override
    public void addListeners() {
        int len = projectMembers.size();
        
        for(int i = 0; i < len; i++){
            int index = i;
            JLabel labelName = panelMembers.get(index).getLabelName();
            JLabel labelRemove = panelMembers.get(index).getLabelRemove();
            Employee employee = projectMembers.get(index);
            
            labelName.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    ViewEmployeeController.getInstance().setViewID(employee.getID());
                    ViewEmployeeController.getInstance().showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelName.setForeground(new Color(231,28,35));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelName.setForeground(new Color(51,51,51));
                }
            
            });
            
            labelRemove.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove Icon Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelRemove.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove Icon.png")));
                }
            
            });
        }
        
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        mainFrame.getLabelViewProjectName().setText(project.getName());
        
        String[] presetDateStarted = project.getDateStarted().toString().split(" ");
        String[] presetDateDue = project.getDateDue().toString().split(" ");
        mainFrame.getLabelViewProjectDuration().setText(monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateStarted[1])) + " " + presetDateStarted[2] + ", " + presetDateStarted[5] + " - " + monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateDue[1])) + " " + presetDateDue[2] + ", " + presetDateDue[5]);
    
        refreshEmployeeList();
        addListeners();
    }
    
    private void refreshEmployeeList(){
        panelMembers = new ArrayList<>();
        
        projectMembers = Employee.getEmployeeByProject(project.getID());
        int len = projectMembers.size();
        mainFrame.getPanelViewProjectMembersContainer().removeAll();
        GridLayout layout = (GridLayout)mainFrame.getPanelViewProjectMembersContainer().getLayout();
        layout.setRows(len);
        mainFrame.getViewProjectPanel().setPreferredSize(new Dimension(mainFrame.getViewProjectPanel().getPreferredSize().width, (int)mainFrame.getLabelViewProjectMembers().getAlignmentY() + ViewProjectMemberListItemPanel.PANEL_HEIGHT * (len+1)));
        
        if(!projectMembers.isEmpty()){
            for(int i = 0; i < len; i++){
                Employee e = projectMembers.get(i);
                System.out.println(i);
                ViewProjectMemberListItemPanel panel = new ViewProjectMemberListItemPanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getID()));
                panelMembers.add(panel);
                mainFrame.getPanelViewProjectMembersContainer().add(panel);
            }
        }
        
        mainFrame.getPanelViewProjectMembersContainer().repaint();
        mainFrame.getPanelViewProjectMembersContainer().revalidate();
    }
    
    public void setProject(Project project){
        this.project = project;
    }
 
    private String monthToString(int month){
        String sMonth = "";
        
        switch(month){
            case(CalendarModel.NJANUARY): sMonth = CalendarModel.SJANUARY; break;
            case(CalendarModel.NFEBRUARY): sMonth = CalendarModel.SFEBRUARY; break;
            case(CalendarModel.NMARCH): sMonth = CalendarModel.SMARCH; break;
            case(CalendarModel.NAPRIL): sMonth = CalendarModel.SAPRIL; break;
            case(CalendarModel.NMAY): sMonth = CalendarModel.SMAY; break;
            case(CalendarModel.NJUNE): sMonth = CalendarModel.SJUNE; break;
            case(CalendarModel.NJULY): sMonth = CalendarModel.SJULY; break;
            case(CalendarModel.NAUGUST): sMonth = CalendarModel.SAUGUST; break;
            case(CalendarModel.NSEPTEMBER): sMonth = CalendarModel.SSEPTEMBER; break;
            case(CalendarModel.NOCTOBER): sMonth = CalendarModel.SOCTOBER; break;
            case(CalendarModel.NNOVEMBER): sMonth = CalendarModel.SNOVEMBER; break;
            case(CalendarModel.NDECEMBER): sMonth = CalendarModel.SDECEMBER; break;
        }
        
        return sMonth;
    }
    
}
