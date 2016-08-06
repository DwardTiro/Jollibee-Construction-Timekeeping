package controller;

import gui.AttendanceChangesPanel;
import gui.AttendanceFrame;
import gui.CalendarDatePanel;
import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.AdminModel;
import model.AttendanceAuditTrail;
import model.AttendanceModel;
import model.CalendarModel;
import model.DbConnection;
import model.Employee;
import model.Project;

public class ViewEmployeeController implements Listen, PanelChanger {

    private static final ViewEmployeeController viewEmployeeController = new ViewEmployeeController();
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;

    private final String SQL_GET_ATTENDANCE = "SELECT * FROM attendance where Month(date) = Month(?) and Year(date) = Year(?) and emp_id = ? order by date";
    private final String SQL_GET_PROJECT_FOR_ATTENDANCE = "SELECT * FROM employee_details_audit_trail where attribute = 'Project' and `date` <= ? and emp_id = ? LIMIT 1 ";
    private final String SQL_DATE_ATTRIBUTE = "date";
    private final String SQL_TIMEIN_ATTRIBUTE = "time_in";
    private final String SQL_TIMEOUT_ATTRIBUTE = "time_out";
    private final String SQL_LEAVE_ATTRIBUTE = "leave";
    private final String PANEL_NAME = "viewEmployeePanel";

    private JPanel viewCalendar[];
    private final int CALENDAR_ROWS = 6;
    private final int CALENDAR_COLS = 7;
    private ArrayList<AttendanceModel> attendance;
    private final CalendarModel calendarModel;
    private Employee employeeToShow;
    private int viewID;

    private int daySelected;
    private ArrayList<AttendanceAuditTrail> auditTrail;
    private ArrayList<AttendanceChangesPanel> auditTrailPanel;

    private ViewEmployeeController() {
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout = (CardLayout) mainCardPanel.getLayout();
        attendance = new ArrayList<>();

        daySelected = 0;
        auditTrail = new ArrayList<>();

        addListeners();
    }

    public static ViewEmployeeController getInstance() {
        return ViewEmployeeController.viewEmployeeController;
    }

    @Override
    public final void addListeners() {
        mainFrame.getLabelViewEmployeeNextMonth().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToNextMonth();
                buildCalendar();
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
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png")));
            }
        });

        mainFrame.getLabelViewEmployeePreviousMonth().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToPreviousMonth();
                buildCalendar();
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
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png")));
            }
        });

        mainFrame.getEditEmployeeLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                EditEmployeeController.getInstance().setViewID(viewID);
                EditEmployeeController.getInstance().showPanel();
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
                mainFrame.getEditEmployeeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit Details Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getEditEmployeeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit Details.png")));
            }
        });

        mainFrame.getLabelEditCurrentAttendance().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    AttendanceFrame addEditHours = new AttendanceFrame(daySelected, calendarModel.getMonth(), calendarModel.getYear(), AttendanceModel.getEntryNum(employeeToShow.getEmpID(), new SimpleDateFormat("yyyy/MM/dd").parse(calendarModel.getYear() + "/" + calendarModel.getMonth() + "/" + daySelected)));
                    addEditHours.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getLabelEditCurrentAttendance().setIcon(new ImageIcon(getClass().getResource("/img/Edit Small Hover.png")));
                mainFrame.getLabelEditCurrentAttendance().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getLabelEditCurrentAttendance().setIcon(new ImageIcon(getClass().getResource("/img/Edit Small.png")));
                mainFrame.getLabelEditCurrentAttendance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }

    public int getID() {
        return this.viewID;
    }

    public void setViewID(int id) {
        this.viewID = id;
    }

    @Override
    public void showPanel() {
        try {
            employeeToShow = Employee.getEmployeeByID(viewID);
            mainFrame.getLabelViewEmployeeName().setText(employeeToShow.toString());
            mainFrame.getLabelViewEmployeeID().setText(employeeToShow.getIdNumber() + "");
            
            mainLayout.show(mainCardPanel, PANEL_NAME);
            hideCurrentDayDetails();
            calendarModel.restartCalendar();
            buildCalendar();
            
            if(NavigationController.getInstance().getAdmin().getUserType().equalsIgnoreCase(LoginController.TYPE_ENCODER)){
                mainFrame.getLabelViewEmployeeName().setPreferredSize(new Dimension((int)mainFrame.getLabelViewEmployeeName().getPreferredSize().getWidth() + (int) mainFrame.getEditEmployeeLabel().getPreferredSize().getWidth(), (int)mainFrame.getLabelViewEmployeeName().getPreferredSize().getHeight()));
                mainFrame.getEditEmployeeLabel().setVisible(false);
                //mainFrame.getLabelEditCurrentAttendance().setVisible(false);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ViewoEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // sample only
    public void buildCalendar() {

        try {
            mainFrame.getLabelViewEmployeeSalary().setText("Computed salary: " + employeeToShow.computeSalaryMonth(calendarModel.getMonth(), calendarModel.getYear()));
        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewCalendar = new JPanel[CALENDAR_ROWS * CALENDAR_COLS];

        mainFrame.getPanelViewEmployeeCalendar().removeAll();

        mainFrame.getLabelViewEmployeeMonthYear().setText(monthToString(calendarModel.getMonth()) + " " + calendarModel.getYear());

        attendance = new ArrayList<>();

        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQL_GET_ATTENDANCE);

            String dateString = calendarModel.getYear() + "-" + calendarModel.getMonth() + "-01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setInt(3, employeeToShow.getEmpID());

            System.out.println(stmt.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Date d = rs.getDate(SQL_DATE_ATTRIBUTE);
                Time tIn = rs.getTime(SQL_TIMEIN_ATTRIBUTE);
                Time tOut = rs.getTime(SQL_TIMEOUT_ATTRIBUTE);
                int leave = rs.getInt(SQL_LEAVE_ATTRIBUTE);
                String[] dArray = sdf.format(d).split("-");
                attendance.add(new AttendanceModel(Integer.parseInt(dArray[1]), Integer.parseInt(dArray[2]), Integer.parseInt(dArray[0]), tIn, tOut, leave));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        JPanel temp;

        for (int i = 0; i < calendarModel.getFirstDay(); i++) {
            temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        int curIndex = 0;
        for (int i = 0; i < calendarModel.getMaxDays(); i++) {
            String projectName = "";
            String dateString = calendarModel.getYear() + "-" + calendarModel.getMonth() + "-" + (i+1);
            String dateTodayString = calendarModel.getYearToday() + "-" + calendarModel.getMonthToday() + "-" + calendarModel.getDayToday();
            
            try {
                Date date = sdf.parse(dateString);
                Date dateToday = sdf.parse(dateTodayString);
                Project project = getProjectToday(i+1, employeeToShow.getEmpID());
                int status = 0;

                if (curIndex < attendance.size() && attendance.get(curIndex).getDay() == i + 1) {
                    long timediff = attendance.get(curIndex).getTimeOut().getTime() - attendance.get(curIndex).getTimeIn().getTime();
                    
                    // on leave
                    if(attendance.get(curIndex).getLeave() == 1){
                        status = CalendarDatePanel.ATTENDANCE_STATUS_LEAVE;
                    }
                    // undertime
                    else if (timediff < CalendarDatePanel.EIGHT_HOURS_MILLISEC) {
                        status = CalendarDatePanel.ATTENDANCE_STATUS_UNDERTIME;
                    } // overtime
                    else if (timediff >= CalendarDatePanel.EIGHT_HOURS_MILLISEC + CalendarDatePanel.ONE_HOUR_MILLISEC) {
                        status = CalendarDatePanel.ATTENDANCE_STATUS_OVERTIME;
                    } // complete
                    else if (timediff >= CalendarDatePanel.EIGHT_HOURS_MILLISEC && timediff < CalendarDatePanel.EIGHT_HOURS_MILLISEC + CalendarDatePanel.ONE_HOUR_MILLISEC) {
                        status = CalendarDatePanel.ATTENDANCE_STATUS_COMPLETE;
                    }
                    curIndex++;
                } 
                // absent
                // if there is project and the date today is between date started and date due
                else if(project != null && (date.after(project.getDateStarted()) || date.equals(project.getDateStarted())) && (date.before(dateToday))){
                    status = CalendarDatePanel.ATTENDANCE_STATUS_ABSENT;
                }
                // no project
                // if there is no project and the date is not after the date today
                else if((date.before(dateToday) || date.equals(dateToday)) && project == null){
                    status = CalendarDatePanel.ATTENDANCE_STATUS_NO_PROJ;
                }
                
                if(project != null){
                    projectName = project.getName();
                }
                
                temp = new CalendarDatePanel(this.viewID, i + 1, calendarModel.getMonth(), calendarModel.getYear(), projectName, status);
                if(date.equals(dateToday)){
                    temp.setBackground(new Color(224, 224, 224));
                }
                temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
                viewCalendar[i] = temp;
                mainFrame.getPanelViewEmployeeCalendar().add(temp);
                
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = calendarModel.getMaxDays() + calendarModel.getFirstDay(); i < CALENDAR_ROWS * CALENDAR_COLS; i++) {
            temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }
    }

    public void setDaySelected(int daySelected) {
        this.daySelected = daySelected;
    }

    public void hideCurrentDayDetails() {
        mainFrame.getPanelCurrentDate().setVisible(false);
        mainFrame.getLabelChangesAttendance().setVisible(false);
        mainFrame.getScrollPaneChangesAttendance().setVisible(false);
    }

    public void showCurrentDayDetails(int day, String timeIn, String timeOut) {
        try {
            mainFrame.getPanelCurrentDate().setVisible(true);

            mainFrame.getLabelCurrentDay().setText(String.valueOf(day));
            mainFrame.getLabelCurrentTimeIn().setText("Time In: " + timeIn);
            mainFrame.getLabelCurrentTimeOut().setText("Time Out: " + timeOut);

            auditTrail = new ArrayList<>();
            auditTrail = AttendanceAuditTrail.getAttendanceAuditTrailOfEmployee(employeeToShow.getEmpID(), new SimpleDateFormat("yyyy/MM/dd").parse(calendarModel.getYear() + "/" + calendarModel.getMonth() + "/" + day));

            auditTrailPanel = new ArrayList<>();
            mainFrame.getPanelChangesAttendanceContainer().removeAll();

            int len = auditTrail.size();

            if (len > 0) {
                mainFrame.getLabelChangesAttendance().setVisible(true);
                mainFrame.getScrollPaneChangesAttendance().setVisible(true);

                mainFrame.getLabelChangesAttendance().setText("Changes in Attendance for " + monthToString(calendarModel.getMonth()) + " " + day + ", " + calendarModel.getYear());
                mainFrame.getPanelChangesAttendanceContainer().setPreferredSize(new Dimension(AttendanceChangesPanel.PANEL_WIDTH, AttendanceChangesPanel.PANEL_HEIGHT * len));

                for (int i = 0; i < len; i++) {
                    AttendanceChangesPanel temp = new AttendanceChangesPanel(auditTrail.get(i).getAttribute(), auditTrail.get(i).getOldValue(), auditTrail.get(i).getNewValue(), auditTrail.get(i).getDate(), auditTrail.get(i).getTime(), AdminModel.getAdminNameByID(auditTrail.get(i).getAdminID()));
                    mainFrame.getPanelChangesAttendanceContainer().add(temp);
                    auditTrailPanel.add(temp);
                }

                mainFrame.getPanelChangesAttendanceContainer().repaint();
                mainFrame.getPanelChangesAttendanceContainer().revalidate();

            } else {
                mainFrame.getLabelChangesAttendance().setVisible(false);
                mainFrame.getScrollPaneChangesAttendance().setVisible(false);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String monthToString(int month) {
        String sMonth = "";

        switch (month) {
            case (CalendarModel.NJANUARY):
                sMonth = CalendarModel.SJANUARY;
                break;
            case (CalendarModel.NFEBRUARY):
                sMonth = CalendarModel.SFEBRUARY;
                break;
            case (CalendarModel.NMARCH):
                sMonth = CalendarModel.SMARCH;
                break;
            case (CalendarModel.NAPRIL):
                sMonth = CalendarModel.SAPRIL;
                break;
            case (CalendarModel.NMAY):
                sMonth = CalendarModel.SMAY;
                break;
            case (CalendarModel.NJUNE):
                sMonth = CalendarModel.SJUNE;
                break;
            case (CalendarModel.NJULY):
                sMonth = CalendarModel.SJULY;
                break;
            case (CalendarModel.NAUGUST):
                sMonth = CalendarModel.SAUGUST;
                break;
            case (CalendarModel.NSEPTEMBER):
                sMonth = CalendarModel.SSEPTEMBER;
                break;
            case (CalendarModel.NOCTOBER):
                sMonth = CalendarModel.SOCTOBER;
                break;
            case (CalendarModel.NNOVEMBER):
                sMonth = CalendarModel.SNOVEMBER;
                break;
            case (CalendarModel.NDECEMBER):
                sMonth = CalendarModel.SDECEMBER;
                break;
        }

        return sMonth;
    }

    private Project getProjectToday(int day, int empID) {
        Project project = null;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQL_GET_PROJECT_FOR_ATTENDANCE);
            String dateString = calendarModel.getYear() + "-" + calendarModel.getMonth() + "-" + day;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);

            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setInt(2, empID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                project = new Project(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
            }
            if (project == null) {
                project = Project.getUndueProjectByID(employeeToShow.getProjectID(), new java.sql.Date(date.getTime()));
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return project;
    }
}
