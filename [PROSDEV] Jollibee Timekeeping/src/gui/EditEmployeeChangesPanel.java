package gui;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditEmployeeChangesPanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 380;
    public static final int PANEL_HEIGHT = 110;
    
    public EditEmployeeChangesPanel(String attributeName, String oldValue, String newValue, Date date, Time time, String adminName) {
        initComponents();
        
        labelAttributeName.setText(attributeName);
        labelOldValue.setText(oldValue);
        labelNewValue.setText(newValue);
        
        
        String timeString = new SimpleDateFormat("h:mm a").format(new Date(time.getTime()));
        
        labelTimestamp.setText(date.toString() + " | " + timeString);
        labelAdminName.setText(adminName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAttribute = new javax.swing.JLabel();
        labelWasChangedFrom = new javax.swing.JLabel();
        labelTo = new javax.swing.JLabel();
        labelAttributeName = new javax.swing.JLabel();
        labelOldValue = new javax.swing.JLabel();
        labelNewValue = new javax.swing.JLabel();
        labelTimestamp = new javax.swing.JLabel();
        labelAdminName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));

        labelAttribute.setFont(new java.awt.Font("Open Sans Light", 0, 14)); // NOI18N
        labelAttribute.setForeground(new java.awt.Color(102, 102, 102));
        labelAttribute.setText("Attribute");

        labelWasChangedFrom.setFont(new java.awt.Font("Open Sans Light", 0, 14)); // NOI18N
        labelWasChangedFrom.setForeground(new java.awt.Color(102, 102, 102));
        labelWasChangedFrom.setText("was changed from");

        labelTo.setFont(new java.awt.Font("Open Sans Light", 0, 14)); // NOI18N
        labelTo.setForeground(new java.awt.Color(102, 102, 102));
        labelTo.setText("to");

        labelAttributeName.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelAttributeName.setText("attribute_name");

        labelOldValue.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelOldValue.setText("old_value");

        labelNewValue.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelNewValue.setText("new_value");

        labelTimestamp.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        labelTimestamp.setText("mm/dd/yyyy h:mm a");
        labelTimestamp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(238, 238, 238)));
        labelTimestamp.setOpaque(true);

        labelAdminName.setBackground(new java.awt.Color(204, 204, 204));
        labelAdminName.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        labelAdminName.setText("admin name");
        labelAdminName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(204, 204, 204)));
        labelAdminName.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAttribute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAttributeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNewValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelWasChangedFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOldValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(labelAdminName, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAttribute)
                    .addComponent(labelAttributeName))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWasChangedFrom)
                    .addComponent(labelOldValue))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTo)
                    .addComponent(labelNewValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimestamp)
                    .addComponent(labelAdminName))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAdminName;
    private javax.swing.JLabel labelAttribute;
    private javax.swing.JLabel labelAttributeName;
    private javax.swing.JLabel labelNewValue;
    private javax.swing.JLabel labelOldValue;
    private javax.swing.JLabel labelTimestamp;
    private javax.swing.JLabel labelTo;
    private javax.swing.JLabel labelWasChangedFrom;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelAdminName() {
        return labelAdminName;
    }

    public javax.swing.JLabel getLabelAttributeName() {
        return labelAttributeName;
    }

    public javax.swing.JLabel getLabelNewValue() {
        return labelNewValue;
    }

    public javax.swing.JLabel getLabelOldValue() {
        return labelOldValue;
    }

    public javax.swing.JLabel getLabelTimestamp() {
        return labelTimestamp;
    }
}
