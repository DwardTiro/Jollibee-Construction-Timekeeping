package controller;

import gui.MainFrame;
import gui.ManageProjectAddEmployeeListItemPanel;
import gui.ViewProjectMemberListItemPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.CalendarModel;
import model.Employee;
import model.EmployeeDetailsAuditTrail;
import model.Project;

public class ViewProjectController implements Listen, PanelChanger {

    private final static ViewProjectController viewProjectController = new ViewProjectController();

    private final MainFrame mainFrame;

    private final String PANEL_NAME = "viewProjectScrollPane";
    private final String ADD_EMPLOYEE_STRING = "Add Employee to ";

    private Project project;

    private ArrayList<Employee> projectMembers;
    private ArrayList<ViewProjectMemberListItemPanel> panelMembers;

    private ArrayList<Employee> unassignedEmployees;
    private ArrayList<ManageProjectAddEmployeeListItemPanel> panelUnassigned;

    private ViewProjectController() {
        mainFrame = MainFrame.getInstance();

        project = null;
        projectMembers = new ArrayList<>();
        panelMembers = new ArrayList<>();

        unassignedEmployees = new ArrayList<>();
        panelUnassigned = new ArrayList<>();
    }

    public static ViewProjectController getInstance() {
        return ViewProjectController.viewProjectController;
    }

    @Override
    public void addListeners() {
        int len = projectMembers.size();

        for (int i = 0; i < len; i++) {
            int index = i;
            JLabel labelName = panelMembers.get(index).getLabelName();
            JLabel labelRemove = panelMembers.get(index).getLabelRemove();
            Employee employee = projectMembers.get(index);

            labelName.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    ViewEmployeeController.getInstance().setViewID(employee.getEmpID());
                    ViewEmployeeController.getInstance().showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelName.setForeground(new Color(231, 28, 35));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelName.setForeground(new Color(51, 51, 51));
                }

            });

            labelRemove.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        employee.setProjectToNull();

                        Date dateNow = new SimpleDateFormat("yyyy/MM/dd").parse(CalendarModel.getInstance().getYearToday() + "/" + CalendarModel.getInstance().getMonthToday() + "/" + CalendarModel.getInstance().getDayToday());

                        DateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        Date timeNow = new Date();
                        timeFormat.format(timeNow);

                        EmployeeDetailsAuditTrail audit = new EmployeeDetailsAuditTrail(employee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_PROJECT, project.getName(), "No Project", dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                        audit.addAuditTrail();

                    } catch (SQLException s) {
                        s.printStackTrace();
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewProjectController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove Icon Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelRemove.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove Icon.png")));
                }

            });
        }

        len = unassignedEmployees.size();
        for (int i = 0; i < len; i++) {
            int index = i;
            JLabel labelName = panelUnassigned.get(index).getLabelName();
            JLabel labelAdd = panelUnassigned.get(index).getLabelAdd();
            Employee employee = unassignedEmployees.get(index);

            labelName.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    ViewEmployeeController.getInstance().setViewID(employee.getEmpID());
                    ViewEmployeeController.getInstance().showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelName.setForeground(new Color(231, 28, 35));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelName.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelName.setForeground(new Color(51, 51, 51));
                }

            });

            labelAdd.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        employee.setProject(project.getID());

                        Date dateNow = new SimpleDateFormat("yyyy/MM/dd").parse(CalendarModel.getInstance().getYearToday() + "/" + CalendarModel.getInstance().getMonthToday() + "/" + CalendarModel.getInstance().getDayToday());

                        DateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        Date timeNow = new Date();
                        timeFormat.format(timeNow);

                        EmployeeDetailsAuditTrail audit = new EmployeeDetailsAuditTrail(employee.getEmpID(), EmployeeDetailsAuditTrail.ATTRIBUTE_PROJECT, "No Project", project.getName(), dateNow, new java.sql.Time(timeNow.getTime()), NavigationController.getInstance().getAdmin().getId());
                        audit.addAuditTrail();
                    } catch (SQLException s) {
                        s.printStackTrace();
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewProjectController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Icon Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelAdd.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    labelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Icon.png")));
                }

            });

        }

    }

    @Override
    public void showPanel() {
        CardLayout cardLayout = (CardLayout) mainFrame.getMainPanelCardPanel().getLayout();
        cardLayout.show(mainFrame.getMainPanelCardPanel(), PANEL_NAME);

        mainFrame.getLabelViewProjectName().setText(project.getName());
        mainFrame.getLabelViewProjectAddEmployee().setText(ADD_EMPLOYEE_STRING + project.getName());

        String[] presetDateStarted = project.getDateStarted().toString().split(" ");
        String[] presetDateDue = project.getDateDue().toString().split(" ");
        mainFrame.getLabelViewProjectDuration().setText(monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateStarted[1])) + " " + presetDateStarted[2] + ", " + presetDateStarted[5] + " - " + monthToString(CalendarModel.getInstance().getEquivalentMonth(presetDateDue[1])) + " " + presetDateDue[2] + ", " + presetDateDue[5]);

        refreshEmployeeList();
        refreshUnassignedEmployeeList();

        addListeners();
    }

    private void refreshEmployeeList() {
        panelMembers = new ArrayList<>();

        projectMembers = Employee.getEmployeeByProject(project.getID());
        int len = projectMembers.size();
        mainFrame.getPanelViewProjectMembersContainer().removeAll();
        GridLayout layout = (GridLayout) mainFrame.getPanelViewProjectMembersContainer().getLayout();
        layout.setRows(len);
        mainFrame.getViewProjectPanel().setPreferredSize(new Dimension(mainFrame.getViewProjectPanel().getPreferredSize().width, MainFrame.SPACE_ABOVE + mainFrame.getLabelViewProjectName().getPreferredSize().height + mainFrame.getLabelViewProjectDuration().getPreferredSize().height + mainFrame.getLabelViewProjectMembers().getPreferredSize().height + ViewProjectMemberListItemPanel.PANEL_HEIGHT * (len)));

        if (!projectMembers.isEmpty()) {
            for (int i = 0; i < len; i++) {
                Employee e = projectMembers.get(i);
                ViewProjectMemberListItemPanel panel = new ViewProjectMemberListItemPanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getIdNumber()));
                panelMembers.add(panel);
                mainFrame.getPanelViewProjectMembersContainer().add(panel);
            }
        }

        mainFrame.getPanelViewProjectMembersContainer().repaint();
        mainFrame.getPanelViewProjectMembersContainer().revalidate();
    }

    public void refreshUnassignedEmployeeList() {
        panelUnassigned = new ArrayList<>();

        unassignedEmployees = Employee.getEmployeeNotInProject();
        int len = unassignedEmployees.size();
        mainFrame.getPanelViewProjectAddEmployeeContainer().removeAll();
        //GridLayout layout = (GridLayout)mainFrame.getPanelViewProjectAddEmployeeContainer().getLayout();
        //layout.setRows(len);
        mainFrame.getPanelViewProjectAddEmployeeContainer().setPreferredSize(new Dimension(ManageProjectAddEmployeeListItemPanel.PANEL_WIDTH, ManageProjectAddEmployeeListItemPanel.PANEL_HEIGHT * len));
        if (!unassignedEmployees.isEmpty()) {
            for (int i = 0; i < len; i++) {
                Employee e = unassignedEmployees.get(i);
                ManageProjectAddEmployeeListItemPanel panel = new ManageProjectAddEmployeeListItemPanel(e.getLname() + ", " + e.getFname() + " " + e.getMname());
                panelUnassigned.add(panel);
                mainFrame.getPanelViewProjectAddEmployeeContainer().add(panel);
            }
        }

        mainFrame.getPanelViewProjectAddEmployeeContainer().repaint();
        mainFrame.getPanelViewProjectAddEmployeeContainer().revalidate();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private String monthToString(int month) {
        String sMonth = "";

        switch (month) {
            case (CalendarModel.NJANUARY):
                sMonth = CalendarModel.SJANUARY;
                break;
            case (CalendarModel.NFEBRUARY):
                sMonth = CalendarModel.SFEBRUARY;
                break;
            case (CalendarModel.NMARCH):
                sMonth = CalendarModel.SMARCH;
                break;
            case (CalendarModel.NAPRIL):
                sMonth = CalendarModel.SAPRIL;
                break;
            case (CalendarModel.NMAY):
                sMonth = CalendarModel.SMAY;
                break;
            case (CalendarModel.NJUNE):
                sMonth = CalendarModel.SJUNE;
                break;
            case (CalendarModel.NJULY):
                sMonth = CalendarModel.SJULY;
                break;
            case (CalendarModel.NAUGUST):
                sMonth = CalendarModel.SAUGUST;
                break;
            case (CalendarModel.NSEPTEMBER):
                sMonth = CalendarModel.SSEPTEMBER;
                break;
            case (CalendarModel.NOCTOBER):
                sMonth = CalendarModel.SOCTOBER;
                break;
            case (CalendarModel.NNOVEMBER):
                sMonth = CalendarModel.SNOVEMBER;
                break;
            case (CalendarModel.NDECEMBER):
                sMonth = CalendarModel.SDECEMBER;
                break;
        }

        return sMonth;
    }

}
