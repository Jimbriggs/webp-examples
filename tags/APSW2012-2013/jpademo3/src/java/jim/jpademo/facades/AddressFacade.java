/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.jpademo.entities.Address;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {
    @PersistenceContext(unitName = "jpademo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

}
