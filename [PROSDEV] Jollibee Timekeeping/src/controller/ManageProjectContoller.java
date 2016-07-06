
package controller;

import gui.MainFrame;
import gui.ManageProjectItemListPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import model.Project;

public class ManageProjectContoller implements Listen, PanelChanger{

    private static final ManageProjectContoller manageProjectContoller = new ManageProjectContoller();
    
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "manageProjectScrollPane";
    
    private ArrayList<Project> projects;
    private ArrayList<ManageProjectItemListPanel> projectsPanels;
    
    private ManageProjectContoller(){
        mainFrame = MainFrame.getInstance();
        
        projects = new ArrayList<>();
        projectsPanels = new ArrayList<>();
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
        
        projects = Project.getProjectList();
        refreshProjectList();
    }
    
    private void refreshProjectList(){
        projectsPanels = new ArrayList<>();
        
        int len = projects.size();
            
        mainFrame.getPanelManageProjectContainer().removeAll();
        GridLayout layout = (GridLayout)mainFrame.getPanelManageProjectContainer().getLayout();
        layout.setRows(len);
        mainFrame.getManageProjectPanel().setPreferredSize(new Dimension(mainFrame.getManageProjectPanel().getPreferredSize().width, (int)mainFrame.getLabelManageProject().getAlignmentY() + mainFrame.getLabelManageProject().getPreferredSize().height + ManageProjectItemListPanel.PANEL_HEIGHT * (len+1)));
        //mainFrame.getPanelManageProjectContainer().setPreferredSize(new Dimension(ManageProjectItemListPanel.PANEL_WIDTH, ManageProjectItemListPanel.PANEL_HEIGHT * len));
            
        if(!projects.isEmpty()){
            for(int i = 0; i < len; i++){
                Project p = projects.get(i);
                ManageProjectItemListPanel panel = new ManageProjectItemListPanel(p.getName(), p.getDateStarted(), p.getDateDue());
                mainFrame.getPanelManageProjectContainer().add(panel);
                projectsPanels.add(panel);
            }
        }
            
        mainFrame.getPanelManageProjectContainer().repaint();
        mainFrame.getPanelManageProjectContainer().revalidate();
    }
}
