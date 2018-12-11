/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author briggsj
 */
@Entity
public class Address implements Serializable {

    @OneToMany(mappedBy = "address")
    private List<Person> occupants;

    public List<Person> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Person> occupants) {
        this.occupants = occupants;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    protected String firstline;

    /**
     * Get the value of firstline
     *
     * @return the value of firstline
     */
    public String getFirstline() {
        return firstline;
    }

    /**
     * Set the value of firstline
     *
     * @param firstline new value of firstline
     */
    public void setFirstline(String firstline) {
        this.firstline = firstline;
    }
    protected String secondline;

    /**
     * Get the value of secondline
     *
     * @return the value of secondline
     */
    public String getSecondline() {
        return secondline;
    }

    /**
     * Set the value of secondline
     *
     * @param secondline new value of secondline
     */
    public void setSecondline(String secondline) {
        this.secondline = secondline;
    }
    protected String city;

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the value of city
     *
     * @param city new value of city
     */
    public void setCity(String city) {
        this.city = city;
    }
    protected String postcode;

    /**
     * Get the value of postcode
     *
     * @return the value of postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Set the value of postcode
     *
     * @param postcode new value of postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    protected String country;

    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country) {
        this.country = country;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getFullAddress();
//        return "jim.entities.Address[id=" + id + "]";
    }

    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        postcode = postcode.trim().toUpperCase();
        if ("UK".equalsIgnoreCase(country) && !postcode.matches("[A-Z]{1,2}\\d{1,2} ?\\d[A-Z][A-Z]")) {
            errors.put("postcode", "Postcode invalid");
        }
        return errors;
    }

    @Transient
    public String getFullAddress() {
        return this.firstline + ", " + this.secondline + ", " + this.city + ", " + this.postcode;
    }
}
