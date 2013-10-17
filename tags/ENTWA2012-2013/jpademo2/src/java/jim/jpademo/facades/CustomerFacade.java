/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.jpademo.entities.Customer;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "jpademo2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List<Customer> findByLastName(String searchString) {
       Query q = em.createQuery("select c from Customer c where c.lastName like :pattern");
       q.setParameter("pattern", "%" + searchString + "%");
       return q.getResultList();
    }
    
}
