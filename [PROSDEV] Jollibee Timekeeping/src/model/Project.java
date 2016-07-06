package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
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
    
    // gets projects that are not yet due
    public static ArrayList<Project> getProjectList(){
        ArrayList<Project> projectList = new ArrayList<>();
        String mysqlstring = "SELECT * FROM project where DATEDIFF(dateDue, ?) >= 0 order by projectName";
        
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlstring);
            
            String dateString = String.valueOf(CalendarModel.getInstance().getYearToday()) + "-" + String.valueOf(CalendarModel.getInstance().getMonthToday()) + "-" +String.valueOf(CalendarModel.getInstance().getDayToday());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dateString);
            ps.setDate(1, new Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                projectList.add(new Project(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException | ParseException ex) {
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