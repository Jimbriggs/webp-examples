/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.entities;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author briggsj
 */
@Entity
public class Person implements Serializable, Principal {
    @OneToMany(mappedBy = "destination")
    private List<Relationship> destinationRelationships;
    @OneToMany(mappedBy = "source")
    private List<Relationship> sourceRelationships;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;

    public Person() {
    }
    
    public Person(String name) {
        id = Long.parseLong(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Relationship> getDestinationRelationships() {
        return destinationRelationships;
    }

    public void setDestinationRelationships(List<Relationship> destinationRelationships) {
        this.destinationRelationships = destinationRelationships;
    }

    public List<Relationship> getSourceRelationships() {
        return sourceRelationships;
    }

    public void setSourceRelationships(List<Relationship> sourceRelationships) {
        this.sourceRelationships = sourceRelationships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected String lastname;

    /**
     * Get the value of lastname
     *
     * @return the value of lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the value of lastname
     *
     * @param lastname new value of lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    protected String firstname;

    /**
     * Get the value of firstname
     *
     * @return the value of firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the value of firstname
     *
     * @param firstname new value of firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @ManyToOne
    protected Address address;

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(Address address) {
        this.address = address;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "jim.entities.Person[id=" + id + "]";
        return this.getFullName();
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }

    @Override
    public String getName() {
        return Long.toString(getId());
    }

}
