package gui;

public class ComputeSalaryEmployeePanel extends javax.swing.JPanel {

    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 100;
    
    public ComputeSalaryEmployeePanel(String name, String idNumber) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
    }
    
    public ComputeSalaryEmployeePanel(String name, String idNumber, String projectName, String salary) {
        initComponents();
        
        labelName.setText(name);
        labelIDNumber.setText(idNumber);
        labelProjectName.setText(projectName);
        labelSalary.setText(salary);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelIDNumber = new javax.swing.JLabel();
        labelProjectName = new javax.swing.JLabel();
        panelSalary = new javax.swing.JPanel();
        labelSalary = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        setMaximumSize(new java.awt.Dimension(600, 100));
        setMinimumSize(new java.awt.Dimension(600, 100));
        setPreferredSize(new java.awt.Dimension(600, 100));

        labelName.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        labelName.setText("Employee Name");

        labelIDNumber.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelIDNumber.setForeground(new java.awt.Color(153, 153, 153));
        labelIDNumber.setText("ID Number");

        labelProjectName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelProjectName.setForeground(new java.awt.Color(153, 153, 153));
        labelProjectName.setText("Project Name");

        panelSalary.setBackground(new java.awt.Color(247, 247, 247));
        panelSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(224, 224, 224)));

        labelSalary.setFont(new java.awt.Font("Open Sans Light", 1, 20)); // NOI18N
        labelSalary.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSalary.setText("P 100,000,000.00");

        javax.swing.GroupLayout panelSalaryLayout = new javax.swing.GroupLayout(panelSalary);
        panelSalary.setLayout(panelSalaryLayout);
        panelSalaryLayout.setHorizontalGroup(
            panelSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSalaryLayout.setVerticalGroup(
            panelSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIDNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(labelProjectName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIDNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProjectName)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(panelSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIDNumber;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelProjectName;
    private javax.swing.JLabel labelSalary;
    private javax.swing.JPanel panelSalary;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelIDNumber() {
        return labelIDNumber;
    }

    public javax.swing.JLabel getLabelName() {
        return labelName;
    }

    public javax.swing.JLabel getLabelProjectName() {
        return labelProjectName;
    }

    public javax.swing.JLabel getLabelSalary() {
        return labelSalary;
    }

    public javax.swing.JPanel getPanelSalary() {
        return panelSalary;
    }
}
