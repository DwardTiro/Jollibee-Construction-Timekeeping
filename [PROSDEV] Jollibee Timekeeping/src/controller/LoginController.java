package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DbConnection;

public class LoginController implements Listen, PanelChanger {

    private static final LoginController loginController = new LoginController();
    private final MainFrame mainFrame;

    private final String USERNAME_FIELD_DEFAULT = "Username";
    private final String PASSWORD_FIELD_DEFAULT = "Password";
    private final String CARD_LOGIN = "panelLogin";
    private final String PANEL_NAME = "panelMain";

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
                //if(tryLogin(mainFrame.getLoginTextFieldUsername().getText(), String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()))){
                CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
                cardLayout.show(mainFrame.getContentPane(), PANEL_NAME);
                //}
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

    // returns true if login is successful (username and password is correct), false otherwise
    private boolean tryLogin(String username, String password) {
        boolean login = false;
        ResultSet rs = null;
        String query = "select id,password from admin where username = '" + username + "'\n"
                + "and password = '" + password + "'";
        System.out.println("Im here!!");
        try {
            Statement s = DbConnection.con.createStatement();
            System.out.println(query);
            s.executeQuery(query);

            rs = s.getResultSet();

            if (rs.next()) {
                login = true;
                System.out.println("Success Login");

            } else {
                System.out.println("Failed to log in");
            }
            // backend logic here
        } catch (SQLException ex) {
            Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return login;
    }
    
    private void logout(){
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), CARD_LOGIN);
    }
}
