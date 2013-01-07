/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.bus;

import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import jim.airline.entities.Airport;
import jim.airline.entities.Flight;
import jim.airline.facades.AirportFacade;
import jim.airline.facades.FlightFacade;
import jim.general.util.CalendarUtil;

/**
 *
 * @author briggsj
 */
@Singleton
public class InitialiseService {

    @EJB
    private FlightFacade ff;
    @EJB
    private AirportFacade af;
    @EJB
    private AirlineService as;

    public void initialise() {
        initAirports();
        initFlights();
    }

    private void initAirports() {
        if (af.count() == 0) {
            for (String s : new String[]{"LHR", "LGW", "JFK", "CDG", "FRA", "SYD"}) {
                Airport a = new Airport(s);
                af.create(a);
            }
        }
    }
    
    private void initFlights() {
        if (ff.count() == 0) {
            List<Airport> allAirports = af.findAll();
            for (Integer i =0 ; i<10; i++) {
                Airport origin;
                Airport destination;
                do {
                    origin = Airport.randomAirport(allAirports);
                    destination = Airport.randomAirport(allAirports);
                } while (origin == destination);
                Calendar day = CalendarUtil.randomDate(0, 365);
                Long capacity = (long)(Math.random() * 20 + 5);
                String code = Flight.generateRandomCode();
                Flight f = new Flight(code, day, origin, destination, capacity);
                as.createFlight(f);
        }
        }
    }
}
