package gui;

import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class ManageEmployeeAttendancePanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 500;
    public static final int PANEL_HEIGHT = 120;
    
    public ManageEmployeeAttendancePanel(String name, String idNumber) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
        
        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setCalendarField(Calendar.MINUTE);
        spinnerTimeIn.setModel(model1);
        spinnerTimeIn.setEditor(new JSpinner.DateEditor(spinnerTimeIn, "h:mm a"));

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setCalendarField(Calendar.MINUTE);
        spinnerTimeOut.setModel(model2);
        spinnerTimeOut.setEditor(new JSpinner.DateEditor(spinnerTimeOut, "h:mm a"));
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        setMaximumSize(new java.awt.Dimension(500, 120));
        setMinimumSize(new java.awt.Dimension(500, 120));

        labelName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelName.setText("LastName, FirstName Middle Name");

        labelIDNumber.setForeground(new java.awt.Color(153, 153, 153));
        labelIDNumber.setText("ID Number");

        labelTimeIn.setText("Time In: ");

        labelTimeOut.setText("Time Out: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName)
                    .addComponent(labelIDNumber)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTimeIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(labelTimeOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
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
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIDNumber;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTimeIn;
    private javax.swing.JLabel labelTimeOut;
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
}
