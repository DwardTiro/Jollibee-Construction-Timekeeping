
package controller;

import gui.MainFrame;
import java.awt.CardLayout;

public class ManageProjectContoller implements Listen, PanelChanger{

    private static final ManageProjectContoller manageProjectContoller = new ManageProjectContoller();
    
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "manageProjectScrollPane";
    
    private ManageProjectContoller(){
        mainFrame = MainFrame.getInstance();
    }
    
    public static ManageProjectContoller getInstance(){
        return ManageProjectContoller.manageProjectContoller;
    }
    
    @Override
    public void addListeners() {
    
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
    }
    
}
