/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.fourth;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author BriggsJ
 */
@Named(value = "gc")
@ApplicationScoped
public class GlobalCounter {

    /**
     * Creates a new instance of GlobalCounter
     */
    public GlobalCounter() {
    }

    private int changes = 0;

    public int getChanges() {
        return changes;
    }

    public void setChanges(int changes) {
        this.changes = changes;
    }

    public int increment() {
        changes++;
        return changes;
    }
}
