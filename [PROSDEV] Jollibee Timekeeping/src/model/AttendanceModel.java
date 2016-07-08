package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AttendanceModel {

    private final int month;
    private final int day;
    private final int year;
    private final Time timeIn;
    private final Time timeOut;

    private int entry_num;
    private int emp_id;
    private double salary;
    private int paid;
    private int leave;
    private Date date;

    private static final String[] column_name = {"entry_num", "emp_id", "date",
        "time_in", "time_out", "compute_salary", "paid", "leave"};

    public AttendanceModel(int entry_num, int emp_id, Date date, Time timeIn, Time timeOut, double salary, int paid, int leave) {
        this.entry_num = entry_num;
        this.emp_id = emp_id;
        this.salary = salary;
        this.paid = paid;
        this.leave = leave;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.date = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        this.month
                = this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.year = cal.get(Calendar.YEAR);
    }

    public AttendanceModel(int month, int day, int year, Time timeIn, Time timeOut) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.entry_num = -1;
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
        System.out.println("Time in: " + time_in + ": " + "Time out: " + time_out);

            //long hours = TimeUnit.MILLISECONDS.toHours(diff);
        Double salary = getSalaryOfEmp(id) * (hour2 - hour1);

        System.out.println("Salary is :" + salary + " hour is " + (hour2 - hour1));
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ps.setInt(1, id);
        ps.setDate(2, new java.sql.Date(date.getTime()));
        ps.setTime(3, new java.sql.Time(time_in.getTime()));
        ps.setTime(4, new java.sql.Time(time_out.getTime()));
        ps.setInt(5, leave);
        ps.setDouble(6, salary);
        ps.executeUpdate();

    }

    public static double getSalaryOfEmp(int id) throws SQLException {
        double cSalary;
        PreparedStatement ps = DbConnection.getConnection().prepareStatement("select id,salary from employee where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        cSalary = rs.getDouble(2);

        return cSalary;
    }

    public static ArrayList<AttendanceModel> getUnpaid() throws SQLException {
        ArrayList<AttendanceModel> list = new ArrayList<>();
        String query = "select entry_num, emp_id,`date`, time_in, time_out, compute_salary\n"
                + "paid,`leave` from attendance where paid = 0";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        // private final String[] column_name = { "entry_num", "emp_id","date",
        // "time_in", "time_out", "compute_salary" ,"paid","leave"};

        while (rs.next()) {
            list.add(new AttendanceModel(rs.getInt(column_name[0]), rs.getInt(column_name[1]),
                    rs.getDate(column_name[2]), rs.getTime(column_name[3]), rs.getTime(column_name[4]),
                    rs.getDouble(column_name[5]), rs.getInt(column_name[6]), rs.getInt(column_name[7])));
        }

        return list;
    }

    public void setPaid() throws SQLException {

        String sql = "UPDATE `attendance` SET `paid`='1' WHERE `entry_num`= ?";
        PreparedStatement ps = DbConnection.getConnection().prepareCall(sql);
        ps.setInt(1, this.entry_num);
        ps.executeUpdate();

    }

    public static boolean isPaid(int emp_id, int month, int day, int year) throws SQLException {
        
        boolean isPaid = false;
        
        String sql = "select emp_id, paid from attendance\n"
                + "where emp_id = ? \n"
                + "and month(date) = ? \n"
                + "and day(date) = ? \n"
                + "and year(date)= ? ";

        PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, emp_id);
        ps.setInt(2,month);
        ps.setInt(3,day);
        ps.setInt(4,year);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            if(rs.getInt("paid") != 0){
                isPaid = true;
            }
        }
        return isPaid;
    }

}
