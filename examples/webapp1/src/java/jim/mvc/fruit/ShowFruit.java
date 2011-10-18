/*
 * sws1.java
 *
 * Created on 16 April 2004, 14:17
 */
package jim.mvc.fruit;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author  briggsj
 * @version
 */
public class ShowFruit extends HttpServlet {

    /** Initializes the servlet.
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /** Destroys the servlet.
     */
    public void destroy() {
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // create a new bean
        Fruit aBanana = new Fruit();
        // associate it with the current request
        request.setAttribute("banana", aBanana);
        // set its properties
        aBanana.setType("banana");
        aBanana.setCondition("fresh");
        aBanana.setColour(request.getParameter("colour"));

        // create a second bean
        Fruit inputFruit = new Fruit();
        // set its properties according to parameters of the request
        try {
            BeanUtils.populate(inputFruit, request.getParameterMap());
        } catch (Exception e) {
            throw new ServletException("Cannot access request parameter map", e);
        }
        // associate it with the current request
        request.setAttribute("inputFruit", inputFruit);

        // Create a collection of fruit
        List<Fruit> allFruit = new ArrayList<Fruit>();
        allFruit.add(inputFruit);
        allFruit.add(aBanana);
        // associate it with the current request
        request.setAttribute("allFruit", allFruit);

        // forward request to JSP
        String outputPage = "/mvc/fruitout.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(outputPage);
        rd.forward(request, response);
    }

    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "showBanana is a servlet that illustrates the MVC pattern";
    }
}