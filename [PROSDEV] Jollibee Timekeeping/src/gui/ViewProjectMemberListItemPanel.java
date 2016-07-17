package gui;

public class ViewProjectMemberListItemPanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 80;
    
    public ViewProjectMemberListItemPanel(String name, String idNumber) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelIDNumber = new javax.swing.JLabel();
        labelRemove = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        setMaximumSize(new java.awt.Dimension(600, 80));

        labelName.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        labelName.setText("LastName, FirstName MiddleName");

        labelIDNumber.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelIDNumber.setForeground(new java.awt.Color(153, 153, 153));
        labelIDNumber.setText("ID Number");

        labelRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove Icon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelIDNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(labelRemove)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName)
                    .addComponent(labelRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIDNumber)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIDNumber;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRemove;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelIDNumber() {
        return labelIDNumber;
    }

    public javax.swing.JLabel getLabelName() {
        return labelName;
    }

    public javax.swing.JLabel getLabelRemove() {
        return labelRemove;
    }
}
