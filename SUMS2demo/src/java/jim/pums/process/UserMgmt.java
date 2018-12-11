/*
 * UserMgmt.java
 *
 * Created on 17 December 2004, 12:16
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
import jim.pums.bus.*;

public class UserMgmt extends BusinessBase {
    
    public UserMgmt(Connection conn) {
        super(conn);
    }
    
    public void enterNewUser(User user) throws SQLException {
        insertUser(user);
        insertEmail(user);
    }
    
    private final String insertUser = "INSERT INTO users (username, password, firstname, lastname, userid ) VALUES ( ?, ?, ?, ?, ?) ";
    private final String insertEmail = "INSERT INTO Emails (useryid, email) VALUES (?, ?)";
    
    private static Vector user2Vector(User user) {
        Vector params = new Vector();
        params.add(user.getUsername());
        params.add(user.getPassword());
        params.add(user.getFirstname());
        params.add(user.getLastname());
        params.add(new Integer(user.getUserId()));
        return params;
    }
    
    private static Vector email2Vector(int userid, String email) {
        Vector params = new Vector();
        params.add(new Integer(userid));
        params.add(email);
        return params;
    }
    
    private void insertUser(User user) throws SQLException {
        Trace.print("Inserting user " + user.getFullname());
        Vector v = user2Vector(user);
        sql.doExecute(insertUser, v.toArray());
    }
    
    private void insertEmail(User user) throws SQLException {
        Trace.print("Inserting emails for user " + user.getFullname());
        String emails[] = user.getEmail();
        for (int i=0; i<emails.length; i++) {            
            Vector v = email2Vector(user.getUserId(), emails[i]);
            sql.doExecute(insertEmail, v.toArray());
        }
    }
}
