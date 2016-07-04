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
 * @author owner
 */
public class Project {
    private final int id;
    private final String name;
    
    public Project(int id,String name){
        this.id= id;
        this.name = name;
    }
   
    public int getID(){
       return this.id; 
    }
    
    public String getName(){
        return this.name;
    }
    
    public static ArrayList<Project> getProjectList() throws SQLException{
        ArrayList<Project> projectList = new ArrayList<>();
        String mysqlstring= "SELECT proj_id, proj_name FROM project WHERE 1";
        PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
           
            projectList.add(new Project(rs.getInt(1), rs.getString(2)));
        }
        
        if(projectList.size() >=0){
            return projectList;
        }
        else return null;
    }
    public static void updateDB(int id){
        String mysqlstring = "UPDATE '' SET 'proj_id'";
    }
}