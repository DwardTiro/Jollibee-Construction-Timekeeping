package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    
    private final String USERNAME_FIELD_DEFAULT = "Username";
    private final String PASSWORD_FIELD_DEFAULT = "Password";
    private final String CARD_LOGIN = "panelLogin";
    private final String CARD_MAIN = "panelMain";
    
    private static final Controller controller = new Controller();
    
    private final MainFrame mainFrame;
    
    private Controller(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        
        addListeners();
    }
    
    public static Controller getInstance(){
        return controller;
    }
    
    private void addListeners(){
        // login panel listeners
        addPanelLoginListeners();
        
    }
    
    private void addPanelLoginListeners(){
        
        mainFrame.getTextfieldLoginUsername().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if(mainFrame.getTextfieldLoginUsername().getText().equalsIgnoreCase("")){
                    mainFrame.getTextfieldLoginUsername().setText(USERNAME_FIELD_DEFAULT);
                }
            }
            
        });
        
        mainFrame.getTextfieldLoginUsername().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(mainFrame.getTextfieldLoginUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getTextfieldLoginUsername().setText("");
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
        
        mainFrame.getTextfieldLoginUsername().addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                if(mainFrame.getTextfieldLoginUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getTextfieldLoginUsername().setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        mainFrame.getPasswordfieldLoginPassword().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if(String.copyValueOf(mainFrame.getPasswordfieldLoginPassword().getPassword()).equalsIgnoreCase(PASSWORD_FIELD_DEFAULT)){
                    mainFrame.getPasswordfieldLoginPassword().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {}
            
        });
        
        mainFrame.getButtonLogin().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(tryLogin(mainFrame.getTextfieldLoginUsername().getText(), String.copyValueOf(mainFrame.getPasswordfieldLoginPassword().getPassword()))){
                    CardLayout cardLayout = (CardLayout) mainFrame.getLayout();
                    cardLayout.show(mainFrame, CARD_MAIN);
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
    
    // returns true if login is successful (username and password is correct), false otherwise
    private boolean tryLogin(String username, String password){
        boolean login = false;
        
        // backend logic here
        
        return login;
    }
    
    private void logout(){
        CardLayout cardLayout = (CardLayout) mainFrame.getLayout();
        cardLayout.show(mainFrame, CARD_LOGIN);
    }
}
