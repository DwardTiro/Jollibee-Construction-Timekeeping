package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import model.CalendarModel;

public class ManageEmployeeController implements Listen, PanelChanger {

    private static final ManageEmployeeController manageEmployeeController = new ManageEmployeeController();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    
    private final String ATTENDANCE_STRING = "Attendance for ";
    private final String PANEL_NAME = "manageEmployeeScrollPane";
    
    private ManageEmployeeController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        calendarModel.restartCalendar();
        
        mainFrame.getLabelManageEmployeeAttendance().setText(ATTENDANCE_STRING + monthToString(calendarModel.getMonth()) + " " + calendarModel.getDayToday() + ", " + calendarModel.getYear());
        
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
