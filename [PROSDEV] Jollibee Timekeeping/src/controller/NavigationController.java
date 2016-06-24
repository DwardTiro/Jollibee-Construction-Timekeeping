
package controller;

public class NavigationController implements Listen{

    private static final NavigationController navigationController = new NavigationController();
    
    private final LoginController loginController = LoginController.getInstance();
    private final HeaderController headerController = HeaderController.getInstance();
    private final WelcomeController welcomeController = WelcomeController.getInstance();
    private final AddEmployeeController addEmployeeController = AddEmployeeController.getInstance();
    private final EditEmployeeController editEmployeeController = EditEmployeeController.getInstance();
    private final ViewEmployeeController viewEmployeeController = ViewEmployeeController.getInstance();
    
    private NavigationController(){
        addListeners();
    }
    
    public static NavigationController getInstance(){
        return NavigationController.navigationController;
    }
    
    @Override
    public final void addListeners() {
        
    }
    
}
