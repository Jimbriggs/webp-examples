/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.apsw151.ents.Person;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "apsw151PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    public List<Person> findByName(Person p) {
        Query q = em.createQuery("SELECT p FROM Person p" +
                " WHERE p.forename = :forename " +
                "AND p.surname = :surname");
        q.setParameter("forename", p.getForename());
        q.setParameter("surname", p.getSurname());
        return q.getResultList();
    }

}