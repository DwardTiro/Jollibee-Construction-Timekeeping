package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminModel {
    
    private final int id;
    private final String name;
    private final String username;
    private final String password;
    private final String userType;

    public AdminModel(int id, String name, String username, String password, String userType){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    
    public static String getAdminNameByID(int id){
        String name = "";
        try {
            String mysqlString = "select `name` from admin where id = ?";
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(mysqlString);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                name = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
}
