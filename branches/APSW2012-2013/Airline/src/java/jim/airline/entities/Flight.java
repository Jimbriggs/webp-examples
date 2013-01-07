/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author briggsj
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar flightDate;
    @ManyToOne
    private Airport origin;
    @ManyToOne
    private Airport destination;
    private Long capacity;
    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;

    public Flight() {
    }

    public Flight(String flightNumber, Calendar flightDate, Airport origin, Airport destination, Long capacity) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Calendar flightDate) {
        this.flightDate = flightDate;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.airline.entities.Flight[ id=" + id + " ]";
    }

    public List<Passenger> getPassengerList() {
        return Booking.getPassengerList(this.bookings);
    }

    public boolean isAlreadyBooked(Passenger passenger) {
        return (getPassengerList().contains(passenger));
    }

    public static String generateRandomCode() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (Math.random() * 26 + (int) 'A'));
        sb.append((char) (Math.random() * 26 + (int) 'A'));
        sb.append((char) (Math.random() * 10 + (int) '0'));
        sb.append((char) (Math.random() * 10 + (int) '0'));
        sb.append((char) (Math.random() * 10 + (int) '0'));
        return sb.toString();
    }
}
