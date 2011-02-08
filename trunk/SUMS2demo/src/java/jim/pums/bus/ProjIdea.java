/*
 * newidea.java
 *
 * Created on 22 January 2004, 22:44
 */
package jim.pums.bus;

import java.sql.Date;
import jim.common.DBBean;

/**
 *
 * @author  briggsj
 */
public class ProjIdea extends DBBean {

    private String Projtitle;
    private String Projaims;
    private String Projquest;
    private String Projdeliver;
    private String Projstudent;
    /** Holds value of property Projstatus. */
    private char Projstatus;
    /** Holds value of property projorg. */
    private int Projorg;
    /** Holds value of property projid. */
    private int projid;
    /** Holds value of property date. */
    private Date Projdate;

    /** Creates a new instance of newidea */
    public ProjIdea() {
        java.util.Date d = new java.util.Date();
        Projdate = new Date(d.getTime());
        Projstatus = 'P';
    }

    public String getProjtitle() {
        return Projtitle;
    }

    public String getProjaims() {
        return Projaims;
    }

    public String getProjquest() {
        return Projquest;
    }

    public String getProjdeliver() {
        return Projdeliver;
    }

    public String getProjstudent() {
        return Projstudent;
    }

    public void setProjtitle(String s) {
        Projtitle = s;
    }

    public void setProjaims(String s) {
        Projaims = s;
    }

    public void setProjquest(String s) {
        Projquest = s;
    }

    public void setProjdeliver(String s) {
        Projdeliver = s;
    }

    public void setProjstudent(String s) {
        Projstudent = s;
    }

    /** Getter for property Projstatus.
     * @return Value of property Projstatus.
     *
     */
    public boolean isProjapproved() {
        return this.Projstatus == 'A';
    }

    /** Setter for property Projstatus.
     * @param Projstatus New value of property Projstatus.
     *
     */
    public void setProjstatus(char Projstatus) {
        this.Projstatus = Projstatus;
    }

    /** Getter for property projorg.
     * @return Value of property projorg.
     *
     */
    public int getProjorg() {
        return this.Projorg;
    }

    /** Setter for property projorg.
     * @param projorg New value of property projorg.
     *
     */
    public void setProjorg(int projorg) {
        this.Projorg = projorg;
    }

    /** Getter for property projid.
     * @return Value of property projid.
     *
     */
    public int getProjid() {
        return this.projid;
    }

    /** Setter for property projid.
     * @param projid New value of property projid.
     *
     */
    public void setProjid(int projid) {
        this.projid = projid;
    }

//    public boolean isValid () {
//        messages.clear ();
//        Checks cs = new Checks(messages);
//        cs.check(Projtitle, "Project title", 1, 100);
//        cs.check(Projaims, "Project aims", 20, 4000);
//        cs.check(Projdeliver, "Project deliverables", 0, 1000);
//        cs.check(Projquest, "Project question", 0, 1000);
//        cs.check(Projstudent, "Project student", 0, 100);
//        cs.check(Projorg, "Project organisation link", 0, Integer.MAX_VALUE);
////        cs.check(Projstatus, "Project approval status", 10, 20);
//        return messages.isEmpty ();
//    }
    /** Getter for property date.
     * @return Value of property date.
     *
     */
    public Date getProjdate() {
        return this.Projdate;
    }

    /** Getter for property Projstatus.
     * @return Value of property Projstatus.
     *
     */
    public char getProjstatus() {
        return Projstatus;
    }

    /** Setter for property date.
     * @param date New value of property date.
     *
     */
    public void setProjdate(java.sql.Date date) {
        this.Projdate = date;
    }
}
