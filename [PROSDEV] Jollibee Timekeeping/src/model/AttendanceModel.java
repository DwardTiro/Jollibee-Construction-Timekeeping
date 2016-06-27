package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AttendanceModel {
    private final int month;
    private final int day;
    private final int year;
    private final float timeIn;
    private final float timeOut;
    
    public AttendanceModel(int month, int day, int year, float timeIn, float timeOut){
        this.month = month;
        this.day = day;
        this.year = year;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public float getTimeIn() {
        return timeIn;
    }

    public float getTimeOut() {
        return timeOut;
    }
    
    
    public static void saveAttendance(int id, Date date,Date time_in,Date time_out) throws SQLException{
        
        String mysqlstring= "INSERT INTO attendance (`emp_id`, `date`, `time_in`, `time_out`) "
                + "VALUES (?,?,?,?)";
        System.out.println(mysqlstring);
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ps.setInt(1, id);
        
        ps.setDate(2, new java.sql.Date( date.getTime()));
        ps.setTime(3, new java.sql.Time( time_in.getTime()));
        ps.setTime(4,new java.sql.Time( time_out.getTime()));
        ps.executeUpdate();
        
    }
    
    
}
