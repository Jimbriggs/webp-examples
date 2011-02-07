/*
 * SPStaffBean.java
 *
 * Created on 24 July 2005, 01:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import org.apache.struts.action.ActionForm;
import jim.util.struts.*;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Used to represent a member of staff
 * @author Steve Powell
 */
public class StaffBean extends ActionForm  {
    
    /**
     * First name of staff member
     */
    private String first_name = null;
    /**
     * Surname of staff member
     */
    private String surname = null;
    /**
     * ID of staff member
     */
    private int ID = 0;
    
    /** Creates a new instance of SPStaffBean */
    public StaffBean() {
    }
    
    /**
     * Creates a new instance of SPStaffBean with person ID
     * @param ID Staff Person ID
     */
    public StaffBean(int ID) {        
        this.ID = ID;
    }
    
    /**
     * Creates a new instance of SPStaffBean with values
     * @param ID Staff person ID
     * @param first_name Staff first name
     * @param surname Staff last name
     */
    public StaffBean(int ID, String first_name, String surname) {
        
        this.ID = ID;
        this.first_name = first_name;
        this.surname = surname;
    }

    /**
     * Getter for staff name
     * @return Name of staff member
     */
    public String getName() {
        return (this.first_name + " " + this.surname);
    }

    public String getEmailName() {
        return (this.first_name + "." + this.surname);
    }
    
    /**
     * Getter for staff ID
     * @return Person ID of staff member
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for staff ID
     * @param ID Person ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Validates the bean during marker assignment
     * @return Errors identified during validation
     * @param mapping Action Mapping
     * @param request Servlet request
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors err = new JimActionErrors();
        err.add(super.validate(mapping, request));
        
        if(this.ID==0) {        
            err.add("ID","marker.notset","is required");            
        }

        return err;
    }           
    
}
