/*
 * SPUnitBean.java
 *
 * Created on 24 July 2005, 12:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

/**
 * Represents a project unit
 * @author Steve Powell
 */
public class UnitBean implements java.io.Serializable {
    
    /**
     * Unit ID
     */
    private int ID;
    /**
     * Code of unit
     */
    private String unitCode;
    /**
     * Name of unit
     */
    private String unitName;
        
    /** Creates a new instance of SPUnitBean */
    public UnitBean() {
    }
    
    /**
     * Creates a new instance of SPUnitBean with values
     * @param ID Unit ID
     * @param unitCode Unit code
     * @param unitName Unit name
     */
    public UnitBean(int ID, String unitCode, String unitName) {
        
        this.ID = ID;
        this.unitCode = unitCode;
        this.unitName = unitName;
    }

    /**
     * Getter for unit ID
     * @return Unit ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for unit ID
     * @param ID Unit ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter for unit code
     * @return Unit code
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * Setter for unit code
     * @param unitCode Unit code
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * Getter for unit name
     * @return Unit name
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Setter for unit name
     * @param unitName Unit name
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    /**
     * Getter for unit description
     * @return Unit description
     */
    public String getDescription() {
        
        return (this.unitCode + " - " + this.unitName);
        
    }
    
}
