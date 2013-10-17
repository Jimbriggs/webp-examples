/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author briggsj
 */
@Entity
@NamedQuery(name="booking.findAllOrderedByDate", query="select b from Booking b order by b.bookingTime DESC")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Flight flight;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date bookingTime;

    public Booking() {
        this.bookingTime = new Date();
    }

    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
        this.bookingTime = new Date();
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passengers) {
        this.passenger = passengers;
    }
    
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.airline.entities.Booking[ id=" + id + " ]";
    }

    static public List<Passenger> getPassengerList(List<Booking> bookings) {
        List<Passenger> passList = new ArrayList<Passenger>();
        for (Booking b : bookings) {
            passList.add(b.getPassenger());
        }
        return passList;
    }
}
