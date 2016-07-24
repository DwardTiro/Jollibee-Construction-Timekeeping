package model;

import java.sql.Time;
import java.util.Date;

public class AttendanceAuditTrail {
    private final int auditTrailID;
    private final int empID;
    private final int attendanceEntryNum;
    private final String attribute;
    private final Time oldValue;
    private final Time newValue;
    private final Date date;
    private final Time time;
    private final int adminID;
    
    public AttendanceAuditTrail(int auditTrailID, int empID, int attendanceEntryNum, String attribute, Time oldValue, Time newValue, Date date, Time time, int adminID){
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

    public Time getOldValue() {
        return oldValue;
    }

    public Time getNewValue() {
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
    
}
