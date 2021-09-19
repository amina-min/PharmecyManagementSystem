/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.customer;

import dmg.drug.*;
import dmg.company.*;
  import java.util.List;

/**
 *
 * @author b
 */
public interface CustomerDao {   
    Customer getCustomer(int id) ;
    void addCustomer(Customer drug);
    void deleteCustomer(int id);
    void updateCustomer(Drug drug); 
    public List<Customer> getCustomerList(String q);     
}
