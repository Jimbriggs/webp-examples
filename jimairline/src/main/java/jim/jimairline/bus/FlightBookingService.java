/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jimairline.bus;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import jim.common.BusinessException;
import jim.jimairline.ent.Booking;
import jim.jimairline.ent.Flight;
import jim.jimairline.ent.Passenger;
import jim.jimairline.pers.BookingFacade;
import jim.jimairline.pers.FlightFacade;
import jim.jimairline.pers.PassengerFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class FlightBookingService {

    private static final Logger log = Logger.getLogger(FlightBookingService.class.getName());
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private BookingFacade bf;
    @EJB
    private FlightFacade ff;
    @EJB
    private PassengerFacade pf;

    public Booking makeBooking(Flight f, Passenger p) throws BusinessException {
        log.info("makeBooking called with Flight " + f + " and Passenger " + p);
        //check flight and passenger
        f = ff.findFlight(f);
        if (f == null) {
            throw new BusinessException("Flight does not exist");
        }

        p = pf.findPassenger(p);
        if (p == null) {
            throw new BusinessException("Passenger does not exist");
        }

        //check flight is not full
        if (f.full()) {
            throw new BusinessException("Flight is full");
        }
        Booking b = new Booking();
        b.linkToFlight(f);
        b.linkToPassenger(p);
        //persist booking
        bf.create(b);
        //return booking
        log.info("makeBooking returns Booking " + b);
        return b;
    }

    public List<Passenger> reportPassengers() throws BusinessException {
        return pf.findAll();
    }

    public List<Booking> reportBookings() throws BusinessException {
        return bf.findAllChronologically();
    }

    public List<Flight> reportFlights(Calendar after, Calendar before) throws BusinessException {
        return ff.findFlightsBetween(after, before);
    }
}
