/*
 * MarkMapHelper.java
 *
 * Created on 01 March 2005, 16:46
 */

package jim.pums.assess.bus;

import java.util.*;
import jim.pums.assess.bus.AnyProjectMark;

/**
 *
 * @author  briggsj
 */
public class MarkMapHelper {
    
    /** Creates a new instance of MarkMapHelper */
    public MarkMapHelper() {
    }
    
    static public void copyMarks(AnyProjectMark marks, Map map) {
        List catNames = marks.getCatNames();
        Iterator it = catNames.iterator();
        while (it.hasNext()) {
            String cat = (String)it.next();
            String[] values = (String[])map.get(cat);
            if (values == null) {
                values = (String[])map.get("catMarks("+cat+")");
            }
            if (values != null) {
                Integer[] intMarks = new Integer[values.length];
                for (int i = 0; i < values.length; i++) {
                    intMarks[i] = Integer.parseInt(values[i]);
                }
                CategoryMark mk = marks.getCategories(cat);
                mk.setMarks(intMarks);
            }
        }
        String[] adjustString = (String[])map.get("adjustment");
        int adjustment = 0;
        if (adjustString != null) {
            for (int i = 0; i < adjustString.length; i++) {
                adjustment += Integer.parseInt(adjustString[i]);
            }
            marks.setAdjustment(adjustment);
        }
    }
}
