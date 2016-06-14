
package gui;

import java.awt.Toolkit;
import sun.net.www.content.image.png;

public class MainFrame extends javax.swing.JFrame {

    private static final MainFrame mainFrame = new MainFrame();
    
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
        labelLoginJollibeeConstructionLogo = new javax.swing.JLabel();
        textfieldLoginUsername = new javax.swing.JTextField();
        passwordfieldLoginPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        mainPanelHeader = new javax.swing.JPanel();
        mainLabelJollibeeConstructionLogo = new javax.swing.JLabel();
        mainTextFieldSearch = new javax.swing.JTextField();
        mainPanelCardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jollibee Construction Timekeeping");
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Jollibee Construction.png")));
        setPreferredSize(getMaximumSize());
        getContentPane().setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(255, 204, 51));
        panelLogin.setName("panelLogin"); // NOI18N
        panelLogin.setLayout(new java.awt.GridBagLayout());

        labelLoginJollibeeConstructionLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Jollibee Construction.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        panelLogin.add(labelLoginJollibeeConstructionLogo, gridBagConstraints);

        textfieldLoginUsername.setText("Username");
        textfieldLoginUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLogin.add(textfieldLoginUsername, gridBagConstraints);

        passwordfieldLoginPassword.setText("Password");
        passwordfieldLoginPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLogin.add(passwordfieldLoginPassword, gridBagConstraints);

        buttonLogin.setBackground(new java.awt.Color(231, 28, 35));
        buttonLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Log-in");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        panelLogin.add(buttonLogin, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        mainPanelHeader.add(mainLabelJollibeeConstructionLogo, gridBagConstraints);

        mainTextFieldSearch.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        mainTextFieldSearch.setText("Search");
        mainTextFieldSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 50.0;
        gridBagConstraints.weighty = 1.0;
        mainPanelHeader.add(mainTextFieldSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        panelMain.add(mainPanelHeader, gridBagConstraints);

        mainPanelCardPanel.setBackground(new java.awt.Color(251, 251, 251));
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
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel labelLoginJollibeeConstructionLogo;
    private javax.swing.JLabel mainLabelJollibeeConstructionLogo;
    private javax.swing.JPanel mainPanelCardPanel;
    private javax.swing.JPanel mainPanelHeader;
    private javax.swing.JTextField mainTextFieldSearch;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPasswordField passwordfieldLoginPassword;
    private javax.swing.JTextField textfieldLoginUsername;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getButtonLogin() {
        return buttonLogin;
    }

    public javax.swing.JPanel getPanelLogin() {
        return panelLogin;
    }

    public javax.swing.JPasswordField getPasswordfieldLoginPassword() {
        return passwordfieldLoginPassword;
    }

    public javax.swing.JTextField getTextfieldLoginUsername() {
        return textfieldLoginUsername;
    }
}
