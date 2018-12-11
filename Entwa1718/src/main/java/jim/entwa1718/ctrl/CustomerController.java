/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1718.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.entwa1718.bus.BusinessException;
import jim.entwa1718.bus.CustomerService;
import jim.entwa1718.ent.Address;
import jim.entwa1718.ent.Customer;

/**
 *
 * @author briggsj
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerController {

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }
    
    @EJB
    private CustomerService cs;
    
    private Customer newCustomer = new Customer();
    private Customer currentCustomer = new Customer();
    private Address currentAddress = new Address();
    private List<Address> allAddresses = null;
    private List<Customer> allCustomers = null;

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public List<Address> getAllAddresses() {
        return allAddresses;
    }

    public void setAllAddresses(List<Address> allAddresses) {
        this.allAddresses = allAddresses;
    }

    public List<Customer> getAllCustomers() {
        if (this.allCustomers == null) {
            allCustomers = cs.fetchAllCustomers();
        }
        return allCustomers;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }
    
    public String doCreateCustomer() {
        try {
            cs.createNewCustomer(newCustomer);
        } catch (BusinessException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String doChangeCustomerHome() {
        try {
            cs.changeCustomerAddress(currentCustomer, currentAddress);
        } catch (BusinessException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
