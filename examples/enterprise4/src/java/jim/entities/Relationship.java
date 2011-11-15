/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author briggsj
 */
@Entity
public class Relationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Person source;
    @ManyToOne
    private Person destination;
    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getDestination() {
        return destination;
    }

    public void setDestination(Person destination) {
        this.destination = destination;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Person getSource() {
        return source;
    }

    public void setSource(Person source) {
        this.source = source;
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
        if (!(object instanceof Relationship)) {
            return false;
        }
        Relationship other = (Relationship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "jim.entities.Relationship[id=" + id + "]";
        return this.source.getFullName() + " is " + this.label + " to " + this.destination.getFullName();
    }

    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        if (this.source == null) {
            errors.put("source", "Source is null");
        }
        if (this.destination == null) {
            errors.put("destination", "Destination is null");
        }
        if (this.label == null || this.label.length() == 0) {
            errors.put("label", "No label");
        }
        return errors;
    }
}
