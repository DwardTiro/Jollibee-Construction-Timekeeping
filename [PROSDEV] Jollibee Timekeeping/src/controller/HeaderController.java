package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;

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
    }
    
    public void showPanel(){
        System.out.println("Here!!! :D");
        mainLayout.show(mainCardPanel, HOME_PAGE);
    }
}
