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
 * @author briggsj
 */
@Stateless
public class CustomerService {

    @EJB
    private CustomerFacade cf;
    @EJB
    private AddressFacade af;

    public Customer createCustomer(Customer cust) throws BusinessException {
        if (cust == null) {
            throw new BusinessException("Customer is null");
        }
        cf.create(cust);
        cust.getAddress().getCustomers().add(cust);
        return cust;
    }

    public Address createAddress(Address addr) throws BusinessException {
        if (addr == null) {
            throw new BusinessException("Address is null");
        }
        af.create(addr);
        return addr;
    }

    public Customer changeAddress(Customer cust, Address addr) throws BusinessException {
        if (cust == null || addr == null) {
            throw new BusinessException("Customer or address is null");
        }
        cust = cf.edit(cust);
        addr = af.edit(addr);
        Address oldAddress = cust.getAddress();
        cust.setAddress(addr);
        oldAddress.getCustomers().remove(cust);
        addr.getCustomers().add(cust);
        return cust;
    }

    public List<Customer> getCustByName(String searchString) {
        return cf.findByName("%" + searchString + "%");
    }

    public List<Address> getAllAddresses() {
        return af.findAll();
    }
}
