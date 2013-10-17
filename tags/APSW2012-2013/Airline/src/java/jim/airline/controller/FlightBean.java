/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.controller;

import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import jim.airline.bus.AirlineService;
import jim.airline.entities.Flight;
import jim.airline.facades.FlightFacade;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public class FlightBean extends AbstractBean<Flight, FlightFacade> {

    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
        super(Flight.class);
    }

    @EJB private FlightFacade ff;
    
    @Override
    public FlightFacade getFacade() {
        return ff;
    }
    
    private Date startDate;
    private Date finishDate;

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @EJB
    private AirlineService as;
    
    public String doFlightList() {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar finish = Calendar.getInstance();
        finish.setTime(finishDate);
        this.setItems(new ListDataModel<Flight>(as.getFlightsByDate(start, finish)));
        return "";
    }
}
