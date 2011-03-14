/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entities.Person;
import jim.entities.Relationship;
import jim.facades.PersonFacade;
import jim.facades.RelationshipFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class RelationshipManagement {
    @EJB
    private RelationshipFacade relationshipFacade;
    @EJB
    private PersonFacade personFacade;


    public Relationship createNewRelationship(String sourceId, String destId, String label) {
        Relationship r = new Relationship();
        Long srcId = Long.parseLong(sourceId);
        Long dstId = Long.parseLong(destId);
        Person source = personFacade.find(srcId);
        Person dest = personFacade.find(dstId);
        r.setSource(source);
        r.setDestination(dest);
        r.setLabel(label);
        relationshipFacade.create(r);
        return r;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
