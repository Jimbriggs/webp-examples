/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yang.sum.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author yang
 */

@Entity
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Forename;
    private String Surname;
    private String Password;
    private String Username;
    private String Email;
    private String Phone;
    private String StudentID;    
    private Long id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getForename() {
        return Forename;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setForename(String forename) {
        this.Forename = forename;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
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
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "yang.sum.entity.Students[ id=" + id + " ]";
    }
}
