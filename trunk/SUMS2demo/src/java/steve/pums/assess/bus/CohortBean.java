/*
 * CohortBean.java
 *
 * Created on 24 July 2005, 01:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.util.Date;

/**
 * Used to represent a particular cohort, used for project registration drop-downs
 * @author Steve Powell
 */
public class CohortBean implements java.io.Serializable {
    
    /**
     * Description of cohort
     */
    private String cohortDesc = null;
    /**
     * ID of cohort
     */
    private int ID = 0;
    
    /** Creates a new instance of CohortBean */
    public CohortBean() {
    }

//    /**
//     * Creates a cohort with values
//     * @param ID ID of cohort
//     * @param cohortDesc Description of cohort
//     */
//    public CohortBean(int ID, String cohortDesc) {
//        this.ID = ID;
//        this.cohortDesc = cohortDesc;
//    }
        
    /**
     * Getter for cohort description
     * @return Cohort descrption
     */
    public String getCohortDesc() {
        return cohortDesc;
    }

    /**
     * Setter for cohort description
     * @param cohortDesc Cohort description
     */
    public void setCohortDesc(String cohortDesc) {
        this.cohortDesc = cohortDesc;
    }

    /**
     * Getter for cohort ID
     * @return ID of cohort
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for cohort ID
     * @param ID Cohort ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Holds value of property startDate.
     */
    private Date startDate;

    /**
     * Getter for property startDate.
     * @return Value of property startDate.
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Setter for property startDate.
     * @param startDate New value of property startDate.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Holds value of property endDate.
     */
    private Date endDate;

    /**
     * Getter for property endDate.
     * @return Value of property endDate.
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Setter for property endDate.
     * @param endDate New value of property endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Holds value of property closed.
     */
    private boolean closed;

    /**
     * Getter for property closed.
     * @return Value of property closed.
     */
    public boolean isClosed() {
        return this.closed;
    }

    /**
     * Setter for property closed.
     * @param closed New value of property closed.
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    
}
