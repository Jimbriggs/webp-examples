/*
 * nameBean.java
 *
 * Created on 16 April 2004, 14:30
 */
package jim.mvc.fruit;

/**
 *
 * @author  briggsj
 */
public class Fruit {

    /** Holds value of property colour. */
    private String colour;
    /** Holds value of property condition. */
    private String condition;
    /** Holds value of property type. */
    protected String type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String name) {
        this.type = name;
    }

    /** Creates a new instance of nameBean */
    public Fruit() {
    }

    /** Getter for property colour.
     * @return Value of property colour.
     *
     */
    public String getColour() {
        return this.colour;
    }

    /** Setter for property colour.
     * @param colour New value of property colour.
     *
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /** Getter for property condition.
     * @return Value of property condition.
     *
     */
    public String getCondition() {
        return this.condition;
    }

    /** Setter for property condition.
     * @param condition New value of property condition.
     *
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }
}
