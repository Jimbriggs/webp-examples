/*
 * MarkFormProcess.java
 *
 * Created on 02 May 2005, 21:28
 */

package jim.pums.assess.process;

import java.sql.*;
import java.util.*;
import jim.common.*;
import jim.common.mail.*;
import jim.pums.assess.bus.*;
import jim.util.SqlUtils;

/**
 *
 * @author  briggsj
 */
public class MarkFormProcess {
    
//    private Connection conn = null;
    private SqlUtils sql = null;
    
    /** Creates a new instance of MarkFormProcess */
    public MarkFormProcess(SqlUtils sql) {
        this.sql = sql;
    }
    
    public Category[] findForm(String unit, java.util.Date date) throws SQLException {
        String select = "SELECT C.CATNAME, C.CATLONGNAME, C.CATDESCRIPTION, FC.CATWEIGHT, FC.CATINDEX "
        + "FROM MARK_CATEGORIES C, MARK_FORMS F, MARK_FORM_CATEGORIES FC "
        + "WHERE lower(F.FORMNAME) = lower(?) "
        + "AND (F.FORMID = FC.FORMID AND C.CATID = FC.CATID)";
        ResultSet rs = sql.selectRS(select, new Object[]{unit});
        List cats = new ArrayList();
        while (rs.next()) {
            Category cat = new Category(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            cats.add(cat);
        }
        rs.close();
        Category[]a = new Category[]{};
        Category[] categoryArray = (Category[])cats.toArray(a);
        Arrays.sort(categoryArray);
        return categoryArray;
    }
    
    private Map mark2map(AnyProjectMark mark) throws JimFatalException {
        try {
            Map map = new HashMap();
            AssessStudentForm student = mark.getStudent();
            map.put("STUDENTNAME", student.getStudentName());
            StringBuffer text = new StringBuffer(1000);
            final String lf = "\n";
            text.append("Student: " + student.getStudentName() + lf);
            text.append("Marker: " + student.getMarker() + lf);
            text.append("Total mark: " + mark.getTotalMark() + lf + lf);
            map.put("TEXT", text.toString());
            map.put("SUPERVISOR", student.getSupervisor());
            map.put("PROJECTTITLE", student.getProjectTitle());
            map.put("MARKER", student.getMarker());
            map.put("UNIT", student.getUnit());
            map.put("STATUS", student.getStatus());
            map.put("TOTALMARK", ""+mark.getTotalMark());
            map.put("ADJUSTMENT", ""+mark.getAdjustment());
            
            StringBuffer cats = new StringBuffer(1000);
            Iterator it = mark.getCatNames().iterator();
            while (it.hasNext()) {
                String catName = (String)it.next();
                CategoryMark cm = mark.getCategories(catName);
                Integer[] ticks = cm.getMarks();
                StringBuffer tickbuf = new StringBuffer(ticks.length*4);
                for (int i=0; i<ticks.length; i++) {
                    if (i==0) {
                        tickbuf.append(ticks[i]);
                    } else {
                        tickbuf.append(", " + ticks[i]);
                    }
                }
                cats.append(catName + " (" + cm.getWeight() + "): " + cm.getMark() + "  [" + tickbuf + "]" + lf);
            }
            map.put("CATS", cats.toString());
            map.put("COMMENTS", mark.getComments());
            map.put("EXAMINERS", mark.getExaminers());
            map.put("UNFAIR", mark.isUnfair()?"Plagiarism / Unfair act":"");
            map.put("DATE", student.getDate().toString());
            return map;
        } catch (Exception e) {
            throw new JimFatalException("Cannot formulate email message", e);
        }
    }
    
    /**
     * 
     * @deprecated No longer should emails be sent containing the marks
     * @param mark 
     * @throws jim.common.JimFatalException 
     * @throws javax.mail.MessagingException 
     */
    public void sendEmail(AnyProjectMark mark) throws JimFatalException, javax.mail.MessagingException {
        DBMessageFetcher dbf = new DBMessageFetcher(sql, "EMAILMESSAGES", "MAILKEY", "MAILSTRING");
        EmailMessage msg = dbf.fetch("SENDMARK");
        msg.setSession(jim.pums.PumsApp.getInstance().getEmailSession());
        msg.setSender("steve-p@ntlworld.com");
        Map args = mark2map(mark);
        msg.setTailoredParams(args);
        String angie = "Angela.Muscat@port.ac.uk,Jim.Briggs@port.ac.uk,Penny.Hart@port.ac.uk";
        angie = "steve-p@ntlworld.com";
        msg.sendMail(angie, false);
    }
}
