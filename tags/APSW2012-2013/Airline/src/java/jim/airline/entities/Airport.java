/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author briggsj
 */
@Entity
public class Airport implements Serializable {
    @OneToMany(mappedBy = "destination")
    private List<Flight> flightsEndingHere;
    @OneToMany(mappedBy = "origin")
    private List<Flight> flightsStartingHere;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airportCode;

    public Airport() {
    }

    public Airport(String code) {
        this.airportCode = code;
    }

    public List<Flight> getFlightsEndingHere() {
        return flightsEndingHere;
    }

    public void setFlightsEndingHere(List<Flight> flightsEndingHere) {
        this.flightsEndingHere = flightsEndingHere;
    }

    public List<Flight> getFlightsStartingHere() {
        return flightsStartingHere;
    }

    public void setFlightsStartingHere(List<Flight> flightsStartingHere) {
        this.flightsStartingHere = flightsStartingHere;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
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
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.airline.entities.Airport[ id=" + id + " ]";
    }
    
    static public Airport randomAirport(List<Airport> airports) {
        int length = airports.size();
        int pick = (int)Math.floor(length * Math.random());
        return airports.get(pick);
    }
}
