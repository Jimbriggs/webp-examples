/*
 * DynamicMap.java
 *
 * Created on 29 April 2005, 10:57
 */

package jim.pums.assess.bus;

/**
 *
 * @author  briggsj
 */
public class CategoryMap extends java.util.TreeMap {
    
    /** Creates a new instance of DynamicMap */
    public CategoryMap()  {
    }
    
    public Object get(String key) {
        CategoryMark retValue = (CategoryMark)super.get(key);
        if (retValue == null) {
            retValue = new CategoryMark(key);
            super.put(key, retValue);
        }
        return retValue;
    }
    
}
