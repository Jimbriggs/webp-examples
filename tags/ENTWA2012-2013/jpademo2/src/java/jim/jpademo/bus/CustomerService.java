/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.jpademo.entities.Address;
import jim.jpademo.entities.Customer;
import jim.jpademo.facades.AddressFacade;
import jim.jpademo.facades.CustomerFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class CustomerService {

    @EJB
    private CustomerFacade cf;
    @EJB
    private AddressFacade af;

    public Customer createCustomer(Customer c) throws BusinessException {
        if (c.getFirstName().equalsIgnoreCase(c.getLastName())) {
            throw new BusinessException("first name and last name are the same");
        }
        cf.create(c);
        c.getAddress().getCustomers().add(c);
        return c;
    }

    public Address createAddress(Address a) throws BusinessException {
        //validation
        af.create(a);
        return a;
    }

    public Customer changeAddress(Customer customer, Address newAddress) throws BusinessException {
        //validation
        if (customer == null) {
            throw new BusinessException("customer is null");
        }
        if (newAddress == null) {
            throw new BusinessException("address is null");
        }

        //confirm that objects passed as parameters are managed by the persistence unit
        customer = cf.edit(customer);
        newAddress = af.edit(newAddress);

        //functionality
        Address oldAddress = customer.getAddress();
        oldAddress.getCustomers().remove(customer);
        customer.setAddress(newAddress);
        newAddress.getCustomers().add(customer);

        return customer;
    }

    public List<Customer> findByLastName(String searchString) {
        return cf.findByLastName(searchString);
    }
}
