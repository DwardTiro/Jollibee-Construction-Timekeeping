package controller;

import gui.CalendarDatePanel;
import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.AttendanceModel;
import model.CalendarModel;
import model.DbConnection;
import model.Employee;

public class ViewEmployeeController implements Listen, PanelChanger {

    private static final ViewEmployeeController viewEmployeeController = new ViewEmployeeController();
    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;

    private final String SQL_GET_ATTENDANCE = "SELECT * FROM attendance where Month(date) = Month(?) and Year(date) = Year(?) and emp_id = ? order by date";
    private final String SQL_DATE_ATTRIBUTE = "date";
    private final String SQL_TIMEIN_ATTRIBUTE = "time_in";
    private final String SQL_TIMEOUT_ATTRIBUTE = "time_out";
    private final String PANEL_NAME = "viewEmployeePanel";

    private JPanel viewCalendar[];
    private final int CALENDAR_ROWS = 6;
    private final int CALENDAR_COLS = 7;
    private ArrayList<AttendanceModel> attendance;
    private final CalendarModel calendarModel;
    private Employee employee;
    private Employee employeeToShow;
    private int viewID;

    private ViewEmployeeController() {
        mainFrame = MainFrame.getInstance();
        calendarModel = CalendarModel.getInstance();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout = (CardLayout) mainCardPanel.getLayout();
        attendance = new ArrayList<>();
        addListeners();
    }

    public static ViewEmployeeController getInstance() {
        return ViewEmployeeController.viewEmployeeController;
    }

    @Override
    public final void addListeners() {
        mainFrame.getLabelViewEmployeeNextMonth().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToNextMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png")));
            }
        });

        mainFrame.getLabelViewEmployeePreviousMonth().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToPreviousMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                mainFrame.getLabelViewEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png")));
            }
        });

        mainFrame.getEditEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditEmployeeController.getInstance().setViewID(viewID);
                EditEmployeeController.getInstance().showPanel();
            }

        });
    }

    public int getID() {
        return this.viewID;
    }

    public void setViewID(int id) {
        this.viewID = id;
    }

    @Override
    public void showPanel() {
        try {
            employeeToShow = Employee.getEmployeeByID(viewID);
            mainFrame.getLabelViewEmployeeName().setText(employeeToShow.toString());
            mainFrame.getLabelViewEmployeeID().setText(employeeToShow.getIdNumber() + "");
            //employee = Employee.getEmployeeByID(this.getID());
            //mainFrame.getLabelViewEmployeeSalary().setText("Computed salary is: " + employee.computeSalary());
            mainLayout.show(mainCardPanel, PANEL_NAME);
            calendarModel.restartCalendar();
            buildCalendar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ViewoEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // sample only
    public void buildCalendar() {

        try {
            employee = Employee.getEmployeeByID(this.getID());
            mainFrame.getLabelViewEmployeeSalary().setText("Computed salary is: " + employee.computeSalaryMonth(calendarModel.getMonth(), calendarModel.getYear()));
        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewCalendar = new JPanel[CALENDAR_ROWS * CALENDAR_COLS];

        mainFrame.getPanelViewEmployeeCalendar().removeAll();

        mainFrame.getLabelViewEmployeeMonthYear().setText(monthToString(calendarModel.getMonth()) + " " + calendarModel.getYear());

        attendance = new ArrayList<>();

        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQL_GET_ATTENDANCE);

            String dateString = calendarModel.getYear() + "-" + calendarModel.getMonth() + "-01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setInt(3, employeeToShow.getEmpID());

            System.out.println(stmt.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Date d = rs.getDate(SQL_DATE_ATTRIBUTE);
                Time tIn = rs.getTime(SQL_TIMEIN_ATTRIBUTE);
                Time tOut = rs.getTime(SQL_TIMEOUT_ATTRIBUTE);

                String[] dArray = sdf.format(d).split("-");
                attendance.add(new AttendanceModel(Integer.parseInt(dArray[1]), Integer.parseInt(dArray[2]), Integer.parseInt(dArray[0]), tIn, tOut));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        JPanel temp;

        for (int i = 0; i < calendarModel.getFirstDay(); i++) {
            temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }

        int curIndex = 0;
        for (int i = 0; i < calendarModel.getMaxDays(); i++) {
            String projectName = "";
            int status = 0;

            if (curIndex < attendance.size() && attendance.get(curIndex).getDay() == i + 1) {
                long timediff = attendance.get(curIndex).getTimeOut().getTime() - attendance.get(curIndex).getTimeIn().getTime();
                System.out.println("hello " + attendance.get(curIndex).getTimeIn() + " " + attendance.get(curIndex).getTimeOut() + " " + timediff + " " + CalendarDatePanel.EIGHT_HOURS_MILLISEC);
                // undertime
                if (timediff < CalendarDatePanel.EIGHT_HOURS_MILLISEC) {
                    status = CalendarDatePanel.ATTENDANCE_STATUS_UNDERTIME;
                } // overtime
                else if (timediff >= CalendarDatePanel.EIGHT_HOURS_MILLISEC + CalendarDatePanel.ONE_HOUR_MILLISEC) {
                    status = CalendarDatePanel.ATTENDANCE_STATUS_OVERTIME;
                } // complete
                else if (timediff >= CalendarDatePanel.EIGHT_HOURS_MILLISEC && timediff < CalendarDatePanel.EIGHT_HOURS_MILLISEC + CalendarDatePanel.ONE_HOUR_MILLISEC) {
                    status = CalendarDatePanel.ATTENDANCE_STATUS_COMPLETE;
                }
                System.out.println("STATUS " + status);
                curIndex++;
            }

            try {
                temp = new CalendarDatePanel(this.viewID, i + 1, calendarModel.getMonth(), calendarModel.getYear(), projectName, status);

                temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
                viewCalendar[i] = temp;
                mainFrame.getPanelViewEmployeeCalendar().add(temp);
            } catch (SQLException ex) {
                Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = calendarModel.getMaxDays() + calendarModel.getFirstDay(); i < CALENDAR_ROWS * CALENDAR_COLS; i++) {
            temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelViewEmployeeCalendar().add(temp);
        }
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
