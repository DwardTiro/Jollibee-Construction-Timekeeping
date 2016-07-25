package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDetailsAuditTrail {

    public static final String ATTRIBUTE_FIRST_NAME = "First Name";
    public static final String ATTRIBUTE_LAST_NAME = "Last Name";
    public static final String ATTRIBUTE_MIDDLE_NAME = "Middle Name";
    public static final String ATTRIBUTE_SALARY = "Salary";
    public static final String ATTRIBUTE_PROJECT = "Project";
    
    private int auditTrailID;
    private final int empID;
    private final String attribute;
    private final String oldValue;
    private final String newValue;
    private final Date date;
    private final Time time;
    private final int adminID;

    public EmployeeDetailsAuditTrail(int empID, String attribute, String oldValue, String newValue, Date date, Time time, int adminID) {
        this.empID = empID;
        this.attribute = attribute;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.date = date;
        this.time = time;
        this.adminID = adminID;
    }
    
    public EmployeeDetailsAuditTrail(int auditTrailID, int empID, String attribute, String oldValue, String newValue, Date date, Time time, int adminID) {
        this.auditTrailID = auditTrailID;
        this.empID = empID;
        this.attribute = attribute;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.date = date;
        this.time = time;
        this.adminID = adminID;
    }

    public int getAuditTrailID() {
        return auditTrailID;
    }

    public int getEmpID() {
        return empID;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getAdminID() {
        return adminID;
    }

    public static ArrayList<EmployeeDetailsAuditTrail> getEmployeeDetailsAuditTrailOfEmployee(int empID){
        ArrayList<EmployeeDetailsAuditTrail> auditTrails = new ArrayList<>();
        
        String mysqlString = "select * from employee_details_audit_trail where emp_id = ? order by `date`, `time` desc";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);

            ps.setInt(1, empID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                auditTrails.add(new EmployeeDetailsAuditTrail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getTime(7), rs.getInt(8)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return auditTrails;
    }
    
    public void addAuditTrail() {

        try {
            String mysqlString = "INSERT INTO employee_details_audit_trail \n"
                    + "(emp_id, attribute, old_value, new_value, `date`, `time`, admin_id) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
            ps.setInt(1, empID);
            ps.setString(2, attribute);
            ps.setString(3, oldValue);
            ps.setString(4, newValue);
            ps.setDate(5, new java.sql.Date(date.getTime()));
            ps.setTime(6, time);
            ps.setInt(7, adminID);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsAuditTrail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
