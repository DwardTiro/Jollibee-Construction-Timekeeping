
package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManageEmployeeFilterPanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 250;
    public static final int PANEL_HEIGHT = 28;
    
    public ManageEmployeeFilterPanel(String projectName) {
        initComponents();
        
        labelProjectName.setText(projectName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelProjectName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(250, 28));
        setMinimumSize(new java.awt.Dimension(0, 0));

        labelProjectName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelProjectName.setText("Project Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelProjectName;
    // End of variables declaration//GEN-END:variables

    public JLabel getLabelProjectName(){
        return labelProjectName;
    }
    
}
