/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jimairline.pers;

import jim.common.facades.AbstractFacade;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jim.jimairline.ent.Flight;

/**
 *
 * @author briggsj
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "jim_jimairline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }

    /**
     *
     * @param f
     * @return
     */
    public Flight findFlight(Flight f) {
        Flight df = this.find(f.getId());
        return df;
    }

    /**
     *
     * @param after
     * @param before
     * @return
     */
    public List<Flight> findFlightsBetween(Calendar after, Calendar before) {
        before.add(Calendar.DAY_OF_WEEK, 1);
        Query q = em.createQuery("SELECT f FROM Flight f WHERE f.flightDate >= :after AND f.flightDate <= :before");
        q.setParameter("after", after);
        q.setParameter("before", before);
        return q.getResultList();
    }

}
