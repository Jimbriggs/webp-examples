/*
 * Ideas.java
 *
 * Created on 02 November 2004, 13:38
 */

package jim.pums.process;

/**
 *
 * @author  briggsj
 */

import java.util.*;
import java.sql.*;
import jim.common.*;
import jim.util.*;
import jim.pums.ideas.ProjContact;
import jim.pums.bus.ProjIdea;

public class IdeasProcess extends BusinessBase {
    
    public IdeasProcess(Connection conn) {
        super(conn);
    }
    
    //    String selectAllStr = "SELECT * FROM IDEAS2 WHERE PROJAPPROVED LIKE ? ORDER BY PROJID";
    private final String selectAllStr = "SELECT projtitle, projid, projorg, orgcontact, orgname, orgid," +
    " orgemail, projstudent, projapproved, projdate FROM ideas2, contacts" +
    " WHERE projorg = orgid AND projapproved LIKE ? ORDER BY projid";
    private final String selectOneIdea = "SELECT * FROM IDEAS2, CONTACTS WHERE projorg = orgid AND PROJID = ?";
    private final String selectOneContact = "SELECT * FROM CONTACTS WHERE orgid = ?";
    private final String insertContact = "INSERT INTO contacts"
    + " (orgid, orgname, orgaddr, orgpostcode, orgcontact, orgdoes, orgtel, orgemail)"
    + " VALUES ( ? , ? , ? , ?, ?, ?, ?, ?)";
    private final String updateContact = "UPDATE contacts"
    + " SET orgid =  ? ,"
    + " orgname = ? ,"
    + " orgaddr = ? ,"
    + " orgpostcode = ? ,"
    + " orgcontact = ? ,"
    + " orgdoes = ? ,"
    + " orgtel = ? ,"
    + " orgemail = ? "
    + "WHERE orgid = ?";
    private final String insertIdea = "INSERT INTO ideas2"
    + " (projid, projtitle, projaims, projdeliver, projquest, projstudent, projorg, projapproved, projdate)"
    + " VALUES ( ? , ? , ? , ?, ?, ?, ?, ?, ?)";
    private final String updateIdea = "UPDATE ideas2"
    + " SET projid =  ? ,"
    + " projtitle = ? ,"
    + " projaims = ? ,"
    + " projdeliver = ? ,"
    + " projquest = ? ,"
    + " projstudent = ? ,"
    + " projorg = ? ,"
    + " projapproved = ? ,"
    + " projdate = ? "
    + "WHERE projid = ?";
    private final String selectMyContacts = "SELECT * FROM contacts" +
    " WHERE (1=1)" +
    " ORDER BY lower(orgname), lower(orgcontact), orgid";
    private final String selectIdeasByContact = "SELECT * FROM ideas2" +
    " WHERE (projorg = ?) ORDER BY lower(projtitle)";
    
    /** @skip MBodyLen */
    public Map getIdeaById(int num) throws SQLException {
        return sql.selectOne(selectOneIdea, new Object[]{new Integer(num)});
    }
    
    /** @skip MBodyLen */
    public Map getContactById(int num) throws SQLException {
        return sql.selectOne(selectOneContact, new Object[]{new Integer(num)});
    }
    
    /** @skip MBodyLen */
    public List getAllIdeas(String approval) throws SQLException {
        return sql.selectList(selectAllStr, new Object[]{approval});
    }
    
    /** @skip MBodyLen */
    public List getIdeasByContact(int contact) throws SQLException {
        return sql.selectList(selectIdeasByContact, new Object[]{new Integer(contact)});
    }
    
    public void enterContact(ProjContact contact) throws SQLException {
        if (contact.getOrgid() == 0) {
            contact.setOrgid(sql.nextval("S_CONTACT"));
            insertContact(contact);
        } else {
            updateContact(contact);
        }
    }
    
    private static Vector contact2Vector(ProjContact contact) {
        Vector params = new Vector();
        params.add(new Integer(contact.getOrgid()));
        params.add(contact.getOrgname());
        params.add(contact.getOrgaddr());
        params.add(contact.getOrgpostcode());
        params.add(contact.getOrgcontact());
        params.add(contact.getOrgdoes());
        params.add(contact.getOrgtel());
        params.add(contact.getOrgemail());
        return params;
    }
    
    public void insertContact(ProjContact contact) throws SQLException {
        Trace.print("Inserting contact with id " + contact.getOrgid());
        Vector v = contact2Vector(contact);
        sql.doExecute(insertContact, v.toArray());
    }
    
    public void updateContact(ProjContact contact) throws SQLException {
        Trace.print("Updating contact with id " + contact.getOrgid());
        Vector v = contact2Vector(contact);
        v.add(new Integer(contact.getOrgid()));
        sql.doExecute(updateContact, v.toArray());
    }
    
    public void enterIdea(ProjIdea idea) throws SQLException {
//        if (idea.getProjid() == 0) {
//            idea.setProjid(sql.nextval("S_IDEA"));
//            insertIdea(idea);
//        } else {
//            updateIdea(idea);
//        }
        if (idea.getProjid() == 0) {    //idea is brand new
            idea.setProjid(sql.nextval("S_IDEA"));
        }
//        ResultSet rs = sql.selectRS(FindIdea, 
    }
    
    private static Vector idea2Vector(ProjIdea idea) {
        Vector params = new Vector();
        params.add(new Integer(idea.getProjid()));
        params.add(idea.getProjtitle());
        params.add(idea.getProjaims());
        params.add(idea.getProjdeliver());
        params.add(idea.getProjquest());
        params.add(idea.getProjstudent());
        params.add(new Integer(idea.getProjorg()));
        params.add(idea.getProjstatus()+"");
        params.add(idea.getProjdate());
        return params;
    }
    
    public void insertIdea(ProjIdea idea) throws SQLException {
        Trace.print("Inserting idea with id " + idea.getProjid());
        Vector v = idea2Vector(idea);
        sql.doExecute(insertIdea, v.toArray());
    }
    
    public void updateIdea(ProjIdea idea) throws SQLException {
        Trace.print("Updating idea with id " + idea.getProjid());
        Vector v = idea2Vector(idea);
        v.add(new Integer(idea.getProjid()));
        sql.doExecute(updateIdea, v.toArray());
    }
    
    public List getMyContacts() throws SQLException {
        Trace.print("getMyContacts");
        return sql.selectList(selectMyContacts);
    }
    
}
