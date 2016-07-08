
package controller;

import gui.MainFrame;
import gui.ManageProjectListItemPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Project;

public class ManageProjectContoller implements Listen, PanelChanger{

    private static final ManageProjectContoller manageProjectContoller = new ManageProjectContoller();
    
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "manageProjectScrollPane";
    
    private ArrayList<Project> projects;
    private ArrayList<ManageProjectListItemPanel> projectsPanels;
    
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
        int len = projectsPanels.size();
        for(int i = 0 ; i < len; i++){
            final int index = i;
            final ManageProjectListItemPanel panel = projectsPanels.get(index);
            final Project project = projects.get(index);
            
            panel.getLabelProjectName().addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    ViewProjectController.getInstance().setProject(project);
                    ViewProjectController.getInstance().showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    panel.getLabelProjectName().setForeground(new Color(231,28,35));
                    panel.getLabelProjectName().setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    panel.getLabelProjectName().setForeground(new Color(51,51,51));
                    panel.getLabelProjectName().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                
            });
        }
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        projects = Project.getProjectList();
        refreshProjectList();
        addListeners();
    }
    
    private void refreshProjectList(){
        projectsPanels = new ArrayList<>();
        
        int len = projects.size();
            
        mainFrame.getPanelManageProjectContainer().removeAll();
        GridLayout layout = (GridLayout)mainFrame.getPanelManageProjectContainer().getLayout();
        layout.setRows(len);
        mainFrame.getManageProjectPanel().setPreferredSize(new Dimension(mainFrame.getManageProjectPanel().getPreferredSize().width, MainFrame.getSPACE_ABOVE() + mainFrame.getLabelManageProject().getPreferredSize().height + ManageProjectListItemPanel.PANEL_HEIGHT * len));
        //mainFrame.getPanelManageProjectContainer().setPreferredSize(new Dimension(ManageProjectItemListPanel.PANEL_WIDTH, ManageProjectItemListPanel.PANEL_HEIGHT * len));
        
        if(!projects.isEmpty()){
            for(int i = 0; i < len; i++){
                Project p = projects.get(i);
                ManageProjectListItemPanel panel = new ManageProjectListItemPanel(p.getName(), p.getDateStarted(), p.getDateDue());
                mainFrame.getPanelManageProjectContainer().add(panel);
                projectsPanels.add(panel);
            }
        }
            
        mainFrame.getPanelManageProjectContainer().repaint();
        mainFrame.getPanelManageProjectContainer().revalidate();
    }
}
