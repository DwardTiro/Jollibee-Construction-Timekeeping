/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jet
 */
public class DbConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String SCHEMA = "timekeep";
    
    public static Connection con = null;
    
    public static Connection getConnection(){
        
        if(DbConnection.con == null){
            DbConnection.con = getConnectionInstance(USERNAME, PASSWORD, SCHEMA);
        }
        return DbConnection.con;
    }
    
    private static Connection getConnectionInstance(String user, String password, String schema){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + schema, user, password);   
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            System.out.println("  > " + schema + "\n");
        } else {
            System.out.println("Failed to make connection!");
            System.out.println("  > " + schema + "\n");
        }
        
        return connection;
    }    
}
