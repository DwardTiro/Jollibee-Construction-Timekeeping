
package gui;

import java.awt.Toolkit;

public class MainFrame extends javax.swing.JFrame {

    private static final MainFrame mainFrame = new MainFrame();
    public static final int SPACE_ABOVE = 60;
    
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
        viewEmployeePanel = new javax.swing.JPanel();
        labelViewEmployeeName = new javax.swing.JLabel();
        labelViewEmployeeID = new javax.swing.JLabel();
        panelViewEmployeeCalendar = new javax.swing.JPanel();
        labelViewEmployeeMonthYear = new javax.swing.JLabel();
        labelViewEmployeeNextMonth = new javax.swing.JLabel();
        labelViewEmployeePreviousMonth = new javax.swing.JLabel();
        editEmployeeButton = new javax.swing.JButton();
        labelViewEmployeeSalary = new javax.swing.JLabel();
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
        searchResultsScrollPane = new javax.swing.JScrollPane();
        searchResultsPanel = new javax.swing.JPanel();
        labelSearchResults = new javax.swing.JLabel();
        panelSearchResultsContainer = new javax.swing.JPanel();
        manageEmployeeScrollPane = new javax.swing.JScrollPane();
        manageEmployeePanel = new javax.swing.JPanel();
        labelManageEmployee = new javax.swing.JLabel();
        labelManageEmployeeAttendance = new javax.swing.JLabel();
        buttonManageEmployeeSubmit = new javax.swing.JButton();
        panelManageEmployeeContainer = new javax.swing.JPanel();
        labelManageProjectFilter = new javax.swing.JLabel();
        panelManageEmployeeProjectContainer = new javax.swing.JPanel();
        manageProjectScrollPane = new javax.swing.JScrollPane();
        manageProjectPanel = new javax.swing.JPanel();
        labelManageProject = new javax.swing.JLabel();
        panelManageProjectContainer = new javax.swing.JPanel();
        viewProjectScrollPane = new javax.swing.JScrollPane();
        viewProjectPanel = new javax.swing.JPanel();
        labelViewProjectName = new javax.swing.JLabel();
        labelViewProjectDuration = new javax.swing.JLabel();
        labelViewProjectMembers = new javax.swing.JLabel();
        panelViewProjectMembersContainer = new javax.swing.JPanel();
        labelViewProjectAddEmployee = new javax.swing.JLabel();
        panelViewProjectAddEmployeeContainer = new javax.swing.JPanel();
        computeSalaryScrollPane = new javax.swing.JScrollPane();
        computeSalaryPanel = new javax.swing.JPanel();
        labelComputeSalary = new javax.swing.JLabel();
        panelComputeSalaryEmployeeContainer = new javax.swing.JPanel();
        labelComputeSalaryFilter = new javax.swing.JLabel();
        panelComputeSalaryFilterContainer = new javax.swing.JPanel();
        buttonComputeSalaryRelease = new javax.swing.JButton();
        mainPanelSidePanel = new javax.swing.JPanel();
        mainPanelSidePanelContainer = new javax.swing.JPanel();
        sidePanelLabelProjectWatch = new javax.swing.JLabel();
        sidePanelLabelAddEmployee = new javax.swing.JLabel();
        sidePanelLabelManageEmployee = new javax.swing.JLabel();
        sidePanelLabelManageProject = new javax.swing.JLabel();
        sidePanelLabelComputeSalary = new javax.swing.JLabel();
        sidePanelLabelLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jollibee Construction Timekeeping");
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Jollibee Construction.png")));
        setMinimumSize(new java.awt.Dimension(1366, 768));
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

        loginTextFieldUsername.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
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
        loginButtonLogin.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
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

        mainTextFieldSearch.setFont(new java.awt.Font("Open Sans Light", 1, 20)); // NOI18N
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

        mainLabelName.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
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

        labelWelcomeProjectWatch.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelWelcomeProjectWatch.setText("PROJECT WATCH");
        labelWelcomeProjectWatch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelWelcomeProjectWatch.setOpaque(true);

        labelWelcomePreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png"))); // NOI18N

        labelWelcomeMonthYear.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
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
                .addGap(90, 90, 90)
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelWelcomeCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(welcomePanelLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(labelWelcomePreviousMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWelcomeMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWelcomeNextMonth))
                    .addComponent(labelWelcomeProjectWatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelWelcomeProjectWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        labelAddEmployee.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelAddEmployee.setText("ADD NEW EMPLOYEE");
        labelAddEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelAddEmployee.setOpaque(true);

        labelAddEmployeeIDNumber.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelAddEmployeeIDNumber.setText("ID Number");

        labelAddEmployeeLastName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelAddEmployeeLastName.setText("Last Name");

        labelAddEmployeeFirstName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelAddEmployeeFirstName.setText("First Name");

        labelAddEmployeeMiddleName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelAddEmployeeMiddleName.setText("Middle Name");

        labelAddEmployeeSalary.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelAddEmployeeSalary.setText("Salary");

        buttonAddEmployee.setBackground(new java.awt.Color(231, 28, 35));
        buttonAddEmployee.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        buttonAddEmployee.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddEmployee.setText("Add Employee");

        javax.swing.GroupLayout addEmployeePanelLayout = new javax.swing.GroupLayout(addEmployeePanel);
        addEmployeePanel.setLayout(addEmployeePanelLayout);
        addEmployeePanelLayout.setHorizontalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddEmployeeIDNumber)
                    .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addEmployeePanelLayout.createSequentialGroup()
                            .addComponent(labelAddEmployeeSalary)
                            .addGap(87, 87, 87)
                            .addComponent(textFieldAddEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeePanelLayout.createSequentialGroup()
                                .addComponent(labelAddEmployeeFirstName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldAddEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeePanelLayout.createSequentialGroup()
                                .addComponent(labelAddEmployeeLastName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldAddEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldAddEmployeeIDNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                                .addComponent(labelAddEmployeeMiddleName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldAddEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(buttonAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addEmployeePanelLayout.setVerticalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddEmployeeIDNumber)
                    .addComponent(textFieldAddEmployeeIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddEmployeeSalary)
                    .addComponent(textFieldAddEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAddEmployee)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(addEmployeePanel, "addEmployeePanel");

        viewEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        viewEmployeePanel.setName("viewEmployeePanel"); // NOI18N

        labelViewEmployeeName.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelViewEmployeeName.setText("LastName, FirstName MiddleName");
        labelViewEmployeeName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelViewEmployeeName.setOpaque(true);

        labelViewEmployeeID.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelViewEmployeeID.setText("ID Number");

        panelViewEmployeeCalendar.setBackground(new java.awt.Color(255, 255, 255));
        panelViewEmployeeCalendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(224, 224, 224)));
        panelViewEmployeeCalendar.setLayout(new java.awt.GridLayout(6, 7));

        labelViewEmployeeMonthYear.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelViewEmployeeMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewEmployeeMonthYear.setText("MONTH YEAR");

        labelViewEmployeeNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png"))); // NOI18N

        labelViewEmployeePreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png"))); // NOI18N

        editEmployeeButton.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        editEmployeeButton.setText("Edit");

        labelViewEmployeeSalary.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelViewEmployeeSalary.setText("Computed Salary");

        javax.swing.GroupLayout viewEmployeePanelLayout = new javax.swing.GroupLayout(viewEmployeePanel);
        viewEmployeePanel.setLayout(viewEmployeePanelLayout);
        viewEmployeePanelLayout.setHorizontalGroup(
            viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                        .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                                .addGap(335, 335, 335)
                                .addComponent(labelViewEmployeePreviousMonth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelViewEmployeeMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelViewEmployeeNextMonth))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewEmployeePanelLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelViewEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelViewEmployeeCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))))
                        .addGap(152, 152, 152)
                        .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editEmployeeButton)
                            .addComponent(labelViewEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(labelViewEmployeeID)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewEmployeePanelLayout.setVerticalGroup(
            viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelViewEmployeeSalary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editEmployeeButton)
                .addGap(422, 422, 422))
            .addGroup(viewEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelViewEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewEmployeeID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelViewEmployeeMonthYear)
                        .addComponent(labelViewEmployeePreviousMonth))
                    .addComponent(labelViewEmployeeNextMonth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelViewEmployeeCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(viewEmployeePanel, "viewEmployeePanel");

        editEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        editEmployeePanel.setName("editEmployeePanel"); // NOI18N

        labelEditEmployee.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelEditEmployee.setText("Edit Employee");
        labelEditEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelEditEmployee.setOpaque(true);

        labelEditEmployeeIDNumber.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelEditEmployeeIDNumber.setText("ID Number");

        labelEditEmployeeLastName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelEditEmployeeLastName.setText("Last Name");

        labelEditEmployeeFirstName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelEditEmployeeFirstName.setText("First Name");

        labelEditEmployeeMiddleName.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelEditEmployeeMiddleName.setText("Middle Name");

        labelEditEmployeeSalary.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelEditEmployeeSalary.setText("Salary");

        textFieldEditEmployeeIDNumber.setEditable(false);

        buttonEditEmployeeSaveChanges.setBackground(new java.awt.Color(231, 28, 35));
        buttonEditEmployeeSaveChanges.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        buttonEditEmployeeSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditEmployeeSaveChanges.setText("Save Changes");

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeePanelLayout.createSequentialGroup()
                                .addComponent(labelEditEmployeeLastName)
                                .addGap(59, 59, 59))
                            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEditEmployeeIDNumber)
                                    .addComponent(labelEditEmployeeFirstName)
                                    .addComponent(labelEditEmployeeMiddleName)
                                    .addComponent(labelEditEmployeeSalary))
                                .addGap(42, 42, 42)))
                        .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldEditEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textFieldEditEmployeeIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldEditEmployeeFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldEditEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldEditEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonEditEmployeeSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editEmployeePanelLayout.setVerticalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditEmployeeIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEditEmployeeIDNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEditEmployeeLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEditEmployeeFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEditEmployeeMiddleName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEditEmployeeSalary))
                .addGap(18, 18, 18)
                .addComponent(buttonEditEmployeeSaveChanges)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(editEmployeePanel, "editEmployeePanel");

        searchResultsScrollPane.setBorder(null);
        searchResultsScrollPane.setName("searchResultsScrollPane"); // NOI18N

        searchResultsPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchResultsPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        labelSearchResults.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelSearchResults.setText("SEARCH RESULTS FOR");
        labelSearchResults.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelSearchResults.setOpaque(true);

        panelSearchResultsContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelSearchResultsContainer.setPreferredSize(new java.awt.Dimension(0, 0));
        panelSearchResultsContainer.setLayout(new javax.swing.BoxLayout(panelSearchResultsContainer, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout searchResultsPanelLayout = new javax.swing.GroupLayout(searchResultsPanel);
        searchResultsPanel.setLayout(searchResultsPanelLayout);
        searchResultsPanelLayout.setHorizontalGroup(
            searchResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchResultsPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(searchResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSearchResultsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addComponent(labelSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchResultsPanelLayout.setVerticalGroup(
            searchResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchResultsPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelSearchResults, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSearchResultsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(456, 456, 456))
        );

        searchResultsScrollPane.setViewportView(searchResultsPanel);

        mainPanelCardPanel.add(searchResultsScrollPane, "searchResultsScrollPane");

        manageEmployeeScrollPane.setBorder(null);

        manageEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        manageEmployeePanel.setName("manageEmployeePanel"); // NOI18N
        manageEmployeePanel.setPreferredSize(new java.awt.Dimension(0, 0));

        labelManageEmployee.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelManageEmployee.setText("MANAGE EMPLOYEE");
        labelManageEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelManageEmployee.setOpaque(true);
        labelManageEmployee.setPreferredSize(new java.awt.Dimension(600, 50));

        labelManageEmployeeAttendance.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelManageEmployeeAttendance.setText("Attendance for Month Day, Year");

        buttonManageEmployeeSubmit.setBackground(new java.awt.Color(231, 28, 35));
        buttonManageEmployeeSubmit.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        buttonManageEmployeeSubmit.setForeground(new java.awt.Color(255, 255, 255));
        buttonManageEmployeeSubmit.setText("Submit");
        buttonManageEmployeeSubmit.setPreferredSize(new java.awt.Dimension(150, 30));

        panelManageEmployeeContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelManageEmployeeContainer.setPreferredSize(new java.awt.Dimension(600, 120));
        panelManageEmployeeContainer.setLayout(new java.awt.GridLayout(1, 1));

        labelManageProjectFilter.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelManageProjectFilter.setText("Filter by project:");

        panelManageEmployeeProjectContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelManageEmployeeProjectContainer.setMaximumSize(new java.awt.Dimension(0, 0));
        panelManageEmployeeProjectContainer.setPreferredSize(new java.awt.Dimension(300, 28));
        panelManageEmployeeProjectContainer.setLayout(new javax.swing.BoxLayout(panelManageEmployeeProjectContainer, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout manageEmployeePanelLayout = new javax.swing.GroupLayout(manageEmployeePanel);
        manageEmployeePanel.setLayout(manageEmployeePanelLayout);
        manageEmployeePanelLayout.setHorizontalGroup(
            manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                .addGroup(manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonManageEmployeeSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelManageEmployeeContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelManageEmployeeAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(labelManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(199, 199, 199)
                .addGroup(manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelManageEmployeeProjectContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelManageProjectFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        manageEmployeePanelLayout.setVerticalGroup(
            manageEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(labelManageProjectFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelManageEmployeeProjectContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(manageEmployeePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelManageEmployeeAttendance)
                .addGap(18, 18, 18)
                .addComponent(panelManageEmployeeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonManageEmployeeSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354))
        );

        manageEmployeeScrollPane.setViewportView(manageEmployeePanel);

        mainPanelCardPanel.add(manageEmployeeScrollPane, "manageEmployeeScrollPane");

        manageProjectScrollPane.setBorder(null);

        manageProjectPanel.setBackground(new java.awt.Color(255, 255, 255));
        manageProjectPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        labelManageProject.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelManageProject.setText("MANAGE ACTIVE PROJECTS");
        labelManageProject.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelManageProject.setOpaque(true);
        labelManageProject.setPreferredSize(new java.awt.Dimension(600, 50));

        panelManageProjectContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelManageProjectContainer.setLayout(new java.awt.GridLayout(1, 1));

        javax.swing.GroupLayout manageProjectPanelLayout = new javax.swing.GroupLayout(manageProjectPanel);
        manageProjectPanel.setLayout(manageProjectPanelLayout);
        manageProjectPanelLayout.setHorizontalGroup(
            manageProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageProjectPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(manageProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelManageProjectContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelManageProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageProjectPanelLayout.setVerticalGroup(
            manageProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageProjectPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelManageProject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelManageProjectContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(447, 447, 447))
        );

        manageProjectScrollPane.setViewportView(manageProjectPanel);

        mainPanelCardPanel.add(manageProjectScrollPane, "manageProjectScrollPane");

        viewProjectScrollPane.setBorder(null);

        viewProjectPanel.setBackground(new java.awt.Color(255, 255, 255));

        labelViewProjectName.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelViewProjectName.setText("Project Name");
        labelViewProjectName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelViewProjectName.setOpaque(true);

        labelViewProjectDuration.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelViewProjectDuration.setText("Date Started - Date Due");

        labelViewProjectMembers.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelViewProjectMembers.setText("Project Members:");
        labelViewProjectMembers.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));

        panelViewProjectMembersContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelViewProjectMembersContainer.setLayout(new java.awt.GridLayout(1, 1));

        labelViewProjectAddEmployee.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        labelViewProjectAddEmployee.setText("Add Employee to ");

        panelViewProjectAddEmployeeContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelViewProjectAddEmployeeContainer.setPreferredSize(new java.awt.Dimension(250, 28));
        panelViewProjectAddEmployeeContainer.setLayout(new javax.swing.BoxLayout(panelViewProjectAddEmployeeContainer, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout viewProjectPanelLayout = new javax.swing.GroupLayout(viewProjectPanel);
        viewProjectPanel.setLayout(viewProjectPanelLayout);
        viewProjectPanelLayout.setHorizontalGroup(
            viewProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProjectPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(viewProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelViewProjectMembers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelViewProjectMembersContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(labelViewProjectDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addGroup(viewProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelViewProjectAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelViewProjectAddEmployeeContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        viewProjectPanelLayout.setVerticalGroup(
            viewProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProjectPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelViewProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewProjectDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(viewProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProjectPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labelViewProjectAddEmployee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelViewProjectAddEmployeeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(452, 452, 452))
                    .addGroup(viewProjectPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelViewProjectMembers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelViewProjectMembersContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        viewProjectScrollPane.setViewportView(viewProjectPanel);

        mainPanelCardPanel.add(viewProjectScrollPane, "viewProjectScrollPane");

        computeSalaryScrollPane.setBorder(null);

        computeSalaryPanel.setBackground(new java.awt.Color(255, 255, 255));
        computeSalaryPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        labelComputeSalary.setFont(new java.awt.Font("Open Sans Light", 1, 24)); // NOI18N
        labelComputeSalary.setText("COMPUTE SALARY");
        labelComputeSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 20, 0, 0, new java.awt.Color(238, 238, 238)));
        labelComputeSalary.setOpaque(true);

        panelComputeSalaryEmployeeContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelComputeSalaryEmployeeContainer.setPreferredSize(new java.awt.Dimension(600, 100));
        panelComputeSalaryEmployeeContainer.setLayout(new javax.swing.BoxLayout(panelComputeSalaryEmployeeContainer, javax.swing.BoxLayout.Y_AXIS));

        labelComputeSalaryFilter.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        labelComputeSalaryFilter.setText("Filter by project:");

        panelComputeSalaryFilterContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelComputeSalaryFilterContainer.setPreferredSize(new java.awt.Dimension(300, 28));
        panelComputeSalaryFilterContainer.setLayout(new javax.swing.BoxLayout(panelComputeSalaryFilterContainer, javax.swing.BoxLayout.Y_AXIS));

        buttonComputeSalaryRelease.setBackground(new java.awt.Color(231, 28, 35));
        buttonComputeSalaryRelease.setFont(new java.awt.Font("Open Sans Light", 1, 12)); // NOI18N
        buttonComputeSalaryRelease.setForeground(new java.awt.Color(255, 255, 255));
        buttonComputeSalaryRelease.setText("Release Salary");

        javax.swing.GroupLayout computeSalaryPanelLayout = new javax.swing.GroupLayout(computeSalaryPanel);
        computeSalaryPanel.setLayout(computeSalaryPanelLayout);
        computeSalaryPanelLayout.setHorizontalGroup(
            computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(computeSalaryPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonComputeSalaryRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelComputeSalaryEmployeeContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelComputeSalary, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addGroup(computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelComputeSalaryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelComputeSalaryFilterContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        computeSalaryPanelLayout.setVerticalGroup(
            computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(computeSalaryPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelComputeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelComputeSalaryFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(computeSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComputeSalaryFilterContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelComputeSalaryEmployeeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonComputeSalaryRelease)
                .addGap(410, 410, 410))
        );

        computeSalaryScrollPane.setViewportView(computeSalaryPanel);

        mainPanelCardPanel.add(computeSalaryScrollPane, "computeSalaryScrollPane");

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
        mainPanelSidePanelContainer.setLayout(new javax.swing.BoxLayout(mainPanelSidePanelContainer, javax.swing.BoxLayout.Y_AXIS));

        sidePanelLabelProjectWatch.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sidePanelLabelProjectWatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Project Watch.png"))); // NOI18N
        sidePanelLabelProjectWatch.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelProjectWatch);

        sidePanelLabelAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Employee.png"))); // NOI18N
        sidePanelLabelAddEmployee.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelAddEmployee);

        sidePanelLabelManageEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Employee.png"))); // NOI18N
        sidePanelLabelManageEmployee.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelManageEmployee);

        sidePanelLabelManageProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Manage Project.png"))); // NOI18N
        sidePanelLabelManageProject.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelManageProject);

        sidePanelLabelComputeSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Compute Salary.png"))); // NOI18N
        sidePanelLabelComputeSalary.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelComputeSalary);

        sidePanelLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Admin.png"))); // NOI18N
        sidePanelLabelLogout.setAlignmentX(0.5F);
        mainPanelSidePanelContainer.add(sidePanelLabelLogout);

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
    private javax.swing.JButton buttonAddEmployee;
    private javax.swing.JButton buttonComputeSalaryRelease;
    private javax.swing.JButton buttonEditEmployeeSaveChanges;
    private javax.swing.JButton buttonManageEmployeeSubmit;
    private javax.swing.JPanel computeSalaryPanel;
    private javax.swing.JScrollPane computeSalaryScrollPane;
    private javax.swing.JButton editEmployeeButton;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JLabel labelAddEmployee;
    private javax.swing.JLabel labelAddEmployeeFirstName;
    private javax.swing.JLabel labelAddEmployeeIDNumber;
    private javax.swing.JLabel labelAddEmployeeLastName;
    private javax.swing.JLabel labelAddEmployeeMiddleName;
    private javax.swing.JLabel labelAddEmployeeSalary;
    private javax.swing.JLabel labelComputeSalary;
    private javax.swing.JLabel labelComputeSalaryFilter;
    private javax.swing.JLabel labelEditEmployee;
    private javax.swing.JLabel labelEditEmployeeFirstName;
    private javax.swing.JLabel labelEditEmployeeIDNumber;
    private javax.swing.JLabel labelEditEmployeeLastName;
    private javax.swing.JLabel labelEditEmployeeMiddleName;
    private javax.swing.JLabel labelEditEmployeeSalary;
    private javax.swing.JLabel labelManageEmployee;
    private javax.swing.JLabel labelManageEmployeeAttendance;
    private javax.swing.JLabel labelManageProject;
    private javax.swing.JLabel labelManageProjectFilter;
    private javax.swing.JLabel labelSearchResults;
    private javax.swing.JLabel labelViewEmployeeID;
    private javax.swing.JLabel labelViewEmployeeMonthYear;
    private javax.swing.JLabel labelViewEmployeeName;
    private javax.swing.JLabel labelViewEmployeeNextMonth;
    private javax.swing.JLabel labelViewEmployeePreviousMonth;
    private javax.swing.JLabel labelViewEmployeeSalary;
    private javax.swing.JLabel labelViewProjectAddEmployee;
    private javax.swing.JLabel labelViewProjectDuration;
    private javax.swing.JLabel labelViewProjectMembers;
    private javax.swing.JLabel labelViewProjectName;
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
    private javax.swing.JScrollPane manageEmployeeScrollPane;
    private javax.swing.JPanel manageProjectPanel;
    private javax.swing.JScrollPane manageProjectScrollPane;
    private javax.swing.JPanel panelComputeSalaryEmployeeContainer;
    private javax.swing.JPanel panelComputeSalaryFilterContainer;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelManageEmployeeContainer;
    private javax.swing.JPanel panelManageEmployeeProjectContainer;
    private javax.swing.JPanel panelManageProjectContainer;
    private javax.swing.JPanel panelSearchResultsContainer;
    private javax.swing.JPanel panelViewEmployeeCalendar;
    private javax.swing.JPanel panelViewProjectAddEmployeeContainer;
    private javax.swing.JPanel panelViewProjectMembersContainer;
    private javax.swing.JPanel panelWelcomeCalendar;
    private javax.swing.JPanel searchResultsPanel;
    private javax.swing.JScrollPane searchResultsScrollPane;
    private javax.swing.JLabel sidePanelLabelAddEmployee;
    private javax.swing.JLabel sidePanelLabelComputeSalary;
    private javax.swing.JLabel sidePanelLabelLogout;
    private javax.swing.JLabel sidePanelLabelManageEmployee;
    private javax.swing.JLabel sidePanelLabelManageProject;
    private javax.swing.JLabel sidePanelLabelProjectWatch;
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
    private javax.swing.JPanel viewEmployeePanel;
    private javax.swing.JPanel viewProjectPanel;
    private javax.swing.JScrollPane viewProjectScrollPane;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables

    public void showError(String error, String head){
        PopBox.infoBox(error, head);
    }
    
    // getters
    public javax.swing.JPanel getAddEmployeePanel() {
        return addEmployeePanel;
    }

    public javax.swing.JButton getButtonAddEmployee() {
        return buttonAddEmployee;
    }

    public javax.swing.JButton getButtonComputeSalaryRelease() {
        return buttonComputeSalaryRelease;
    }

    public javax.swing.JButton getButtonEditEmployeeSaveChanges() {
        return buttonEditEmployeeSaveChanges;
    }

    public javax.swing.JButton getButtonManageEmployeeSubmit() {
        return buttonManageEmployeeSubmit;
    }

    public javax.swing.JPanel getComputeSalaryPanel() {
        return computeSalaryPanel;
    }

    public javax.swing.JScrollPane getComputeSalaryScrollPane() {
        return computeSalaryScrollPane;
    }

    public javax.swing.JButton getEditEmployeeButton() {
        return editEmployeeButton;
    }

    public javax.swing.JPanel getEditEmployeePanel() {
        return editEmployeePanel;
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

    public javax.swing.JLabel getLabelComputeSalary() {
        return labelComputeSalary;
    }

    public javax.swing.JLabel getLabelComputeSalaryFilter() {
        return labelComputeSalaryFilter;
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

    public javax.swing.JLabel getLabelManageProject() {
        return labelManageProject;
    }

    public javax.swing.JLabel getLabelManageProjectFilter() {
        return labelManageProjectFilter;
    }

    public javax.swing.JLabel getLabelSearchResults() {
        return labelSearchResults;
    }

    public javax.swing.JLabel getLabelViewEmployeeID() {
        return labelViewEmployeeID;
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

    public javax.swing.JLabel getLabelViewEmployeeSalary() {
        return labelViewEmployeeSalary;
    }

    public javax.swing.JLabel getLabelViewProjectAddEmployee() {
        return labelViewProjectAddEmployee;
    }

    public javax.swing.JLabel getLabelViewProjectDuration() {
        return labelViewProjectDuration;
    }

    public javax.swing.JLabel getLabelViewProjectMembers() {
        return labelViewProjectMembers;
    }

    public javax.swing.JLabel getLabelViewProjectName() {
        return labelViewProjectName;
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

    public javax.swing.JScrollPane getManageEmployeeScrollPane() {
        return manageEmployeeScrollPane;
    }

    public javax.swing.JPanel getManageProjectPanel() {
        return manageProjectPanel;
    }

    public javax.swing.JScrollPane getManageProjectScrollPane() {
        return manageProjectScrollPane;
    }

    public javax.swing.JPanel getPanelComputeSalaryEmployeeContainer() {
        return panelComputeSalaryEmployeeContainer;
    }

    public javax.swing.JPanel getPanelComputeSalaryFilterContainer() {
        return panelComputeSalaryFilterContainer;
    }

    public javax.swing.JPanel getPanelLogin() {
        return panelLogin;
    }

    public javax.swing.JPanel getPanelMain() {
        return panelMain;
    }

    public javax.swing.JPanel getPanelManageEmployeeContainer() {
        return panelManageEmployeeContainer;
    }

    public javax.swing.JPanel getPanelManageEmployeeProjectContainer() {
        return panelManageEmployeeProjectContainer;
    }

    public javax.swing.JPanel getPanelManageProjectContainer() {
        return panelManageProjectContainer;
    }

    public javax.swing.JPanel getPanelSearchResultsContainer() {
        return panelSearchResultsContainer;
    }

    public javax.swing.JPanel getPanelViewEmployeeCalendar() {
        return panelViewEmployeeCalendar;
    }

    public javax.swing.JPanel getPanelViewProjectAddEmployeeContainer() {
        return panelViewProjectAddEmployeeContainer;
    }

    public javax.swing.JPanel getPanelViewProjectMembersContainer() {
        return panelViewProjectMembersContainer;
    }

    public javax.swing.JPanel getPanelWelcomeCalendar() {
        return panelWelcomeCalendar;
    }

    public javax.swing.JPanel getSearchResultsPanel() {
        return searchResultsPanel;
    }

    public javax.swing.JScrollPane getSearchResultsScrollPane() {
        return searchResultsScrollPane;
    }

    public javax.swing.JLabel getSidePanelLabelAddEmployee() {
        return sidePanelLabelAddEmployee;
    }

    public javax.swing.JLabel getSidePanelLabelComputeSalary() {
        return sidePanelLabelComputeSalary;
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

    public javax.swing.JPanel getViewEmployeePanel() {
        return viewEmployeePanel;
    }

    public javax.swing.JPanel getViewProjectPanel() {
        return viewProjectPanel;
    }

    public javax.swing.JScrollPane getViewProjectScrollPane() {
        return viewProjectScrollPane;
    }

    public javax.swing.JPanel getWelcomePanel() {
        return welcomePanel;
    }
    
    public javax.swing.JButton getReleaseSalaryButton(){
        return buttonComputeSalaryRelease;
    }
    
    
}
