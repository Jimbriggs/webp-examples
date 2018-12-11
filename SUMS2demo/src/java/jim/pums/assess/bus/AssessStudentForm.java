/*
 * AssessStudentForm.java
 *
 * Created on 27 April 2005, 21:37
 */

package jim.pums.assess.bus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import jim.util.struts.JimActionErrors;
import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author  briggsj
 */
public class AssessStudentForm extends ValidatorForm {
    
    /**
     * Holds value of property studentName.
     */
    private String studentName;
    
    /**
     * Holds value of property unit.
     */
    private String unit;
    
    /**
     * Holds value of property marker.
     */
    private String marker;
    
    /**
     * Holds value of property studentNumber.
     */
    private String studentNumber;
    
    /**
     * Holds value of property date.
     */
    private Date date;
    
    /**
     * Holds value of property cohort.
     */
    private String cohort;
    
    /**
     * Holds value of property supervisor.
     */
    private String supervisor;
    
    /**
     * Holds value of property projectTitle.
     */
    private String projectTitle;
    
    /**
     * Holds value of property status.
     */
    private String status;
    
    /** Creates a new instance of AssessStudentForm */
    public AssessStudentForm() {
    }
    
    /**
     * Getter for property studentName.
     * @return Value of property studentName.
     */
    public String getStudentName() {
        return this.studentName;
    }
    
    /**
     * Setter for property studentName.
     * @param studentName New value of property studentName.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    /**
     * Getter for property unit.
     * @return Value of property unit.
     */
    public String getUnit() {
        return this.unit;
    }
    
    /**
     * Setter for property unit.
     * @param unit New value of property unit.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors err = new JimActionErrors();
        err.add(super.validate(mapping, request));
        
        if (studentName == null || "".equals(studentName)) {
            err.add("studentName", "markForm.studentname", studentName);
        } else {
            if (! studentName.matches("[\\w'-]+( [\\w'-]+)+") && ! studentName.matches("\\d{5,12}")) {
                err.add("studentName", "markForm.badstudentname", studentName);
            }
        }
        //        if (studentNumber == null || "".equals(studentNumber)) {
        //            err.add("studentNumber", "markForm.studentnumber", studentNumber);
        //        } else if (! studentNumber.matches("\\d{5,12}")) {
        //            err.add("studentNumber", "markForm.badstudentnumber", studentNumber);
        //        }
        if (marker == null || "".equals(marker)) {
            err.add("marker", "markForm.marker", marker);
        }
        if (unit == null || "".equals(unit)) {
            err.add("unit", "markForm.unit", unit);
        }
        if (status == null || "".equals(status)) {
            err.add("status", "markForm.status", status);
        }
        if (projectTitle == null || "".equals(projectTitle)) {
            err.add("projectTitle", "markForm.projectTitle", projectTitle);
        }
        return err;
    }
    
    /**
     * Getter for property marker.
     * @return Value of property marker.
     */
    public String getMarker() {
        return this.marker;
    }
    
    /**
     * Setter for property marker.
     * @param marker New value of property marker.
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }
    
    /**
     * Getter for property studentNumber.
     * @return Value of property studentNumber.
     */
    public String getStudentNumber() {
        return this.studentNumber;
    }
    
    /**
     * Setter for property studentNumber.
     * @param studentNumber New value of property studentNumber.
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    /**
     * Getter for property date.
     * @return Value of property date.
     */
    public Date getDate() {
        return this.date;
    }
    
    /**
     * Setter for property date.
     * @param date New value of property date.
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
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
     * Getter for property supervisor.
     * @return Value of property supervisor.
     */
    public String getSupervisor() {
        return this.supervisor;
    }
    
    /**
     * Setter for property supervisor.
     * @param supervisor New value of property supervisor.
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    
    /**
     * Getter for property projectTitle.
     * @return Value of property projectTitle.
     */
    public String getProjectTitle() {
        return this.projectTitle;
    }
    
    /**
     * Setter for property projectTitle.
     * @param projectTitle New value of property projectTitle.
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
    
    /**
     * Getter for property status.
     * @return Value of property status.
     */
    public String getStatus() {
        return this.status;
    }
    
    /**
     * Setter for property status.
     * @param status New value of property status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
