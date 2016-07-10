/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class Payroll {
    
    private ArrayList<AttendanceModel> entries;
    private double salarytotal; 
    
    public Payroll(){
        salarytotal = 0;
        entries = new ArrayList<>();
    }
    
    public void setTotal(double total){
        this.salarytotal = total;
    }
    
    public double getTotal(){
        return salarytotal;
    }
    
    public void addEntry(AttendanceModel am){
        entries.add(am);
    }
    
    
    public void savePayroll() throws SQLException{
        
        String query = "INSERT INTO `payroll` (`date_now`) VALUES (Now())";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int id;
        if(rs.next()){
            id = rs.getInt(1); 
            System.out.println("HERE ID IS "+id);
            for(AttendanceModel am: entries){
                am.savePayRollEntry(id);
            }           
        }
        
    }
    
    
    public static Payroll computeSalary(ArrayList<Employee> empList){
        
        double total = 0;
        Payroll payroll = new Payroll();
        
        for(Employee e: empList){
            for(AttendanceModel am: e.getAttendance()){
                total = total + am.getSalary();
                payroll.addEntry(am);
            }
        }
        payroll.setTotal(total);
        //PreparedStatement ps = DbConnection.getConnection().prepareStatement("");
        
        return payroll;
    }
    
    
    
}
