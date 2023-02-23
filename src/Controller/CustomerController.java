package Controller;

import Model.Customer;
import java.sql.ResultSet;


public class CustomerController {
        
    
    public boolean register(String firstName, String lastName, String streetAddress, String city, String email, int telephone, String username, String password)
    {
        Customer customer = new Customer();
        return customer.register(firstName,lastName,streetAddress,city,email,telephone,username,password);
        
    }
    
    public Customer getCustomerDetails(int customerId){
        Customer customer = new Customer();
        return customer.getCustomerDetails(customerId);
    }
    
    public boolean updateCustomer(int customerId, String firstName, String lastName, String streetAddress, String city, String email, int telephone){
        Customer customer = new Customer();
        return customer.updateCustomerInformation(customerId, firstName, lastName, streetAddress, city, email, telephone);
    }
    
    
}
