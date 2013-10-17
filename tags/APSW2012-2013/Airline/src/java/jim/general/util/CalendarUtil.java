/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.general.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author briggsj
 */
public class CalendarUtil {

    static public void setTimeOfDay(Calendar c, int hours, int minutes, int seconds) {
        c.set(Calendar.HOUR_OF_DAY, hours);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);
    }

    static public Calendar randomDate (int daysBack, int daysForward) {
        int range = daysBack + daysForward + 1;
        Calendar day = new GregorianCalendar();
        int pick = (int)Math.floor(Math.random() * range);
        day.add(Calendar.DAY_OF_YEAR, pick-daysBack);
        return day;
    }
}
