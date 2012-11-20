/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.jpademo.bus.CustomerService;
import jim.jpademo.entities.Customer;

/**
 *
 * @author BriggsJ
 */
@ManagedBean
@RequestScoped
public class CustomerBean extends BaseBean {

    private Customer newCustomer = new Customer();
    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }
    @EJB
    private CustomerService cs;

    public String addCustomer() {
        try {
            newCustomer = cs.createCustomer(newCustomer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
            addError(ex.getMessage());
        }
        return "";
    }

    public List<Customer> getCustByName() {
        return cs.findByLastName(searchString);
    }

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
}
