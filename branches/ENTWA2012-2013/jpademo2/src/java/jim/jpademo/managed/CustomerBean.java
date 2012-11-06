/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.jpademo.entities.Customer;
import jim.jpademo.facades.CustomerFacade;

/**
 *
 * @author BriggsJ
 */
@ManagedBean
@RequestScoped
public class CustomerBean {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @EJB
    private CustomerFacade cf;
    
    public String addCustomer() {
        Customer cust = new Customer();
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        cf.create(cust);
        return "";
    }
    
    public List<Customer> getCustByName() {
        return cf.findAll();
    }
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
}
