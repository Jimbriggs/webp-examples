package jim.intro;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a simple servlet example that shows the main request methods.
 *
 * @author Hans Bergsten, Gefion software <hans@gefionsoftware.com>
 * @version 1.0
 */
public class HelloYou extends HttpServlet {

    /**
     * This method writes the most commonly used request information
     * to the response body, such as the User-Agent header, the
     * various paths associated with the request, and the request
     * parameters.
     */
    public void doGet(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null) {
            name =  "you";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello " + name + "</h1>");

        out.println("I see that:<ul>");
        String userAgent = request.getHeader("User-Agent");
        out.println("<li>your browser is: " + userAgent);
        String requestURI = request.getRequestURI();
        out.println("<li>the URI for this page is: " +
            requestURI);
        String contextPath = request.getContextPath();
        out.println("<li>the context path for this app is: " +
            contextPath);
        String servletPath = request.getServletPath();
        out.println("<li>this servlet is mapped to: " + 
            servletPath);
        String pathInfo = request.getPathInfo();
        out.println("<li>the remaining path is: " + pathInfo);
        Map parameters = request.getParameterMap();
        out.println("<li>you sent the following params:<ul>");
        Iterator i = parameters.keySet().iterator();
        while (i.hasNext()) {
            String paramName = (String) i.next();
            out.println("<li><b>" + paramName + "</b>:");
            String[] paramValues = 
                (String[]) parameters.get(paramName);
            for (int j = 0; j < paramValues.length; j++) {
                if (j != 0) {
                    out.print(", ");
                }
                out.print(paramValues[j]);
            }
        }
        out.println("</ul></ul></body></html>");
    }
}
