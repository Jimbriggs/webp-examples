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
 * @author BriggsJ
 */
@Stateless
public class CustomerService {

    @EJB
    private CustomerFacade cf;

    public Customer createCustomer(Customer c) throws BusinessException {
        if (c.getFirstName().equalsIgnoreCase(c.getLastName())) {
            throw new BusinessException("first name and last name are the same");
        }
        cf.create(c);
        return c;
    }

    public List<Customer> findByLastName(String searchString) {
        return cf.findByLastName(searchString);
    }
}
