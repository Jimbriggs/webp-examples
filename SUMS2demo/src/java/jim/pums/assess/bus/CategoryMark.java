/*
 * CategoryMark.java
 *
 * Created on 29 April 2005, 08:59
 */

package jim.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import jim.util.struts.JimActionErrors;

/**
 *
 * @author  briggsj
 */
public class CategoryMark extends ActionForm {
    
    /**
     * Holds value of property weight.
     */
    private int weight;
    
    /**
     * Holds value of property marks.
     */
    //private Set marks = new TreeSet();
    private Integer[] marks;
    
    /**
     * Holds value of property name.
     */
    private String name;
    
    /**
     * Holds value of property cat.
     */
    private Category cat;
    
    /** Creates a new instance of CategoryMark */
    public CategoryMark(String name) {
        this.name = name;
    }
    
    /**
     * Getter for property weight.
     * @return Value of property weight.
     */
    public int getWeight() {
        return cat.getWeight();
    }
    
    private int average(Integer[] marks) throws Exception {
        int sum = 0;
        if (marks == null || marks.length <= 0) {
            return 0;
        }
        for (int i=0; i<marks.length; i++) {
            int mk = marks[i].intValue();
            if (mk < 0 || mk > 100) {
                throw new Exception("Mark of " + mk + " out of range 0..100");
            }
            sum += mk;
        }
        return Math.round((float)sum / marks.length);
    }
    
    public int getMark() throws Exception {
        return average(marks);
    }
    
    /**
     * Setter for property marks.
     * @param marks New value of property marks.
     */
    public void setMarks(Integer[] marks) {
        this.marks = marks;
    }
    
    public Integer[] getMarks() {
        return marks;
    }
    
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        JimActionErrors retValue = new JimActionErrors();
        
        retValue.add(super.validate(actionMapping, httpServletRequest));
        if (marks == null || marks.length == 0) {
            retValue.add(name, "markForm.nomark", name);
        }
        
        return retValue;
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
     * Getter for property cat.
     * @return Value of property cat.
     */
    public Category getCat() {
        return this.cat;
    }
    
    /**
     * Setter for property cat.
     * @param cat New value of property cat.
     */
    public void setCat(Category cat) {
        this.cat = cat;
    }
    
    /**
     * Getter for property longname.
     * @return Value of property longname.
     */
    public String getLongname() {
        return cat.getLongname();
    }
    
    /**
     * Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {
        return cat.getDescription();
    }
    
    /**
     * Getter for property shortname.
     * @return Value of property shortname.
     */
    public String getShortname() {
        return cat.getName().trim().replaceAll("[^a-zA-Z0-9]+", "_");
    }
    
}