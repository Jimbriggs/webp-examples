/*
 * LoadCohortForm.java
 *
 * Created on 15 September 2005, 14:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jim.pums.assess.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author briggsj
 */
public class LoadCohortForm extends ActionForm {
    
    static private SimpleDateFormat sdf = new SimpleDateFormat("d/M/yy");
    
    /**
     * Creates a new instance of LoadCohortForm
     */
    public LoadCohortForm() {
    }
    
    /**
     * Holds value of property cohort.
     */
    private String cohort;
    
    /**
     * Getter for property cohort.
     * @return Value of property cohort.
     */
    public String getCohort() {
        
        return this.cohort;
    }
    
    /**
     * Setter for property cohort.
     * @param cohort New value of property cohort.
     */
    public void setCohort(String cohort) {
        
        this.cohort = cohort;
    }
    
    /**
     * Holds value of property studentFile.
     */
    private FormFile studentFile;
    
    /**
     * Getter for property studentFile.
     * @return Value of property studentFile.
     */
    public FormFile getStudentFile() {
        
        return this.studentFile;
    }
    
    /**
     * Setter for property studentFile.
     * @param studentFile New value of property studentFile.
     */
    public void setStudentFile(FormFile studentFile) {
        
        this.studentFile = studentFile;
    }
    
    /**
     * Holds value of property staffFile.
     */
    private FormFile staffFile;
    
    /**
     * Getter for property staffFile.
     * @return Value of property staffFile.
     */
    public FormFile getStaffFile() {
        
        return this.staffFile;
    }
    
    /**
     * Setter for property staffFile.
     * @param staffFile New value of property staffFile.
     */
    public void setStaffFile(FormFile staffFile) {
        
        this.staffFile = staffFile;
    }
    
    /**
     * Holds value of property cohortID.
     */
    private int cohortID;
    
    /**
     * Getter for property cohortID.
     * @return Value of property cohortID.
     */
    public int getCohortID() {
        return this.cohortID;
    }
    
    /**
     * Setter for property cohortID.
     * @param cohortID New value of property cohortID.
     */
    public void setCohortID(int cohortID) {
        this.cohortID = cohortID;
    }
    
    /**
     * Holds value of property deadline.
     */
    private Date deadline;
    
    /**
     * Getter for property deadline.
     * @return Value of property deadline.
     */
    public Date getDeadline() {
        return this.deadline;
    }
    
    /**
     * Setter for property deadline.
     * @param deadline New value of property deadline.
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    /**
     * Getter for property deadlineStr.
     * @return Value of property deadlineStr.
     */
    public String getDeadlineStr() {
        if (deadline == null) {
            return "";
        } else {
            return deadline.toString();
        }
    }
    
    /**
     * Setter for property deadlineStr.
     * @param deadlineStr New value of property deadlineStr.
     */
    public void setDeadlineStr(String deadlineStr) throws ParseException {
        if ("".equals(deadlineStr)) {
            deadline = null;
        } else {
            deadline = sdf.parse(deadlineStr);
        }
    }
    
    
    
}
