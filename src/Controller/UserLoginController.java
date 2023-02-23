package Controller;

import Model.Customer;
import Model.UserLoginCredentials;

public class UserLoginController {
    
    public String login(String username, String password)
    {
        UserLoginCredentials user = new UserLoginCredentials();
        return user.login(username, password);
    }
    
    public int getCustomerId(String username, String password){
        UserLoginCredentials customer = new UserLoginCredentials();
        return customer.getCustomerId(username, password);
    }
}
