package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static ArrayList<Project> getProjectList(){
        ArrayList<Project> projectList = new ArrayList<>();
        String mysqlstring = "SELECT * FROM project order by projectName";
        
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                projectList.add(new Project(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
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