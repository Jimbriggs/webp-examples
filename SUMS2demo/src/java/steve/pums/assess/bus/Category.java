/*
 * SPCategory.java
 *
 * Created on 19 July 2005, 16:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import jim.util.struts.*;
import org.apache.struts.action.*;
import jim.pums.assess.bus.*;

/**
 * Represents a mark category within the project mark form
 * @author Steve Powell
 */
public class Category extends ActionForm {
    
    /**
     * Identifier of the category
     */
    private int categoryID = 0;
    /**
     * Name of the category
     */
    private String name = null;
    /**
     * Long name of the category
     */
    private String longName = null;
    /**
     * Description of the category
     */
    private String description = null;
    /**
     * Indicates if the category is optional
     */
    private boolean optional = false;
    /**
     * Indicates the type of category
     * 
     * R - Radio
     * S - Select
     * C - Checkbox
     */
    private String optionType = null;
    /**
     * Identifies the group of options available for the category
     */
    private int optionGroup = 0;
    /**
     * The options available for the category
     */
    private Vector categoryOptions = new Vector();
    /**
     * The weight the category has in the mark calculation
     */
    private int weight = 0;
    /**
     * Comments assigned by the marker for this category
     */
    private String comments = null;
    /**
     * The options selected by the marker in this category
     */
    private int[] optionsSelected = {};
        
    /** Creates a new instance of SPCategory */
    public Category() {
    }
    
    /**
     * Creates a new instance of SPCategory with values assigned
     * @param categoryID Unique ID of category
     * @param name Name of category
     * @param longName Long name of category
     * @param description Descrpition of category
     * @param optional Indicates if category is optional
     * @param optionType Inidicates option type
     * @param optionGroup Inidicates the group of options
     * @param weight Category weight in the mark process
     */
    public Category (int categoryID, String name, String longName, String description, String optional, String optionType, int optionGroup, int weight, String critical) {
        this.setCategoryID(categoryID);
        this.setName(name);
        this.setLongName(longName);
        this.setDescription(description);
        this.setOptional(optional);
        this.setOptionType(optionType);
        this.setOptionGroup(optionGroup);
        this.setWeight(weight);
        this.setCritical(critical);
    }        

    /**
     * Getter for category name
     * @return Category name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for category name
     * @param name Category name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for category long name
     * @return Category long name
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Setter for category long name
     * @param longName Category long name
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * Getter for category description
     * @return Category name
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for category description
     * @param description Category description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for category optional
     * @return If category is optional or not
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * Setter for category optional
     * @param optional Boolean optional
     */
    public void setOptional(boolean optional) {
        this.optional = optional;
    }
    
    /**
     * Setter for category optional
     * @param optional String optional
     */
    public void setOptional(String optional) {
        
        if(optional==null||(optional.indexOf("")==-1)) {            
            this.setOptional(false);            
        } else if (optional.indexOf("Y")>-1) {            
            this.setOptional(true);            
        }
    }

    /**
     * Getter for category option type
     * @return Category option type
     */
    public String getOptionType() {
        return optionType;
    }

    /**
     * Setter for category option type
     * @param optionType Category option type
     */
    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    /**
     * Getter for category option group
     * @return Category option group
     */
    public int getOptionGroup() {
        return optionGroup;
    }

    /**
     * Adds a new option to the category
     * @param opt New option
     */
    public void addCategoryOption(Option opt) {        
        this.getCategoryOptions().add(opt);
    }
    
    /**
     * Getter for category weight
     * @return Category weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter for category weight
     * @param weight Weight of category
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter for category comments
     * @return Category comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Setter for category comments
     * @param comments Category comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Getter for category ID
     * @return Category ID
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * Setter for category ID
     * @param categoryID Category ID
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    /**
     * Validates the category during submission of the mark form
     * @param actionMapping Action Mapping
     * @param httpServletRequest Servlet request
     * @return Errors identified from validation
     */
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        
        JimActionErrors retValue = new JimActionErrors();               
        retValue.add(super.validate(actionMapping, httpServletRequest));
        
        if(!this.isOptional()) {                  
            if (this.optionsSelected.length == 0) {
                retValue.add(this.getName(), "markform.nomark", this.getName());
            }
            if(this.getOptionType().indexOf("S")>-1) {
                if(this.getOptionsSelected()[0]==-1) {
                    retValue.add(this.getName(), "markform.nomark", this.getName());
                }
            }
        }
        
        return retValue;
    }

    /**
     * Getter for category options
     * @return Category options
     */
    public Vector getCategoryOptions() {
        return categoryOptions;
    }

    /**
     * Setter for category options
     * @param categoryOptions Category options
     */
    public void setCategoryOptions(Vector categoryOptions) {
        this.categoryOptions = categoryOptions;
    }

    /**
     * Setter for category option group
     * @param optionGroup Category option group
     */
    public void setOptionGroup(int optionGroup) {
        this.optionGroup = optionGroup;    
    }
    
    /**
     * Getter for selected category options
     * @return Selected category options
     */
    public int[] getOptionsSelected() {
        return optionsSelected;
    }

    /**
     * Setter for options selected in category
     * @param optionsSelected Array of selected options
     */
    public void setOptionsSelected(int[] optionsSelected) {
            this.optionsSelected = null;
            this.optionsSelected = optionsSelected;
    }
    
    /**
     * Counts the number of available options
     * @return The count of options
     */
    public int getOptCount() {        
        return this.categoryOptions.size();
    }
    
    /**
     * Getter for category mark
     * @return Mark awarded for category
     * @throws java.lang.Exception In the event of lang error
     */
    public int getMark() throws Exception {
        return average(optionsSelected);
    }   
    
    /**
     * Calculates an average mark from multiple option selections
     * @return Average mark for category
     * @throws java.lang.Exception As a result of lang error
     * @param optionsSelected Options selected
     */
    private int average(int[] optionsSelected) throws Exception {
        
        int sum = 0;
        if (optionsSelected == null || optionsSelected.length <= 0 || optionsSelected[0] == -1) {
            return -1;
        }
        for (int i=0; i<optionsSelected.length; i++) {
            
            Option opt = (Option)categoryOptions.get(optionsSelected[i]);

            int mk = (int)opt.getValue();

            if (mk < 0 || mk > 100) {
                throw new Exception("Mark of " + mk + " out of range 0..100");
            }
            sum += mk;
        }
        if(sum==0) {
            return 0;
        } else {
            return Math.round((float)sum / optionsSelected.length);
        }
      }    

    /**
     * Holds value of property critical.
     */
    private boolean critical;

    /**
     * Getter for property critical.
     * @return Value of property critical.
     */
    public boolean isCritical() {
        return this.critical;
    }

    /**
     * Setter for property critical.
     * @param critical New value of property critical.
     */
    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    /**
     * Setter for category optional
     * @param optional String optional
     */
    public void setCritical(String critical) {
        
        if(critical==null||(critical.indexOf("")==-1)) {            
            this.setCritical(false);            
        } else if (critical.indexOf("Y")>-1) {            
            this.setCritical(true);            
        }
    }
    
    /**
     * Getter for property commentLength.
     * @return Length of property comment.
     */
    public int getCommentLength() {
        return this.getComments().trim().length();
    }
}
