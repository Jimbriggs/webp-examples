/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.jpademo.bus.BusinessException;
import jim.jpademo.bus.CustomerService;
import jim.jpademo.entities.Address;
import jim.jpademo.entities.Customer;

/**
 *
 * @author BriggsJ
 */
@ManagedBean
@RequestScoped
public class EditCustAddr {

    private Customer customer;
    private Address address;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @EJB
    private CustomerService cs;

    public String doChangeAddress() {
        try {
            cs.changeAddress(customer, address);
        } catch (BusinessException ex) {
            Logger.getLogger(EditCustAddr.class.getName()).log(Level.SEVERE, null, ex);
            //TODO do something
        }
        return "index";
    }

    /**
     * Creates a new instance of EditCustAddr
     */
    public EditCustAddr() {
    }
}
