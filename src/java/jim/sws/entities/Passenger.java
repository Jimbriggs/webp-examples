/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author BriggsJ
 */
@Entity
public class Passenger implements Serializable {
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.sws.entities.Passenger[ id=" + id + " ]";
    }
 
    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        if (this.name == null || this.name.length() == 0 ) {
            errors.put("name", "Name is required");
        }
        if (this.address == null || this.address.length() == 0) {
            errors.put("address", "Address is required");
        }
        return errors;
    }
}
