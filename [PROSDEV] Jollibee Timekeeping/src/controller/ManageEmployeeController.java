package controller;

import gui.MainFrame;
import gui.ManageEmployeeAttendancePanel;
import gui.PopBox;
import gui.ProjectFilterPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import model.CalendarModel;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Employee;
import model.Project;
import model.AttendanceModel;

public class ManageEmployeeController implements Listen, PanelChanger {

    private static final ManageEmployeeController manageEmployeeController = new ManageEmployeeController();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    
    private final String MANAGE_EMPLOYEE_STRING = "MANAGE EMPLOYEE";
    private final String MANAGE_EMPLOYEE_NEGATIVE_STRING = "NO EMPLOYEE TO MANAGE FOR ";
    private final String ATTENDANCE_STRING = "Attendance for ";
    private final String PANEL_NAME = "manageEmployeeScrollPane";
    
    private ArrayList<Employee> employees;
    private ArrayList<ManageEmployeeAttendancePanel> attendancePanels;
    
    private ArrayList<Project> projects;
    private ArrayList<ProjectFilterPanel> projectsPanels;
    
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
        //addAttendancePanelListeners();
        //addProjectPanelListeners();
        
        mainFrame.getButtonManageEmployeeSubmit().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                // code later
                Calendar calendar = Calendar.getInstance();
                Date date = new java.sql.Date(calendar.getTime().getTime());
                DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
                Date timeIn, timeOut;
                
                for (int i = 0; i < attendancePanels.size(); i++) {
                    ManageEmployeeAttendancePanel attendancePanel = attendancePanels.get(i);
                    Employee employee = employees.get(i);
                    if(attendancePanel.getToAddStatus()){
                        try {
                            timeIn = df.parse(attendancePanel.getSpinnerTimeIn().getValue().toString());
                            timeOut = df.parse(attendancePanel.getSpinnerTimeOut().getValue().toString());
                            int empID = employee.getEmpID();
                            AttendanceModel.saveAttendance(empID, date, timeIn, timeOut, 0);
                        }catch(ParseException ex){
                            ex.toString();
                        }
                    }
                }
                PopBox.infoBox("Successfully added all attendance records", "Success");
                showPanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getButtonManageEmployeeSubmit().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getButtonManageEmployeeSubmit().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        
        });
    }

    private void addAttendancePanelListeners(){
        int len = attendancePanels.size();
        for(int i = 0; i < len; i++){
            int index = i;
            ManageEmployeeAttendancePanel attendancePanel = attendancePanels.get(index);
            JSpinner timeInSpinner = attendancePanels.get(index).getSpinnerTimeIn();
            JSpinner timeOutSpinner = attendancePanels.get(index).getSpinnerTimeOut();
            
            timeInSpinner.addChangeListener(new ChangeListener(){

                @Override
                public void stateChanged(ChangeEvent e) {
                    try {
                        String timeInString = new SimpleDateFormat("h:mm a").format(timeInSpinner.getValue());
                        String timeOutString = new SimpleDateFormat("h:mm a").format(timeOutSpinner.getValue());
                        
                        Date timeIn = new SimpleDateFormat("h:mm a").parse(timeInString);
                        Date timeOut = new SimpleDateFormat("h:mm a").parse(timeOutString);
                        
                        if(timeIn.getTime() > timeOut.getTime()){
                            timeOutSpinner.getModel().setValue(timeInSpinner.getModel().getValue());
                        }
                        
                        long diff = timeOut.getTime() - timeIn.getTime();
                        
                        if(diff > 0){
                            attendancePanel.getPanelStatus().setBackground(ManageEmployeeAttendancePanel.COLOR_ADD);
                            attendancePanel.setToAddStatus(true);
                        } else {
                            attendancePanel.getPanelStatus().setBackground(ManageEmployeeAttendancePanel.COLOR_DONT_ADD);
                            attendancePanel.setToAddStatus(false);
                        }
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(ManageEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            timeOutSpinner.addChangeListener(new ChangeListener(){

                @Override
                public void stateChanged(ChangeEvent e) {
                    try {
                        String timeInString = new SimpleDateFormat("h:mm a").format(timeInSpinner.getValue());
                        String timeOutString = new SimpleDateFormat("h:mm a").format(timeOutSpinner.getValue());
                        
                        Date timeIn = new SimpleDateFormat("h:mm a").parse(timeInString);
                        Date timeOut = new SimpleDateFormat("h:mm a").parse(timeOutString);
                        
                        if(timeOut.getTime() < timeIn.getTime()){
                            timeInSpinner.getModel().setValue(timeOutSpinner.getModel().getValue());
                        }
                        
                        long diff = timeOut.getTime() - timeIn.getTime();
                        
                        if(diff > 0){
                            attendancePanel.getPanelStatus().setBackground(ManageEmployeeAttendancePanel.COLOR_ADD);
                            attendancePanel.setToAddStatus(true);
                        } else {
                            attendancePanel.getPanelStatus().setBackground(ManageEmployeeAttendancePanel.COLOR_DONT_ADD);
                            attendancePanel.setToAddStatus(false);
                        }
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(ManageEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }
    
    private void addProjectPanelListeners(){
        int len = projectsPanels.size();
        for(int i = 0; i < len; i++){
            int index = i;
            JLabel label = projectsPanels.get(i).getLabelProjectName();
            
            label.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    if(index < projects.size())
                        showEmployeesInProject(projects.get(index).getID());
                    else
                        showEmployeesInProject(-1);
                    
                    if(!employees.isEmpty() && index < projects.size()){
                        mainFrame.getLabelManageEmployee().setText(MANAGE_EMPLOYEE_STRING + " FOR " + projects.get(index).getName().toUpperCase());
                        mainFrame.getButtonManageEmployeeSubmit().setVisible(true);
                        mainFrame.getButtonManageEmployeeSubmit().setEnabled(true);
                    }
                    else if(index == projects.size()){
                        mainFrame.getLabelManageEmployee().setText(MANAGE_EMPLOYEE_STRING + " FOR ALL PROJECTS");
                        mainFrame.getButtonManageEmployeeSubmit().setVisible(true);
                        mainFrame.getButtonManageEmployeeSubmit().setEnabled(true);
                    }
                    else if(employees.isEmpty()){
                        mainFrame.getLabelManageEmployee().setText(MANAGE_EMPLOYEE_NEGATIVE_STRING + projects.get(index).getName().toUpperCase());
                        mainFrame.getButtonManageEmployeeSubmit().setVisible(false);
                        mainFrame.getButtonManageEmployeeSubmit().setEnabled(false);
                    }
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
        employees = Employee.getEmployeeWithNoAttendanceForToday();
        projects = Project.getProjectList();
        
        mainFrame.getLabelManageEmployee().setText(MANAGE_EMPLOYEE_STRING);
        JScrollBar verticalScrollBar = mainFrame.getManageEmployeeScrollPane().getVerticalScrollBar();
        JScrollBar horizontalScrollBar = mainFrame.getManageEmployeeScrollPane().getHorizontalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());
        horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
        
        refreshEmployeeList();
        refreshProjectList();
        
        addListeners();
    }
    
    private void refreshEmployeeList(){
        attendancePanels = new ArrayList<>();
        
        int len = employees.size();
        mainFrame.getPanelManageEmployeeContainer().removeAll();
        GridLayout layout = (GridLayout)mainFrame.getPanelManageEmployeeContainer().getLayout();
        layout.setRows(len);
        mainFrame.getManageEmployeePanel().setPreferredSize(new Dimension(mainFrame.getManageEmployeePanel().getPreferredSize().width, MainFrame.getSPACE_ABOVE() + mainFrame.getLabelManageEmployee().getPreferredSize().height + mainFrame.getLabelManageEmployeeAttendance().getPreferredSize().height + ManageEmployeeAttendancePanel.PANEL_HEIGHT * (len + 1) + mainFrame.getButtonManageEmployeeSubmit().getPreferredSize().height));
        
        if(!employees.isEmpty()){
            //mainFrame.getPanelManageEmployeeContainer().setPreferredSize(new Dimension(ManageEmployeeAttendancePanel.PANEL_WIDTH, ManageEmployeeAttendancePanel.PANEL_HEIGHT * (len + 1)));
            for (Employee e : employees) {
                ManageEmployeeAttendancePanel panel = new ManageEmployeeAttendancePanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getIdNumber()));
                mainFrame.getPanelManageEmployeeContainer().add(panel);
                attendancePanels.add(panel); 
            }
        }
        mainFrame.getPanelManageEmployeeContainer().repaint();
        mainFrame.getPanelManageEmployeeContainer().revalidate();
        
        addAttendancePanelListeners();
    }
    
    private void refreshProjectList(){
        projectsPanels = new ArrayList<>();
        
        int len = projects.size();
            
        mainFrame.getPanelManageEmployeeProjectContainer().removeAll();
        mainFrame.getPanelManageEmployeeProjectContainer().setPreferredSize(new Dimension(ProjectFilterPanel.PANEL_WIDTH, ProjectFilterPanel.PANEL_HEIGHT * len));
            
        if(!projects.isEmpty()){
            for(int i = 0; i < len; i++){
                Project p = projects.get(i);
                ProjectFilterPanel panel = new ProjectFilterPanel(p.getName());
                mainFrame.getPanelManageEmployeeProjectContainer().add(panel);
                projectsPanels.add(panel);
            }
        }
        ProjectFilterPanel panel = new ProjectFilterPanel("All Projects");
        mainFrame.getPanelManageEmployeeProjectContainer().add(panel);
        projectsPanels.add(panel);
            
        mainFrame.getPanelManageEmployeeProjectContainer().repaint();
        mainFrame.getPanelManageEmployeeProjectContainer().revalidate();
        
        addProjectPanelListeners();
    }
    
    private void showEmployeesInProject(int projectID){
        if(projectID != -1)
            employees = Employee.getEmployeeByProjectWithNoAttendanceForToday(projectID);
        else
            employees = Employee.getEmployeeWithNoAttendanceForToday();
        refreshEmployeeList();
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
