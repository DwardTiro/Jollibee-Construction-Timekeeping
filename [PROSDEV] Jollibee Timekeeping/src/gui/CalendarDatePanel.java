package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import model.AttendanceModel;
import model.CalendarModel;

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

    public CalendarDatePanel(int emp_id, int day, int month, int year, String projectName, int attendanceStatus) throws SQLException {
        initComponents();

        this.day = day;
        this.month = month;
        this.year = year;

        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);

        if (AttendanceModel.isPaid(emp_id, month, day, year)) {
            addListenersPaid();
        } else if(!AttendanceModel.isPaid(emp_id, month, day, year) && year <= CalendarModel.getInstance().getYearToday() && month <= CalendarModel.getInstance().getMonthToday() && day <= CalendarModel.getInstance().getDayToday()){
            addListeners();
        }

        setStatus(attendanceStatus);
    }

    public CalendarDatePanel(int day, int month, int year, String projectName, int attendanceStatus) {
        initComponents();

        this.day = day;
        this.month = month;
        this.year = year;

        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);

        setStatus(attendanceStatus);
        
        addListeners();
    }

    public CalendarDatePanel(int day, int month, int year, String projectName) {
        initComponents();

        this.day = day;
        this.month = month;
        this.year = year;

        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);
    }
    
    /*public CalendarDatePanel(int day, String projectName, int attendanceStatus) {
     initComponents();
        
     this.day = day;
        
     labelDay.setText(String.valueOf(day));
     labelProjectName.setText(projectName);
        
     switch(attendanceStatus){
     case ATTENDANCE_STATUS_COMPLETE:    panelAttendanceStatus.setBackground(COLOR_COMPLETE); break;
     case ATTENDANCE_STATUS_UNDERTIME:   panelAttendanceStatus.setBackground(COLOR_UNDERTIME); break;
     case ATTENDANCE_STATUS_OVERTIME:    panelAttendanceStatus.setBackground(COLOR_OVERTIME); break;
     case ATTENDANCE_STATUS_ABSENT:      panelAttendanceStatus.setBackground(COLOR_ABSENT); break;
     case ATTENDANCE_STATUS_LEAVE:       panelAttendanceStatus.setBackground(COLOR_LEAVE); break;
     case ATTENDANCE_STATUS_NO_PROJ:     panelAttendanceStatus.setBackground(COLOR_NO_PROJ); break;
     }
     }
     */
    
    public void setStatus(int attendanceStatus){
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
    
    private void addListeners() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                AttendanceFrame addEditHours = new AttendanceFrame(day, month, year);
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
                //AttendanceFrame addEditHours = new AttendanceFrame(day, month, year);
                //addEditHours.setVisible(true);
                PopBox.infoBox("Already paid cant edit", "Error");
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

    public void setProjectName(String projectName){
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
