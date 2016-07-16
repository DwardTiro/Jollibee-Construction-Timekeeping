/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class Employee {

    private final int empID;
    private final int idNumber;
    private final String fname;
    private final String lname;
    private final String mname;
    private final double salary;

    private ArrayList<AttendanceModel> attendance;

    public Employee(int empID, int idNumber, String fname, String lname, String mname, double salary) {
        this.empID = empID;
        this.idNumber = idNumber;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.salary = salary;
        attendance = null;
    }

    public void setAttendance(ArrayList<AttendanceModel> list) {
        this.attendance = list;
    }

    public ArrayList<AttendanceModel> getAttendance() {
        return attendance;
    }

    public void setProjectToNull() throws SQLException {
        String mysqlstring = "UPDATE `employee` SET `project_id` = NULL WHERE `emp_id` = ?";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ps.setInt(1, this.getEmpID());
        ps.executeUpdate();
    }

    public void setProject(int proj_id) throws SQLException {
        String mysqlstring = "UPDATE `employee` SET `project_id` = ? WHERE `emp_id` = ?";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ps.setInt(1, proj_id);
        ps.setInt(2, this.getEmpID());
        ps.executeUpdate();
    }

    public double computeSalary() throws SQLException {
        double cSalary = 0;
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getEmployeeHoursStatement());
        ps.setInt(1, this.empID);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cSalary = cSalary + (this.salary * rs.getInt(1));
            System.out.println(cSalary);
        }

        return cSalary;
    }

    public double computeSalaryMonth(int month, int year) throws SQLException {
        double csalary = 0;
        String query = "select emp_id, sum(compute_salary) as total from attendance where \n"
                + "month(date) = ? \n"
                + "and year(date) = ? \n"
                + "and emp_id = ?";

        System.out.println(query);
        System.out.println(month + " " + year);

        PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
        ps.setInt(3, this.empID);
        ps.setInt(1, month);
        ps.setInt(2, year);

        ResultSet rs = ps.executeQuery();
        rs.next();

        csalary = rs.getDouble("total");

        return csalary;

    }

    public static void addDB(int IDNumber, String firstName, String lastName, String middleName, double salary) throws SQLException {
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getAddEmployeeStatement());
        ps.setInt(1, IDNumber);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setString(4, middleName);
        ps.setDouble(5, salary);
        ps.executeUpdate();
    }

    public static ArrayList<Employee> searchDB(String searchString) throws SQLException {
        ArrayList<Employee> empList = new ArrayList<>();
        searchString = "%" + searchString + "%";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getSearchStatement());
        ps.setString(1, searchString);
        ps.setString(2, searchString);
        ps.setString(3, searchString);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            empList.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
        }

        if (empList.size() >= 0) {
            return empList;
        } else {
            return null;
        }
    }

    public static void editEmployee(int IDNumber, String firstName, String lastName, String middleName, double salary) throws SQLException {
        String mysqlString = "UPDATE `employee` SET `first_name`=?, "
                + "`last_name`=?, `middle_name`=?,"
                + " `salary`=? WHERE `id_number`=?;";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
        ps.setInt(5, IDNumber);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, middleName);
        ps.setDouble(4, salary);
        ps.executeUpdate();
    }

    public static ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        String mysqlString = "select * from employee order by last_name, first_name, middle_name";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    public static ArrayList<Employee> getEmployeeByProject(int projectID) {
        ArrayList<Employee> employees = new ArrayList<>();

        String mysqlString = "select * from employee where project_id = ? order by last_name";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);

            ps.setInt(1, projectID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    public static ArrayList<Employee> getEmployeeNotInProject() {
        ArrayList<Employee> employees = new ArrayList<>();

        String mysqlString = "select * from employee where project_id is null order by last_name";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    public static Employee getEmployeeByID(int id) throws SQLException {
        System.out.println("id is " + id);
        String mysqlString = "select emp_id, id_number,first_name,last_Name,middle_name,salary\n"
                + "from employee\n"
                + "where emp_id = ?";

        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
    }

    public static String getEmployeeHoursStatement() {
        return "SELECT TIMESTAMPDIFF(HOUR, time_in, time_out)" + "\n"
                + "FROM attendance" + "\n"
                + "WHERE emp_id = ?";
    }

    public static String getAddEmployeeStatement() {
        return "INSERT INTO `employee` " + "\n"
                + "(`id_number`, `first_name`, `last_name`, `middle_name`, `salary`)" + "\n"
                + "VALUES (?,?,?,?,?);";
    }

    public static String getSearchStatement() {
        return "select emp_id,id_number,first_name,last_Name,middle_name,salary" + "\n"
                + "from employee" + "\n"
                + "where first_name like ?" + "\n"
                + "or last_name like ?" + "\n"
                + "or middle_name like ?" + "\n"
                + "order by last_name, first_name, middle_name";
    }

    @Override
    public String toString() {
        return this.lname + ", " + this.fname;
    }

    public Double getTotalSalary() {
        double cSalary = 0;
        if (attendance != null) {
            for (AttendanceModel am : attendance) {
                cSalary = cSalary + am.getSalary();
            }
        }
        return cSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public double getSalary() {
        return salary;
    }
}
