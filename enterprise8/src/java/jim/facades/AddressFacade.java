/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.entities.Address;

/**
 *
 * @author briggsj
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {
    @PersistenceContext(unitName = "enterprise2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

    public List<Address> findSameAddress(Address a) {
        Query q = em.createQuery("select a from Address a "
                + "where lower(a.postcode) = lower(:postcode)");
        q.setParameter("postcode", a.getPostcode());
        List<Address> l = q.getResultList();
        return l;
    }

}
