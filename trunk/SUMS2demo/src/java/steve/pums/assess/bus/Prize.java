/*
 * Prize.java
 *
 * Created on 01 August 2005, 16:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

/**
 * Represents a prize category
 * @author Steve Powell
 */
public class Prize implements java.io.Serializable {
    
    /**
     * ID of prize
     */
    private int prizeID = 0;
    /**
     * Name of prize
     */
    private String name = null;
    /**
     * Monetary value of prize
     */
    private int value = 0;
    /**
     * Criteria for nomination
     */
    private String criteria = null;
    
    /** Creates a new instance of Prize */
    
    public Prize() {
    }
    
    /**
     * Creates a new instance of Prize with values
     * @param prizeID ID of prize
     * @param name Prize name
     * @param value Prize value
     * @param criteria Prize nomination criteria
     */
    public Prize(int prizeID,String name,int value,String criteria) {
        this.setPrizeID(prizeID);
        this.setName(name);
        this.setValue(value);
        this.setCriteria(criteria);
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
     * Getter for prize name
     * @return Prize name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for prize name
     * @param name Prize name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for prize value
     * @return Prize value
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for prize value
     * @param value Prize value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter for prize criteria
     * @return Prize criteria
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * Setter for prize nomination criteria
     * @param criteria Nomination criteria
     */
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
    
    /**
     * Getter for prize descrpition, combines name, value and criteria
     * @return Prize description
     */
    public String getDescription() {
        return this.name + " - Prize " + this.value + " - " + this.criteria;
    }
    
}
