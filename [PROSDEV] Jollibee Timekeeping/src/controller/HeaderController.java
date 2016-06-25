package controller;

import gui.MainFrame;
import gui.PopBox;
import java.awt.CardLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Employee;

public class HeaderController implements Listen {
    
    private final String SEARCH_FIELD_DEFAULT = "Search";
    private final String HOME_PAGE = "add_time";
    
    private static final HeaderController controller = new HeaderController();
    
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    
    private HeaderController(){
        mainFrame = MainFrame.getInstance();
        
        addListeners();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout =(CardLayout) mainCardPanel.getLayout();
    }
    
    public static HeaderController getInstance(){
        return controller;
    }
    
    @Override
    public final void addListeners(){
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
        
        mainFrame.getMainTextFieldSearch().addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER &&  mainFrame.getMainTextFieldSearch().hasFocus()){
                    
                    String s = mainFrame.getMainTextFieldSearch().getText();
                    System.out.println("Bro ! "+s);
                    if(!s.isEmpty()){
                        System.out.println("Bro2 ! "+s);
                        try {
                            ArrayList<Employee> empList = Employee.searchDB(s);
                            if(empList == null){
                                PopBox.infoBox("No search Result", "");
                            }else{
                                System.out.println("U got results");
                                SearchResultController.getInstance().setModel(empList);
                                SearchResultController.getInstance().showPanel();
                                
                            }
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }    
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            
        });
        
        
        
    }
    
    
    public void search(String input){
        
        
    }
    
    
    public void showPanel(){
        System.out.println("Here!!! :D");
        mainLayout.show(mainCardPanel, HOME_PAGE);
    }
}
