package gui;

import controller.ViewEmployeeController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import model.AttendanceModel;

public class AttendanceFrame extends javax.swing.JFrame {

    private int day;
    private int month;
    private int year;

    public AttendanceFrame(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        initComponents();
        addListener_employee();
        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setCalendarField(Calendar.MINUTE);
        spinnerTimeIn.setModel(model1);
        spinnerTimeIn.setEditor(new JSpinner.DateEditor(spinnerTimeIn, "h:mm a"));

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setCalendarField(Calendar.MINUTE);
        spinnerTimeOut.setModel(model2);
        spinnerTimeOut.setEditor(new JSpinner.DateEditor(spinnerTimeOut, "h:mm a"));
    }

    public AttendanceFrame(int day, int month, int year, int the_emp) {
        this.day = day;
        this.month = month;
        this.year = year;

        initComponents();
        addListener_employeeEdit(the_emp);
        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setCalendarField(Calendar.MINUTE);
        spinnerTimeIn.setModel(model1);
        spinnerTimeIn.setEditor(new JSpinner.DateEditor(spinnerTimeIn, "h:mm a"));

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setCalendarField(Calendar.MINUTE);
        spinnerTimeOut.setModel(model2);
        spinnerTimeOut.setEditor(new JSpinner.DateEditor(spinnerTimeOut, "h:mm a"));
    }

    public AttendanceFrame() {
        initComponents();
        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setCalendarField(Calendar.MINUTE);
        spinnerTimeIn.setModel(model1);
        spinnerTimeIn.setEditor(new JSpinner.DateEditor(spinnerTimeIn, "h:mm a"));

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setCalendarField(Calendar.MINUTE);

        spinnerTimeOut.setModel(model2);
        spinnerTimeOut.setEditor(new JSpinner.DateEditor(spinnerTimeOut, "h:mm a"));
    }

    private void addListener_employee() {

        buttonSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Date dateToday = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-"+day);
                    //Date time_in = new SimpleDateFormat("HH:mm").parse(spinnerTimeIn.getValue()));

                    System.out.println("Date passed to me " + day + " " + month + " " + year);

                    Date time_in = (Date) spinnerTimeIn.getValue();
                    System.out.println(time_in.toString());
                    Date time_out = (Date) spinnerTimeOut.getValue();
                    Date date_today = new SimpleDateFormat("yyyy:MM:dd").parse(year + ":" + month + ":" + day);
                    int leave = 0;
                    if (isLeave.isSelected()) {
                        leave = 1;
                    }

                    AttendanceModel.saveAttendance(ViewEmployeeController.getInstance().getID(), date_today, time_in, time_out, leave);

                    close();
                } catch (ParseException ex) {
                    //Logger.getLogger(AttendanceFrame.class.getName()).log(Level.SEVERE, null, ex);
                    MainFrame.getInstance().showError("Invalid Date", "");
                } finally {
                    ViewEmployeeController.getInstance().buildCalendar();
                    MainFrame.getInstance().getViewEmployeePanel().repaint();
                    MainFrame.getInstance().getViewEmployeePanel().revalidate();
                }
                AttendanceFrame.this.dispose();
            }

        });

    }

    
    private void addListener_employeeEdit(int entry_id) {
        
        buttonSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("U edit here!!!");
                    //Date dateToday = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-"+day);
                    //Date time_in = new SimpleDateFormat("HH:mm").parse(spinnerTimeIn.getValue()));

                    System.out.println("Date passed to me " + day + " " + month + " " + year);

                    Date time_in = (Date) spinnerTimeIn.getValue();
                    System.out.println(time_in.toString());
                    Date time_out = (Date) spinnerTimeOut.getValue();
                    Date date_today = new SimpleDateFormat("yyyy:MM:dd").parse(year + ":" + month + ":" + day);
                    int leave = 0;
                    if (isLeave.isSelected()) {
                        leave = 1;
                    }

                    AttendanceModel.editAttendance(ViewEmployeeController.getInstance().getID(), date_today, time_in, time_out, leave,entry_id);

                    close();
                } catch (ParseException ex) {
                    //Logger.getLogger(AttendanceFrame.class.getName()).log(Level.SEVERE, null, ex);
                    MainFrame.getInstance().showError("Invalid Date", "");
                } finally {
                    ViewEmployeeController.getInstance().buildCalendar();
                    MainFrame.getInstance().getViewEmployeePanel().repaint();
                    MainFrame.getInstance().getViewEmployeePanel().revalidate();
                }
                AttendanceFrame.this.dispose();
            }

        });

    }
    
    
    
    public void close() {
        //super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        labelAttendance = new javax.swing.JLabel();
        labelTimeIn = new javax.swing.JLabel();
        labelTimeOut = new javax.swing.JLabel();
        spinnerTimeIn = new javax.swing.JSpinner();
        spinnerTimeOut = new javax.swing.JSpinner();
        buttonSubmit = new javax.swing.JButton();
        isLeave = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance");
        setBackground(new java.awt.Color(255, 255, 255));

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        labelAttendance.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        labelAttendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAttendance.setText("Attendance");
        labelAttendance.setOpaque(true);

        labelTimeIn.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelTimeIn.setText("Time in:");

        labelTimeOut.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelTimeOut.setText("Time out:");

        spinnerTimeIn.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N

        spinnerTimeOut.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N

        buttonSubmit.setBackground(new java.awt.Color(231, 28, 35));
        buttonSubmit.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        buttonSubmit.setForeground(new java.awt.Color(255, 255, 255));
        buttonSubmit.setText("Submit");

        isLeave.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        isLeave.setText("Leave(?)");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(isLeave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSubmit))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTimeIn)
                            .addComponent(labelTimeOut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAttendance)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimeIn)
                    .addComponent(spinnerTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimeOut)
                    .addComponent(spinnerTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSubmit)
                    .addComponent(isLeave))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JCheckBox isLeave;
    private javax.swing.JLabel labelAttendance;
    private javax.swing.JLabel labelTimeIn;
    private javax.swing.JLabel labelTimeOut;
    private javax.swing.JPanel panelMain;
    private javax.swing.JSpinner spinnerTimeIn;
    private javax.swing.JSpinner spinnerTimeOut;
    // End of variables declaration//GEN-END:variables
}
