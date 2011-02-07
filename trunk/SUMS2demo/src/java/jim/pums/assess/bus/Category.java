/*
 * Category.java
 *
 * Created on 02 May 2005, 21:50
 */

package jim.pums.assess.bus;

/**
 *
 * @author  briggsj
 */
public class Category implements Comparable, java.io.Serializable {
    
    /**
     * Holds value of property name.
     */
    private String name;
    
    /**
     * Holds value of property weight.
     */
    private int weight;
    
    /**
     * Holds value of property index.
     */
    private int index;
    
    /**
     * Holds value of property longname.
     */
    private String longname;
    
    /**
     * Holds value of property description.
     */
    private String description;
    
    /** Creates a new instance of Category */
    public Category() {
    }
    
    public Category(String name, int weight, int index) {
        init(name, "", "", weight, index);
    }
    
    public Category(String name, String longname, String description, int weight, int index) {
        init(name, longname, description, weight, index);
    }
    
    private void init (String name, String longname, String description, int weight, int index) {
        this.name = name;
        this.longname = longname;
        this.description = description;
        this.weight = weight;
        this.index = index;
    }
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
    
    /**
     * Getter for property weight.
     * @return Value of property weight.
     */
    public int getWeight() {
        return this.weight;
    }
    
    /**
     * Setter for property weight.
     * @param weight New value of property weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    /**
     * Getter for property index.
     * @return Value of property index.
     */
    public int getIndex() {
        return this.index;
    }
    
    /**
     * Setter for property index.
     * @param index New value of property index.
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int compareTo(Object o) {
        Category cat = (Category)o;
        if (index < cat.index) {
            return -1;
        } else if (index > cat.index) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Getter for property longname.
     * @return Value of property longname.
     */
    public String getLongname() {
        return this.longname;
    }
    
    /**
     * Setter for property longname.
     * @param longname New value of property longname.
     */
    public void setLongname(String longname) {
        this.longname = longname;
    }
    
    /**
     * Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Setter for property description.
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
