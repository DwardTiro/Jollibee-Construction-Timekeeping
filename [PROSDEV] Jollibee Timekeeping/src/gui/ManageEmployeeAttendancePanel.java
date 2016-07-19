package gui;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerDateModel;

public class ManageEmployeeAttendancePanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 500;
    public static final int PANEL_HEIGHT = 120;
    
    public static final Color COLOR_ADD = Color.GREEN;
    public static final Color COLOR_DONT_ADD = Color.WHITE;
    
    private boolean toAddStatus;
    
    public ManageEmployeeAttendancePanel(String name, String idNumber) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
        
        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setCalendarField(Calendar.MINUTE);
        spinnerTimeIn.setModel(model1);
        spinnerTimeIn.setEditor(new JSpinner.DateEditor(spinnerTimeIn, "h:mm a"));
        ((DefaultEditor) spinnerTimeIn.getEditor()).getTextField().setEditable(false);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        spinnerTimeIn.setValue(calendar.getTime());

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setCalendarField(Calendar.MINUTE);
        spinnerTimeOut.setModel(model2);
        spinnerTimeOut.setEditor(new JSpinner.DateEditor(spinnerTimeOut, "h:mm a"));
        ((DefaultEditor) spinnerTimeOut.getEditor()).getTextField().setEditable(false);
        
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        spinnerTimeOut.setValue(calendar.getTime());
        
        toAddStatus = true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelIDNumber = new javax.swing.JLabel();
        labelTimeIn = new javax.swing.JLabel();
        spinnerTimeIn = new javax.swing.JSpinner();
        labelTimeOut = new javax.swing.JLabel();
        spinnerTimeOut = new javax.swing.JSpinner();
        panelStatus = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        setMaximumSize(new java.awt.Dimension(500, 120));
        setMinimumSize(new java.awt.Dimension(500, 120));

        labelName.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        labelName.setText("LastName, FirstName Middle Name");

        labelIDNumber.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelIDNumber.setForeground(new java.awt.Color(153, 153, 153));
        labelIDNumber.setText("ID Number");

        labelTimeIn.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelTimeIn.setText("Time In: ");

        spinnerTimeIn.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N

        labelTimeOut.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelTimeOut.setText("Time Out: ");

        spinnerTimeOut.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N

        panelStatus.setBackground(java.awt.Color.green);

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelIDNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelTimeIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(labelTimeOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIDNumber)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimeIn)
                    .addComponent(spinnerTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTimeOut)
                    .addComponent(spinnerTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIDNumber;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTimeIn;
    private javax.swing.JLabel labelTimeOut;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JSpinner spinnerTimeIn;
    private javax.swing.JSpinner spinnerTimeOut;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelIDNumber() {
        return labelIDNumber;
    }

    public javax.swing.JLabel getLabelName() {
        return labelName;
    }

    public javax.swing.JSpinner getSpinnerTimeIn() {
        return spinnerTimeIn;
    }

    public javax.swing.JSpinner getSpinnerTimeOut() {
        return spinnerTimeOut;
    }
    
    public javax.swing.JPanel getPanelStatus() {
        return panelStatus;
    }
    
    public boolean getToAddStatus(){
        return toAddStatus;
    }
    
    public void setToAddStatus(boolean toAddStatus){
        this.toAddStatus = toAddStatus;
    }
}
