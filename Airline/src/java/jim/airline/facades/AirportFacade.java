/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.airline.entities.Airport;

/**
 *
 * @author briggsj
 */
@Stateless
public class AirportFacade extends AbstractFacade<Airport> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AirportFacade() {
        super(Airport.class);
    }
    
}
