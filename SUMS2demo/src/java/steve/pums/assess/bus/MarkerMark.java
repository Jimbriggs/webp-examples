/*
 * MarkerMarks.java
 *
 * Created on 09 August 2005, 10:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.util.Date;

/**
 * Represents an individual project mark
 * @author Steve Powell
 */
public class MarkerMark implements java.io.Serializable {
    
    /**
     * Name of marker
     */
    private String marker = null;
    /**
     * ID of marker
     */
    private int personID = 0;
    /**
     * Date of mark
     */
    private Date markdate = null;
    /**
     * Mark assigned
     */
    private int mark = 0;
    
    /** Creates a new instance of MarkerMarks */
    public MarkerMark() {
    }
        
    /**
     * Creates a new instance of MarkerMarks with values
     * @param marker Marker name
     * @param personID Marker ID
     * @param markdate Mark date
     * @param mark Mark
     */
    public MarkerMark(String marker, int personID, Date markdate, int mark, boolean plagiarismSuspect) {
        this.setMarker(marker);
        this.setPersonID(personID);
        this.setMarkdate(markdate);
        this.setMark(mark);
        this.setPlagiarismSuspect(plagiarismSuspect);
    }  
    
    /**
     * Getter for marker name
     * @return Marker name
     */
    public String getMarker() {
        return marker;
    }

    /**
     * Setter for marker name
     * @param marker Marker name
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * Getter for marker ID
     * @return Marker ID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * Setter for marker ID
     * @param personID Marker ID
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * Getter for mark date
     * @return Mark date
     */
    public Date getMarkdate() {
        return markdate;
    }

    /**
     * Setter for mark date
     * @param markdate Mark date
     */
    public void setMarkdate(Date markdate) {
        this.markdate = markdate;
    }

    /**
     * Getter for mark
     * @return Mark
     */
    public int getMark() {
        return mark;
    }

    /**
     * Setter for mark
     * @param mark Mark
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Holds value of property plagiarismSuspect.
     */
    private boolean plagiarismSuspect;

    /**
     * Getter for property plagiarismSuspect.
     * @return Value of property plagiarismSuspect.
     */
    public boolean isPlagiarismSuspect() {
        return this.plagiarismSuspect;
    }

    /**
     * Setter for property plagiarismSuspect.
     * @param plagiarismSuspect New value of property plagiarismSuspect.
     */
    public void setPlagiarismSuspect(boolean plagiarismSuspect) {
        this.plagiarismSuspect = plagiarismSuspect;
    }
    

}
