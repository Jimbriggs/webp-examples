/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.sws.entities.Booking;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class BookingFacade extends AbstractFacade<Booking> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingFacade() {
        super(Booking.class);
    }
    
}
