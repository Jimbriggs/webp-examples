/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.ent;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author BriggsJ
 */
@Entity
public class LoginRole implements Serializable {
    @ManyToMany(mappedBy = "roles")
    private Set<LoginUser> users;
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    public Set<LoginUser> getUsers() {
        return users;
    }

    public void setUsers(Set<LoginUser> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof LoginRole)) {
            return false;
        }
        LoginRole other = (LoginRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.sixthS.ent.Role[ id=" + id + " ]";
    }

}
