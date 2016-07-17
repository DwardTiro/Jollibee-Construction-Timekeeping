package model;

import java.sql.Time;
import java.util.Date;

public class AttendanceAuditTrail {
    private final int auditTrailID;
    private final int empID;
    private final int attendanceEntryNum;
    private final Time oldTimeIn;
    private final Time newTimeIn;
    private final Time oldTimeOut;
    private final Time newTimeOut;
    private final Date date;
    private final Time time;
    private final int adminID;
    
    public AttendanceAuditTrail(int auditTrailID, int empID, int attendanceEntryNum, Time oldTimeIn, Time newTimeIn, Time oldTimeOut, Time newTimeOut, Date date, Time time, int adminID){
        this.auditTrailID = auditTrailID;
        this.empID = empID;
        this.attendanceEntryNum = attendanceEntryNum;
        this.oldTimeIn = oldTimeIn;
        this.newTimeIn = newTimeIn;
        this.oldTimeOut = oldTimeOut;
        this.newTimeOut = newTimeOut;
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

    public Time getOldTimeIn() {
        return oldTimeIn;
    }

    public Time getNewTimeIn() {
        return newTimeIn;
    }

    public Time getOldTimeOut() {
        return oldTimeOut;
    }

    public Time getNewTimeOut() {
        return newTimeOut;
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
