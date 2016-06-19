
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
        jPanel1 = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        mainPanelHeader = new javax.swing.JPanel();
        mainLabelJollibeeConstructionLogo = new javax.swing.JLabel();
        mainTextFieldSearch = new javax.swing.JTextField();
        mainLabelName = new javax.swing.JLabel();
        mainLabelLogout = new javax.swing.JLabel();
        mainPanelCardPanel = new javax.swing.JPanel();
        add_time = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        employeeTime = new javax.swing.JLabel();
        testing = new javax.swing.JPanel();

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        panelLogin.add(loginButtonLogin, gridBagConstraints);
        panelLogin.add(jPanel1, new java.awt.GridBagConstraints());

        getContentPane().add(panelLogin, "panelLogin");

        panelMain.setName("panelMain"); // NOI18N
        panelMain.setLayout(new java.awt.GridBagLayout());

        mainPanelHeader.setBackground(new java.awt.Color(244, 244, 244));
        mainPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        panelMain.add(mainPanelHeader, gridBagConstraints);

        mainPanelCardPanel.setBackground(new java.awt.Color(251, 251, 251));
        mainPanelCardPanel.setLayout(new java.awt.CardLayout());

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
                .addContainerGap(915, Short.MAX_VALUE))
        );
        add_timeLayout.setVerticalGroup(
            add_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_timeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(employeeTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        mainPanelCardPanel.add(add_time, "card2");
        mainPanelCardPanel.add(testing, "card3");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        panelMain.add(mainPanelCardPanel, gridBagConstraints);

        getContentPane().add(panelMain, "panelMain");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static MainFrame getInstance(){
        return mainFrame;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_time;
    private javax.swing.JLabel employeeTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButtonLogin;
    private javax.swing.JLabel loginLabelJollibeeConstructionLogo;
    private javax.swing.JPasswordField loginPasswordFieldPassword;
    private javax.swing.JTextField loginTextFieldUsername;
    private javax.swing.JLabel mainLabelJollibeeConstructionLogo;
    private javax.swing.JLabel mainLabelLogout;
    private javax.swing.JLabel mainLabelName;
    private javax.swing.JPanel mainPanelCardPanel;
    private javax.swing.JPanel mainPanelHeader;
    private javax.swing.JTextField mainTextFieldSearch;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel testing;
    // End of variables declaration//GEN-END:variables

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

    public javax.swing.JTextField getMainTextFieldSearch() {
        return mainTextFieldSearch;
    }

    public javax.swing.JPanel getPanelLogin() {
        return panelLogin;
    }

    public javax.swing.JPanel getPanelMain() {
        return panelMain;
    }
}
