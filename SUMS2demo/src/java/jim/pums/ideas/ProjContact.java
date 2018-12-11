/*
 * projcontact.java
 *
 * Created on 28 January 2004, 21:27
 */

package jim.pums.ideas;

import jim.common.DBBean;

/**
 *
 * @author  briggsj
 */
public class ProjContact extends DBBean {
    
    private String Orgname;
    
    private String Orgaddr;
    
    private String Orgpostcode;
    
    private String Orgdoes;
    
    private String Orgcontact;
    
    private String Orgtel;
    
    private String Orgemail;
    
    /** Holds value of property orgid. */
    private int Orgid;
    
    /** Creates a new instance of projcontact */
    public ProjContact () {
    }
    
    public String getOrgname () {
        return Orgname;
    }
    
    public void setOrgname (String s) {
        Orgname = s;
    }
    
    public String getOrgaddr () {
        return Orgaddr;
    }
    
    public String getOrgpostcode () {
        return Orgpostcode;
    }
    
    public String getOrgdoes () {
        return Orgdoes;
    }
    
    public String getOrgcontact () {
        return Orgcontact;
    }
    
    public String getOrgtel () {
        return Orgtel;
    }
    
    public String getOrgemail () {
        return Orgemail;
    }
    
    public void setOrgaddr (String s) {
        Orgaddr = s;
    }
    
    public void setOrgpostcode (String s) {
        Orgpostcode = s;
    }
    
    public void setOrgdoes (String s) {
        Orgdoes = s;
    }
    
    public void setOrgcontact (String s) {
        Orgcontact = s;
    }
    
    public void setOrgtel (String s) {
        Orgtel = s;
    }
    
    public void setOrgemail (String s) {
        Orgemail = s;
    }
    
    /** Getter for property orgid.
     * @return Value of property orgid.
     *
     */
    public int getOrgid() {
        return this.Orgid;
    }
    
    /** Setter for property orgid.
     * @param orgid New value of property orgid.
     *
     */
    public void setOrgid(int orgid) {
        this.Orgid = orgid;
    }
    
//    public boolean isValid () {
//        messages.clear ();
//        Checks cs = new Checks(messages);
//        cs.check(Orgname, "Organisation name", 1, 50);
//        cs.check(Orgaddr, "Organisation address", 1, 100);
//        cs.check(Orgpostcode, "Organisation postcode", 0, 10);
//        cs.check(Orgcontact, "Organisation contact name", 1, 50);
//        cs.check(Orgdoes, "What organisation does", 0, 50);
//        cs.check(Orgtel, "Organisation telephone number", 0, 20);
//        cs.check(Orgemail, "Organisation email address", 10, 50);
//        return messages.isEmpty ();
//    }
}
