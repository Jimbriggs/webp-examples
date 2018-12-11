/*
 * SPStudentBean.java
 *
 * Created on 24 July 2005, 01:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import org.apache.struts.action.ActionForm;

/**
 * Used to represent a student
 * @author Steve Powell
 */
public class StudentBean extends ActionForm {
    
    /**
     * Student first name
     */
    private String first_name = null;
    /**
     * Student surname
     */
    private String surname = null;
    /**
     * Student hemis number
     */
    private int hemis = 0;
    /**
     * Student person ID
     */
    private int ID = 0;
    
    /** Creates a new instance of SPStudentBean */
    
    public StudentBean(){
    }
        
    /**
     * Creates a new instance of SPStudentBean with values
     * @param ID Person ID of student
     * @param first_name First name of student
     * @param surname Surname of student
     * @param hemis Hemis number of student
     */
    public StudentBean(int ID, String first_name, String surname, int hemis) {
        this.setFirst_name(first_name);  
        this.setSurname(surname);
        this.hemis = hemis;
        this.ID = ID;
    }

    /**
     * Getter for student name
     * @return Student name
     */
    public String getName() {
        return (this.getFirst_name() + " " + this.getSurname());
    }

    /**
     * Getter for student ID
     * @return Student ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for student ID
     * @param ID Student person ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter for hemis number
     * @return Hemis number
     */
    public int getHemis() {
        return hemis;
    }

    /**
     * Setter for student hemis
     * @param hemis Student hemis
     */
    public void setHemis(int hemis) {
        this.hemis = hemis;
    }

    /**
     * Getter for student first name
     * @return First name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter for student first name
     * @param first_name Student first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter for student surname
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter for student surname
     * @param surname Student surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Holds value of property degreeStream.
     */
    private String degreeStream;

    /**
     * Getter for property degreeStream.
     * @return Value of property degreeStream.
     */
    public String getDegreeStream() {

        return this.degreeStream;
    }

    /**
     * Setter for property degreeStream.
     * @param degreeStream New value of property degreeStream.
     */
    public void setDegreeStream(String degreeStream) {

        this.degreeStream = degreeStream;
    }

    /**
     * Holds value of property final_year.
     */
    private String final_year;

    /**
     * Getter for property final_year.
     * @return Value of property final_year.
     */
    public String getFinal_year() {

        return this.final_year;
    }

    /**
     * Setter for property final_year.
     * @param final_year New value of property final_year.
     */
    public void setFinal_year(String final_year) {

        this.final_year = final_year;
    }

    /**
     * Getter for property indexName.
     * @return Value of property indexName.
     */
    public String getIndexName() {

        return getSurname() + ", " + getFirst_name();
    }
    
    public String getNameAndId() {
        return getIndexName() + "(" + this.getHemis() + ")";
    }
}
