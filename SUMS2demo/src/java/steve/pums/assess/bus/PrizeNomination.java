/*
 * PrizeNomination.java
 *
 * Created on 01 August 2005, 15:50
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

/**
 * Represents a project prize nomination
 * @author Steve Powell
 */
public class PrizeNomination implements java.io.Serializable {
    
    /**
     * ID of prize
     */
    private int prizeID = 0;
    /**
     * Justification for nomination
     */
    private String justification = null;
    /**
     * Flag for deletion of nomination
     */
    private String[] delete = {};
    
    /** Creates a new instance of PrizeNomination */
    public PrizeNomination() {
    }
    
    /**
     * Creates a new instance of PrizeNomination with values
     * @param prizeID Prize ID
     * @param justification Justification for prize nomination
     */
    public PrizeNomination(int prizeID, String justification) {
        this.prizeID = prizeID;
        this.justification = justification;        
    }

    /**
     * Getter for prize ID
     * @return Prize ID
     */
    public int getPrizeID() {
        return prizeID;
    }

    /**
     * Setter for prize ID
     * @param prizeID Prize ID
     */
    public void setPrizeID(int prizeID) {
        this.prizeID = prizeID;
    }
    
    /**
     * Getter for prize justification
     * @return Prize justification
     */
    public String getJustification() {
        return justification;
    }

    /**
     * Setter for prize nomination justification
     * @param justification Setter for prize nomination justification
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }    

    /**
     * Getter for prize deletion flag
     * @return Prize deletion flag
     */
    public String[] getDelete() {
        return delete;
    }

    /**
     * Setter for prize deletion flag
     * @param delete Deletion flag
     */
    public void setDelete(String[] delete) {
        this.delete = delete;
    }
}
