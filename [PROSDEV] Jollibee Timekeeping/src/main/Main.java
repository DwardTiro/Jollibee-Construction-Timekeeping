
package main;

import controller.*;

public class Main {

    public static void main(String[] args) {
        LoginController.getInstance();
        HeaderController.getInstance();
        AddEmployeeController.getInstance();
        EditEmployeeController.getInstance();
        ViewEmployeeController.getInstance();
    }
    
}
