
package gui;

import java.awt.Color;

public class CalendarDatePanel extends javax.swing.JPanel {

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
    
    public CalendarDatePanel(int day, String projectName, int attendanceStatus) {
        initComponents();
        
        labelDay.setText(String.valueOf(day));
        labelProjectName.setText(projectName);
        
        switch(attendanceStatus){
            case ATTENDANCE_STATUS_COMPLETE: panelAttendanceStatus.setBackground(COLOR_COMPLETE); break;
            case ATTENDANCE_STATUS_UNDERTIME: panelAttendanceStatus.setBackground(COLOR_UNDERTIME); break;
            case ATTENDANCE_STATUS_OVERTIME: panelAttendanceStatus.setBackground(COLOR_OVERTIME); break;
            case ATTENDANCE_STATUS_ABSENT: panelAttendanceStatus.setBackground(COLOR_ABSENT); break;
            case ATTENDANCE_STATUS_LEAVE: panelAttendanceStatus.setBackground(COLOR_LEAVE); break;
            case ATTENDANCE_STATUS_NO_PROJ: panelAttendanceStatus.setBackground(COLOR_NO_PROJ); break;
        }
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDay = new javax.swing.JLabel();
        labelProjectName = new javax.swing.JLabel();
        panelAttendanceStatus = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelDay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelDay.setText("Day");

        labelProjectName.setText("Project Name");

        panelAttendanceStatus.setBackground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout panelAttendanceStatusLayout = new javax.swing.GroupLayout(panelAttendanceStatus);
        panelAttendanceStatus.setLayout(panelAttendanceStatusLayout);
        panelAttendanceStatusLayout.setHorizontalGroup(
            panelAttendanceStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAttendanceStatusLayout.setVerticalGroup(
            panelAttendanceStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(panelAttendanceStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDay))
                    .addComponent(panelAttendanceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProjectName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelProjectName;
    private javax.swing.JPanel panelAttendanceStatus;
    // End of variables declaration//GEN-END:variables
}
