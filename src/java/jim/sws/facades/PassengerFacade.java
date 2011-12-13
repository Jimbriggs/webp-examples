/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.sws.entities.Passenger;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PassengerFacade extends AbstractFacade<Passenger> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PassengerFacade() {
        super(Passenger.class);
    }
    
}
