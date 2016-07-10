package controller;

import gui.ComputeSalaryEmployeePanel;
import gui.ComputeSalaryTotalPanel;
import gui.MainFrame;
import gui.ProjectFilterPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.AttendanceModel;
import model.Employee;
import model.Payroll;
import model.Project;

public class ComputeSalaryController implements Listen, PanelChanger{

    private static final ComputeSalaryController computeSalaryController = new ComputeSalaryController();
    
    private final MainFrame mainFrame;
    
    private final String PANEL_NAME = "computeSalaryScrollPane";
    private final String MANAGE_EMPLOYEE_STRING = "COMPUTE SALARY";
    private final String MANAGE_EMPLOYEE_NEGATIVE_STRING = "NOTHING TO COMPUTE FOR ";
    
    private ArrayList<Employee> employees;
    private Payroll payroll;
    private ArrayList<ComputeSalaryEmployeePanel> employeePanels;
    
    private ArrayList<Project> projects;
    private ArrayList<ProjectFilterPanel> projectsPanels;
    
    private ComputeSalaryTotalPanel totalPanel;
    
    private ComputeSalaryController (){
        mainFrame = MainFrame.getInstance();
        
        employees = new ArrayList<>();
        employeePanels = new ArrayList<>();
        
        projects = new ArrayList<>();
        projectsPanels = new ArrayList<>();
        
        totalPanel = new ComputeSalaryTotalPanel();
    }
    
    public static ComputeSalaryController getInstance(){
        return ComputeSalaryController.computeSalaryController;
    }
    
    @Override
    public void addListeners() {
        int len = projectsPanels.size();
        
        MainFrame.getInstance().getReleaseSalaryButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                
                if(!employees.isEmpty()){
                    try {
                        payroll.savePayroll();
                        employees = Employee.getAllEmployees();
                        projects = Project.getProjectList();
                        refreshEmployeeList();
                        refreshProjectList();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ComputeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
           
        });
        
        
        for(int i = 0; i < len; i++){
            int index = i;
            JLabel label = projectsPanels.get(i).getLabelProjectName();
            
            label.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    if(index < projects.size())
                        showEmployeesInProject(projects.get(index).getID());
                    else
                        showEmployeesInProject(-1);
                    
                    if(!employees.isEmpty() && index < projects.size()){
                        mainFrame.getLabelComputeSalary().setText(MANAGE_EMPLOYEE_STRING + " FOR " + projects.get(index).getName().toUpperCase());
                        mainFrame.getButtonComputeSalaryRelease().setVisible(true);
                        mainFrame.getButtonComputeSalaryRelease().setEnabled(true);
                    }
                    else if(index == projects.size()){
                        mainFrame.getLabelComputeSalary().setText(MANAGE_EMPLOYEE_STRING + " FOR ALL PROJECTS");
                        mainFrame.getButtonComputeSalaryRelease().setVisible(true);
                        mainFrame.getButtonComputeSalaryRelease().setEnabled(true);
                    }
                    else if(employees.isEmpty()){
                        mainFrame.getLabelComputeSalary().setText(MANAGE_EMPLOYEE_NEGATIVE_STRING + projects.get(index).getName().toUpperCase());
                        mainFrame.getButtonComputeSalaryRelease().setVisible(false);
                        mainFrame.getButtonComputeSalaryRelease().setEnabled(false);
                        mainFrame.getPanelComputeSalaryEmployeeContainer().remove(totalPanel);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(new Color(231,28,35));
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(new Color(51,51,51));
                    label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            
            });
        }
        
        
        
    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);
        
        employees = Employee.getAllEmployees();
        projects = Project.getProjectList();
        
        refreshEmployeeList();
        refreshProjectList();
        addListeners();
    }
    
    
    
    private void removeNoSalary() throws SQLException{
         ArrayList<AttendanceModel> attendance;
         Iterator<Employee> iterator = employees.iterator();
         Employee emp;
         while(iterator.hasNext()){
             emp = iterator.next();
             attendance = AttendanceModel.getUnpaidEmp(emp.getID());
             if(attendance.isEmpty()){
                 iterator.remove();
             }else{
                 emp.setAttendance(attendance);
             }
         }
         
    }
    
    
    private void refreshEmployeeList(){
        
        try {
            //filter employee list those who have salaries.
            removeNoSalary();
            payroll = Payroll.computeSalary(employees);
        } catch (SQLException ex) {
            Logger.getLogger(ComputeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        employeePanels = new ArrayList<>();
        int len = employees.size();
        
        mainFrame.getPanelComputeSalaryEmployeeContainer().removeAll();
        //GridLayout layout = (GridLayout)mainFrame.getPanelComputeSalaryEmployeeContainer().getLayout();
        //layout.setRows(len + 1);
        mainFrame.getComputeSalaryPanel().setPreferredSize(new Dimension(mainFrame.getComputeSalaryPanel().getPreferredSize().width, MainFrame.SPACE_ABOVE + mainFrame.getLabelComputeSalary().getPreferredSize().height + ComputeSalaryEmployeePanel.PANEL_HEIGHT * (len + 2) + mainFrame.getButtonComputeSalaryRelease().getPreferredSize().height));
        mainFrame.getPanelComputeSalaryEmployeeContainer().setPreferredSize(new Dimension(ComputeSalaryEmployeePanel.PANEL_WIDTH, ComputeSalaryEmployeePanel.PANEL_WIDTH * (len + 1)));
        
        if(!employees.isEmpty()){
            //mainFrame.getPanelManageEmployeeContainer().setPreferredSize(new Dimension(ManageEmployeeAttendancePanel.PANEL_WIDTH, ManageEmployeeAttendancePanel.PANEL_HEIGHT * (len + 1)));
            for(int i = 0; i < len; i++){
                Employee e = employees.get(i);
                ComputeSalaryEmployeePanel panel = new ComputeSalaryEmployeePanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getID()),"Project Name", employees.get(i).getTotalSalary()+"");
                mainFrame.getPanelComputeSalaryEmployeeContainer().add(panel);
                employeePanels.add(panel);
            }
        }
        totalPanel.setTotal(payroll.getTotal()+"");
        mainFrame.getPanelComputeSalaryEmployeeContainer().add(totalPanel);
        
        mainFrame.getPanelComputeSalaryEmployeeContainer().repaint();
        mainFrame.getPanelComputeSalaryEmployeeContainer().revalidate();
    }
    
    private void refreshProjectList(){
        projectsPanels = new ArrayList<>();
        
        int len = projects.size();
            
        mainFrame.getPanelComputeSalaryFilterContainer().removeAll();
        mainFrame.getPanelComputeSalaryFilterContainer().setPreferredSize(new Dimension(ProjectFilterPanel.PANEL_WIDTH, ProjectFilterPanel.PANEL_HEIGHT * len));
            
        if(!projects.isEmpty()){
            for(int i = 0; i < len; i++){
                Project p = projects.get(i);
                ProjectFilterPanel panel = new ProjectFilterPanel(p.getName());
                mainFrame.getPanelComputeSalaryFilterContainer().add(panel);
                projectsPanels.add(panel);
            }
        }
        ProjectFilterPanel panel = new ProjectFilterPanel("All Projects");
        mainFrame.getPanelComputeSalaryFilterContainer().add(panel);
        projectsPanels.add(panel);
            
        mainFrame.getPanelComputeSalaryFilterContainer().repaint();
        mainFrame.getPanelManageEmployeeProjectContainer().revalidate();
    }
    
    private void showEmployeesInProject(int projectID){
        if(projectID != -1)
            employees = Employee.getEmployeeByProject(projectID);
        else
            employees = Employee.getAllEmployees();
        refreshEmployeeList();
    }
    
    
    
    
    
    
    
}
