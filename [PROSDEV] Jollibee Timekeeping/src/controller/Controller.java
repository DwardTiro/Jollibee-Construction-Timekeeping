package controller;

import gui.MainFrame;

public class Controller {
    private static final Controller controller = new Controller();
    
    private final MainFrame mainFrame;
    
    private Controller(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
    
    public static Controller getInstance(){
        return controller;
    }
}
