package controller;

import gui.MainFrame;
import gui.ManageEmployeeAttendancePanel;
import gui.ManageEmployeeFilterPanel;
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

public class ManageEmployeeController implements Listen, PanelChanger {

    private static final ManageEmployeeController manageEmployeeController = new ManageEmployeeController();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    
    private final String MANAGE_EMPLOYEE_STRING = "Manage Employee";
    private final String MANAGE_EMPLOYEE_NEGATIVE_STRING = "No Employee to Manage for ";
    private final String ATTENDANCE_STRING = "Attendance for ";
    private final String PANEL_NAME = "manageEmployeeScrollPane";
    
    private ArrayList<Employee> employees;
    private ArrayList<ManageEmployeeAttendancePanel> attendancePanels;
    
    private ArrayList<Project> projects;
    private ArrayList<ManageEmployeeFilterPanel> projectsPanels;
    
    private ManageEmployeeController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        calendarModel.restartCalendar();
        
        mainFrame.getLabelManageEmployeeAttendance().setText(ATTENDANCE_STRING + monthToString(calendarModel.getMonth()) + " " + calendarModel.getDayToday() + ", " + calendarModel.getYear());
        
        employees = new ArrayList<>();
        attendancePanels = new ArrayList<>();
        
        projects = new ArrayList<>();
        projectsPanels = new ArrayList<>();
    }
    
    public static ManageEmployeeController getInstance(){
        return ManageEmployeeController.manageEmployeeController;
    }
    
    @Override
    public final void addListeners() {
        int len = projects.size();
        for(int i = 0; i < len; i++){
            int index = i;
            JLabel label = projectsPanels.get(i).getLabelProjectName();
            
            label.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    mainFrame.getLabelManageEmployee().setText(MANAGE_EMPLOYEE_STRING + " for " + projects.get(index).getName());
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(new Color(231,28,35));
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(new Color(51,51,51));
                    label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            
            });
        }
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        attendancePanels = new ArrayList<>();
        projectsPanels = new ArrayList<>();
        
        employees = Employee.getAllEmployees();
        projects = Project.getProjectList();
        
        if(!employees.isEmpty()){
            
            int len = employees.size();
            
            mainFrame.getPanelManageEmployeeContainer().removeAll();
            GridLayout layout = (GridLayout)mainFrame.getPanelManageEmployeeContainer().getLayout();
            layout.setRows(len);
            //mainFrame.getPanelManageEmployeeContainer().setPreferredSize(new Dimension(ManageEmployeeAttendancePanel.PANEL_WIDTH, ManageEmployeeAttendancePanel.PANEL_HEIGHT * (len + 1)));
            mainFrame.getManageEmployeePanel().setPreferredSize(new Dimension(mainFrame.getManageEmployeePanel().getPreferredSize().width, (int)mainFrame.getLabelManageEmployee().getAlignmentY() + mainFrame.getLabelManageEmployee().getPreferredSize().height + mainFrame.getLabelManageEmployeeAttendance().getPreferredSize().height + ManageEmployeeAttendancePanel.PANEL_HEIGHT * (len + 1) + mainFrame.getButtonManageEmployeeSubmit().getPreferredSize().height));
            
            for(int i = 0; i < len; i++){
                Employee e = employees.get(i);
                ManageEmployeeAttendancePanel panel = new ManageEmployeeAttendancePanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getID()));
                mainFrame.getPanelManageEmployeeContainer().add(panel);
                attendancePanels.add(panel);
            }
            
            mainFrame.getPanelManageEmployeeContainer().repaint();
            mainFrame.getPanelManageEmployeeContainer().revalidate();
        }
        
        if(!projects.isEmpty()){
            
            int len = projects.size();
            
            mainFrame.getPanelManageEmployeeProjectContainer().removeAll();
            mainFrame.getPanelManageEmployeeProjectContainer().setPreferredSize(new Dimension(ManageEmployeeFilterPanel.PANEL_WIDTH, ManageEmployeeFilterPanel.PANEL_HEIGHT * len));
            
            for(int i = 0; i < len; i++){
                Project p = projects.get(i);
                ManageEmployeeFilterPanel panel = new ManageEmployeeFilterPanel(p.getName());
                mainFrame.getPanelManageEmployeeProjectContainer().add(panel);
                projectsPanels.add(panel);
            }
            
            ManageEmployeeFilterPanel panel = new ManageEmployeeFilterPanel("All Projects");
            mainFrame.getPanelManageEmployeeProjectContainer().add(panel);
            projectsPanels.add(panel);
            
            mainFrame.getPanelManageEmployeeProjectContainer().repaint();
            mainFrame.getPanelManageEmployeeProjectContainer().revalidate();
        }
        addListeners();
        
    }
    
    private void showEmployeesInProject(int projectID){
        
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
