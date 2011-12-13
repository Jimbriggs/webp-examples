/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author BriggsJ
 */
@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Passenger passenger;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateOfBooking;

    public Booking() {
    }

    public Booking(Flight flight, Passenger passenger) {
        makeBooking(flight, passenger);
    }

    public final void makeBooking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
        this.dateOfBooking = new Date();
        flight.getBookings().add(this);
        passenger.getBookings().add(this);
    }
    
    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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
        return "jim.sws.entities.Booking[ id=" + id + " ]";
    }
    
}
