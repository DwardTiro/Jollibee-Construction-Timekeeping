
package gui;

import java.awt.Toolkit;

public class MainFrame extends javax.swing.JFrame {

    private static final MainFrame mainFrame = new MainFrame();

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
    
    private MainFrame() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLogin = new javax.swing.JPanel();
        loginLabelJollibeeConstructionLogo = new javax.swing.JLabel();
        loginTextFieldUsername = new javax.swing.JTextField();
        loginPasswordFieldPassword = new javax.swing.JPasswordField();
        loginButtonLogin = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        mainPanelHeader = new javax.swing.JPanel();
        mainLabelJollibeeConstructionLogo = new javax.swing.JLabel();
        mainTextFieldSearch = new javax.swing.JTextField();
        mainLabelName = new javax.swing.JLabel();
        mainLabelLogout = new javax.swing.JLabel();
        mainPanelCardPanel = new javax.swing.JPanel();
        showEmployeePanel = new javax.swing.JPanel();
        labelShowEmployeeName = new javax.swing.JLabel();
        labelShowEmployeeID = new javax.swing.JLabel();
        panelShowEmployeeCalendar = new javax.swing.JPanel();
        testing = new javax.swing.JPanel();
        add_time = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        employeeTime = new javax.swing.JLabel();
        addEmployeePanel = new javax.swing.JPanel();
        labelAddEmployee = new javax.swing.JLabel();
        labelAddEmployeeIDNumber = new javax.swing.JLabel();
        labelAddEmployeeLastName = new javax.swing.JLabel();
        labelAddEmployeeFirstName = new javax.swing.JLabel();
        labelAddEmployeeMiddleName = new javax.swing.JLabel();
        labelAddEmployeeSalary = new javax.swing.JLabel();
        textFieldAddEmployeeIDNumber = new javax.swing.JTextField();
        textFieldAddEmployeeLastName = new javax.swing.JTextField();
        textFieldAddEmployeeFirstName = new javax.swing.JTextField();
        textFieldAddEmployeeMiddleName = new javax.swing.JTextField();
        textFieldAddEmployeeSalary = new javax.swing.JTextField();
        buttonAddEmployee = new javax.swing.JButton();
        editEmployeePanel = new javax.swing.JPanel();
        labelEditEmployee = new javax.swing.JLabel();
        labelEditEmployeeIDNumber = new javax.swing.JLabel();
        labelEditEmployeeLastName = new javax.swing.JLabel();
        labelEditEmployeeFirstName = new javax.swing.JLabel();
        labelEditEmployeeMiddleName = new javax.swing.JLabel();
        labelEditEmployeeSalary = new javax.swing.JLabel();
        textFieldEditEmployeeIDNumber = new javax.swing.JTextField();
        textFieldEditEmployeeLastName = new javax.swing.JTextField();
        textFieldEditEmployeeFirstName = new javax.swing.JTextField();
        textFieldEditEmployeeMiddleName = new javax.swing.JTextField();
        textFieldEditEmployeeSalary = new javax.swing.JTextField();
        buttonEditEmployeeSaveChanges = new javax.swing.JButton();
        mainPanelSidePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jollibee Construction Timekeeping");
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Jollibee Construction.png")));
        setPreferredSize(getMaximumSize());
        getContentPane().setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(255, 204, 51));
        panelLogin.setName("panelLogin"); // NOI18N
        panelLogin.setLayout(new java.awt.GridBagLayout());

        loginLabelJollibeeConstructionLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Jollibee Construction.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        panelLogin.add(loginLabelJollibeeConstructionLogo, gridBagConstraints);

        loginTextFieldUsername.setText("Username");
        loginTextFieldUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLogin.add(loginTextFieldUsername, gridBagConstraints);

        loginPasswordFieldPassword.setText("Password");
        loginPasswordFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLogin.add(loginPasswordFieldPassword, gridBagConstraints);

        loginButtonLogin.setBackground(new java.awt.Color(231, 28, 35));
        loginButtonLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        loginButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        loginButtonLogin.setText("Log-in");
        loginButtonLogin.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        panelLogin.add(loginButtonLogin, gridBagConstraints);

        getContentPane().add(panelLogin, "panelLogin");

        panelMain.setName("panelMain"); // NOI18N
        panelMain.setLayout(new java.awt.GridBagLayout());

        mainPanelHeader.setBackground(new java.awt.Color(244, 244, 244));
        mainPanelHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));
        mainPanelHeader.setLayout(new java.awt.GridBagLayout());

        mainLabelJollibeeConstructionLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Jollibee Construction Small.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.05;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        mainPanelHeader.add(mainLabelJollibeeConstructionLogo, gridBagConstraints);

        mainTextFieldSearch.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        mainTextFieldSearch.setText("Search");
        mainTextFieldSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 1.0;
        mainPanelHeader.add(mainTextFieldSearch, gridBagConstraints);

        mainLabelName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        mainLabelName.setText("Administrator Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        mainPanelHeader.add(mainLabelName, gridBagConstraints);

        mainLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        mainLabelLogout.setToolTipText("Logout");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 1.0;
        mainPanelHeader.add(mainLabelLogout, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        panelMain.add(mainPanelHeader, gridBagConstraints);

        mainPanelCardPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanelCardPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        mainPanelCardPanel.setLayout(new java.awt.CardLayout());

        showEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));

        labelShowEmployeeName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelShowEmployeeName.setText("LastName, FirstName MiddleName");

        labelShowEmployeeID.setText("ID Number");

        panelShowEmployeeCalendar.setBackground(new java.awt.Color(255, 255, 255));
        panelShowEmployeeCalendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(224, 224, 224)));
        panelShowEmployeeCalendar.setLayout(new java.awt.GridLayout(6, 7));

        javax.swing.GroupLayout showEmployeePanelLayout = new javax.swing.GroupLayout(showEmployeePanel);
        showEmployeePanel.setLayout(showEmployeePanelLayout);
        showEmployeePanelLayout.setHorizontalGroup(
            showEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showEmployeePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(showEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelShowEmployeeID)
                    .addComponent(labelShowEmployeeName)
                    .addComponent(panelShowEmployeeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showEmployeePanelLayout.setVerticalGroup(
            showEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelShowEmployeeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelShowEmployeeID)
                .addGap(36, 36, 36)
                .addComponent(panelShowEmployeeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(showEmployeePanel, "card4");

        testing.setBackground(new java.awt.Color(255, 255, 255));
        testing.setMinimumSize(new java.awt.Dimension(0, 0));
        testing.setPreferredSize(new java.awt.Dimension(0, 0));
        mainPanelCardPanel.add(testing, "card3");

        add_time.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(jPanel2);

        employeeTime.setText("Employee Time");

        javax.swing.GroupLayout add_timeLayout = new javax.swing.GroupLayout(add_time);
        add_time.setLayout(add_timeLayout);
        add_timeLayout.setHorizontalGroup(
            add_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_timeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(add_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        add_timeLayout.setVerticalGroup(
            add_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_timeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(employeeTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(add_time, "card2");

        addEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));

        labelAddEmployee.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelAddEmployee.setText("Add New Employee");

        labelAddEmployeeIDNumber.setText("ID Number");

        labelAddEmployeeLastName.setText("Last Name");

        labelAddEmployeeFirstName.setText("First Name");

        labelAddEmployeeMiddleName.setText("Middle Name");

        labelAddEmployeeSalary.setText("Salary");

        buttonAddEmployee.setBackground(new java.awt.Color(231, 28, 35));
        buttonAddEmployee.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonAddEmployee.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddEmployee.setText("Add Employee");

        javax.swing.GroupLayout addEmployeePanelLayout = new javax.swing.GroupLayout(addEmployeePanel);
        addEmployeePanel.setLayout(addEmployeePanelLayout);
        addEmployeePanelLayout.setHorizontalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddEmployee)
                    .addGroup(addEmployeePanelLayout.createSequentialGroup()
                        .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAddEmployeeIDNumber)
                            .addComponent(labelAddEmployeeLastName)
                            .addComponent(labelAddEmployeeFirstName)
                            .addComponent(labelAddEmployeeMiddleName)
                            .addComponent(labelAddEmployeeSalary))
                        .addGap(42, 42, 42)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldAddEmployeeIDNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(textFieldAddEmployeeLastName)
                            .addComponent(textFieldAddEmployeeFirstName)
                            .addComponent(textFieldAddEmployeeMiddleName)
                            .addComponent(textFieldAddEmployeeSalary)))
                    .addComponent(buttonAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addEmployeePanelLayout.setVerticalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelAddEmployee)
                .addGap(18, 18, 18)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeIDNumber)
                    .addComponent(textFieldAddEmployeeIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeLastName)
                    .addComponent(textFieldAddEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeFirstName)
                    .addComponent(textFieldAddEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeMiddleName)
                    .addComponent(textFieldAddEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeSalary)
                    .addComponent(textFieldAddEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAddEmployee)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(addEmployeePanel, "card5");

        editEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));

        labelEditEmployee.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelEditEmployee.setText("Edit Employee");

        labelEditEmployeeIDNumber.setText("ID Number");

        labelEditEmployeeLastName.setText("Last Name");

        labelEditEmployeeFirstName.setText("First Name");

        labelEditEmployeeMiddleName.setText("Middle Name");

        labelEditEmployeeSalary.setText("Salary");

        buttonEditEmployeeSaveChanges.setBackground(new java.awt.Color(231, 28, 35));
        buttonEditEmployeeSaveChanges.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonEditEmployeeSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditEmployeeSaveChanges.setText("Save Changes");

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditEmployee)
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEditEmployeeIDNumber)
                            .addComponent(labelEditEmployeeLastName)
                            .addComponent(labelEditEmployeeFirstName)
                            .addComponent(labelEditEmployeeMiddleName)
                            .addComponent(labelEditEmployeeSalary))
                        .addGap(42, 42, 42)
                        .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldEditEmployeeIDNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(textFieldEditEmployeeLastName)
                            .addComponent(textFieldEditEmployeeFirstName)
                            .addComponent(textFieldEditEmployeeMiddleName)
                            .addComponent(textFieldEditEmployeeSalary)))
                    .addComponent(buttonEditEmployeeSaveChanges, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(737, Short.MAX_VALUE))
        );
        editEmployeePanelLayout.setVerticalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelEditEmployee)
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditEmployeeIDNumber)
                    .addComponent(textFieldEditEmployeeIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditEmployeeLastName)
                    .addComponent(textFieldEditEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditEmployeeFirstName)
                    .addComponent(textFieldEditEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditEmployeeMiddleName)
                    .addComponent(textFieldEditEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditEmployeeSalary)
                    .addComponent(textFieldEditEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonEditEmployeeSaveChanges)
                .addContainerGap(360, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(editEmployeePanel, "card6");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 1.0;
        panelMain.add(mainPanelCardPanel, gridBagConstraints);

        mainPanelSidePanel.setBackground(new java.awt.Color(247, 247, 247));
        mainPanelSidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(224, 224, 224)));

        javax.swing.GroupLayout mainPanelSidePanelLayout = new javax.swing.GroupLayout(mainPanelSidePanel);
        mainPanelSidePanel.setLayout(mainPanelSidePanelLayout);
        mainPanelSidePanelLayout.setHorizontalGroup(
            mainPanelSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelSidePanelLayout.setVerticalGroup(
            mainPanelSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        panelMain.add(mainPanelSidePanel, gridBagConstraints);

        getContentPane().add(panelMain, "panelMain");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static MainFrame getInstance(){
        return mainFrame;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEmployeePanel;
    private javax.swing.JPanel add_time;
    private javax.swing.JButton buttonAddEmployee;
    private javax.swing.JButton buttonEditEmployeeSaveChanges;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JLabel employeeTime;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAddEmployee;
    private javax.swing.JLabel labelAddEmployeeFirstName;
    private javax.swing.JLabel labelAddEmployeeIDNumber;
    private javax.swing.JLabel labelAddEmployeeLastName;
    private javax.swing.JLabel labelAddEmployeeMiddleName;
    private javax.swing.JLabel labelAddEmployeeSalary;
    private javax.swing.JLabel labelEditEmployee;
    private javax.swing.JLabel labelEditEmployeeFirstName;
    private javax.swing.JLabel labelEditEmployeeIDNumber;
    private javax.swing.JLabel labelEditEmployeeLastName;
    private javax.swing.JLabel labelEditEmployeeMiddleName;
    private javax.swing.JLabel labelEditEmployeeSalary;
    private javax.swing.JLabel labelShowEmployeeID;
    private javax.swing.JLabel labelShowEmployeeName;
    private javax.swing.JButton loginButtonLogin;
    private javax.swing.JLabel loginLabelJollibeeConstructionLogo;
    private javax.swing.JPasswordField loginPasswordFieldPassword;
    private javax.swing.JTextField loginTextFieldUsername;
    private javax.swing.JLabel mainLabelJollibeeConstructionLogo;
    private javax.swing.JLabel mainLabelLogout;
    private javax.swing.JLabel mainLabelName;
    private javax.swing.JPanel mainPanelCardPanel;
    private javax.swing.JPanel mainPanelHeader;
    private javax.swing.JPanel mainPanelSidePanel;
    private javax.swing.JTextField mainTextFieldSearch;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelShowEmployeeCalendar;
    private javax.swing.JPanel showEmployeePanel;
    private javax.swing.JPanel testing;
    private javax.swing.JTextField textFieldAddEmployeeFirstName;
    private javax.swing.JTextField textFieldAddEmployeeIDNumber;
    private javax.swing.JTextField textFieldAddEmployeeLastName;
    private javax.swing.JTextField textFieldAddEmployeeMiddleName;
    private javax.swing.JTextField textFieldAddEmployeeSalary;
    private javax.swing.JTextField textFieldEditEmployeeFirstName;
    private javax.swing.JTextField textFieldEditEmployeeIDNumber;
    private javax.swing.JTextField textFieldEditEmployeeLastName;
    private javax.swing.JTextField textFieldEditEmployeeMiddleName;
    private javax.swing.JTextField textFieldEditEmployeeSalary;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JPanel getAddEmployeePanel() {
        return addEmployeePanel;
    }

    public javax.swing.JPanel getAdd_time() {
        return add_time;
    }

    public javax.swing.JButton getButtonAddEmployee() {
        return buttonAddEmployee;
    }

    public javax.swing.JButton getButtonEditEmployeeSaveChanges() {
        return buttonEditEmployeeSaveChanges;
    }

    public javax.swing.JPanel getEditEmployeePanel() {
        return editEmployeePanel;
    }

    public javax.swing.JLabel getEmployeeTime() {
        return employeeTime;
    }

    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public javax.swing.JLabel getLabelAddEmployee() {
        return labelAddEmployee;
    }

    public javax.swing.JLabel getLabelAddEmployeeFirstName() {
        return labelAddEmployeeFirstName;
    }

    public javax.swing.JLabel getLabelAddEmployeeIDNumber() {
        return labelAddEmployeeIDNumber;
    }

    public javax.swing.JLabel getLabelAddEmployeeLastName() {
        return labelAddEmployeeLastName;
    }

    public javax.swing.JLabel getLabelAddEmployeeMiddleName() {
        return labelAddEmployeeMiddleName;
    }

    public javax.swing.JLabel getLabelAddEmployeeSalary() {
        return labelAddEmployeeSalary;
    }

    public javax.swing.JLabel getLabelEditEmployee() {
        return labelEditEmployee;
    }

    public javax.swing.JLabel getLabelEditEmployeeFirstName() {
        return labelEditEmployeeFirstName;
    }

    public javax.swing.JLabel getLabelEditEmployeeIDNumber() {
        return labelEditEmployeeIDNumber;
    }

    public javax.swing.JLabel getLabelEditEmployeeLastName() {
        return labelEditEmployeeLastName;
    }

    public javax.swing.JLabel getLabelEditEmployeeMiddleName() {
        return labelEditEmployeeMiddleName;
    }

    public javax.swing.JLabel getLabelEditEmployeeSalary() {
        return labelEditEmployeeSalary;
    }

    public javax.swing.JLabel getLabelShowEmployeeID() {
        return labelShowEmployeeID;
    }

    public javax.swing.JLabel getLabelShowEmployeeName() {
        return labelShowEmployeeName;
    }

    public javax.swing.JButton getLoginButtonLogin() {
        return loginButtonLogin;
    }

    public javax.swing.JLabel getLoginLabelJollibeeConstructionLogo() {
        return loginLabelJollibeeConstructionLogo;
    }

    public javax.swing.JPasswordField getLoginPasswordFieldPassword() {
        return loginPasswordFieldPassword;
    }

    public javax.swing.JTextField getLoginTextFieldUsername() {
        return loginTextFieldUsername;
    }

    public javax.swing.JLabel getMainLabelJollibeeConstructionLogo() {
        return mainLabelJollibeeConstructionLogo;
    }

    public javax.swing.JLabel getMainLabelLogout() {
        return mainLabelLogout;
    }

    public javax.swing.JLabel getMainLabelName() {
        return mainLabelName;
    }

    public javax.swing.JPanel getMainPanelCardPanel() {
        return mainPanelCardPanel;
    }

    public javax.swing.JPanel getMainPanelHeader() {
        return mainPanelHeader;
    }

    public javax.swing.JPanel getMainPanelSidePanel() {
        return mainPanelSidePanel;
    }

    public javax.swing.JTextField getMainTextFieldSearch() {
        return mainTextFieldSearch;
    }

    public javax.swing.JPanel getPanelLogin() {
        return panelLogin;
    }

    public javax.swing.JPanel getPanelMain() {
        return panelMain;
    }

    public javax.swing.JPanel getPanelShowEmployeeCalendar() {
        return panelShowEmployeeCalendar;
    }

    public javax.swing.JPanel getShowEmployeePanel() {
        return showEmployeePanel;
    }

    public javax.swing.JPanel getTesting() {
        return testing;
    }

    public javax.swing.JTextField getTextFieldAddEmployeeFirstName() {
        return textFieldAddEmployeeFirstName;
    }

    public javax.swing.JTextField getTextFieldAddEmployeeIDNumber() {
        return textFieldAddEmployeeIDNumber;
    }

    public javax.swing.JTextField getTextFieldAddEmployeeLastName() {
        return textFieldAddEmployeeLastName;
    }

    public javax.swing.JTextField getTextFieldAddEmployeeMiddleName() {
        return textFieldAddEmployeeMiddleName;
    }

    public javax.swing.JTextField getTextFieldAddEmployeeSalary() {
        return textFieldAddEmployeeSalary;
    }

    public javax.swing.JTextField getTextFieldEditEmployeeFirstName() {
        return textFieldEditEmployeeFirstName;
    }

    public javax.swing.JTextField getTextFieldEditEmployeeIDNumber() {
        return textFieldEditEmployeeIDNumber;
    }

    public javax.swing.JTextField getTextFieldEditEmployeeLastName() {
        return textFieldEditEmployeeLastName;
    }

    public javax.swing.JTextField getTextFieldEditEmployeeMiddleName() {
        return textFieldEditEmployeeMiddleName;
    }

    public javax.swing.JTextField getTextFieldEditEmployeeSalary() {
        return textFieldEditEmployeeSalary;
    }
}
