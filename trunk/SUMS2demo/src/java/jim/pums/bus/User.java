/*
 * User.java
 *
 * Created on 17 December 2004, 12:07
 */

package jim.pums.bus;

/**
 *
 * @author  briggsj
 */
public class User {
    
    /**
     * Holds value of property firstname.
     */
    private String firstname;
    
    /**
     * Holds value of property lastname.
     */
    private String lastname;
    
    /**
     * Holds value of property password.
     */
    private String password;
    
    /**
     * Holds value of property username.
     */
    private String username;
    
    /**
     * Holds value of property userId.
     */
    private int userId;
    
    /**
     * Holds value of property email.
     */
    private String[] email;
    
    /** Creates a new instance of User */
    public User() {
        email = new String[] {};
    }
    
    /**
     * Getter for property firstname.
     * @return Value of property firstname.
     */
    public String getFirstname() {
        return this.firstname;
    }
    
    /**
     * Setter for property firstname.
     * @param firstname New value of property firstname.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    /**
     * Getter for property lastname.
     * @return Value of property lastname.
     */
    public String getLastname() {
        return this.lastname;
    }
    
    /**
     * Setter for property lastname.
     * @param lastname New value of property lastname.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Mock getter for property password1.
     * @return Value of property password.
     */
    public String getPassword1() {
        return this.password;
    }
    
    /**
     * Mock getter for property password2.
     * @return Value of property password.
     */
    public String getPassword2() {
        return this.password;
    }
    
    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFullname() {
        if (firstname.length() > 0 && lastname.length() > 0) {
            return firstname + " " + lastname;
        } else if (firstname.length() > 0) {
            return firstname;
        } else {
            return lastname;
        }
    }
    
    /**
     * Getter for property username.
     * @return Value of property username.
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Setter for property username.
     * @param username New value of property username.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Getter for property userId.
     * @return Value of property userId.
     */
    public int getUserId() {
        return this.userId;
    }
    
    /**
     * Setter for property userId.
     * @param userId New value of property userId.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /**
     * Indexed getter for property email.
     * @param index Index of the property.
     * @return Value of the property at <CODE>index</CODE>.
     */
    public String getEmail(int index) {
        return this.email[index];
    }
    
    /**
     * Getter for property email.
     * @return Value of property email.
     */
    public String[] getEmail() {
        return this.email;
    }
    
    /**
     * Indexed setter for property email.
     * @param index Index of the property.
     * @param email New value of the property at <CODE>index</CODE>.
     */
    public void setEmail(int index, String email) {
        this.email[index] = email;
    }
    
    /**
     * Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String[] email) {
        this.email = email;
    }
    
}