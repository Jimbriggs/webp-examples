/*
 * SPOption.java
 *
 * Created on 19 July 2005, 16:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.io.Serializable;

/**
 * Represents a mark form category option
 * @author Steve Powell
 */
public class Option implements Serializable {
    
    /**
     * ID of option
     */
    private int optionID = 0;
    /**
     * Option label
     */
    private String label = null;
    /**
     * Selected value of option
     */
    private float value = 0;
    /**
     * Positive criteria for awarding option
     */
    private String positiveCriteria = null;
    /**
     * Negative criteria for assigning option
     */
    private String negativeCriteria = null;
   
    /**
     * Creates a new instance of Option
     */
    public Option() {
    }
    
    /**
     * Creates a new instance of Option with values
     * @param optionID Option ID
     * @param label Option label
     * @param value Option value
     * @param positiveCriteria Option positive criteria
     * @param negativeCriteria Negative criteria
     */
    public Option(int optionID, String label, float value, String positiveCriteria, String negativeCriteria) {
        
        this.optionID = optionID;
        this.label = label;
        this.value = value;
        this.positiveCriteria = positiveCriteria;
        this.negativeCriteria = negativeCriteria;       
        
    }

    /**
     * Getter for option ID
     * @return Option ID
     */
    public int getOptionID() {
        return optionID;
    }

    /**
     * Setter for option ID
     * @param optionID ID of Option
     */
    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    /**
     * Getter for option label
     * @return Option label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter for option label
     * @param label Option label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter for option positive criteria
     * @return Positive criteria
     */
    public String getPositiveCriteria() {
        return positiveCriteria;
    }

    /**
     * Setter for option positive criteria
     * @param positiveCriteria Positive criteria
     */
    public void setPositiveCriteria(String positiveCriteria) {
        this.positiveCriteria = positiveCriteria;
    }

    /**
     * Getter for option negative criteria
     * @return Negative criteria
     */
    public String getNegativeCriteria() {
        return negativeCriteria;
    }

    /**
     * Setter for option negative criteria
     * @param negativeCriteria Negative criteria
     */
    public void setNegativeCriteria(String negativeCriteria) {
        this.negativeCriteria = negativeCriteria;
    }

    /**
     * Getter for option value
     * @return Option value
     */
    public float getValue() {
        return value;
    }

    /**
     * Setter for option value
     * @param value Option value
     */
    public void setValue(float value) {
        this.value = value;
    }
    
}
