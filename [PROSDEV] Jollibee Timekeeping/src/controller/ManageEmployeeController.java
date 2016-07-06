package controller;

import gui.MainFrame;
import gui.ManageEmployeeAttendancePanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import model.CalendarModel;
import model.Employee;

public class ManageEmployeeController implements Listen, PanelChanger {

    private static final ManageEmployeeController manageEmployeeController = new ManageEmployeeController();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    
    private final String ATTENDANCE_STRING = "Attendance for ";
    private final String PANEL_NAME = "manageEmployeeScrollPane";
    
    private ArrayList<Employee> employees;
    private ArrayList<ManageEmployeeAttendancePanel> attendancePanels;
    
    private ManageEmployeeController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        calendarModel.restartCalendar();
        
        mainFrame.getLabelManageEmployeeAttendance().setText(ATTENDANCE_STRING + monthToString(calendarModel.getMonth()) + " " + calendarModel.getDayToday() + ", " + calendarModel.getYear());
        
        employees = new ArrayList<>();
        attendancePanels = new ArrayList<>();
        
        addListeners();
    }
    
    public static ManageEmployeeController getInstance(){
        return ManageEmployeeController.manageEmployeeController;
    }
    
    @Override
    public final void addListeners() {
        
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        attendancePanels = new ArrayList<>();
        
        employees = Employee.getAllEmployees();
        if(!employees.isEmpty()){
            
            int len = employees.size();
            
            mainFrame.getPanelManageEmployeeContainer().removeAll();
            mainFrame.getPanelManageEmployeeContainer().setPreferredSize(new Dimension(ManageEmployeeAttendancePanel.PANEL_WIDTH, ManageEmployeeAttendancePanel.PANEL_HEIGHT * len));
            mainFrame.getManageEmployeePanel().setPreferredSize(new Dimension(mainFrame.getManageEmployeePanel().getPreferredSize().width, (int)mainFrame.getLabelManageEmployee().getAlignmentY() + mainFrame.getLabelManageEmployee().getPreferredSize().height + mainFrame.getLabelManageEmployeeAttendance().getPreferredSize().height + mainFrame.getPanelManageEmployeeContainer().getPreferredSize().height + mainFrame.getButtonManageEmployeeSubmit().getPreferredSize().height));
            
            for(int i = 0; i < len; i++){
                Employee e = employees.get(i);
                ManageEmployeeAttendancePanel panel = new ManageEmployeeAttendancePanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getID()));
                mainFrame.getPanelManageEmployeeContainer().add(panel);
                attendancePanels.add(panel);
            }
            
            mainFrame.getPanelManageEmployeeContainer().repaint();
            mainFrame.getPanelManageEmployeeContainer().revalidate();
        }
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
