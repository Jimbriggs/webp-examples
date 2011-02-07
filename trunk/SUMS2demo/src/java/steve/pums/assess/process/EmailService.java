/*
 * EmailNotifications.java
 *
 * Created on 02 August 2005, 07:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.process;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jim.util.SqlUtils;
import jim.common.*;
import jim.common.mail.*;
import java.util.Map;
import jim.pums.PumsApp;


/**
 * Used for constructing and sending email messages from the SUMS marking system
 * @author Steve Powell
 */
public class EmailService {
    
    private DBMessageFetcher dbf = null;
    private SqlUtils sql = null;
    
    //TODO Get this from the properties file
    private boolean emailTestOnly = false;
    /**
     * Creates a new instance of EmailService
     * @param sql Handle on the SUMS database
     */
    public EmailService(SqlUtils sql) {
        this.sql = sql;
        dbf = new DBMessageFetcher(sql, "EMAILMESSAGES", "MAILKEY", "MAILSTRING");
    }
    
    /**
     * Sends an email with the specified parameters
     * @param to array of person ids to send the email to
     * @param from email address of sender
     * @param messageKey identifier of the email template held in the SUMS database
     * @param messageSubject email subject
     * @param messageArgs values to insert in to the email template
     * @throws jim.common.JimFatalException as a result of error in DB fetcher
     * @throws java.sql.SQLException as a result of an error in the address lookup
     * @throws javax.mail.MessagingException as a result of error in email sending
     */
    public void sendEmail(int[] to, String from, String messageKey, String messageSubject, Map<String,Object> messageArgs) throws JimFatalException, SQLException {
        Trace.print("Message " + messageKey + " to " + StringFormatter.join(to, ", "));
        if (to.length <= 0) {
            //No recipients
            //TODO: need to note this somewhere, probably in a log file
            return;
        }
        try {
            EmailMessage msg = dbf.fetch(messageKey);
            msg.setText(msg.getText().replace("$APPURL$", PumsApp.getInstance().getProperty("pums.url")));
            msg.setSession(PumsApp.getInstance().getEmailSession());
            msg.setSender(from);
            msg.setSubject(messageSubject);
            msg.setTailoredParams(jim.util.MapUtils.convertObjects2Strings(messageArgs));
            msg.sendMail(addressLookUp(to), isEmailTestOnly());
        } catch (javax.mail.MessagingException e) {
            try {
                EmailMessage msg = dbf.fetch("MAILPROBLEM");
                msg.setText(msg.getText().replace("$APPURL$", PumsApp.getInstance().getProperty("pums.url")));
                msg.setSession(PumsApp.getInstance().getEmailSession());
                msg.setSender("Jim.Briggs@port.ac.uk");
                msg.setSubject("Failed to send email message");
                Map<String, String> newargs = new HashMap<String, String>();
                newargs.put("TEXT", msg.toString());
                newargs.put("EXCEPTION", e.getMessage());
                newargs.put("RECIP", this.addressLookUp(to));
                msg.setTailoredParams(newargs);
                msg.sendMail("camprojects@port.ac.uk, disprojects@port.ac.uk", isEmailTestOnly());
            } catch (javax.mail.MessagingException e2) {
                throw new JimFatalException("Two failures of the email system", e2);
            }
        }
    }
    
    /**
     * Sends an email with standardised subject and sender, loaded from application properties
     * @param to array of person ids to send the email to
     * @param messageKey identifier of the email template held in the SUMS database
     * @param messageArgs values to insert in to the email template
     * @throws jim.common.JimFatalException as a result of error in DB fetcher
     * @throws java.sql.SQLException as a result of an error in the address lookup
     * @throws javax.mail.MessagingException as a result of error in email sending
     */
    public void sendEmail(int[] to, String messageKey, Map<String,Object> messageArgs) throws JimFatalException, SQLException, javax.mail.MessagingException {
        String from = PumsApp.getInstance().getProperty("mail.from");
        String messageSubject = PumsApp.getInstance().getProperty("mail.subject");
        sendEmail(to, from, messageKey, messageSubject, messageArgs);
    }
    
    /**
     * Used to look up email addresses associated with specified people in the SUMS database
     * @param people people to send the email to
     * @return email addresses to send the email to
     * @throws java.sql.SQLException as a result of SQL error
     */
    private String addressLookUp(int[] people) throws SQLException {
        if (people.length == 0) {
            return "";
        }
        String emailaddresses = "";
        
        String select = "SELECT E_MAIL_ADD FROM PERSON_EMAIL " +
                "WHERE ";
        for (int i=0; i<people.length-1; i++) {
            select += " PERSON_ID = " + people[i] + " OR ";
        }
        select += " PERSON_ID = " + people[people.length-1];
        ResultSet rs = sql.selectRS(select);
        List<String> addresses = new ArrayList<String>();
        while (rs.next()) {
            addresses.add(rs.getString(1));
        }
        rs.close();
        emailaddresses = StringFormatter.join(addresses, ",");
        
        if(emailaddresses.equals("")) {
            emailaddresses = jim.pums.PumsApp.getInstance().getProperty("mail.noemail");
        }
        
        return emailaddresses;
    }
    
    public boolean isEmailTestOnly() {
        return emailTestOnly;
    }
    
    public void setEmailTestOnly(boolean emailTestOnly) {
        this.emailTestOnly = emailTestOnly;
    }
}
