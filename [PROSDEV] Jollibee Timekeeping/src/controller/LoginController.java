package controller;

import gui.MainFrame;
import gui.PopBox;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AdminModel;
import model.DbConnection;

public class LoginController implements Listen, PanelChanger {

    private static final LoginController loginController = new LoginController();
    private final MainFrame mainFrame;

    private final String USERNAME_FIELD_DEFAULT = "Username";
    private final String PASSWORD_FIELD_DEFAULT = "Password";
    
    public static final String TYPE_ADMINISTRATOR  = "Administrator";
    public static final String TYPE_ENCODER = "Encoder";
    
    private final String CARD_LOGIN = "panelLogin";
    private final String PANEL_NAME = "panelMain";
    private final String PANEL_WELCOME = "welcomePanel";

    private LoginController() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);

        addListeners();
    }

    public static LoginController getInstance() {
        return LoginController.loginController;
    }

    @Override
    public final void addListeners() {
        mainFrame.getLoginTextFieldUsername().addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase("")) {
                    mainFrame.getLoginTextFieldUsername().setText(USERNAME_FIELD_DEFAULT);
                }
            }

        });

        mainFrame.getLoginTextFieldUsername().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)) {
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        mainFrame.getLoginTextFieldUsername().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)) {
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        mainFrame.getLoginPasswordFieldPassword().addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()).equalsIgnoreCase(PASSWORD_FIELD_DEFAULT)) {
                    mainFrame.getLoginPasswordFieldPassword().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }

        });

        mainFrame.getLoginButtonLogin().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                AdminModel admin;
                if((admin = tryLogin(mainFrame.getLoginTextFieldUsername().getText(), String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()))) != null){
                    NavigationController.getInstance().setAdmin(admin);
                    login();
                }else{
                    PopBox.infoBox("Failed to log in", "");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }

    @Override
    public void showPanel() {
        logout();
    }

    private AdminModel tryLogin(String username, String password) {
        AdminModel admin = null;
        ResultSet rs = null;
        
        String query = "select * from admin where username = ? and password = ?";
        
        try {
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                admin = new AdminModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return admin;
    }
    
    private void login(){
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), PANEL_NAME);
        
        cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_WELCOME);
        
        mainFrame.getMainTextFieldSearch().setText("Search");
        
        mainFrame.getLoginTextFieldUsername().setText(USERNAME_FIELD_DEFAULT);
        mainFrame.getLoginPasswordFieldPassword().setText("");
        mainFrame.getMainLabelName().setText(NavigationController.getInstance().getAdmin().getName());
        
        if(NavigationController.getInstance().getAdmin().getUserType().equals(TYPE_ENCODER)){
            mainFrame.getSidePanelLabelAddEmployee().setVisible(false);
            mainFrame.getSidePanelLabelManageProject().setVisible(false);
            mainFrame.getSidePanelLabelComputeSalary().setVisible(false);
            /*
            Container parent;
            parent = mainFrame.getSidePanelLabelAddEmployee().getParent();
            parent.remove(mainFrame.getSidePanelLabelAddEmployee());
            parent.repaint();
            parent.revalidate();
            
            parent = mainFrame.getSidePanelLabelManageProject().getParent();
            parent.remove(mainFrame.getSidePanelLabelManageProject());
            parent.repaint();
            parent.revalidate();
            
            parent = mainFrame.getSidePanelLabelComputeSalary().getParent();
            parent.remove(mainFrame.getSidePanelLabelComputeSalary());
            parent.repaint();
            parent.revalidate();
            */
        } else{
            mainFrame.getSidePanelLabelAddEmployee().setVisible(true);
            mainFrame.getSidePanelLabelManageProject().setVisible(true);
            mainFrame.getSidePanelLabelComputeSalary().setVisible(true);
        }
        
    }
    
    private void logout(){
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), CARD_LOGIN);
    }
}
