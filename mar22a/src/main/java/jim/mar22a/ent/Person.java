/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jim.mar22a.ent;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jim Briggs
 */
@Entity
@NamedQuery(name = "person.findByResidence", query = "SELECT p FROM Person p WHERE :addr MEMBER OF p.residences")
public class Person implements java.io.Serializable {

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public List<Address> getResidences() {
        return residences;
    }

    public void setResidences(List<Address> residences) {
        this.residences = residences;
    }

    @ManyToMany(mappedBy = "residents")
    private List<Address> residences = new ArrayList<>();

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

    public String getResidencesList() {
        StringBuilder sb = new StringBuilder();
        residences.forEach((a) -> sb.append(" ").append(a.getCity()));
        return sb.toString();
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
        return "jim.mar22a.ent.Person[ id=" + id + " ]";
    }
}
