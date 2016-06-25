package controller;

import gui.AttendanceFrame;
import gui.CalendarDatePanel;
import gui.MainFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.AttendanceModel;
import model.CalendarModel;

public class ViewEmployeeController implements Listen, PanelChanger{

    private static final ViewEmployeeController viewEmployeeController = new ViewEmployeeController();
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "viewEmployeePanel";
    
    private JPanel viewCalendar[];
    private final int CALENDAR_ROWS = 6;
    private final int CALENDAR_COLS = 7;
    private ArrayList<AttendanceModel> attendance;
    private final CalendarModel calendarModel;
    
    private ViewEmployeeController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        attendance = new ArrayList<>();
        addListeners();
        buildCalendar(); //  remove here
    }
    
    public static ViewEmployeeController getInstance(){
        return ViewEmployeeController.viewEmployeeController;
    }
    
    @Override
    public void addListeners() {
        mainFrame.getLabelViewEmployeeNextMonth().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToNextMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png")));
            }
        });
        
        mainFrame.getLabelViewEmployeePreviousMonth().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToPreviousMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png")));
            }
        });
    }
    
    @Override
    public void showPanel() {
        
    }
    
    // sample only
    private void buildCalendar(){
        viewCalendar = new JPanel[CALENDAR_ROWS * CALENDAR_COLS];
        
        mainFrame.getPanelViewEmployeeCalendar().removeAll();
        
        mainFrame.getLabelViewEmployeeMonthYear().setText(monthToString(calendarModel.getMonth()) + " " + calendarModel.getYear());
        
        // fill attendance arraylist here
        
        for(int i = 0; i < calendarModel.getFirstDay(); i++){
            JPanel temp = new JPanel();
            
            temp.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    AttendanceFrame addEditHours = new AttendanceFrame();
                    addEditHours.setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
            
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }
        for(int i = 0; i < calendarModel.getMaxDays(); i++){
            JPanel temp = new CalendarDatePanel(i + 1, "project", CalendarDatePanel.ATTENDANCE_STATUS_COMPLETE);
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            viewCalendar[i] = temp;
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }
        for(int i = calendarModel.getMaxDays() + calendarModel.getFirstDay(); i < CALENDAR_ROWS * CALENDAR_COLS; i++){
            JPanel temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
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
