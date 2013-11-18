/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.fifth.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.fifth.ent.Person;

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

    public List<Person> findByName (String searchString) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE lowerc(p.name) LIKE lowerc(:pattern)");
        q.setParameter("pattern", "%"+searchString+"%");
        return q.getResultList();
    }
}
