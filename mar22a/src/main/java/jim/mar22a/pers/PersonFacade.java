/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jim.mar22a.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.mar22a.ent.Address;
import jim.mar22a.ent.Person;

/**
 *
 * @author owenkempton
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "jim_mar22a_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    public List<Person> findByResidence(Address a) {
//        Query q = em.createQuery("SELECT p FROM Person p WHERE :addr MEMBER OF p.residences");
        Query q = em.createNamedQuery("person.findByResidence");
        q.setParameter("addr", a);
        return q.getResultList();
    }

}
