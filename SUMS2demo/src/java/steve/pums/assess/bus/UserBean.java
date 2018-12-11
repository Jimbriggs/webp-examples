/*
 * SPUser.java
 *
 * Created on 19 July 2005, 21:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import jim.util.struts.JimActionErrors;

/**
 * Session bean to identify current user
 * @author Steve Powell
 */
public class UserBean extends ActionForm {
    
    
    /**
     * UserBean person ID
     */
    private int personID = 0;
        
    /** Creates a new instance of SPUser */
    public UserBean() {
    }
    
    /**
     * Getter for user ID
     * @return Person ID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * Setter for user person ID
     * @param personID Person ID
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * Holds value of property name.
     */
    private String name;

    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getName() {

        return this.name;
    }

    /**
     * Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {

        this.name = name;
    }


      
}
