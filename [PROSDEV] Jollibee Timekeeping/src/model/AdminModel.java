package model;

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
    
}
