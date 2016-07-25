package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttendanceAuditTrail {

    public static final String ATTRIBUTE_TIME_IN = "Time In";
    public static final String ATTRIBUTE_TIME_OUT = "Time Out";
    public static final String ATTRIBUTE_LEAVE = "Leave";

    public static final String LEAVE_ON_LEAVE = "On Leave";
    public static final String LEAVE_NOT_ON_LEAVE = "Not on Leave";

    private int auditTrailID;
    private final int empID;
    private final int attendanceEntryNum;
    private final String attribute;
    private final String oldValue;
    private final String newValue;
    private final Date date;
    private final Time time;
    private final int adminID;

    public AttendanceAuditTrail(int empID, int attendanceEntryNum, String attribute, String oldValue, String newValue, Date date, Time time, int adminID) {
        this.empID = empID;
        this.attendanceEntryNum = attendanceEntryNum;
        this.attribute = attribute;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.date = date;
        this.time = time;
        this.adminID = adminID;
    }

    public AttendanceAuditTrail(int auditTrailID, int empID, int attendanceEntryNum, String attribute, String oldValue, String newValue, Date date, Time time, int adminID) {
        this.auditTrailID = auditTrailID;
        this.empID = empID;
        this.attendanceEntryNum = attendanceEntryNum;
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

    public int getAttendanceEntryNum() {
        return attendanceEntryNum;
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

    public static ArrayList<AttendanceAuditTrail> getAttendanceAuditTrailOfEmployee(int empID, Date date) {
        ArrayList<AttendanceAuditTrail> auditTrails = new ArrayList<>();

        String mysqlString = "SELECT T.attendance_audit_trail_id, T.emp_id, T.attendance_entry_num, T.attribute, T.old_value, T.new_value, T.`date`, T.`time`, T.admin_id, A.`date`\n"
                + "FROM attendance_audit_trail T join attendance A on T.attendance_entry_num = A.entry_num \n"
                + "WHERE T.emp_id = ? and A.`date` = ?\n"
                + "ORDER BY T.`date`, T.`time` desc";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);

            ps.setInt(1, empID);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                auditTrails.add(new AttendanceAuditTrail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getTime(8), rs.getInt(9)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auditTrails;
    }

    public void addAuditTrail() {

        try {
            String mysqlString = "INSERT INTO attendance_audit_trail \n"
                    + "(emp_id, attendance_entry_num, attribute, old_value, new_value, `date`, `time`, admin_id) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
            ps.setInt(1, empID);
            ps.setInt(2, attendanceEntryNum);
            ps.setString(3, attribute);
            ps.setString(4, oldValue);
            ps.setString(5, newValue);
            ps.setDate(6, new java.sql.Date(date.getTime()));
            ps.setTime(7, time);
            ps.setInt(8, adminID);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsAuditTrail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
