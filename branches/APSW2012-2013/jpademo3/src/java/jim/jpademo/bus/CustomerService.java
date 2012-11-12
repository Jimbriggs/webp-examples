/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.jpademo.entities.Customer;
import jim.jpademo.facades.CustomerFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class CustomerService {

    @EJB
    private CustomerFacade cf;

    public Customer createCustomer(Customer cust) throws BusinessException {
        if (cust == null) {
            throw new BusinessException("Customer is null");
        }
        cf.create(cust);
        return cust;
    }

    public List<Customer> getCustByName(String searchString) {
        return cf.findByName("%" + searchString + "%");
    }

}
