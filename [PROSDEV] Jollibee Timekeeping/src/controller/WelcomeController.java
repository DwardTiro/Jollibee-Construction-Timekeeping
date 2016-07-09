
package controller;

import gui.CalendarDatePanel;
import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.CalendarModel;
import model.Project;

public class WelcomeController implements Listen, PanelChanger{

    private static final WelcomeController welcomeController = new WelcomeController();
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "welcomePanel";
    
    private JPanel viewCalendar[];
    private final int CALENDAR_ROWS = 6;
    private final int CALENDAR_COLS = 7;
    private final CalendarModel calendarModel;
    
    private ArrayList<Project> projectDue;
    
    private WelcomeController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        projectDue = new ArrayList<>();
        
        addListeners();
        buildCalendar();
    }
    
    public static WelcomeController getInstance(){
        return WelcomeController.welcomeController;
    }
    
    @Override
    public final void addListeners() {
        mainFrame.getLabelWelcomeNextMonth().addMouseListener(new MouseListener(){

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
                mainFrame.getLabelWelcomeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelWelcomeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png")));
            }
        });
        
        mainFrame.getLabelWelcomePreviousMonth().addMouseListener(new MouseListener(){

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
                mainFrame.getLabelWelcomePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelWelcomePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png")));
            }
        });
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        buildCalendar();
    }
    
    // sample only
    private void buildCalendar(){
        
        projectDue = Project.getProjectDue(calendarModel.getMonth(), calendarModel.getYear());
        
        viewCalendar = new JPanel[CALENDAR_ROWS * CALENDAR_COLS];
        
        mainFrame.getPanelWelcomeCalendar().removeAll();
        
        mainFrame.getLabelWelcomeMonthYear().setText(monthToString(calendarModel.getMonth()) + " " + calendarModel.getYear());
        
        for(int i = 0; i < calendarModel.getFirstDay(); i++){
            JPanel temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelWelcomeCalendar().add(temp);
        }
        
        int dayToday = calendarModel.getDayToday();
        int status = 0;
        int index = 0;
        for(int i = 0; i < calendarModel.getMaxDays(); i++){
            CalendarDatePanel temp = new CalendarDatePanel(i + 1, calendarModel.getMonth(), calendarModel.getYear(), "");
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            
            if((i+1) == dayToday && calendarModel.getMonth() == calendarModel.getMonthToday() && calendarModel.getYear() == calendarModel.getYearToday())
                temp.setBackground(new Color(224, 224, 224));
            
            if(index < projectDue.size()){
                Project p = projectDue.get(index);
            
                if((i+1) == Integer.parseInt(p.getDateDue().toString().split(" ")[2])){
                    temp.setProjectName(p.getName());
                    temp.setStatus(CalendarDatePanel.ATTENDANCE_STATUS_ABSENT);
                    index++;
                }
                else{
                    temp.setStatus(status);
                }
            } 
            else {
                temp.setStatus(status);
            }
            
            viewCalendar[i] = temp;
            mainFrame.getPanelWelcomeCalendar().add(temp);
        }
        for(int i = calendarModel.getMaxDays() + calendarModel.getFirstDay(); i < CALENDAR_ROWS * CALENDAR_COLS; i++){
            JPanel temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelWelcomeCalendar().add(temp);
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
