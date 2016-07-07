
package controller;

import gui.MainFrame;
import java.awt.CardLayout;
import model.CalendarModel;
import model.Project;

public class ViewProjectController implements Listen, PanelChanger{

    private final static ViewProjectController viewProjectController = new ViewProjectController();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    
    private final String PANEL_NAME = "viewProjectPanel";
    
    private Project project;
    
    private ViewProjectController(){
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        
        project = null;
    }
    
    public static ViewProjectController getInstance(){
        return ViewProjectController.viewProjectController;
    }
    
    @Override
    public void addListeners() {
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        mainFrame.getLabelViewProjectName().setText(project.getName());
        
        String[] presetDateStarted = project.getDateStarted().toString().split(" ");
        String[] presetDateDue = project.getDateDue().toString().split(" ");
        mainFrame.getLabelViewProjectDuration().setText(monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateStarted[1])) + " " + presetDateStarted[2] + ", " + presetDateStarted[5] + " - " + monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateDue[1])) + " " + presetDateDue[2] + ", " + presetDateDue[5]);
    }
    
    public void setProject(Project project){
        this.project = project;
    }
 
    private String monthToString(int month){
        String sMonth = "";
        
        switch(month){
            case(CalendarModel.NJANUARY): sMonth = CalendarModel.SJANUARY; break;
            case(CalendarModel.NFEBRUARY): sMonth = CalendarModel.SFEBRUARY; break;
            case(CalendarModel.NMARCH): sMonth = CalendarModel.SMARCH; break;
            case(CalendarModel.NAPRIL): sMonth = CalendarModel.SAPRIL; break;
            case(CalendarModel.NMAY): sMonth = CalendarModel.SMAY; break;
            case(CalendarModel.NJUNE): sMonth = CalendarModel.SJUNE; break;
            case(CalendarModel.NJULY): sMonth = CalendarModel.SJULY; break;
            case(CalendarModel.NAUGUST): sMonth = CalendarModel.SAUGUST; break;
            case(CalendarModel.NSEPTEMBER): sMonth = CalendarModel.SSEPTEMBER; break;
            case(CalendarModel.NOCTOBER): sMonth = CalendarModel.SOCTOBER; break;
            case(CalendarModel.NNOVEMBER): sMonth = CalendarModel.SNOVEMBER; break;
            case(CalendarModel.NDECEMBER): sMonth = CalendarModel.SDECEMBER; break;
        }
        
        return sMonth;
    }
    
}
