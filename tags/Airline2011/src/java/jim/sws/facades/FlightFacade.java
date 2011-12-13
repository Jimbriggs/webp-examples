/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.facades;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.sws.entities.Flight;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {
    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }

    public List<Flight> findBetweenDates(Date startDate, Date endDate) {
        Query q = em.createQuery("select f from flight "
                + "where f.flightDate >= :startDate "
                + "and f.flightDate <= :endDate");
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);
        return q.getResultList();        
    }
    
}
