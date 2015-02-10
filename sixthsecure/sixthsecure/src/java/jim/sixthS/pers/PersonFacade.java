/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.sixthS.ent.Address;
import jim.sixthS.ent.Person;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "fifthPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    public List<Person> findPersonAtHomeAddress(Address a) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.home = :a");
        q.setParameter("a", a);
        return q.getResultList();
    }

    public List<Person> findPersonAtHomeAddress(String searchString) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.home.details LIKE :search");
        q.setParameter("search", "%"+searchString+"%");
        return q.getResultList();
    }
}
