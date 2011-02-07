/*
 * AuditBean.java
 *
 * Created on 21 August 2005, 16:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.bus;

import java.util.Date;

/**
 * Used to represent an item in the audit trail of a student project
 * @author Steve Powell
 */
public class AuditBean implements java.io.Serializable {
    
    /**
     * Identifies the person who initiated the change
     */
    private StaffBean changedBy = null;
    /**
     * The date the change was made
     */
    private java.util.Date dateChanged = null;    
    /**
     * The time the change was made
     */
    private java.util.Date timeChanged = null;
    /**
     * The identifier of the item affected
     */
    private String itemChanged = null;
    /**
     * The old value of the item
     */
    private String oldValue = null;
    /**
     * The new value of the item
     */
    private String newValue = null;
    
    /**
     * Creates a new instance of AuditBean
     * @param changedBy ID of person initiating change
     * @param dateChanged Date change was made
     * @param timeChanged Time change was made
     * @param itemChanged Item changed
     * @param oldValue Old value of item
     * @param newValue New value of item
     */
    public AuditBean(StaffBean changedBy, Date dateChanged, Date timeChanged,
            String itemChanged, String oldValue, String newValue) {
        this.setChangedBy(changedBy);
        this.setDateChanged(dateChanged);
        this.setTimeChanged(timeChanged);
        this.setItemChanged(itemChanged);
        this.setOldValue(oldValue);
        this.setNewValue(newValue);
    }

    /**
     * Getter for changed by
     * @return StaffBean identifying Person making change
     */
    public StaffBean getChangedBy() {
        return changedBy;
    }

    /**
     * Setter for changed by
     * @param changedBy Person making change
     */
    public void setChangedBy(StaffBean changedBy) {
        this.changedBy = changedBy;
    }

    /**
     * Getter for date changed
     * @return Date changed
     */
    public java.util.Date getDateChanged() {
        return dateChanged;
    }

    /**
     * Setter for date changed
     * @param dateChanged Date changed
     */
    public void setDateChanged(java.util.Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    /**
     * Getter for item changed
     * @return Item changed
     */
    public String getItemChanged() {
        return itemChanged;
    }

    /**
     * Setter for item changed
     * @param itemChanged Item changed
     */
    public void setItemChanged(String itemChanged) {
        this.itemChanged = itemChanged;
    }

    /**
     * Getter for old value of item
     * @return Old value of item
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Setter for old value of item
     * @param oldValue Old value of item
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * Getter for new value of item
     * @return Old value of item
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Setter for new value of item
     * @param newValue New value of item
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * Getter for time change made
     * @return Time change was made
     */
    public java.util.Date getTimeChanged() {
        return timeChanged;
    }

    /**
     * Setter for time change was made
     * @param timeChanged Time item changed
     */
    public void setTimeChanged(java.util.Date timeChanged) {
        this.timeChanged = timeChanged;
    }
    
}
