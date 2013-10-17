/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.facades;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import jim.airline.entities.Flight;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 *
 * @author briggsj
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "AirlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }

    public List<Flight> getFlightsBetween(Calendar start, Calendar finish) {
        Query q = em.createQuery("SELECT f FROM Flight f "
                + "WHERE f.flightDate >= :start "
                + "AND f.flightDate <= :finish");
        q.setParameter("start", start);
        q.setParameter("finish", finish);
        return q.getResultList();
    }
}
