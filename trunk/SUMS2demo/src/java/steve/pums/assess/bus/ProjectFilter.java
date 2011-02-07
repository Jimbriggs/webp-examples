/*
 * ProjectFilter.java
 *
 * Created on 10 October 2005, 13:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package steve.pums.assess.bus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jim.common.StringFormatter;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author briggsj
 */
public class ProjectFilter extends ActionForm {

    /** Creates a new instance of ProjectFilter */
    public ProjectFilter() {
    }
//    static private final SimpleDateFormat df = new SimpleDateFormat();
    /**
     * Holds value of property people.
     */
    private Set<Integer> people = new HashSet<Integer>();

    /**
     * Getter for property people.
     * @return Value of property people.
     */
    public Set<Integer> getPeople() {

        return this.people;
    }

    /**
     * Setter for property people.
     * @param people New value of property people.
     */
    public void setPeople(Set<Integer> people) {

        this.people = people;
    }

    public void addPeople(Set<Integer> people) {
        this.people.addAll(people);
    }

    private void termValueOr(ProjectFilterResult res, String name, Set field) {
        if (field != null && field.size() > 0) {
            if (res.getWhere().length() > 0) {
                res.getWhere().append(" " + operator + " ");
            }
            res.getWhere().append(name + " IN (" + StringFormatter.join(field, ", ") + ") ");
        }
    }

    private void termDateRange(ProjectFilterResult res, String name, Date start, Date finish) {
        if (start != null) {
            if (res.getWhere().length() > 0) {
                res.getWhere().append(" " + operator + " ");
            }
            res.getWhere().append(name + " > ?");
            res.getArgs().add(new java.sql.Timestamp(start.getTime()));
        }
        if (finish != null) {
            if (res.getWhere().length() > 0) {
                res.getWhere().append(" AND ");
            }
            res.getWhere().append(name + " < ?");
            res.getArgs().add(new java.sql.Timestamp(finish.getTime()));
        }
    }

    private void termStatus(ProjectFilterResult res, String name, String status) {
        if (status != null && !"".equals(status)) {
            if ("U".equalsIgnoreCase(status)) {
                if (res.getWhere().length() > 0) {
                    res.getWhere().append(" AND ");
                }
                res.getWhere().append("NOT (" + name + " IN ('SM', 'C', 'R1M', 'R2M', 'R3M', 'NS')) " +
                        "AND NOT (UNIT_ID IN (1,3,6))");
            }
        }
    }

    public ProjectFilterResult getResult() {
        ProjectFilterResult res = new ProjectFilterResult();

        termValueOr(res, "PERSON_ID", people);
        termStatus(res, "PROJECT_STATUS", status);
        termValueOr(res, "UNIT_ID", units);
        termDateRange(res, "PROJECT_END_DATE", dateRangeStart, dateRangeFinish);

//        if (res.getWhere().length() > 0) {
//            res.getWhere().append(")");
//        }
        return res;
    }
    /**
     * Holds value of property units.
     */
    private Set<Integer> units = new HashSet<Integer>();

    /**
     * Getter for property units.
     * @return Value of property units.
     */
    public Set<Integer> getUnits() {

        return this.units;
    }

    /**
     * Setter for property units.
     * @param units New value of property units.
     */
    public void setUnits(Set<Integer> units) {

        this.units = units;
    }

    public void addUnits(Set<Integer> units) {
        this.units.addAll(units);
    }
    /**
     * Holds value of property operator.
     */
    private String operator = "AND";

    /**
     * Getter for property operator.
     * @return Value of property operator.
     */
    public String getOperator() {

        return this.operator;
    }

    /**
     * Setter for property operator.
     * @param operator New value of property operator.
     */
    public void setOperator(String operator) {

        this.operator = operator;
    }
    /**
     * Holds value of property dateRangeStart.
     */
    private Date dateRangeStart;

    /**
     * Getter for property dateRangeStart.
     * @return Value of property dateRangeStart.
     */
    public Date getDateRangeStart() {

        return this.dateRangeStart;
    }

    /**
     * Setter for property dateRangeStart.
     * @param dateRangeStart New value of property dateRangeStart.
     */
    public void setDateRangeStart(Date dateRangeStart) {

        this.dateRangeStart = dateRangeStart;
    }
    /**
     * Holds value of property dateRangeFinish.
     */
    private Date dateRangeFinish;

    /**
     * Getter for property dateRangeFinish.
     * @return Value of property dateRangeFinish.
     */
    public Date getDateRangeFinish() {

        return this.dateRangeFinish;
    }

    /**
     * Setter for property dateRangeFinish.
     * @param dateRangeFinish New value of property dateRangeFinish.
     */
    public void setDateRangeFinish(Date dateRangeFinish) {

        this.dateRangeFinish = dateRangeFinish;
    }
    private String status = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
