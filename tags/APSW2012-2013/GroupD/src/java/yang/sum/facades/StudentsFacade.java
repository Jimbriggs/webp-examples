/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yang.sum.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import yang.sum.entity.Students;

/**
 *
 * @author yang
 */
@Stateless
public class StudentsFacade extends AbstractFacade<Students> {
    @PersistenceContext(unitName = "SUMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentsFacade() {
        super(Students.class);
    }
    
    public List<Students> findByUsername(String username) {
        Query q = em.createNamedQuery("Students.findByUsername");
        q.setParameter("username", username);
        return q.getResultList();
    }
    
}
