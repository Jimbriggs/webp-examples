/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.bus;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import jim.sws.entities.Booking;
import jim.sws.entities.Flight;
import jim.sws.entities.Passenger;
import jim.sws.facades.BookingFacade;
import jim.sws.facades.FlightFacade;
import jim.sws.facades.PassengerFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
@LocalBean
public class BookingService {

    @EJB
    private FlightFacade ff;
    @EJB
    private PassengerFacade pf;
    @EJB
    private BookingFacade bf;
    
    public Booking makeBooking(Flight flight, Passenger passenger) throws BusinessException {
        Flight f = ff.edit(flight);
        if (f == null) {
            throw new BusinessException("Flight " + flight.getNumber() + " not found");
        }
        Passenger p = pf.edit(passenger);
        if (p == null) {
            throw new BusinessException("Passenger " + passenger.getName() + " not found");
        }
        Booking b = new Booking(f, p);
        bf.create(b);
        return b;
    }

    public void cancelBooking(Booking booking) {
    }
 
    public List<Flight> listFlights() {
        return ff.findAll();
    }
    
    public List<Flight> listFlights(Date startDate, Date endDate) {
        return ff.findBetweenDates(startDate, endDate);
    }
    
    public List<Passenger> listPassengers() {
        return pf.findAll();
    }
    
    public List<Booking> listBookings() {
        return bf.findAll();
    }

    public Booking makeBooking(Long flightId, Long passengerId) throws BusinessException {
        Flight f = ff.find(flightId);
        if (f == null) {
            ///flight not found
        }
        Passenger p = pf.find(passengerId);
        return makeBooking(f, p);
    }
}
