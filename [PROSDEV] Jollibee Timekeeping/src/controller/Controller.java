package controller;

import gui.CalendarDatePanel;
import gui.MainFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.AttendanceModel;
import model.CalendarModel;
import model.DbConnection;

public class Controller {
    
    private final String USERNAME_FIELD_DEFAULT = "Username";
    private final String PASSWORD_FIELD_DEFAULT = "Password";
    private final String SEARCH_FIELD_DEFAULT = "Search";
    
    private final String CARD_LOGIN = "panelLogin";
    private final String CARD_MAIN = "panelMain";
    private final String HOME_PAGE = "add_time";
    
    private JPanel viewCalendar[];
    private final int CALENDAR_ROWS = 6;
    private final int CALENDAR_COLS = 7;
    private ArrayList<AttendanceModel> attendance;
    
    private static final Controller controller = new Controller();
    
    private final MainFrame mainFrame;
    private final CalendarModel calendarModel;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;
    
    private Controller(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        
        calendarModel = CalendarModel.getInstance();
        
        addListeners();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout =(CardLayout) mainCardPanel.getLayout();
        
        attendance = new ArrayList<>();
        
        buildCalendar();
    }
    
    public static Controller getInstance(){
        return controller;
    }
    
    private void addListeners(){
        // login panel listeners
        addPanelLoginListeners();
        addMainPanelHeaderListeners();
        addShowEmployeePanelListeners();
        addAddEmployeePanelListeners();
        addEditEmployeePanelListeners();
        addViewEmployeePanelListeners();
    }
    
    private void addPanelLoginListeners(){
        
        mainFrame.getLoginTextFieldUsername().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase("")){
                    mainFrame.getLoginTextFieldUsername().setText(USERNAME_FIELD_DEFAULT);
                }
            }
            
        });
        
        mainFrame.getLoginTextFieldUsername().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        
        mainFrame.getLoginTextFieldUsername().addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                if(mainFrame.getLoginTextFieldUsername().getText().equalsIgnoreCase(USERNAME_FIELD_DEFAULT)){
                    mainFrame.getLoginTextFieldUsername().setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        mainFrame.getLoginPasswordFieldPassword().addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if(String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()).equalsIgnoreCase(PASSWORD_FIELD_DEFAULT)){
                    mainFrame.getLoginPasswordFieldPassword().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {}
            
        });
        
        mainFrame.getLoginButtonLogin().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                //if(tryLogin(mainFrame.getLoginTextFieldUsername().getText(), String.copyValueOf(mainFrame.getLoginPasswordFieldPassword().getPassword()))){
                    CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
                    cardLayout.show(mainFrame.getContentPane(), CARD_MAIN);
                //    showHomePage();
                //}
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
    }
    
    private void addMainPanelHeaderListeners(){
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
        
        mainFrame.getMainLabelLogout().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                logout();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    private void addShowEmployeePanelListeners(){
        
    }
    
    private void addAddEmployeePanelListeners(){
        mainFrame.getButtonAddEmployee().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!mainFrame.getTextFieldAddEmployeeIDNumber().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeLastName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeFirstName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeMiddleName().getText().isEmpty() &&
                   !mainFrame.getTextFieldAddEmployeeSalary().getText().isEmpty()){
                    
                    if(tryAddEmployee(Integer.parseInt(mainFrame.getTextFieldAddEmployeeIDNumber().getText()),
                            mainFrame.getTextFieldAddEmployeeLastName().getText(),
                            mainFrame.getTextFieldAddEmployeeFirstName().getText(),
                            mainFrame.getTextFieldAddEmployeeMiddleName().getText(),
                            Float.parseFloat(mainFrame.getTextFieldAddEmployeeSalary().toString()))){
                        // success: notify user
                    } else{
                        // failure: notify user
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
    }
    
    private void addEditEmployeePanelListeners(){
        mainFrame.getButtonEditEmployeeSaveChanges().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!mainFrame.getTextFieldEditEmployeeIDNumber().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeLastName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeFirstName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeMiddleName().getText().isEmpty() &&
                   !mainFrame.getTextFieldEditEmployeeSalary().getText().isEmpty()){
                    
                    if(tryEditEmployee(Integer.parseInt(mainFrame.getTextFieldEditEmployeeIDNumber().getText()),
                            mainFrame.getTextFieldEditEmployeeLastName().getText(),
                            mainFrame.getTextFieldEditEmployeeFirstName().getText(),
                            mainFrame.getTextFieldEditEmployeeMiddleName().getText(),
                            Float.parseFloat(mainFrame.getTextFieldEditEmployeeSalary().toString()))){
                        // success: notify user
                    } else{
                        // failure: notify user
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    private void addViewEmployeePanelListeners(){
        mainFrame.getLabelShowEmployeeNextMonth().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToNextMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getLabelShowEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getLabelShowEmployeeNextMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Right.png")));
            }
        });
        
        mainFrame.getLabelShowEmployeePreviousMonth().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                calendarModel.moveToPreviousMonth();
                buildCalendar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.getLabelShowEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left Hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.getLabelShowEmployeePreviousMonth().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow Left.png")));
            }
        });
    }
    
    // sample only
    private void buildCalendar(){
        viewCalendar = new JPanel[CALENDAR_ROWS * CALENDAR_COLS];
        
        mainFrame.getPanelShowEmployeeCalendar().removeAll();
        
        mainFrame.getLabelShowEmployeeMonthYear().setText(monthToString(calendarModel.getMonth()) + " " + calendarModel.getYear());
        
        // fill attendance arraylist here
        
        for(int i = 0; i < calendarModel.getFirstDay(); i++){
            JPanel temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelShowEmployeeCalendar().add(temp);
        }
        for(int i = 0; i < calendarModel.getMaxDays(); i++){
            JPanel temp = new CalendarDatePanel(i + 1, "project", CalendarDatePanel.ATTENDANCE_STATUS_COMPLETE);
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            viewCalendar[i] = temp;
            mainFrame.getPanelShowEmployeeCalendar().add(temp);
        }
        for(int i = calendarModel.getMaxDays() + calendarModel.getFirstDay(); i < CALENDAR_ROWS * CALENDAR_COLS; i++){
            JPanel temp = new JPanel();
            temp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(224, 224, 224)));
            temp.setBackground(Color.WHITE);
            mainFrame.getPanelShowEmployeeCalendar().add(temp);
        }
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
    
    // returns true if login is successful (username and password is correct), false otherwise
    private boolean tryLogin(String username, String password){
        boolean login = false;
        ResultSet rs = null;
        String query = "select id,password from admin where username = '"+  username+"'\n"+
                "and password = '"+password+"'";
        System.out.println("Im here!!");
        try {
            Statement s = DbConnection.con.createStatement();
            System.out.println(query);
            s.executeQuery(query);
            
            rs = s.getResultSet();
            
            if(rs.next()){
                login= true;
                System.out.println("Success Login");
                
            }else{
                System.out.println("Failed to log in");
            }
            // backend logic here
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return login;
    }
    
    // returns true if successful in adding employee, false if there is a similar IDNumber in database
    private boolean tryAddEmployee(int IDNumber, String lastName, String firstName, String middleName, float salary){
        boolean tryAdd = false;
        
        // logic here
        
        return tryAdd;
    }
    
    // returns true if successful in editing employee, false if there is a similar IDNumber in database
    private boolean tryEditEmployee(int IDNumber, String lastName, String firstName, String middleName, float salary){
        boolean tryEdit = false;
        
        // logic here
        
        return tryEdit;
    }
    
    private void logout(){
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), CARD_LOGIN);
    }
    
    private void showHomePage(){
        System.out.println("Here!!! :D");
        mainLayout.show(mainCardPanel,HOME_PAGE);
    }
}
