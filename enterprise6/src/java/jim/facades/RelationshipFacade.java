/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.entities.Relationship;

/**
 *
 * @author briggsj
 */
@Stateless
public class RelationshipFacade extends AbstractFacade<Relationship> {
    @PersistenceContext(unitName = "enterprise2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RelationshipFacade() {
        super(Relationship.class);
    }

}
