/*
 * LoggerService.java
 *
 * Created on 21 August 2005, 14:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.process;

import java.sql.*;
import jim.util.SqlUtils;
import steve.pums.assess.bus.*;
import java.util.*;
import java.text.ParseException;
import java.util.Date;

/**
 * Used for events logging and retrieval in the SUMS database
 */
public class LoggerService {
    
    /**
     * Jim App SQL Utils
     */
    private SqlUtils sql = null;
    
    /**
     * Creates a new instance of LoggerService
     * @param conn Connection to the SUMS database
     */
    public LoggerService(SqlUtils sql) {
        this.sql = sql;
    }
    
    private static final String auditFields =
            "AUDIT_ID, " +
            "PERSON_MAKING_CHANGE_ID, " +
            "PROJECT_BEING_CHANGED_ID, " +
            "REASON, " +
            "DATE_ALTERED, " +
            "ITEM_CHANGED, " +
            "OLD_VALUE_OF_ITEM, " +
            "NEW_VALUE_OF_ITEM, " +
            "TIME_ALTERED";
    
    /**
     * Inserts the log of a new event in the SUMS database
     * @param user ID of the user triggering the event
     * @param project ID of the project the event relates to
     * @param item description of the affected item
     * @param oldVal original value of the affected item
     * @param newVal new value of the affected item
     * @throws java.sql.SQLException as a result of SQL errors
     * @throws java.text.ParseException as a result of date parsing error
     */
    public void log(int user, int project, String item, String oldVal, String newVal) throws SQLException {
        if (oldVal == null || oldVal.equals("")){
            oldVal="Null";
        }
        if (newVal == null || newVal.equals("")){
            newVal="Null";
        }
        if (!oldVal.equals(newVal)) {
            Date now = new Date();
            String insert = "INSERT INTO AUDIT_TRAIL (" + auditFields + ") " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            sql.doExecute(insert, new Object[]{
                sql.nextval("AUDIT_1"),
                        user,
                        project,
                        "no reason",
                        sql.dateParam(now),
                        sql.stringParam(item, 128),
                        sql.clobParam(oldVal),
                        sql.clobParam(newVal),
                        sql.timeStampParam(now)
            });
            
//            rs.moveToInsertRow();
//            rs.updateInt("PERSON_MAKING_CHANGE_ID", user);
//            rs.updateInt("PROJECT_BEING_CHANGED_ID", project);
//            rs.updateDate("DATE_ALTERED", sql.dateParam(now));
//            rs.updateDate("TIME_ALTERED", sql.dateParam(now));
//            rs.updateString("ITEM_CHANGED",item);
////            rs.updateClob("OLD_VALUE_OF_ITEM", old);
////            rs.updateClob("NEW_VALUE_OF_ITEM", newv);
//            rs.insertRow();
//            rs.close();
        }
        
    }
    
    /**
     * Used for the retrieval of events associated with a particular project
     * @param projectid ID of the project to retrieve events for
     * @return returns a collection of events associated with the project
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public Vector getAudit(int projectid) throws SQLException {
        
        Vector audit = new Vector();
        
        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME, " +
                "A.DATE_ALTERED, A.TIME_ALTERED, A.ITEM_CHANGED, " +
                "A.OLD_VALUE_OF_ITEM, A.NEW_VALUE_OF_ITEM " +
                "FROM AUDIT_TRAIL A, PERSON P " +
                "WHERE A.PROJECT_BEING_CHANGED_ID = ? " +
                "AND A.PERSON_MAKING_CHANGE_ID = P.PERSON_ID " +
                "ORDER BY AUDIT_ID";
        
        ResultSet rs = sql.selectRS(select, new Object[]{
            projectid
        });
        while(rs.next()){
            AuditBean a = new AuditBean(
                    new StaffBean(rs.getInt(1), rs.getString(2), rs.getString(3)),
                    rs.getDate(4), rs.getDate(5),
                    rs.getString(6), sql.getClobString(rs, 7), sql.getClobString(rs, 8)
                    );
            audit.add(a);
        }
        rs.close();
        return audit;
    }
    
}
