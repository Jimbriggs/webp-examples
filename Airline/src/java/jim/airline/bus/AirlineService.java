/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.bus;

import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.airline.entities.Airport;
import jim.airline.entities.Booking;
import jim.airline.entities.Flight;
import jim.airline.entities.Passenger;
import jim.airline.facades.AirportFacade;
import jim.airline.facades.BookingFacade;
import jim.airline.facades.FlightFacade;
import jim.airline.facades.PassengerFacade;
import jim.general.util.CalendarUtil;

/**
 *
 * @author briggsj
 */
@Stateless
public class AirlineService {

    @EJB private FlightFacade ff;
    @EJB private PassengerFacade pf;
    @EJB private BookingFacade bf;
    @EJB private AirportFacade af;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //add passenger to flight, checking that they are not already on the flight
    public Booking makeBooking(Flight flight, Passenger passenger) throws BusinessException {
        //validate flight
        flight = ff.edit(flight);
        //validate passenger, including not already on flight
        passenger = pf.edit(passenger);
        if (flight.isAlreadyBooked(passenger)) {
            throw new BusinessException("Passenger " + passenger.getUsername()
                    + " is already booked on Flight " + flight.getFlightNumber());
        }
        Booking booking = new Booking(passenger, flight);
        bf.create(booking);
        return booking;
    }

    //add flight
    //add passenger

    //REPORTS
    //flight list between dates

    public List<Flight> getFlightsByDate(Calendar start, Calendar finish) {
        CalendarUtil.setTimeOfDay(start, 0, 0, 0);
        CalendarUtil.setTimeOfDay(finish, 23, 59, 59);
        return ff.getFlightsBetween(start, finish);
    }
    //all passengers

    public List<Passenger> getAllPassengers() {
        return pf.findAll();
    }

    //all bookings ordered chronologically

    public List<Booking> getBookings() {
        return bf.findAllOrderedByDate();
    }

    /**
     *
     * @param f the value of f
     * @param origin the value of origin
     * @param destination the value of destination
     */
    public void createFlight(Flight f) {
        f.getOrigin().getFlightsStartingHere().add(f);
        f.getDestination().getFlightsEndingHere().add(f);
        ff.create(f);
    }
}
