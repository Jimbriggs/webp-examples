/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jimairline.bus;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import jim.common.BusinessException;
import jim.jimairline.ent.Flight;
import jim.jimairline.pers.FlightFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class InitService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void initDatabase() throws BusinessException {
        initFlights();
        //initPassengers();
    }

    @EJB
    private FlightFacade ff;

    public void initFlights() {
        if (ff.count() == 0) {
            Flight f1 = new Flight();
            f1.setMaxPassengers(10);
            ff.create(f1);
        }
    }
}
