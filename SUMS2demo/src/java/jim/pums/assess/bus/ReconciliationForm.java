/*
 * ReconciliationForm.java
 *
 * Created on 09 June 2006, 14:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jim.pums.assess.bus;

import javax.servlet.http.HttpServletRequest;
import jim.util.struts.JimActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author briggsj
 */
public class ReconciliationForm extends ActionForm {
    
    /** Creates a new instance of ReconciliationForm */
    public ReconciliationForm() {
    }

    /**
     * Holds value of property mark.
     */
    private int mark;

    /**
     * Getter for property mark.
     * @return Value of property mark.
     */
    public int getMark() {
        return this.mark;
    }

    /**
     * Setter for property mark.
     * @param mark New value of property mark.
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Holds value of property reason.
     */
    private String reason;

    /**
     * Getter for property reason.
     * @return Value of property reason.
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Setter for property reason.
     * @param reason New value of property reason.
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Holds value of property decision.
     */
    private String decision;

    /**
     * Getter for property decision.
     * @return Value of property decision.
     */
    public String getDecision() {
        return this.decision;
    }

    /**
     * Setter for property decision.
     * @param decision New value of property decision.
     */
    public void setDecision(String decision) {
        this.decision = decision;
    }

    public JimActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        JimActionErrors err = new JimActionErrors();
        err.add(super.validate(mapping, request));
                
        if (mark < 0 || mark > 100) {
            err.add("mark", "reconciliationForm.mark", "out of range 0..100");
        }
        if (reason.length() <= 20) {
            err.add("reason", "reconciliationForm.reason", "needs to be more than 20 characters long");
        }
        return err;
    }
    
    
}
