/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.airline.entities.Booking;

/**
 *
 * @author briggsj
 */
@Stateless
public class BookingFacade extends AbstractFacade<Booking> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingFacade() {
        super(Booking.class);
    }
    
    public List<Booking> findAllOrderedByDate() {
        Query q = em.createNamedQuery("booking.findAllOrderedByDate");
        return q.getResultList();
    }
}
