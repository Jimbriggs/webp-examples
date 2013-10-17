/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yang.sum.controller;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import yang.sum.entity.Students;
import yang.sum.business.StudentService;

/**
 *
 * @author yang
 */
@ManagedBean
@SessionScoped
public class RegistController extends BaseController {

    private Collection<Students> StudentsList;


    @EJB
    private StudentService ss;


    /**
     * Creates a new instance of RegistController
     */
    public RegistController() {
    }

//    public Collection<Students> getFlightList() {
        //return flightList;
//        return ss.getFf().findAll();
//    }

//    public void setNewFlight(Flight newFlight) {
  //      this.newFlight = newFlight;
   // }

    public String prepareAddFlight() {
        return "addFlight";
    }

 /*   public String addFlight() {
        try {
            fs.createFlight(newFlight);
        } catch (BusinessException bEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, bEx);
            addError(bEx.getMessage());
            return "addFlight";
        } catch (FlightAlreadyExistsException fAEEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, fAEEx);
            addErrorToComponent(flightNumber.getClientId(), fAEEx.getMessage());
            return "addFlight";
        }
        // This catch clause is too general but is the only one that could be caught;
        // this means that, to manage the unique contraints violation we need to go through the stack trace
        // before getting the relevant message. This could cause other exception to arise (NullPointerException)
        // in case other events occurred, different from unique contraint violation
//        catch (EJBException EJBEx){// The same exception is not caught if try-catch is put around createFlight in flightService
//            String EJBExCCCMessage = EJBEx.getCause().getCause().getCause().getMessage();
//            System.out.println(EJBExCCCMessage);
//            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, EJBEx);
//            addError(EJBExCCCMessage);
//            
//            return "addFlight";
//        }
        newFlight = new Flight();
        return "index";
    }
*/

/*    public String prepareBook(Flight flight) {
        this.currentFlight = flight;
        return "bookFlight";
    }
*/
 /*   public String bookFlightForNewPassenger() {
        // Instead of values 1, 2 or 3 we want to persist the correspondent label
        CountryConverter cc = new CountryConverter();
        newPassenger.setCountry((String) cc.getAsObject(null, null, newPassenger.getCountry()));
        System.out.println(newPassenger.getCountry());

        try {
            ps.createPassenger(newPassenger);
            ps.bookFlight(newPassenger, currentFlight);
        } catch (BusinessException bEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, bEx);
            addError(bEx.getMessage());
            return "bookFlight";
        } catch (PassengerAlreadyExistsException pAEEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, pAEEx);
            addErrorToComponent(username.getClientId(), pAEEx.getMessage());
            return "bookFlight";
        } catch (UKZipCodeNotValidException zCNVEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, zCNVEx);
            addErrorToComponent(zipCode.getClientId(), zCNVEx.getMessage());
            return "bookFlight";
        }
        newPassenger = new Passenger();
        return "index";
    }
*/

/*    public String bookFlightForExistingPassenger() {
        try {
            ps.bookFlight(currentPassenger, currentFlight);
        } catch (BusinessException bEx) {
            Logger.getLogger(RegistController.class.getName()).log(Level.SEVERE, null, bEx);
            addError(bEx.getMessage());
            return "bookFlight";
        }
        currentPassenger = new Passenger();
        return "index";
    }
*/

}
