package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.DbConnection;

public class Controller {
    
    private final String USERNAME_FIELD_DEFAULT = "Username";
    private final String PASSWORD_FIELD_DEFAULT = "Password";
    private final String SEARCH_FIELD_DEFAULT = "Search";
    
    private final String CARD_LOGIN = "panelLogin";
    private final String CARD_MAIN = "panelMain";
    private final String HOME_PAGE = "add_time";
    
    private static final Controller controller = new Controller();
    
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    
    private Controller(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        addListeners();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout =(CardLayout) mainCardPanel.getLayout();
    }
    
    public static Controller getInstance(){
        return controller;
    }
    
    private void addListeners(){
        // login panel listeners
        addPanelLoginListeners();
        addPanelMainListeners();
    }
    
    private void addPanelLoginListeners(){
        
        mainFrame.getLoginTextFieldUsername().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase("")){
                    mainFrame.getLoginTextFieldUsername().setText(USERNAME_FIELD_DEFAULT);
                }
            }
            
        });
        
        mainFrame.getLoginTextFieldUsername().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        
        mainFrame.getLoginTextFieldUsername().addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        mainFrame.getLoginPasswordFieldPassword().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if(String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()).equalsIgnoreCase(PASSWORD_FIELD_DEFAULT)){
                    mainFrame.getLoginPasswordFieldPassword().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {}
            
        });
        
        mainFrame.getLoginButtonLogin().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(tryLogin(mainFrame.getLoginTextFieldUsername().getText(), String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()))){
                    CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
                    cardLayout.show(mainFrame.getContentPane(), CARD_MAIN);
                    showHomePage();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
    }
    
    private void addPanelMainListeners(){
        mainFrame.getMainTextFieldSearch().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if(mainFrame.getMainTextFieldSearch().getText().equalsIgnoreCase(SEARCH_FIELD_DEFAULT)){
                    mainFrame.getMainTextFieldSearch().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(mainFrame.getMainTextFieldSearch().getText().equalsIgnoreCase("")){
                    mainFrame.getMainTextFieldSearch().setText(SEARCH_FIELD_DEFAULT);
                }
            } 
        });
        
        mainFrame.getMainLabelLogout().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                logout();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    // returns true if login is successful (username and password is correct), false otherwise
    private boolean tryLogin(String username, String password){
        boolean login = false;
        ResultSet rs = null;
        String query = "select id,password from admin where username = '"+  username+"'\n"+
                "and password = '"+password+"'";
        System.out.println("Im here!!");
        try {
            Statement s = DbConnection.con.createStatement();
            System.out.println(query);
            s.executeQuery(query);
            
            rs = s.getResultSet();
            
            if(rs.next()){
                login= true;
                System.out.println("Success Login");
                
            }else{
                System.out.println("Failed to log in");
            }
            // backend logic here
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return login;
    }
    
    private void logout(){
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), CARD_LOGIN);
    }
    
    private void showHomePage(){
        System.out.println("Here!!! :D");
        mainLayout.show(mainCardPanel,HOME_PAGE);
        
        
    }
    
    
    
}
