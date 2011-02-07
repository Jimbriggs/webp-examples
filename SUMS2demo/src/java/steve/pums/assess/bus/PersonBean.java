/*
 * PersonBean.java
 *
 * Created on 20 September 2005, 13:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import jim.common.StringFormatter;

/**
 *
 * @author briggsj
 */
public class PersonBean implements java.io.Serializable {
    
    /** Creates a new instance of PersonBean */
    public PersonBean() {
    }
    
    /**
     * Holds value of property person_id.
     */
    private int person_id;
    
    /**
     * Getter for property person_id.
     * @return Value of property person_id.
     */
    public int getPerson_id() {
        
        return this.person_id;
    }
    
    /**
     * Setter for property person_id.
     * @param person_id New value of property person_id.
     */
    public void setPerson_id(int person_id) {
        
        this.person_id = person_id;
    }
    
    /**
     * Holds value of property user_name.
     */
    private String user_name;
    static private final int maxUser_nameLength = 256;
    
    /**
     * Getter for property user_name.
     * @return Value of property user_name.
     */
    public String getUser_name() {
        
        return this.user_name;
    }
    
    /**
     * Setter for property user_name.
     * @param user_name New value of property user_name.
     */
    public void setUser_name(String user_name) {
        user_name = user_name.trim();
        this.user_name = StringFormatter.trimAndTruncate(user_name, maxUser_nameLength);
    }
    
    /**
     * Holds value of property first_name.
     */
    private String first_name;
    static private final int maxFirst_nameLength = 64;    
    
    /**
     * Getter for property first_name.
     * @return Value of property first_name.
     */
    public String getFirst_name() {
        
        return this.first_name;
    }
    
    /**
     * Setter for property first_name.
     * @param first_name New value of property first_name.
     */
    public void setFirst_name(String first_name) {
        first_name = first_name.trim();
        this.first_name = StringFormatter.trimAndTruncate(first_name, maxFirst_nameLength);
    }
    
    /**
     * Holds value of property surname.
     */
    private String surname;
    static private final int maxSurnameLength = 64;      
    
    /**
     * Getter for property surname.
     * @return Value of property surname.
     */
    public String getSurname() {
        
        return this.surname;
    }
    
    /**
     * Setter for property surname.
     * @param surname New value of property surname.
     */
    public void setSurname(String surname) {
        surname = surname.trim();
        this.surname = StringFormatter.trimAndTruncate(surname, maxSurnameLength);
    }
    
    /**
     * Holds value of property password.
     */
    private String password;
    
    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public String getPassword() {
        return this.password==null?"":this.password;
    }
    
    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    /**
     * Holds value of property inactive.
     */
    private boolean inactive;
    
    /**
     * Getter for property inactive.
     * @return Value of property inactive.
     */
    public boolean isInactive() {
        
        return this.inactive;
    }
    
    /**
     * Setter for property inactive.
     * @param inactive New value of property inactive.
     */
    public void setInactive(boolean inactive) {
        
        this.inactive = inactive;
    }
    
    private String longUserName;

    public String getLongUserName() {
        return longUserName;
    }

    public void setLongUserName(String longUserName) {
        this.longUserName = longUserName;
    }
    
    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.getFirst_name() + " " + this.getSurname();
    }

    public PersonBean(int person_id, String first_name, String surname) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.surname = surname;
    }

    public boolean isSameUsername(String str) {
        if (str == null) {
            return (user_name == null);
        }
        str = StringFormatter.trimAndTruncate(str, maxUser_nameLength);
        return str.equalsIgnoreCase(getUser_name());
    }

    public boolean isSameName(String name) {
        if (name == null) {
            return (first_name == null && surname == null);
        }
        return name.equalsIgnoreCase(getName());
    }
    
}