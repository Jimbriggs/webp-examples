/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.pers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.apsw3.ents.Person;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "apsw3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

}
