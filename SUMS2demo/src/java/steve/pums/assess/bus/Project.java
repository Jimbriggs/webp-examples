/*
 * SPProject.java
 *
 * Created on 23 July 2005, 09:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;
import java.util.ArrayList;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
import jim.util.struts.*;
import org.apache.struts.validator.ValidatorActionForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a student project
 * @author Steve Powell
 */
public class Project extends ValidatorActionForm implements Comparable {
    
    /**
     * Project ID
     */
    private int projectID = 0;
    /**
     * Project status code
     */
    private String status = "NS";
    /**
     * Project status description
     */
    private String statusDesc = "Not submitted";
    /**
     * Project student ID
     */
    private int studentID = -1;
    /**
     * Project unit ID
     */
    private int unitID = -1;
    /**
     * Project cohort
     */
    private int cohortID = -1;
    /**
     * Project title
     */
    private String title = null;
    /**
     * Project submission date
     */
    private java.util.Date datesubmitted = null;
    /**
     * Project late handin?
     */
    private String latehandin = null;
    /**
     * Project markers
     */
    private Map<String, StaffBean> markers = new HashMap<String, StaffBean>();
    /**
     * Project marks
     */
    private Map<String, MarkerMark> markermarks = new HashMap<String, MarkerMark>();
    /**
     * Project co-ordinators
     */
    private List<StaffBean> coordinators = new ArrayList<StaffBean>();
    /**
     * Overall project mark
     */
    private int mark = 0;
    /**
     * Overall project comments
     */
    private String comments = "";
    /**
     * Flag for overiding reconcilliation limits
     */
    private boolean needoverride = false;
    /**
     * Overrides reconcilliation limits
     */
    private int overrideReconMark = 0;
    
    /** Creates a new instance of SPProject */
    public Project() {
    }
    
    /**
     * Getter for project student
     * @return Student ID
     */
    public int getStudentID()  {
        
        return studentID;
    }
    
    /**
     * Setter for project student
     * @param student Student
     */
    public void setStudentID(int studentID)  {
        
        this.studentID = studentID;
    }
    
    /**
     * Getter for project unit
     * @return Unit ID
     */
    public int getUnitID()  {
        return unitID;
    }
    
    /**
     * Setter for project unit
     * @param unit Unit ID
     */
    public void setUnitID(int unitID)  {
        this.unitID = unitID;
    }
    
    /**
     * Getter for project cohort
     * @return Cohort ID
     */
    public int getCohortID()  {
        return cohortID;
    }
    
    /**
     * Setter for project cohort
     * @param cohort Cohort ID
     */
    public void setCohortID(int cohortID)  {
        this.cohortID = cohortID;
    }
    
    /**
     * Getter for project title
     * @return Project title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Setter for project title
     * @param title Project title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Getter for project submission date
     * @return Submission date
     */
    public java.util.Date getDatesubmitted() {
        return datesubmitted;
    }
    
    /**
     * Setter for project submission date
     * @param datesubmitted Project submission date
     */
    public void setDatesubmitted(java.util.Date datesubmitted) {
        this.datesubmitted = datesubmitted;
    }
    
    /**
     * Getter for project late handin?
     * @return Late handin?
     */
    public String getLatehandin() {
        return latehandin;
    }
    
    /**
     * Setter for project late handin?
     * @param latehandin Project late handin?
     */
    public void setLatehandin(String latehandin) {
        this.latehandin = latehandin;
    }
    
    /**
     * Validates project data for registration of a new project
     * @param mapping Action mapping
     * @param request Servlet request
     * @return Errors identified during validation
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors err = new JimActionErrors();
        err.add(super.validate(mapping, request));
        
        if(getStatus().equals("A")) {
            if (getSupervisorID()==0) {
                err.add("supervisor","projectForm.supervisor","is required");
            }
            
            if (getModerator()==0) {
                err.add("moderator","projectForm.moderator","is required");
            }
            
            if((getSupervisorID()==getModerator()) && getSupervisorID()!=0) {
                err.add("supervisor", "projectForm.supmoddup", "");
            }
        }
        
        if((getStatus().contains("R"))&&(!getStatus().contains("M"))&&(getOverrideReconMark()==0)) {
            
            if(!((getMark()>=getLowestMark())&&(getMark()<=getHighestMark()))) {
                err.add("mark","reconForm.markrange","between " + getLowestMark() + "% and " + getHighestMark() + "%");
                this.setNeedoverride(true);
            }
            
        }
        
        if((getStatus().contains("R"))&&(!getStatus().contains("M"))&&(getOverrideReconMark()==1)) {
            if(!((getMark()>0)&&(getMark()<=100))) {
                err.add("mark","reconForm.mark","must be between 1% and 100%");
                this.setNeedoverride(true);
            }
            
        }
        
        return err;
    }
    
    /**
     * Getter for project ID
     * @return Project ID
     */
    public int getProjectID() {
        return projectID;
    }
    
    /**
     * Setter for project ID
     * @param projectID Project ID
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    /**
     * Getter for project student description
     * @return Student description
     */
    public String getStudentTxt() {
        if (student == null) {
            return "Unknown student";
        } else {
            return student.getNameAndId();
        }
    }
    
    /**
     * Getter for project unit description
     * @return Unit description
     */
    public String getUnitTxt() {
        if (unit == null) {
            return "Unit unknown";
        } else {
            return unit.getDescription();
        }
    }
    
    /**
     * Getter for project cohort description
     * @return Cohort description
     */
    public String getCohortTxt() {
        if (cohort == null) {
            return "Cohort unknown";
        } else {
            return cohort.getCohortDesc();
        }
    }
    
    /**
     * Getter for project status
     * @return Project status code
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Setter for project status
     * @param status Status code
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Getter for project mark
     * @return Project mark
     */
    public int getMark() {
        return mark;
    }
    
    /**
     * Setter for project mark
     * @param mark Project mark
     */
    public void setMark(int mark) {
        this.mark = mark;
    }
    
    /**
     * Getter for project markers
     * @return Project markers
     */
    public Map<String, StaffBean> getMarkers() {
        return markers;
    }
    
    /**
     * Setter for project markers
     * @param markers Map of project markers
     */
    public void setMarkers(Map<String, StaffBean> markers) {
        this.markers = markers;
    }
    
    /**
     * Adds a marker to the project markers collection
     * @param capacity Marker capacity
     * @param staff Marker
     */
    public void addMarker(String capacity, StaffBean staff) {
        this.markers.put(capacity, staff);
    }
    
    /**
     * Getter for project marker marks
     * @return Project marker marks
     */
    public Map<String, MarkerMark> getMarkermarks() {
        return markermarks;
    }
    
    /**
     * Setter for project marker marks
     * @param markermarks Map of marker marks
     */
    public void setMarkermarks(Map<String, MarkerMark> markermarks) {
        this.markermarks = markermarks;
    }
    
    /**
     * Gets the lowest mark assigned
     * @return Lowest marker mark
     */
    private int getLowestMark() {
        int lowestmark = -1;
        for (Iterator iter = markermarks.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry)iter.next();
            int currmark = ((MarkerMark)entry.getValue()).getMark();
            if (lowestmark == -1) {
                lowestmark = currmark;
            } else if (currmark < lowestmark) {
                lowestmark = currmark;
            }
        }
        if (lowestmark == -1) {
            lowestmark = 0;
        }
        return lowestmark;
    }
    
    /**
     * Gets the highest mark assigned
     * @return Highest marker mark
     */
    private int getHighestMark() {
        int highestmark = -1;
        for (Iterator iter = markermarks.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry)iter.next();
            int currmark = ((MarkerMark)entry.getValue()).getMark();
            if (highestmark == -1) {
                highestmark = currmark;
            } else if (currmark > highestmark) {
                highestmark = currmark;
            }
        }
        if (highestmark == -1) {
            highestmark = 100;
        }
        return highestmark;
    }
    
    /**
     * Setter for project supervisor
     * @param supervisor Supervisor person ID
     */
    public void setSupervisorID(int supervisor) {
        addMarker("Supervisor", new StaffBean(supervisor));
    }
    
    /**
     * Setter for project moderator
     * @param moderator Moderator person ID
     */
    public void setModeratorID(int moderator) {
        addMarker("Moderator", new StaffBean(moderator));
    }
    
    /**
     * Getter for project marker for a particular role
     * @return Staff member
     * @param capacity Marker capacity
     */
    public StaffBean getMarker(String capacity) {
        if (markers.containsKey(capacity)) {
            return (StaffBean)markers.get(capacity);
        } else {
            return null;
        }
    }
    
    /**
     * Getter for project supervisor
     * @return Project supervisor
     */
    public int getSupervisorID() {
        StaffBean sb = getMarker("Supervisor");
        if (sb == null) {
            return 0;
        } else {
            return sb.getID();
        }
    }
    
    public String getSupervisorName() {
        StaffBean sb = getMarker("Supervisor");
        if (sb == null) {
            return "No supervisor";
        } else {
            return sb.getName();
        }
    }
    
    /**
     * Getter for project moderator
     * @return Project moderator
     */
    public int getModerator() {
        StaffBean sb = getMarker("Moderator");
        if (sb == null) {
            return 0;
        } else {
            return sb.getID();
        }
    }
    
    public String getModeratorName() {
        StaffBean sb = getMarker("Moderator");
        if (sb == null) {
            return "No moderator";
        } else {
            return sb.getName();
        }
    }
    
    /**
     * Getter for project co-ordinators
     * @return Collection of project co-ordinators
     */
    public List<StaffBean> getCoordinators() {
        return coordinators;
    }
    
    /**
     * Setter for project co-ordinators
     * @param coordinators Map of project co-ordinators
     */
    public void setCoordinators(List<StaffBean> coordinators) {
        this.coordinators = coordinators;
    }
    
    /**
     * Adds a co-ordinator to the collection of project co-ordinators
     * @param coordinator Co-ordinator
     */
    public void addCoordinator(StaffBean coordinator) {
        this.coordinators.add(coordinator);
    }
    
    /**
     * Checks if a person is a co-ordinator for a particular project
     * @param person Person ID
     * @return true if person is a co-ordinator
     * false if not
     */
    public boolean isPersonCoordinator(int person) {
        
        boolean isCoordinator = false;
        
        Iterator coords = this.coordinators.iterator();
        
        while (coords.hasNext()) {
            if (((StaffBean)coords.next()).getID()==person) { isCoordinator = true; }
        }
        
        return isCoordinator;
        
    }
    
    /**
     * Getter for project status description
     * @return Project status description
     */
    public String getStatusDesc() {
        return statusDesc;
    }
    
    /**
     * Setter for project status description
     * @param statusDesc Status description
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
    
    /**
     * Getter for project comments
     * @return Project comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Setter for project comments
     * @param comments Project comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * Retrieves project data as a hashmap for sending emails
     * @return Map of project data
     * @param projMap Existing map to add data to
     */
    public Map<String,Object> getProjectMap(Map<String,Object> projMap) {
        
        String markers = "";
        
        projMap.put("ID", String.valueOf(getProjectID()));
        projMap.put("STATUS", getStatusDesc());
        projMap.put("STUDENT", getStudentTxt());
        projMap.put("UNIT",  getUnitTxt());
        projMap.put("COHORT",  getCohortTxt());
        projMap.put("TITLE", getTitle());
        projMap.put("DATESUBMIT", getDatesubmitted());
        projMap.put("LATEHANDIN", getLatehandin());
        
        if(getMark()==0) {
            projMap.put("MARK",  "Not assigned");
        } else {
            projMap.put("MARK",  String.valueOf(getMark())+"%");
        }
        
        if(getComments() == null || getComments().equals("")) {
            projMap.put("COMMENTS", "Not set");
        } else {
            projMap.put("COMMENTS", getComments());
        }
        if (getReconComments() == null || "".equals(getReconComments())) {
            projMap.put("RECONCOMMENTS", "Not set");
        } else {
            projMap.put("RECONCOMMENTS", getReconComments());
        }
        
        if(getMarkers().containsKey("Supervisor")) {
            markers += "Supervisor: " + ((StaffBean)getMarkers().get("Supervisor")).getName() + "\n";
        }
        
        if(getMarkers().containsKey("Moderator")) {
            markers += "Moderator: " + ((StaffBean)getMarkers().get("Moderator")).getName() + "\n";
        }
        
        if(getMarkers().containsKey("Third")) {
            markers += "Third Marker: " + ((StaffBean)getMarkers().get("Third")).getName() + "\n";
        }
        
        if(getMarkers().containsKey("Examiner")) {
            markers += "Examiner Marker: " + ((StaffBean)getMarkers().get("Examiner")).getName() + "\n";
        }
        
        projMap.put("MARKERS", markers);
        
        return projMap;
        
    }
    
    /**
     * Retrieves project data as a hashmap for sending emails with new hashmap
     * @return Map of project data
     */
    public Map<String,Object> getProjectMap() {
        
        Map<String,Object> projMap = new HashMap<String,Object>();
        return getProjectMap(projMap);
        
    }
    
    /**
     * Getter for IDs of project markers
     * @return Int array of marker IDs
     */
    public int[] getMarkerIDs() {
        
        int[] markerIDs = new int[markers.size()];
        int count = 0;
        
        for (Iterator iter = markers.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry)iter.next();
            markerIDs[count] = ((StaffBean)entry.getValue()).getID();
            count ++;
        }
        
        return markerIDs;
    }
    
    /**
     * Getter for project co-ordinator IDs
     * @return Int array of co-ordinator IDs
     */
    public int[] getCoordinatorIDs() {
        
        int[] coordinatorIDs = new int[coordinators.size()];
        Iterator coords = this.coordinators.iterator();
        
        int count = 0;
        while (coords.hasNext()) {
            coordinatorIDs[count] = ((StaffBean)coords.next()).getID();
            count++;
        }
        
        return coordinatorIDs;
        
    }
    
    /**
     * Getter for marker and coordinator IDs
     * @return Int array of marker/co-ordinator IDs
     */
    public int[] getCoordAndMarkerIDs() {
        
        int[] coordAndMarkerIDs = new int[getMarkerIDs().length+getCoordinatorIDs().length];
        System.arraycopy(getMarkerIDs(), 0, coordAndMarkerIDs, 0, getMarkerIDs().length);
        System.arraycopy(getCoordinatorIDs(), 0, coordAndMarkerIDs, getMarkerIDs().length, getCoordinatorIDs().length);
        
        return coordAndMarkerIDs;
    }
    
    /**
     * Getter for project reconciled mark override flag
     * @return Marker override flag
     */
    public int getOverrideReconMark() {
        return overrideReconMark;
    }
    
    /**
     * Setter for project override flag
     * @param overrideReconMark Override flag
     */
    public void setOverrideReconMark(int overrideReconMark) {
        this.overrideReconMark = overrideReconMark;
    }
    
    /**
     * Getter for project override required
     * @return Marker override
     */
    public boolean isNeedoverride() {
        return needoverride;
    }
    
    /**
     * Setter for project ovveride
     * @param needoverride Override
     */
    public void setNeedoverride(boolean needoverride) {
        this.needoverride = needoverride;
    }
    
    public int compareTo(Object obj) {
        return this.getStudentTxt().toLowerCase().compareTo(((Project)obj).getStudentTxt().toLowerCase());
    }
    
    /**
     * Holds value of property student.
     */
    private StudentBean student = null;
    
    /**
     * Getter for property student.
     * @return Value of property student.
     */
    public StudentBean getStudent() {
        return this.student;
    }
    
    /**
     * Setter for property student.
     * @param student New value of property student.
     */
    public void setStudent(StudentBean student) {
        this.student = student;
    }
    
    /**
     * Holds value of property unit.
     */
    private UnitBean unit = null;
    
    /**
     * Getter for property unit.
     * @return Value of property unit.
     */
    public UnitBean getUnit() {
        return this.unit;
    }
    
    /**
     * Setter for property unit.
     * @param unit New value of property unit.
     */
    public void setUnit(UnitBean unit) {
        this.unit = unit;
    }
    
    /**
     * Holds value of property cohort.
     */
    private CohortBean cohort = null;
    
    /**
     * Getter for property cohort.
     * @return Value of property cohort.
     */
    public CohortBean getCohort() {
        return this.cohort;
    }
    
    /**
     * Setter for property cohort.
     * @param cohort New value of property cohort.
     */
    public void setCohort(CohortBean cohort) {
        this.cohort = cohort;
    }
    
    /**
     * Holds value of property reconComments.
     */
    private String reconComments;
    
    /**
     * Getter for property reconComments.
     * @return Value of property reconComments.
     */
    public String getReconComments() {
        return this.reconComments;
    }
    
    /**
     * Setter for property reconComments.
     * @param reconComments New value of property reconComments.
     */
    public void setReconComments(String reconComments) {
        this.reconComments = reconComments;
    }
    
    /**
     * Appender for property reconComments.
     * @param reconComments Value to be appended to property reconComments.
     */
    public void addReconComments(String reconComments) {
        if (this.reconComments != null) {
            this.reconComments += "\n\n" + reconComments;
        } else {
            this.reconComments = reconComments;
        }
    }
}
