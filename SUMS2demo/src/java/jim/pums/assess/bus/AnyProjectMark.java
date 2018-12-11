/*
 * AnyProjectMark.java
 *
 * Created on 22 February 2005, 16:12
 */

package jim.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import jim.util.struts.*;
import org.apache.struts.action.*;



/**
 *
 * @author  briggsj
 */
public class AnyProjectMark extends ActionForm {
    
    private CategoryMap /*CategoryMark*/ categories;
    private List /*String*/ catNames;
    
    private static final int MIN_CAT_WEIGHT = 1;
    
    private static final int MAX_CAT_WEIGHT = 3;
    
    private static final int MIN_ADJUSTMENT = -5;
    
    private static final int MAX_ADJUSTMENT = 5;
    
    private static final int MIN_COMMENT_LENGTH = 250;
    
    /**
     * Holds value of property adjustment.
     */
    private int adjustment = 0;
    
    private void init(String[] catNames) {
        this.student = new AssessStudentForm();
        this.categories = new CategoryMap();
        for (int i = 0; i<catNames.length; i++) {
            this.categories.put(catNames[i], new CategoryMark(catNames[i]));
        }
        this.adjustment = 0;
    }
    
    /** Creates a new instance of AnyProjectMark */
    public AnyProjectMark() {
//        String[] catNames = new String[]{"Review", "Design", "Context_and_objectives"};
        String[] catNames = new String[]{};
        init(catNames);
    }
    
    public void setWeights(Category[] cats) {
        catNames = new ArrayList();
        for (int i = 0; i<cats.length; i++) {
            CategoryMark cat = (CategoryMark)categories.get(cats[i].getName());
            cat.setCat(cats[i]);
            catNames.add(cats[i].getName());
        }
    }
    
    /**
     * Getter for property totalMark.
     * @return Value of property totalMark.
     */
    public int getTotalMark() throws Exception {
        Set keys = categories.keySet();
        Iterator i = keys.iterator();
        int sum = 0;
        int totalWeight = 0;
        while (i.hasNext()) {
            String name = (String)i.next();
            CategoryMark cat = (CategoryMark)categories.get(name);
            int mark = cat.getMark();
            int weight = cat.getWeight();
            sum += (mark * weight);
            totalWeight += weight;
        }
        if (totalWeight <= 0) {
            throw new IllegalStateException("Total weight of categories is " + totalWeight);
        }
        return (int)(((float)sum / totalWeight)+0.5) + adjustment;
    }
    
    /**
     * Getter for property catNames.
     * @return Value of property catNames.
     */
    public List getCatNames() {
        return catNames;
//        return new ArrayList(categories.keySet());
    }
    
    /**
     * Getter for property catAvgeMarks.
     * @return Value of property catAvgeMarks.
     */
    public Map getCatAvgeMarks() {
        Map averages = new HashMap();
        Iterator it = getCatNames().iterator();
        while (it.hasNext()) {
            String name = (String)it.next();
            CategoryMark cat = (CategoryMark)categories.get(name);
            try {
                averages.put(cat, new Integer(cat.getMark()));
            } catch (Exception e) {
                //ignore
            }
        }
        return averages;
    }
    
    /**
     * Getter for property adjustment.
     * @return Value of property adjustment.
     */
    public int getAdjustment() {
        return this.adjustment;
    }
    
    /**
     * Setter for property adjustment.
     * @param adjustment New value of property adjustment.
     */
    public void setAdjustment(int adjustment) {
        if (adjustment < this.MIN_ADJUSTMENT || adjustment > this.MAX_ADJUSTMENT) {
            throw new IllegalStateException("Adjustment of " + adjustment + " must be in the range " + MIN_ADJUSTMENT + ".." + MAX_ADJUSTMENT);
        }
        this.adjustment = adjustment;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors retValue = new JimActionErrors();
        
        Iterator it = getCatNames().iterator();
        while (it.hasNext()) {
            String name = (String)it.next();
            CategoryMark cat = (CategoryMark)categories.get(name);
            retValue.add(cat.validate(mapping, request));
        }
        int len = this.getComments().trim().length();
        if (len < MIN_COMMENT_LENGTH) {
            retValue.add("generalComments", "markform.shortComment", new Integer[] {len, MIN_COMMENT_LENGTH});
        }
        return retValue;
    }
    
    public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        super.reset(actionMapping, httpServletRequest);
        //set multibox arrays to zero length
    }
    
    /**
     * Getter for property categories.
     * @return Value of property categories.
     */
    public CategoryMap getCategories() {
        return categories;
    }
    
    /**
     * Setter for property categories.
     * @param categories New value of property categories.
     */
    public void setCategories(CategoryMap categories) {
        this.categories = categories;
    }
    
    public CategoryMark getCategories(String key){
        CategoryMark cat = (CategoryMark)categories.get(key);
        //        if (cat == null) {
        //            cat =  new CategoryMark();
        //            categories.put(key, cat);
        //        }
        return cat;
    }
    
    public void setCategories(String key, CategoryMark cat) {
        categories.put(key, cat);
    }
    
    
    static final int[] grades = new int[]{5,15,25,35,45,55,65,75,85,95};
    static final int numGrades = grades.length;
    
    /**
     * Holds value of property student.
     */
    private AssessStudentForm student;
    
    /**
     * Holds value of property comments.
     */
    private String comments;
    
    /**
     * Holds value of property examiners.
     */
    private String examiners;
    
    /**
     * Holds value of property unfair.
     */
    private boolean unfair;
    
    /**
     * Getter for property grades.
     * @return Value of property grades.
     */
    public int[] getGrades() {
        return grades;
    }
    
    public String[] getGradeStrings() {
        String[] strings = new String[grades.length];
        for (int i=0; i<grades.length; i++) {
            strings[i] = grades[i] + "";
        }
        return strings;
    }
    
    /**
     * Getter for property student.
     * @return Value of property student.
     */
    public AssessStudentForm getStudent() {
        return this.student;
    }
    
    /**
     * Setter for property student.
     * @param student New value of property student.
     */
    public void setStudent(AssessStudentForm student) {
        this.student = student;
    }
    
    /**
     * Getter for property comments.
     * @return Value of property comments.
     */
    public String getComments() {
        return this.comments;
    }
    
    /**
     * Setter for property comments.
     * @param comments New value of property comments.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * Getter for property examiners.
     * @return Value of property examiners.
     */
    public String getExaminers() {
        return this.examiners;
    }
    
    /**
     * Setter for property examiners.
     * @param examiners New value of property examiners.
     */
    public void setExaminers(String examiners) {
        this.examiners = examiners;
    }
    
    /**
     * Getter for property unfair.
     * @return Value of property unfair.
     */
    public boolean isUnfair() {
        return this.unfair;
    }
    
    /**
     * Setter for property unfair.
     * @param unfair New value of property unfair.
     */
    public void setUnfair(boolean unfair) {
        this.unfair = unfair;
    }
    
}
