/*
 * ProjectFilterResult.java
 *
 * Created on 16 December 2005, 16:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package steve.pums.assess.bus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author briggsj
 */
public class ProjectFilterResult {
    
    private StringBuffer where = new StringBuffer();
    private List<Object> args = new ArrayList<Object>();

    public StringBuffer getWhere() {

        return where;
    }

    public List<Object> getArgs() {
        return args;
    }
    
}
