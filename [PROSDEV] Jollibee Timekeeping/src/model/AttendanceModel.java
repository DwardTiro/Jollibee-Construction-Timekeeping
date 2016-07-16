package model;

import gui.PopBox;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public double getSalary() {
        return salary;
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

    public static void editAttendance(int id, Date date, Date time_in, Date time_out, int leave, int entry_id){

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(time_in);
            int hour1 = cal.get(Calendar.HOUR_OF_DAY);
            cal.setTime(time_out);
            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
            
            String mysqlstring = "UPDATE `attendance` SET `time_in`= ?, \n"
                    + "`time_out`= ?, `compute_salary`= ?, `leave`= ? \n"
                    + "WHERE `entry_num`= ? ";
            System.out.println(mysqlstring);
            System.out.println("Time in: " + time_in + ": " + "Time out: " + time_out);
            
            //long hours = TimeUnit.MILLISECONDS.toHours(diff);
            int totalHours = (hour2 - hour1);
            int overTime = 0;
            if (totalHours > 8) {
                overTime = totalHours - 8;
                totalHours = 8;
            }
            
            Double salary = (getSalaryOfEmp(id) * totalHours) + ((getSalaryOfEmp(id) + (getSalaryOfEmp(id) * 0.25)) * overTime);
            
            System.out.println("Salary is :" + salary + " hour is " + (hour2 - hour1));
            PreparedStatement ps;
            
            ps = DbConnection.getConnection().prepareStatement(mysqlstring);
            ps.setTime(1, new java.sql.Time(time_in.getTime()));
            ps.setTime(2, new java.sql.Time(time_out.getTime()));
            ps.setDouble(3, salary);
            ps.setInt(4, leave);
            ps.setInt(5, entry_id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            PopBox.infoBox("Unable to add Attendance", "Error");
        }

    }

    public static void saveAttendance(int empID, Date date, Date time_in, Date time_out, int leave){

        try {
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
            int totalHours = (hour2 - hour1);
            int overTime = 0;
            if (totalHours > 8) {
                overTime = totalHours - 8;
                totalHours = 8;
            }
            
            Double salary = (getSalaryOfEmp(empID) * totalHours) + ((getSalaryOfEmp(empID) + (getSalaryOfEmp(empID) * 0.25)) * overTime);
            
            System.out.println("Salary is :" + salary + " hour is " + (hour2 - hour1));
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
            ps.setInt(1, empID);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setTime(3, new java.sql.Time(time_in.getTime()));
            ps.setTime(4, new java.sql.Time(time_out.getTime()));
            ps.setInt(5, leave);
            ps.setDouble(6, salary);
            ps.executeUpdate();
        } catch (SQLException ex) {
            PopBox.infoBox("Unable to add Attendance", "Error");
        }

    }

    public static double getSalaryOfEmp(int empID){
        double cSalary = -1;
        
        try {
            
            PreparedStatement ps = DbConnection.getConnection().prepareStatement("select salary from employee where emp_id = ?");
            ps.setInt(1, empID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cSalary = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cSalary;
    }

    public static ArrayList<AttendanceModel> getUnpaid(){
        ArrayList<AttendanceModel> list = new ArrayList<>();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void setPaid(){
        try {
            String sql = "UPDATE `attendance` SET `paid`='1' WHERE `entry_num`= ?";
            PreparedStatement ps = DbConnection.getConnection().prepareCall(sql);
            ps.setInt(1, this.entry_num);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int isPaid(int emp_id, int month, int day, int year){
        //-2 if paid
        //0 if not paid
        // -1 if no entry
            
        int isPaid = -1;
        
        try {
            String sql = "select emp_id,entry_num, paid from attendance\n"
                    + "where emp_id = ? \n"
                    + "and month(date) = ? \n"
                    + "and day(date) = ? \n"
                    + "and year(date)= ? ";
            
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, emp_id);
            ps.setInt(2, month);
            ps.setInt(3, day);
            ps.setInt(4, year);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                isPaid = rs.getInt(2);
                if (rs.getInt("paid") != 0) {
                    isPaid = -2;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return isPaid;
    }

    public static ArrayList<AttendanceModel> getUnpaidEmp(int id){
        ArrayList<AttendanceModel> list = new ArrayList<>();
        try {
            String sql = "select entry_num,emp_id,`date`, time_in , time_out, compute_salary, `paid`, `leave`\n"
                    + "from attendance\n"
                    + "where emp_id = ? \n"
                    + "and paid = 0";
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new AttendanceModel(rs.getInt(column_name[0]), rs.getInt(column_name[1]),
                        rs.getDate(column_name[2]), rs.getTime(column_name[3]), rs.getTime(column_name[4]),
                        rs.getDouble(column_name[5]), rs.getInt(column_name[6]), rs.getInt(column_name[7])));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void savePayRollEntry(int payroll){
        try {
            String query = "INSERT INTO `payroll_entry` (`payroll_id`, `attendance_id`) VALUES ( ? , ? );";
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, payroll);
            ps.setInt(2, this.entry_num);
            this.setPaid();
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
