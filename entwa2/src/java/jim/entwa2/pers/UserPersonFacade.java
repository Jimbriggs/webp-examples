/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.pers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.entwa2.ent.UserPerson;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class UserPersonFacade extends AbstractFacade<UserPerson> {
    @PersistenceContext(unitName = "entwa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPersonFacade() {
        super(UserPerson.class);
    }

    public List<UserPerson> findUsersByName(String forename, String surname) {
        Query q = em.createQuery("SELECT u FROM UserPerson u WHERE u.forename = :forename AND u.surname = :surname");
        q.setParameter("forename", forename);
        q.setParameter("surname", surname);
        return q.getResultList();
    }
}
