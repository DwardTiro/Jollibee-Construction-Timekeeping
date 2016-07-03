
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
        mainPanelCardPanel = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        labelWelcomeProjectWatch = new javax.swing.JLabel();
        labelWelcomePreviousMonth = new javax.swing.JLabel();
        labelWelcomeMonthYear = new javax.swing.JLabel();
        labelWelcomeNextMonth = new javax.swing.JLabel();
        panelWelcomeCalendar = new javax.swing.JPanel();
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
        manageEmployeePanel = new javax.swing.JPanel();
        labelManageEmployee = new javax.swing.JLabel();
        labelManageEmployeeAttendance = new javax.swing.JLabel();
        viewEmployeePanel = new javax.swing.JPanel();
        labelViewEmployeeName = new javax.swing.JLabel();
        labelViewEmployeeID = new javax.swing.JLabel();
        panelViewEmployeeCalendar = new javax.swing.JPanel();
        labelViewEmployeeMonthYear = new javax.swing.JLabel();
        labelViewEmployeeNextMonth = new javax.swing.JLabel();
        labelViewEmployeePreviousMonth = new javax.swing.JLabel();
        editEmployeeButton = new javax.swing.JButton();
        labelViewEmployeeSalary = new javax.swing.JLabel();
        testing = new javax.swing.JPanel();
        add_time = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        employeeTime = new javax.swing.JLabel();
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
        searchResultPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeList = new javax.swing.JList();
        viewEmployeeButton = new javax.swing.JButton();
        mainPanelSidePanel = new javax.swing.JPanel();
        mainPanelSidePanelContainer = new javax.swing.JPanel();
        sidePanelLabelProjectWatch = new javax.swing.JLabel();
        sidePanelLabelAddEmployee = new javax.swing.JLabel();
        sidePanelLabelManageEmployee = new javax.swing.JLabel();
        sidePanelLabelManageProject = new javax.swing.JLabel();
        sidePanelLabelLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jollibee Construction Timekeeping");
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Jollibee Construction.png")));
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

        welcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        welcomePanel.setName("welcomePanel"); // NOI18N

        labelWelcomeProjectWatch.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelWelcomeProjectWatch.setForeground(new java.awt.Color(231, 28, 35));
        labelWelcomeProjectWatch.setText("Project Watch");

        labelWelcomePreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png"))); // NOI18N

        labelWelcomeMonthYear.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelWelcomeMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcomeMonthYear.setText("MONTH YEAR");

        labelWelcomeNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png"))); // NOI18N

        panelWelcomeCalendar.setBackground(new java.awt.Color(255, 255, 255));
        panelWelcomeCalendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(224, 224, 224)));
        panelWelcomeCalendar.setLayout(new java.awt.GridLayout(6, 7));

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelWelcomeProjectWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelWelcomeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(welcomePanelLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(labelWelcomePreviousMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWelcomeMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWelcomeNextMonth)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelWelcomeProjectWatch)
                .addGap(18, 18, 18)
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelWelcomePreviousMonth, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelWelcomeNextMonth)
                    .addComponent(labelWelcomeMonthYear, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelWelcomeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(welcomePanel, "welcomePanel");

        addEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        addEmployeePanel.setName("addEmployeePanel"); // NOI18N

        labelAddEmployee.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelAddEmployee.setForeground(new java.awt.Color(231, 28, 35));
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
                .addGap(90, 90, 90)
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

        mainPanelCardPanel.add(addEmployeePanel, "addEmployeePanel");

        manageEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        manageEmployeePanel.setName("manageEmployeePanel"); // NOI18N

        labelManageEmployee.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelManageEmployee.setForeground(new java.awt.Color(231, 28, 35));
        labelManageEmployee.setText("Manage Employee");

        labelManageEmployeeAttendance.setText("Attendance for Month Day, Year");

        javax.swing.GroupLayout manageEmployeePanelLayout = new javax.swing.GroupLayout(manageEmployeePanel);
        manageEmployeePanel.setLayout(manageEmployeePanelLayout);
        manageEmployeePanelLayout.setHorizontalGroup(
            manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelManageEmployeeAttendance)
                    .addComponent(labelManageEmployee))
                .addContainerGap(606, Short.MAX_VALUE))
        );
        manageEmployeePanelLayout.setVerticalGroup(
            manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelManageEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelManageEmployeeAttendance)
                .addContainerGap(505, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(manageEmployeePanel, "manageEmployeePanel");

        viewEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        viewEmployeePanel.setName("viewEmployeePanel"); // NOI18N

        labelViewEmployeeName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelViewEmployeeName.setForeground(new java.awt.Color(231, 28, 35));
        labelViewEmployeeName.setText("LastName, FirstName MiddleName");

        labelViewEmployeeID.setText("ID Number");

        panelViewEmployeeCalendar.setBackground(new java.awt.Color(255, 255, 255));
        panelViewEmployeeCalendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(224, 224, 224)));
        panelViewEmployeeCalendar.setLayout(new java.awt.GridLayout(6, 7));

        labelViewEmployeeMonthYear.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelViewEmployeeMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewEmployeeMonthYear.setText("MONTH YEAR");

        labelViewEmployeeNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png"))); // NOI18N

        labelViewEmployeePreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png"))); // NOI18N

        editEmployeeButton.setText("Edit");

        labelViewEmployeeSalary.setText("Computed Salary");

        javax.swing.GroupLayout viewEmployeePanelLayout = new javax.swing.GroupLayout(viewEmployeePanel);
        viewEmployeePanel.setLayout(viewEmployeePanelLayout);
        viewEmployeePanelLayout.setHorizontalGroup(
            viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelViewEmployeeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewEmployeeName)
                    .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                        .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                                .addComponent(labelViewEmployeeID)
                                .addGap(18, 18, 18)
                                .addComponent(labelViewEmployeeSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                                .addComponent(editEmployeeButton)
                                .addGap(102, 102, 102)
                                .addComponent(labelViewEmployeePreviousMonth)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViewEmployeeMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViewEmployeeNextMonth)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        viewEmployeePanelLayout.setVerticalGroup(
            viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelViewEmployeeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewEmployeeID)
                    .addComponent(labelViewEmployeeSalary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelViewEmployeeNextMonth, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewEmployeePanelLayout.createSequentialGroup()
                        .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelViewEmployeeMonthYear)
                                .addComponent(labelViewEmployeePreviousMonth))
                            .addComponent(editEmployeeButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelViewEmployeeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        mainPanelCardPanel.add(viewEmployeePanel, "viewEmployeePanel");

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

        editEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        editEmployeePanel.setName("editEmployeePanel"); // NOI18N

        labelEditEmployee.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelEditEmployee.setForeground(new java.awt.Color(231, 28, 35));
        labelEditEmployee.setText("Edit Employee");

        labelEditEmployeeIDNumber.setText("ID Number");

        labelEditEmployeeLastName.setText("Last Name");

        labelEditEmployeeFirstName.setText("First Name");

        labelEditEmployeeMiddleName.setText("Middle Name");

        labelEditEmployeeSalary.setText("Salary");

        textFieldEditEmployeeIDNumber.setEditable(false);

        buttonEditEmployeeSaveChanges.setBackground(new java.awt.Color(231, 28, 35));
        buttonEditEmployeeSaveChanges.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonEditEmployeeSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditEmployeeSaveChanges.setText("Save Changes");

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(editEmployeePanel, "editEmployeePanel");

        jScrollPane3.setViewportView(employeeList);

        viewEmployeeButton.setText("View");

        javax.swing.GroupLayout searchResultPanelLayout = new javax.swing.GroupLayout(searchResultPanel);
        searchResultPanel.setLayout(searchResultPanelLayout);
        searchResultPanelLayout.setHorizontalGroup(
            searchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchResultPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(searchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewEmployeeButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchResultPanelLayout.setVerticalGroup(
            searchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchResultPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewEmployeeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(searchResultPanel, "searchResultPanel");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 1.0;
        panelMain.add(mainPanelCardPanel, gridBagConstraints);

        mainPanelSidePanel.setBackground(new java.awt.Color(247, 247, 247));
        mainPanelSidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(224, 224, 224)));
        mainPanelSidePanel.setLayout(new java.awt.CardLayout());

        mainPanelSidePanelContainer.setBackground(new java.awt.Color(247, 247, 247));
        mainPanelSidePanelContainer.setPreferredSize(new java.awt.Dimension(0, 0));
        mainPanelSidePanelContainer.setLayout(new java.awt.GridBagLayout());

        sidePanelLabelProjectWatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Project Watch.png"))); // NOI18N
        mainPanelSidePanelContainer.add(sidePanelLabelProjectWatch, new java.awt.GridBagConstraints());

        sidePanelLabelAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Employee.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        mainPanelSidePanelContainer.add(sidePanelLabelAddEmployee, gridBagConstraints);

        sidePanelLabelManageEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Employee.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        mainPanelSidePanelContainer.add(sidePanelLabelManageEmployee, gridBagConstraints);

        sidePanelLabelManageProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Project.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        mainPanelSidePanelContainer.add(sidePanelLabelManageProject, gridBagConstraints);

        sidePanelLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Admin.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        mainPanelSidePanelContainer.add(sidePanelLabelLogout, gridBagConstraints);

        mainPanelSidePanel.add(mainPanelSidePanelContainer, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
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
    private javax.swing.JButton editEmployeeButton;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JList employeeList;
    private javax.swing.JLabel employeeTime;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JLabel labelManageEmployee;
    private javax.swing.JLabel labelManageEmployeeAttendance;
    private javax.swing.JLabel labelViewEmployeeID;
    private javax.swing.JLabel labelViewEmployeeMonthYear;
    private javax.swing.JLabel labelViewEmployeeName;
    private javax.swing.JLabel labelViewEmployeeNextMonth;
    private javax.swing.JLabel labelViewEmployeePreviousMonth;
    private javax.swing.JLabel labelViewEmployeeSalary;
    private javax.swing.JLabel labelWelcomeMonthYear;
    private javax.swing.JLabel labelWelcomeNextMonth;
    private javax.swing.JLabel labelWelcomePreviousMonth;
    private javax.swing.JLabel labelWelcomeProjectWatch;
    private javax.swing.JButton loginButtonLogin;
    private javax.swing.JLabel loginLabelJollibeeConstructionLogo;
    private javax.swing.JPasswordField loginPasswordFieldPassword;
    private javax.swing.JTextField loginTextFieldUsername;
    private javax.swing.JLabel mainLabelJollibeeConstructionLogo;
    private javax.swing.JLabel mainLabelName;
    private javax.swing.JPanel mainPanelCardPanel;
    private javax.swing.JPanel mainPanelHeader;
    private javax.swing.JPanel mainPanelSidePanel;
    private javax.swing.JPanel mainPanelSidePanelContainer;
    private javax.swing.JTextField mainTextFieldSearch;
    private javax.swing.JPanel manageEmployeePanel;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelViewEmployeeCalendar;
    private javax.swing.JPanel panelWelcomeCalendar;
    private javax.swing.JPanel searchResultPanel;
    private javax.swing.JLabel sidePanelLabelAddEmployee;
    private javax.swing.JLabel sidePanelLabelLogout;
    private javax.swing.JLabel sidePanelLabelManageEmployee;
    private javax.swing.JLabel sidePanelLabelManageProject;
    private javax.swing.JLabel sidePanelLabelProjectWatch;
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
    private javax.swing.JButton viewEmployeeButton;
    private javax.swing.JPanel viewEmployeePanel;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JList getSearchLists(){
        return employeeList;
    }

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

    public javax.swing.JList getEmployeeList() {
        return employeeList;
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

    public javax.swing.JScrollPane getjScrollPane3() {
        return jScrollPane3;
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

    public javax.swing.JLabel getLabelManageEmployee() {
        return labelManageEmployee;
    }

    public javax.swing.JLabel getLabelManageEmployeeAttendance() {
        return labelManageEmployeeAttendance;
    }

    public javax.swing.JLabel getLabelViewEmployeeID() {
        return labelViewEmployeeID;
    }

    public javax.swing.JLabel getlabelViewEmployeeSalary(){
        return labelViewEmployeeSalary;
    }
    
    public javax.swing.JLabel getLabelViewEmployeeMonthYear() {
        return labelViewEmployeeMonthYear;
    }

    public javax.swing.JLabel getLabelViewEmployeeName() {
        return labelViewEmployeeName;
    }

    public javax.swing.JLabel getLabelViewEmployeeNextMonth() {
        return labelViewEmployeeNextMonth;
    }

    public javax.swing.JLabel getLabelViewEmployeePreviousMonth() {
        return labelViewEmployeePreviousMonth;
    }

    public javax.swing.JLabel getLabelWelcomeMonthYear() {
        return labelWelcomeMonthYear;
    }

    public javax.swing.JLabel getLabelWelcomeNextMonth() {
        return labelWelcomeNextMonth;
    }

    public javax.swing.JLabel getLabelWelcomePreviousMonth() {
        return labelWelcomePreviousMonth;
    }

    public javax.swing.JLabel getLabelWelcomeProjectWatch() {
        return labelWelcomeProjectWatch;
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

    public javax.swing.JPanel getMainPanelSidePanelContainer() {
        return mainPanelSidePanelContainer;
    }

    public javax.swing.JTextField getMainTextFieldSearch() {
        return mainTextFieldSearch;
    }

    public javax.swing.JPanel getManageEmployeePanel() {
        return manageEmployeePanel;
    }

    public javax.swing.JPanel getPanelLogin() {
        return panelLogin;
    }

    public javax.swing.JPanel getPanelMain() {
        return panelMain;
    }

    public javax.swing.JPanel getPanelViewEmployeeCalendar() {
        return panelViewEmployeeCalendar;
    }

    public javax.swing.JPanel getPanelWelcomeCalendar() {
        return panelWelcomeCalendar;
    }

    public javax.swing.JPanel getSearchResultPanel() {
        return searchResultPanel;
    }

    public javax.swing.JLabel getSidePanelLabelAddEmployee() {
        return sidePanelLabelAddEmployee;
    }

    public javax.swing.JLabel getSidePanelLabelLogout() {
        return sidePanelLabelLogout;
    }

    public javax.swing.JLabel getSidePanelLabelManageEmployee() {
        return sidePanelLabelManageEmployee;
    }

    public javax.swing.JLabel getSidePanelLabelManageProject() {
        return sidePanelLabelManageProject;
    }

    public javax.swing.JLabel getSidePanelLabelProjectWatch() {
        return sidePanelLabelProjectWatch;
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

    public javax.swing.JButton getViewEmployeeButton() {
        return viewEmployeeButton;
    }

    public javax.swing.JPanel getViewEmployeePanel() {
        return viewEmployeePanel;
    }

    public javax.swing.JPanel getWelcomePanel() {
        return welcomePanel;
    }
    
    
    public javax.swing.JButton getEditEmployeeButton(){
        return editEmployeeButton;
    }
    
    
}
