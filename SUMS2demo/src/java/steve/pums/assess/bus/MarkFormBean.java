/*
 * SPMarkFormBean.java
 *
 * Created on 19 July 2005, 16:26
 *
 * This bean represents a project mark form.
 *
 */

package steve.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import jim.util.struts.*;
import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;


/**
 * Represents a project marking form
 * @author Steve Powell
 */

public class MarkFormBean extends ValidatorForm {
    
    /** Creates a new instance of SPMarkFormBean */
    public MarkFormBean() {
    }
    
    /**
     * Name of mark form
     */
    private String formName = null;
    /**
     * ID of mark form
     */
    private int formID = 0;
    /**
     * ID of project being marked
     */
    private int projectID = 0;
    /**
     * ID of mark (used for recall of previously entered data)
     */
    private int markID = 0;
    /**
     * ID Capacity of marker
     */
    private int markerCapacity = 0;
    /**
     * Text capacity of marker
     */
    private String markerCapacityDesc = null;
    /**
     * Identifies marker
     */
    private StaffBean marker = null;
    /**
     * ID of person entering mark
     */
    private int markEnteredBy = 0;
    /**
     * Indicates if marker suspects plagiarism
     */
    private boolean plagiarismSuspect = false;
    /**
     * General marker comments
     */
    private String generalComments = "";
    /**
     * Marker comments for exam board
     */
    private String examinerComments = "";
    /**
     * Collection of categories associated with the mark form
     */
    private Vector formCategories = new Vector();
    /**
     * Adjustment applied to project mark
     */
    private int adjustment = 0;
    /**
     * Project mark
     */
    private int projectMark = 0;
    /**
     * Collection of prize nominations
     */
    private Vector prizeNominations = new Vector();
    /**
     * Prize ID - new nomination
     */
    private int prizeID = 0;
    /**
     * Prize justification - new nomination
     */
    private String justification = null;
    
    /**
     * Getter for mark form name
     * @return Mark form name
     */
    public String getFormName() {
        return formName;
    }
    
    /**
     * Setter for mark form name
     * @param formName Mark form name
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }
    
    /**
     * Getter for mark form ID
     * @return Mark form ID
     */
    public int getFormID() {
        return formID;
    }
    
    /**
     * Setter for mark form ID
     * @param formID Mark form ID
     */
    public void setFormID(int formID) {
        this.formID = formID;
    }
    
    /**
     * Getter for mark form project ID
     * @return Mark form project ID
     */
    public int getProjectID() {
        return projectID;
    }
    
    /**
     * Setter for mark form project ID
     * @param projectID Project ID
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    /**
     * Getter for mark form suspected plagiarism
     * @return If project is suspected of plagiarism
     */
    public boolean isPlagiarismSuspect() {
        return plagiarismSuspect;
    }
    
    /**
     * Setter for mark form suspected plagiarism
     * @param plagiarismSuspect Suspected plagiarism
     */
    public void setPlagiarismSuspect(boolean plagiarismSuspect) {
        this.plagiarismSuspect = plagiarismSuspect;
    }
    
    /**
     * Getter for mark form suspected plagiarism
     * @return Mark form suspected plagiarism
     */
    public String getPlagiarismSuspect() {
        if (this.plagiarismSuspect) {
            return "Yes";
        } else {
            return "No";
        }
    }
    
    /**
     * Getter for mark form general comments
     * @return Mark form general comments
     */
    public String getGeneralComments() {
        return generalComments;
    }
    
    /**
     * Setter for mark form general comments
     * @param generalComments General comments
     */
    public void setGeneralComments(String generalComments) {
        this.generalComments = generalComments;
    }
    
    /**
     * Getter for mark form comments
     * @return Mark form comments
     */
    public String getExaminerComments() {
        return examinerComments;
    }
    
    /**
     * Setter for mark form examiner comments
     * @param examinerComments Mark form examiner comments
     */
    public void setExaminerComments(String examinerComments) {
        this.examinerComments = examinerComments;
    }
    
    /**
     * Adds a new mark category to the form
     * @param cat Mark category
     */
    public void addFormCategory(Category cat) {
        getFormCategories().add(cat);
    }
    
    /**
     * Adds a new prize nomination to the mark form
     * @param nom Prize nomination
     */
    public void addPrizeNomination(PrizeNomination nom) {
        getPrizeNominations().add(nom);
    }
    
    /**
     * Getter for mark form adjustment
     * @return Mark form adjustment
     */
    public int getAdjustment() {
        return adjustment;
    }
    
    /**
     * Setter for mark form mark adjustment
     * @param adjustment Mark adjustment
     */
    public void setAdjustment(int adjustment) {
        this.adjustment = adjustment;
    }
    
    /**
     * Getter for mark form mark
     * @return Mark
     * @throws java.lang.Exception In the event of lang exception
     */
    public int getProjectMark() throws Exception {
        
        Iterator it = getFormCategories().iterator();
        int sum = 0;
        int totalWeight = 0;
        boolean capped = false;
        
        while (it.hasNext()) {
            Category cat = (Category) it.next();
            if (cat.getMark()>-1) {
                sum += (cat.getMark() * cat.getWeight());
                totalWeight += cat.getWeight();
            } else if ((cat.getMark()==-1) && (!cat.isOptional())) {
                return -1;
            }
            //if the category is "critical" and the mark in the category is less than 40, the student is capped at 39
            if (cat.getMark() < 40 && cat.isCritical()) {
                capped = true;
            }
        }
        if (totalWeight <= 0) {
            throw new IllegalStateException("Total weight of categories is " + totalWeight);
        }
        if(sum==0){
            return 0;
        } else {
            int mark = (int)(((float)sum / totalWeight)+0.5) + adjustment;
            if (capped && mark >= 40) {
                mark = 39;
            }
            return mark;
        }
        
    }
    
    private static final int MIN_COMMENT_LENGTH = 15;
    private static final int MIN_TOTAL_COMMENT_LENGTH = 250;
    
    /**
     * Validates the mark form on submission
     * @return Errors identified during validation
     * @param mapping Action Mapping
     * @param request Servlet request
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors retValue = new JimActionErrors();
        int totalCommentLength = 0;
        
        Iterator it = getFormCategories().iterator();
        
        while (it.hasNext()) {
            Category cat = (Category) it.next();
            retValue.add(cat.validate(mapping, request));
            totalCommentLength += cat.getCommentLength();
        }
        
        if(((getPrizeID()>0)&&(getJustification().length()==0))||((getPrizeID()==0)&&(getJustification().length()>0))){
            retValue.add("prizeerr","markform.prize","prizeerr");
        }
        
        updatePrizes();
        int generalCommentLength = this.getGeneralComments().trim().length();
        if (generalCommentLength < MIN_COMMENT_LENGTH) {
            retValue.add("generalComments", "markform.shortComment", new Integer[] {generalCommentLength, MIN_COMMENT_LENGTH, MIN_COMMENT_LENGTH-generalCommentLength});
        } else {
            totalCommentLength += generalCommentLength;
            if (totalCommentLength < MIN_TOTAL_COMMENT_LENGTH) {
                retValue.add("generalComments", "markform.shortComment", new Integer[] {totalCommentLength, MIN_TOTAL_COMMENT_LENGTH, MIN_TOTAL_COMMENT_LENGTH-totalCommentLength});
            }
        }
        return retValue;
    }
    
    /**
     * Adds the new prize nomination to the collection of existing nominations
     */
    private void updatePrizes() {
        
        if ((getPrizeID()>0)&&(getJustification().length()>0)) {
            addPrizeNomination(new PrizeNomination(getPrizeID(),getJustification()));
            resetPrize();
        }
        
        Iterator noms = getPrizeNominations().iterator();
        Vector newnoms = new Vector();
        
        while (noms.hasNext()) {
            PrizeNomination nom = (PrizeNomination)noms.next();
            if (nom.getDelete().length==0) {
                newnoms.add(nom);
            }
        }
        setPrizeNominations(newnoms);
    }
    
    /**
     * Getter for mark form categories
     * @return Mark form categories
     */
    public Vector getFormCategories() {
        return formCategories;
    }
    
    /**
     * Getter for mark form prize nominations
     * @return Collection of prize nominations
     */
    public Vector getPrizeNominations() {
        return prizeNominations;
    }
    
    /**
     * Counts the number of mark form categories
     * @return Count of mark form categoies
     */
    public int getCatCount() {
        return this.getFormCategories().size();
    }
    
    /**
     * Checks if all categories have the same amount of options
     * @return If all categories have the same amount of options
     */
    public boolean isAllOptionsSame() {
        
        Iterator cat = getFormCategories().iterator();
        Category catgry = (Category)cat.next();
        int group = catgry.getOptionGroup();
        
        while(cat.hasNext()) {
            catgry = (Category)cat.next();
            if (!(catgry.getOptionGroup()==group)) return false;
        }
        
        return true;
    }
    
    /**
     * Checks if all categories use multiple input types such as radio or checkbox
     * @return If all categories use same input
     */
    public boolean isAllOptionsMulti() {
        
        Iterator cat = getFormCategories().iterator();
        Category catgry = null;
        
        while(cat.hasNext()) {
            catgry = (Category)cat.next();
            if (catgry.getOptionType().equals("S")) return false;
        }
        
        return true;
    }
    
    
    /**
     * Works out which category has the most options, helps with generation of mark form table
     * @return Category count
     */
    public int getMostOptions() {
        
        Iterator cat = getFormCategories().iterator();
        Category catgry = (Category)cat.next();
        
        int size = 0;
        int cursize = 0;
        
        if (catgry.getOptionType().indexOf("S")>-1) {
            size = 1;
        } else {
            size = catgry.getCategoryOptions().size();
        }
        
        while(cat.hasNext()) {
            
            catgry = (Category)cat.next();
            
            if (catgry.getOptionType().indexOf("S")>-1) {
                cursize = 1;
            } else {
                cursize = catgry.getCategoryOptions().size();
            }
            
            if (cursize>size)
                size = cursize;
        }
        
        return size;
    }
    
    /**
     * Clears out the prize nominations
     */
    public void resetPrize() {
        this.setPrizeID(0);
        this.setJustification(null);
    }
    
    /**
     * Getter for mark form prize ID
     * @return ID of prize
     */
    public int getPrizeID() {
        return prizeID;
    }
    
    /**
     * Setter for mark form prize nomination ID
     * @param prizeID ID of prize
     */
    public void setPrizeID(int prizeID) {
        this.prizeID = prizeID;
    }
    
    /**
     * Getter for mark form prize justification
     * @return Nomination justification
     */
    public String getJustification() {
        return justification;
    }
    
    /**
     * Setter for mark form prize justification
     * @param justification Justification of prize nomination
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }
    
    /**
     * Counts the number of prize nominations
     * @return Prize nomination count
     */
    public int getNomCount() {
        return getPrizeNominations().size();
    }
    
    /**
     * Setter for collection of prize nominations
     * @param prizeNominations Collection of prize nominations
     */
    public void setPrizeNominations(Vector prizeNominations) {
        this.prizeNominations = prizeNominations;
    }
    
    /**
     * Getter for mark form mark ID
     * @return Mark ID
     */
    public int getMarkID() {
        return markID;
    }
    
    /**
     * Setter for mark form mark ID
     * @param markID Mark ID
     */
    public void setMarkID(int markID) {
        this.markID = markID;
    }
    
    /**
     * Setter for mark form categories
     * @param formCategories Collection of mark categories
     */
    public void setFormCategories(Vector formCategories) {
        this.formCategories = formCategories;
    }
    
    /**
     * Getter for mark form marker capacity ID
     * @return Marker capacity
     */
    public int getMarkerCapacity() {
        return markerCapacity;
    }
    
    /**
     * Setter for mark form marker capacity ID
     * @param markerCapacity Marker capacity ID
     */
    public void setMarkerCapacity(int markerCapacity) {
        this.markerCapacity = markerCapacity;
    }
    
    /**
     * Getter for mark form marker
     * @return Marker
     */
    public StaffBean getMarker() {
        return marker;
    }
    
    /**
     * Setter for mark form marker
     * @param marker Marker
     */
    public void setMarker(StaffBean marker) {
        this.marker = marker;
    }
    
    /**
     * Getter for mark form marker capacity description
     * @return Marker capacity string
     */
    public String getMarkerCapacityDesc() {
        return markerCapacityDesc;
    }
    
    /**
     * Setter for mark form marker capacity string
     * @param markerCapacityDesc Marker capacity string
     */
    public void setMarkerCapacityDesc(String markerCapacityDesc) {
        this.markerCapacityDesc = markerCapacityDesc;
    }
    
    /**
     * Getter for person completing mark form
     * @return Person ID of person entering mark
     */
    public int getMarkEnteredBy() {
        return markEnteredBy;
    }
    
    /**
     * Setter for ID of person entering the mark
     * @param markEnteredBy ID of person entering the mark
     */
    public void setMarkEnteredBy(int markEnteredBy) {
        this.markEnteredBy = markEnteredBy;
    }
    
    /**
     * Loads mark form data into a HashMap for email sending
     * @param markFormMap If needing to add to existing map
     * @throws java.lang.Exception In the event of lang exception
     * @return Map of mark form data
     */
    public Map<String,Object> getMarkFormMap(Map<String,Object> markFormMap) throws java.lang.Exception {
        
        markFormMap.put("MARKFORMMARK", String.valueOf(getProjectMark()));
        markFormMap.put("MARKWEIGHT", String.valueOf(getAdjustment()));
        markFormMap.put("GENERALCOMMENTS", getGeneralComments());
        markFormMap.put("EXAMCOMMENTS", getExaminerComments());
        markFormMap.put("PLAGIARISM", getPlagiarismSuspect());
        markFormMap.put("CATMARKS", getCatMarksString());
        
        return markFormMap;
        
    }
    
    /**
     * Loads mark form data into a HashMap for email sending
     * @return Mark of mark form data
     * @throws java.lang.Exception In the event of lang exception
     */
    public Map getMarkFormMap() throws java.lang.Exception {
        
        Map markFormMap = new HashMap();
        
        return getMarkFormMap(markFormMap);
        
    }
    
    /**
     * Creates a string to identify category marks
     * @return Category mark string
     * @throws java.lang.Exception In the event of lang exception
     */
    private String getCatMarksString() throws java.lang.Exception {
        
        String catmarks = "";
        
        Iterator it = getFormCategories().iterator();
        
        while (it.hasNext()) {
            Category cat = (Category) it.next();
            catmarks += cat.getLongName();
            catmarks += " - ";
            catmarks += String.valueOf(cat.getMark());
            catmarks += "% \n";
        }
        
        return catmarks;
    }
    
}
