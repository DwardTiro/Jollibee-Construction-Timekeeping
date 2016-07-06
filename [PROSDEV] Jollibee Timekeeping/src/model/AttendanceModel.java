package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class AttendanceModel {

    private final int month;
    private final int day;
    private final int year;
    private final Time timeIn;
    private final Time timeOut;

    public AttendanceModel(int month, int day, int year, Time timeIn, Time timeOut) {
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

    public Time getTimeIn() {
        return timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public static void saveAttendance(int id, Date date, Date time_in, Date time_out, int leave) throws SQLException {
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(time_in);
            int hour1 = cal.get(Calendar.HOUR_OF_DAY);
            cal.setTime(time_out);
            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
            
            
            String mysqlstring = "INSERT INTO attendance (`emp_id`, `date`, `time_in`, `time_out`, `leave`,`compute_salary`) "
                    + "VALUES (?,?,?,?,?,?)";
            System.out.println(mysqlstring);
            System.out.println("Time in: "+time_in+": "+"Time out: "+ time_out);
            
            //long hours = TimeUnit.MILLISECONDS.toHours(diff);
      
            Double salary = getSalary(id) * (hour2-hour1);
            
            System.out.println("Salary is :"+ salary +" hour is "+ (hour2 - hour1));
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
            ps.setInt(1, id);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setTime(3, new java.sql.Time(time_in.getTime()));
            ps.setTime(4, new java.sql.Time(time_out.getTime()));
            ps.setInt(5, leave);
            ps.setDouble(6,salary);
            ps.executeUpdate();
            
    }

    public static double getSalary(int id) throws SQLException {
        double cSalary;
        PreparedStatement ps = DbConnection.getConnection().prepareStatement("select id,salary from employee where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        cSalary = rs.getDouble(2);
        
        return cSalary;
    }

}
