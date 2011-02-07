/*
 * AssetQueryAction.java
 *
 * Created on 17 February 2005, 11:33
 */

package jim.assets.action;

import jim.util.struts.JimBaseAction;
/**
 *
 * @author  briggsj
 */
public class AssetQueryAction extends JimBaseAction {
    
    /** Creates a new instance of AssetQueryAction */
    public AssetQueryAction() {
    }
    
    public jim.common.BaseApplication createApplication() {
        return null;
    }
    
    public org.apache.struts.action.ActionForward doExecute(jim.util.struts.StrutsUtils su) throws java.io.IOException, javax.servlet.ServletException, jim.common.JimFatalException {
        //validate the form
        //query the database
        //produce a Java Bean that contains the output to be displayed
        //calls the appropriate JSP to display the view
        return su.success();
    }
    
}
