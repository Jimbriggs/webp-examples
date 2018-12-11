/*
 * intro1.java
 *
 * Created on 24 March 2004, 15:25
 */

package jim.intro;

import java.io.*;
//import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author  briggsj
 * @version
 */
public class hello extends HttpServlet {
    
    /** Initializes the servlet.
     */
    public void init (ServletConfig config) throws ServletException {
        super.init (config);
        
    }
    
    /** Destroys the servlet.
     */
    public void destroy () {
        
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello world servlet</title>");
        out.println("</head>");
        out.println("<body>");
        
        String name = request.getParameter ("name");
        out.println("<P>Hello " + name);
        out.println("</body>");
        out.println("</html>");

        out.close ();
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest (request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest (request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo () {
        return "Short description";
    }
    
}
