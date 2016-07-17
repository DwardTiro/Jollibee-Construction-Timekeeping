package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
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
