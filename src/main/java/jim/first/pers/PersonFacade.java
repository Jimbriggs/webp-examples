/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.first.ent.Person;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "jim.first_firstenterprise_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
    public List<Person> findPersonByName (String name2searchfor){
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.name = :searchname");
        q.setParameter("searchname", name2searchfor);
        List<Person> pl = q.getResultList();
        return pl;
    }
    
    public List<Person> findPersonByCity (String cityname) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.home.city = :searchname");
        q.setParameter("searchname", cityname);
        List<Person> pl = q.getResultList();
        return pl;
    }
}
