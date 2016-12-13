/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jimairline.pers;

import jim.common.facades.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.jimairline.ent.Passenger;

/**
 *
 * @author briggsj
 */
@Stateless
public class PassengerFacade extends AbstractFacade<Passenger> {

    @PersistenceContext(unitName = "jim_jimairline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassengerFacade() {
        super(Passenger.class);
    }

    /**
     *
     * @param p
     * @return
     */
    public Passenger findPassenger(Passenger p) {
        Passenger pf = this.find(p.getId());
        return pf;
    }

}
