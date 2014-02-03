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
import jim.common.util.PasswordEncryption;

/**
 *
 * @author BriggsJ
 */
@Entity
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
//    @Transient  //Uncomment this line if you don't want the plain text password stored in the database
    private String password;
    private String passwordEncrypted;
    @ManyToMany
    private Set<LoginRole> roles;

    public Set<LoginRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<LoginRole> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
        this.passwordEncrypted = PasswordEncryption.SHA256Hex(pwd);
    }

    public String getId() {
        return id;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
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
        if (!(object instanceof LoginUser)) {
            return false;
        }
        LoginUser other = (LoginUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jim.sixthS.ent.LoginUser[ id=" + id + " ]";
    }

}
