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
import jim.entities.Person;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "enterprise2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    public List<Person> findSameName(Person newbie) {
        Query q = em.createQuery("select p from Person p "
                + "where p.firstname = :firstname AND p.lastname = :lastname ");
        q.setParameter("firstname", newbie.getFirstname());
        q.setParameter("lastname", newbie.getLastname());
        List<Person> l = q.getResultList();
        return l;
    }

}
