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
import jim.entities.Relationship;

/**
 *
 * @author briggsj
 */
@Stateless
public class RelationshipFacade extends AbstractFacade<Relationship> {

    @PersistenceContext(unitName = "enterprise2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelationshipFacade() {
        super(Relationship.class);
    }

    public List<Relationship> findSameRelationship(Relationship r) {
        Query q = em.createQuery("select r from Relationship r "
                + "where r.source = :source "
                + "and r.destination = :destination "
                + "and r.label = :label");
        q.setParameter("source", r.getSource());
        q.setParameter("destination", r.getDestination());
        q.setParameter("label", r.getLabel());
        List<Relationship> l = q.getResultList();
        return l;
    }
}
