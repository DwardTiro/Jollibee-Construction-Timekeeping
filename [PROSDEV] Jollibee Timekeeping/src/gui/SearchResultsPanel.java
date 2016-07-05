package gui;

public class SearchResultsPanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 770;
    public static final int PANEL_HEIGHT = 80;
    
    public SearchResultsPanel(String name, String idNumber) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelIDNumber = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        setMaximumSize(new java.awt.Dimension(770, 80));

        labelName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelName.setText("LastName, FirstName MiddleName");

        labelIDNumber.setForeground(new java.awt.Color(153, 153, 153));
        labelIDNumber.setText("ID Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(labelIDNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIDNumber)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIDNumber;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelIDNumber() {
        return labelIDNumber;
    }

    public javax.swing.JLabel getLabelName() {
        return labelName;
    }
}
