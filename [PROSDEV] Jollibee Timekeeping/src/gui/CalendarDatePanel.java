package gui;

import controller.ViewEmployeeController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AttendanceModel;

public class CalendarDatePanel extends javax.swing.JPanel {

    public static final int ONE_HOUR_MILLISEC = 3600000;
    public static final int EIGHT_HOURS_MILLISEC = ONE_HOUR_MILLISEC * 8;

    public static final int ATTENDANCE_STATUS_COMPLETE = 1;
    public static final int ATTENDANCE_STATUS_UNDERTIME = 2;
    public static final int ATTENDANCE_STATUS_OVERTIME = 3;
    public static final int ATTENDANCE_STATUS_ABSENT = 4;
    public static final int ATTENDANCE_STATUS_LEAVE = 5;
    public static final int ATTENDANCE_STATUS_NO_PROJ = 6;

    private final Color COLOR_COMPLETE = Color.GREEN;
    private final Color COLOR_UNDERTIME = Color.YELLOW;
    private final Color COLOR_OVERTIME = Color.BLUE;
    private final Color COLOR_ABSENT = Color.RED;
    private final Color COLOR_LEAVE = Color.PINK;
    private final Color COLOR_NO_PROJ = Color.BLACK;
    private final Color COLOR_DEFAULT = Color.WHITE;

    private final int day;
    private final int month;
    private final int year;
    private int emp_id;

    public CalendarDatePanel(int emp_id, int day, int month, int year, String projectName, int attendanceStatus) throws SQLException {
        initComponents();
        this.emp_id = emp_id;
        this.day = day;
        this.month = month;
        this.year = year;

        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);
        /*
         if (AttendanceModel.isPaid(emp_id, month, day, year)) {
         addListenersPaid();
         } else if(!AttendanceModel.isPaid(emp_id, month, day, year) && year <= CalendarModel.getInstance().getYearToday() && month <= CalendarModel.getInstance().getMonthToday() && day <= CalendarModel.getInstance().getDayToday()){
         addListeners();
         }
         */
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        Date date_clicked = c.getTime();

        Date date_today = new Date();
        int isPaid = AttendanceModel.isPaid(emp_id, month, day, year);

        if (!date_clicked.after(date_today)) {
            if (isPaid == -1) {
                addListenersAdd();
            } else if (isPaid == -2) {
                addListenersPaid();
            } else{
                addListenersEdit(isPaid);
            }
        }
        
        setStatus(attendanceStatus);
    }

    public CalendarDatePanel(int day, int month, int year, String projectName) {
        initComponents();

        this.day = day;
        this.month = month;
        this.year = year;

        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);
    }
    
    public void setStatus(int attendanceStatus) {
        switch (attendanceStatus) {
            case ATTENDANCE_STATUS_COMPLETE:
                panelAttendanceStatus.setBackground(COLOR_COMPLETE);
                break;
            case ATTENDANCE_STATUS_UNDERTIME:
                panelAttendanceStatus.setBackground(COLOR_UNDERTIME);
                break;
            case ATTENDANCE_STATUS_OVERTIME:
                panelAttendanceStatus.setBackground(COLOR_OVERTIME);
                break;
            case ATTENDANCE_STATUS_ABSENT:
                panelAttendanceStatus.setBackground(COLOR_ABSENT);
                break;
            case ATTENDANCE_STATUS_LEAVE:
                panelAttendanceStatus.setBackground(COLOR_LEAVE);
                break;
            case ATTENDANCE_STATUS_NO_PROJ:
                panelAttendanceStatus.setBackground(COLOR_NO_PROJ);
                break;
            default:
                panelAttendanceStatus.setBackground(COLOR_DEFAULT);
                panelAttendanceStatus.setOpaque(false);
        }
    }
    
    private void addListenersAdd() {
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                AttendanceFrame addEditHours = new AttendanceFrame(day, month, year);
                addEditHours.setVisible(true);
                ViewEmployeeController.getInstance().setDaySelected(day);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        
        });
        
    }

    private void addListenersEdit(int the_emp) {
        
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Date date = new SimpleDateFormat("yyyy/MM/dd").parse(year + "/" + month + "/" + day);
                    AttendanceModel attendance = AttendanceModel.getAttendace(emp_id, date);
                    
                    DateFormat timeFormat = new SimpleDateFormat("h:mm a");
                    
                    ViewEmployeeController.getInstance().showCurrentDayDetails(day, timeFormat.format(new Date(attendance.getTimeIn().getTime())), timeFormat.format(new Date(attendance.getTimeOut().getTime())));
                    ViewEmployeeController.getInstance().setDaySelected(day);
                    //AttendanceFrame addEditHours = new AttendanceFrame(day, month, year,the_emp);
                    //addEditHours.setVisible(true);
                    
                    MainFrame.getInstance().getLabelEditCurrentAttendance().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarDatePanel.class.getName()).log(Level.SEVERE, null, ex);
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
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }

    private void addListenersPaid() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Date date = new SimpleDateFormat("yyyy/MM/dd").parse(year + "/" + month + "/" + day);
                    AttendanceModel attendance = AttendanceModel.getAttendace(emp_id, date);
                    
                    DateFormat timeFormat = new SimpleDateFormat("h:mm a");
                    if(attendance != null)
                        ViewEmployeeController.getInstance().showCurrentDayDetails(day, timeFormat.format(new Date(attendance.getTimeIn().getTime())), timeFormat.format(new Date(attendance.getTimeOut().getTime())));
                    else
                        ViewEmployeeController.getInstance().hideCurrentDayDetails();
                    
                    MainFrame.getInstance().getLabelEditCurrentAttendance().setVisible(false);
                    ViewEmployeeController.getInstance().setDaySelected(day);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarDatePanel.class.getName()).log(Level.SEVERE, null, ex);
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
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }

    public void setProjectName(String projectName) {
        labelProjectName.setText(projectName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDay = new javax.swing.JLabel();
        labelProjectName = new javax.swing.JLabel();
        panelAttendanceStatus = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelDay.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        labelDay.setText("Day");

        labelProjectName.setFont(new java.awt.Font("Open Sans Light", 1, 10)); // NOI18N
        labelProjectName.setText("Project Name");

        panelAttendanceStatus.setBackground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout panelAttendanceStatusLayout = new javax.swing.GroupLayout(panelAttendanceStatus);
        panelAttendanceStatus.setLayout(panelAttendanceStatusLayout);
        panelAttendanceStatusLayout.setHorizontalGroup(
            panelAttendanceStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelAttendanceStatusLayout.setVerticalGroup(
            panelAttendanceStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAttendanceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProjectName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelAttendanceStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelProjectName;
    private javax.swing.JPanel panelAttendanceStatus;
    // End of variables declaration//GEN-END:variables
}
