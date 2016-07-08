/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jet
 */
public class EntryPayroll {
    
    private int entry_id;
    private int attendance;
    private int employee;
    
    private static final String TABLE_NAME = "payroll_entry";
    
    public EntryPayroll(int entry_id, int attendance, int employee){
        this.entry_id= entry_id;
        this.attendance = attendance;
        this.employee = employee;
    }
    
    
    public EntryPayroll(int attendance, int employee){
        this.entry_id = -1;
        this.attendance = attendance;
        this.employee= employee;
    }
    
    public void save() throws SQLException{
        String sql = "INSERT INTO `payroll_entry` (`payroll_id`, `attendance_id`) VALUES (?, ?);";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,this.attendance);
        ps.setInt(2,this.employee);
        ps.executeUpdate();
    }
    
    
}
