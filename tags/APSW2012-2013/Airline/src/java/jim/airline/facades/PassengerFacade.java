/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.airline.entities.Passenger;

/**
 *
 * @author briggsj
 */
@Stateless
public class PassengerFacade extends AbstractFacade<Passenger> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassengerFacade() {
        super(Passenger.class);
    }
    
}
