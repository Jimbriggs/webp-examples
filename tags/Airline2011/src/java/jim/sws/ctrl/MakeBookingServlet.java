/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.sws.ctrl;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jim.sws.bus.BookingService;
import jim.sws.bus.BusinessException;
import jim.sws.entities.Booking;
import jim.sws.entities.Passenger;

/**
 *
 * @author BriggsJ
 */
@WebServlet(name = "MakeBookingServlet", urlPatterns = {"/MakeBookingServlet"})
public class MakeBookingServlet extends HttpServlet {

    @EJB
    private BookingService service;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form parameters
        String flight = request.getParameter("flight");
        String passenger = request.getParameter("passenger");
        //Validate all input data
        Long flightId;
        try {
             flightId = Long.parseLong(flight);
        } catch (NumberFormatException numberFormatException) {
            
        }
        Passenger p;
        BeanUtils.copyProperties(p, request.getParameterMap());
        Map<String, String> errors = p.validate();
        if (errors.isEmpty()) {
            
        } else {
            request.setAttribute("errors", errors);
        }
        Long passengerId = Long.parseLong(passenger);
        Booking b;
        try {
            //Call business code
            b = service.makeBooking(flightId, passengerId);           
        } catch (BusinessException ex) {
            Logger.getLogger(MakeBookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Setup view
        request.setAttribute("booking", b);
        //redirect
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
