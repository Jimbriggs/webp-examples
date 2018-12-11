/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1718.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entwa1718.ent.Address;
import jim.entwa1718.ent.Customer;
import jim.entwa1718.pers.AddressFacade;
import jim.entwa1718.pers.CustomerFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class CustomerService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private CustomerFacade cf;
    @EJB
    private AddressFacade af;
    
    public Customer createNewCustomer(Customer c) throws BusinessException {
        cf.create(c);
        return c;
    }
    
    public Customer changeCustomerAddress(Customer c, Address newAddress) throws BusinessException {
        //make sure we're dealing with persistent versions of these objects
        c = cf.edit(c);
        newAddress = af.edit(newAddress);
        
        connectCustomerHome(c, newAddress);
        
        return c;
    }

    public void connectCustomerHome(Customer c, Address newAddress) {
        //set up relationship
        if (c.getHome() != null){
            c.getHome().getOccupiers().remove(c);
        }
        c.setHome(newAddress);
        newAddress.getOccupiers().add(c);
    }

    public List<Customer> fetchAllCustomers() {
       return cf.findAll();
    }
}
