/*
 * ProjectMarkFactory.java
 *
 * Created on 22 February 2005, 16:50
 */

package jim.pums.assess.bus;

import java.util.*;
import jim.pums.assess.process.MarkFormProcess;
import jim.common.*;
import jim.pums.PumsApp;
import jim.util.SqlUtils;

/**
 *
 * @author  briggsj
 */
public class ProjectMarkFactory {
    
    /** Creates a new instance of ProjectMarkFactory */
    public ProjectMarkFactory() {
    }
    
    static private List/*String*/ units = null;
    static private Map/*String[]*/ categories = null;
    static private Map/*int[]*/ weights = null;
    
    static void createUnit(String unit, String[] cats, int[] wgts) {
        units.add(unit);
        categories.put(unit, cats);
        weights.put(unit, wgts);
    }
    
    {
        if (units == null) {
            units = new ArrayList();
            categories = new HashMap();
            weights = new HashMap();
            createUnit("PJE30",
            new String[]{"Context and objectives", "Review", "Design"},
            new int[]{2, 2, 3});
            createUnit("PJS30",
            new String[]{"context", "review"},
            new int[]{2, 2});
        }
    }
    
    public AnyProjectMark createProjectMark(String unit) throws JimFatalException {
        if (! units.contains(unit)) {
            throw new IllegalStateException(unit + " is not a valid unit name");
        }
        AnyProjectMark mark = new AnyProjectMark();
        //        initialise(mark, unit);
        initialise2(mark, unit, null);
        return mark;
    }
    
    //    private void initialise(AnyProjectMark mark, String unit) {
    //        String[] cats = (String[])categories.get(unit);
    //        int[] wgts = (int[])weights.get(unit);
    //        mark.setWeights(cats, wgts);
    //    }
    
    public List getAllUnits() {
        List allUnits = new ArrayList(units);
        allUnits.add("INVALID");
        return allUnits;
    }
    
    public boolean isValidUnit(String unit) {
        return units.contains(unit);
    }
    
    private void initialise2(AnyProjectMark mark, String unit, java.util.Date date) throws JimFatalException {
        if (date == null) {
            date = new java.util.Date();
        }
        try {
            SqlUtils sql = PumsApp.getInstance().getSqlUtils();
            MarkFormProcess mfp = new MarkFormProcess(sql);
            Category[] cats = mfp.findForm(unit, date);
            mark.setWeights(cats);
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot get mark form categories - database problem", e);
        }
    }
}