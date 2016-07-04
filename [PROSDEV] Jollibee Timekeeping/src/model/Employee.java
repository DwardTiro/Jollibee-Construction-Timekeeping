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

/**
 *
 * @author Jet
 */
public class Employee {
    
    private final int id;
    private final String fname;
    private final String lname;
    private final String mname;
    private final double salary;
    
    public Employee(int id,String fname, String lname, String mname, double salary){
        this.id= id;
        this.fname= fname;
        this.lname= lname;
        this.mname= mname;
        this.salary = salary;
    }
    
    public void updateProject(int proj_id) throws SQLException{
        String mysqlstring="UPDATE `employee` SET `project_id` =? WHERE `id` = ?";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ps.setInt(1, proj_id);
        ps.setInt(2, this.getID());
        ps.executeUpdate();
    }
    
    public double computeSalary() throws SQLException{
        double cSalary = 0;
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getEmployeeHoursStatement());
        ps.setInt(1, this.id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            cSalary = cSalary + (this.salary * rs.getInt(1));
            System.out.println(cSalary);
        }
        
        return cSalary;
    }
    
    public static void addDB(int IDNumber,String firstName,String lastName,String middleName,double salary) throws SQLException{
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getAddEmployeeStatement());
                ps.setInt(1, IDNumber);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4,middleName);
                ps.setDouble(5, salary);
                ps.executeUpdate();
    }
    
    public static ArrayList<Employee> searchDB(String searchString) throws SQLException{
        ArrayList<Employee> empList = new ArrayList<>();
        searchString = "%"+searchString+"%";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(Employee.getSearchStatement());
        ps.setString(1, searchString);
        ps.setString(2, searchString);
        ps.setString(3, searchString);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            empList.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }
        
        if(empList.size() >=0){
            return empList;
        }else return null;
    }
    
    public static void editEmployee(int IDNumber,String firstName,String lastName,String middleName,double salary) throws SQLException{
        String mysqlString ="UPDATE `employee` SET `first_name`=?, "
                + "`last_name`=?, `middle_name`=?,"
                + " `salary`=? WHERE `id`=?;";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString); 
        ps.setInt(5,IDNumber);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3,middleName);
        ps.setDouble(4, salary);
        ps.executeUpdate();
    }
    
    
    public static Employee getEmployeeByID(int id) throws SQLException{
        System.out.println("id is "+id);
        String mysqlString = "select id,first_name,last_Name,middle_name,salary\n" +
                            "from employee\n" +
                            "where id = ?";
        
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));    
    }
    
    public static String getEmployeeHoursStatement(){
        return "SELECT TIMESTAMPDIFF(HOUR, time_in, time_out)"+"\n"+
                "FROM attendance"+"\n"+
                "WHERE emp_id = ?";
    }
    
    public static String getAddEmployeeStatement(){
        return "INSERT INTO `employee` "+"\n"+
        "(`id`, `first_name`, `last_name`, `middle_name`, `salary`)" +"\n"+
        "VALUES (?,?,?,?,?);";
    }
    
    public static String getSearchStatement(){
        return "select id,first_name,last_Name,middle_name,salary"+"\n"+
                "from employee"+"\n"+
                "where first_name like ?"+"\n"+
                "or last_name like ?"+"\n"+
                "or middle_name like ?";
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getFname(){
        return this.fname;
    }
    
    public String getLname(){
        return this.lname;
    }
    
    public String getMname(){
        return this.mname;
    }
    
    public double getSalary(){
        return this.salary;
    }
    
    @Override
    public String toString(){
        return this.lname+", "+this.fname;
    }
}
