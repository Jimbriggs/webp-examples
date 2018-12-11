/*
 * MarkFormFactory.java
 *
 * Created on 25 July 2005, 23:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package steve.pums.assess.process;

import java.sql.*;
import jim.util.SqlUtils;
import steve.pums.assess.bus.*;
import java.util.*;
import java.text.ParseException;
import java.util.Date;
import jim.common.JimFatalException;
import jim.pums.assess.bus.ReconciliationForm;

/**
 * Used for the processing of project mark forms and the associated marking data
 * @author Steve Powell
 */
public class MarkFormProcess {

    /**
     * SUMS database connection
     */
    //    private Connection conn = null;
    /**
     * Jim App SQL Utils
     */
    private SqlUtils sql = null;

    /**
     * Creates a new instance of MarkFormProcess
     * @param conn Connection to the SUMS database
     */
    public MarkFormProcess(SqlUtils sql) {
        this.sql = sql;
    }

    /**
     * Generates the appropriate mark form for the project being assessed
     * @param project project the mark form is to be generated for
     * @param marker ID of the person marking the project
     * @return the mark form data for the assessment of the project
     * @throws java.sql.SQLException in the event of SQL errors
     * @throws java.text.ParseException in the event of date parsing errors
     */
    public MarkFormBean readMarkFormForMarker(Project project, int marker) throws SQLException, ParseException, JimFatalException {

        MarkFormBean markform = new MarkFormBean();

        markform = updateMarker(markform, project.getProjectID(), marker);

        String select = "SELECT F.FORM_ID,  M.FORMNAME " +
                "FROM UNIT_MARK_FORMS F, MARK_FORMS M " +
                "WHERE F.UNIT_ID = ? " +
                "AND ((? > F.UMFBEGIN AND F.UMFEND IS NULL) OR (? > F.UMFBEGIN AND ? < F.UMFEND)) " +
                "AND F.FORM_ID = M.FORMID " +
                "AND ((? > M.FORMBEGIN AND M.FORMEND IS NULL) OR (? > M.FORMBEGIN AND ? < M.FORMEND))";

        Map form = sql.selectOne(select, new Object[]{
            project.getUnitID(),
            sql.dateParam(project.getDatesubmitted()),
            sql.dateParam(project.getDatesubmitted()),
            sql.dateParam(project.getDatesubmitted()),
            sql.dateParam(project.getDatesubmitted()),
            sql.dateParam(project.getDatesubmitted()),
            sql.dateParam(project.getDatesubmitted())
        });

        if (form == null) {
            throw new JimFatalException("Cannot find a mark form for unit '" + project.getUnitTxt() + "'");
        }
        markform.setFormID(sql.num2int(form.get("FORM_ID")));
        markform.setFormName((String) form.get("FORMNAME"));

        select = "SELECT C.CATID, C.CATNAME, C.CATLONGNAME, C.CATDESCRIPTION, M.OPTIONAL, C.OPTION_TYPE, C.COG_ID, M.CATWEIGHT, M.CRITICAL " +
                "FROM MARK_FORM_CATEGORIES M, MARK_CATEGORIES C " +
                "WHERE M.FORMID = ? " +
                "AND ((? > M.MFCBEGIN AND M.MFCEND IS NULL) OR (? > M.MFCBEGIN AND ? < M.MFCEND)) " +
                "AND M.CATID = C.CATID AND ((? > C.CATBEGIN AND C.CATEND IS NULL) OR (? > C.CATBEGIN AND ? < C.CATEND)) ORDER BY M.CATINDEX";

        ResultSet cats = sql.selectRS(select, new Object[]{
            markform.getFormID(),
            project.getDatesubmitted(),
            project.getDatesubmitted(),
            project.getDatesubmitted(),
            project.getDatesubmitted(),
            project.getDatesubmitted(),
            project.getDatesubmitted()
        });

        while (cats.next()) {
            Category cat = new Category(cats.getInt(1), cats.getString(2), cats.getString(3), cats.getString(4), cats.getString(5), cats.getString(6), cats.getInt(7), cats.getInt(8), cats.getString(9));
            select = "SELECT O.OPT_ID, O.OPT_LABEL, O.OPT_SELECTED_VALUE, C.POSITIVE_CRITERIA, C.NEGATIVE_CRITERIA " +
                    "FROM CATEGORY_OPTIONS O, CATEGORY_OPTION_CRITERIA C " +
                    "WHERE O.OPT_GROUP = ? " +
                    "AND O.OPT_ID = C.CAT_OPTION " +
                    "AND C.MARK_CATEGORY = ? " +
                    "ORDER BY O.OPT_INDEX";

            ResultSet opts = sql.selectRS(select, new Object[]{
                cat.getOptionGroup(),
                cat.getCategoryID()
            });

            while (opts.next()) {
                Option opt = new Option(opts.getInt(1), opts.getString(2), opts.getFloat(3), opts.getString(4), opts.getString(5));
                cat.addCategoryOption(opt);
            }
            markform.addFormCategory(cat);
        }
        cats.close();
        markform = readMarkForm(project.getProjectID(), markform);
        return markform;
    }

    /**
     * Obtains details of potential prizes a mark form can nominate a project for
     * @return details of prize categories
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public Vector readPrizes() throws SQLException {
        Vector<Prize> prizes = new Vector<Prize>();
        String select = "SELECT PRIZE_CAT_ID, PRIZE_CAT_NAME, PRIZE_VALUE, PRIZE_CAT_CRITERIA " +
                "FROM PRIZE_CATEGORIES";

        ResultSet prz = sql.selectRS(select);

        while (prz.next()) {
            Prize p = new Prize(prz.getInt(1), prz.getString(2), prz.getInt(3), sql.getClobString(prz, 4));
            prizes.add(p);
        }
        prz.close();
        return prizes;
    }
    
    private static final String markFields =
            "MARK_ID, " +
            "PROJECT_ID, " +
            "MARKER_CAPACITY_ID, " +
            "MARK, " +
            "MARK_DATE, " +
            "GENERAL_COMMENTS, " +
            "COMMENTS_FOR_EXAMINERS, " +
            "GENERAL_COMMENTS_EXAMBOARD, " +
            "PLAGIARISM_UNFAIR_ACT, " +
            "PLAGIARISM_COMMENTS, " +
            "UNFAIR_ACT_NOTES, " +
            "ADJUSTMENT_APPLIED, " +
            "PLAGIARISM_SUSPECT";
    private static final String categoryMarkFields =
            "CAT_MARK_ID, " +
            "MARK_ID, " +
            "CAT_ID, " +
            "MARK, " +
            "CAT_COMMENT";
    private static final String optionMarkFields =
            "OPT_MARK_ID, " +
            "MARK_ID, " +
            "CAT_ID, " +
            "CO_ID";
    private static final String prizeNominationFields =
            "PRIZE_NOM_ID, " +
            "PRIZE_CAT_ID, " +
            "MARK_ID, " +
            "SUPPORTING_COMMENTS";

    /**
     * Saves mark form data
     * @param project ID of project mark form relates to
     * @param markform mark form data
     * @throws java.lang.Exception lang exception
     */
    private void updateMarkForm(int project, MarkFormBean markform) throws Exception {
        String select = null;
        String insert = null;
        LoggerService logger = new LoggerService(sql);

        if (markform.getMarkID() > 0) {
            // do an update
            select = "SELECT " + markFields + " FROM MARKS WHERE MARK_ID = ?";
            ResultSet rs = sql.selectRSlock(select, new Object[]{
                markform.getMarkID()
            });
            rs.first();
            // logger stuff goes here
            if ((rs.getInt("MARK") != markform.getProjectMark())) {
                logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - Mark", String.valueOf(rs.getInt("MARK")), String.valueOf(markform.getProjectMark()));
            }
            if (!(sql.getClobString(rs, "GENERAL_COMMENTS").equals(markform.getGeneralComments()))) {
                logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - General Comments", sql.getClobString(rs, "GENERAL_COMMENTS"), markform.getGeneralComments());
            }
            if (!(sql.getClobString(rs, "COMMENTS_FOR_EXAMINERS").equals(markform.getExaminerComments()))) {
                logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - Examiner Comments", sql.getClobString(rs, "COMMENTS_FOR_EXAMINERS"), markform.getExaminerComments());
            }
            // end of logger stuff

            rs.updateInt("PROJECT_ID", project);
            rs.updateInt("MARKER_CAPACITY_ID", markform.getMarkerCapacity());
            rs.updateInt("MARK", markform.getProjectMark());
            rs.updateDate("MARK_DATE", sql.dateParam(new Date()));
            sql.setClobString(rs, "GENERAL_COMMENTS", markform.getGeneralComments());
            sql.setClobString(rs, "COMMENTS_FOR_EXAMINERS", markform.getExaminerComments());
            rs.updateString("PLAGIARISM_SUSPECT", markform.isPlagiarismSuspect() ? "Y" : "N");
            rs.updateInt("ADJUSTMENT_APPLIED", markform.getAdjustment());

            rs.updateRow();
            rs.close();

            String deleteCats = "DELETE FROM CATEGORY_MARKS WHERE MARK_ID = " + markform.getMarkID();
            String deleteOpts = "DELETE FROM OPTION_MARKS WHERE MARK_ID = " + markform.getMarkID();
            String deleteNoms = "DELETE FROM PRIZE_NOMINATIONS WHERE MARK_ID = " + markform.getMarkID();

            sql.doExecute(deleteCats);
            sql.doExecute(deleteOpts);
            sql.doExecute(deleteNoms);

        } else {
            // add new mark record
            insert = "INSERT INTO MARKS(" +
                    "MARK_ID, GENERAL_COMMENTS, COMMENTS_FOR_EXAMINERS, GENERAL_COMMENTS_EXAMBOARD, PLAGIARISM_COMMENTS) " +
                    "VALUES (?, ?, ?, EMPTY_CLOB(), EMPTY_CLOB())";
            markform.setMarkID(sql.nextval("MARKS_1"));
            sql.doExecute(insert, new Object[]{
                markform.getMarkID(),
                markform.getGeneralComments(),
                markform.getExaminerComments()
            });

            select = "SELECT " + markFields + " FROM MARKS WHERE MARK_ID = ?";
            ResultSet rs = sql.selectRSmod(select, new Object[]{
                markform.getMarkID()
            });
            rs.first();

            // logger stuff goes here
            logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - Mark", "", String.valueOf(markform.getProjectMark()));
            logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - General Comments", "", markform.getGeneralComments());
            logger.log(markform.getMarkEnteredBy(), project, markform.getMarkerCapacityDesc() + " Project Mark - Examiner Comments", "", markform.getExaminerComments());
            // end of logger stuff

            rs.updateInt("MARK_ID", markform.getMarkID());
            rs.updateInt("PROJECT_ID", project);
            rs.updateInt("MARKER_CAPACITY_ID", markform.getMarkerCapacity());
            rs.updateInt("MARK", markform.getProjectMark());
            rs.updateDate("MARK_DATE", sql.dateParam(new Date()));
            rs.updateString("PLAGIARISM_SUSPECT", markform.isPlagiarismSuspect() ? "Y" : "N");
            rs.updateInt("ADJUSTMENT_APPLIED", markform.getAdjustment());
            //TODO: perhaps uncomment these and change to selectRSlock above
            //            sql.setClobString(rs, "GENERAL_COMMENTS", markform.getGeneralComments());
            //            sql.setClobString(rs, "COMMENTS_FOR_EXAMINERS", markform.getExaminerComments());
            rs.updateRow();
            rs.close();
        }

        //        select = "SELECT " + categoryMarkFields + " FROM CATEGORY_MARKS";
        //        ResultSet catrs = sql.selectRSmod(select);

        //        select = "SELECT " + optionMarkFields + " FROM OPTION_MARKS";
        //        ResultSet optrs = sql.selectRSmod(select);

        Iterator it = markform.getFormCategories().iterator();
        while (it.hasNext()) {
            Category cat = (Category) it.next();
            if (cat.getMark() > -1) {
                //                catrs.moveToInsertRow();
                String catInsert = "INSERT INTO CATEGORY_MARKS (" +
                        categoryMarkFields + ") VALUES (?, ?, ?, ?, ?)";
                int catMarkId = sql.nextval("CATEGORY_MARKS_1");
                sql.doExecute(catInsert, new Object[]{
                    sql.intParam(catMarkId),
                    sql.intParam(markform.getMarkID()),
                    sql.intParam(cat.getCategoryID()),
                    sql.intParam(cat.getMark()),
                    sql.clobParam(cat.getComments())
                });

                //                catrs.updateInt("MARK_ID", markform.getMarkID());
                //                catrs.updateInt("CAT_ID", cat.getCategoryID());
                //                catrs.updateInt("MARK", cat.getMark());
                //                sql.setClobString(catrs, "CAT_COMMENT", cat.getComments());
                //                catrs.insertRow();

                int[] optionsSelected = cat.getOptionsSelected();
                Vector options = cat.getCategoryOptions();
                for (int i = 0; i < optionsSelected.length; i++) {
                    Option opt = (Option) options.get(optionsSelected[i]);
                    String optInsert = "INSERT INTO OPTION_MARKS (" +
                            optionMarkFields + ") VALUES (?, ?, ?, ?)";
                    int optMarkId = sql.nextval("OPTION_MARKS_1");
                    sql.doExecute(optInsert, new Object[]{
                        sql.intParam(optMarkId),
                        sql.intParam(markform.getMarkID()),
                        sql.intParam(cat.getCategoryID()),
                        sql.intParam(opt.getOptionID())
                    });
                //                    optrs.moveToInsertRow();
                //
                //                    optrs.updateInt("MARK_ID", markform.getMarkID());
                //                    optrs.updateInt("CAT_ID", cat.getCategoryID());
                //                    optrs.updateInt("CO_ID", opt.getOptionID());
                //
                //                    optrs.insertRow();
                }
            }
        }
        //        catrs.close();
        //        optrs.close();

        it = markform.getPrizeNominations().iterator();

        //        select = "SELECT " + prizeNominationFields + " FROM PRIZE_NOMINATIONS";
        //        ResultSet przrs = sql.selectRSmod(select);

        while (it.hasNext()) {
            PrizeNomination nom = (PrizeNomination) it.next();
            String prizeInsert = "INSERT INTO PRIZE_NOMINATIONS (" +
                    prizeNominationFields + ") VALUES (?, ?, ?, ?)";
            int prizeId = sql.nextval("PRIZE_NOMINATIONS_1");
            sql.doExecute(prizeInsert, new Object[]{
                sql.intParam(prizeId),
                sql.intParam(nom.getPrizeID()),
                sql.intParam(markform.getMarkID()),
                sql.clobParam(nom.getJustification())
            });
        //            przrs.moveToInsertRow();
        //            przrs.updateInt("PRIZE_CAT_ID",nom.getPrizeID());
        //            przrs.updateInt("MARK_ID", markform.getMarkID());
        //            sql.setClobString(przrs, "SUPPORTING_COMMENTS", nom.getJustification());
        //            przrs.insertRow();
        }
    //        przrs.close();
    }

    /**
     * Populates a mark form with previously entered data
     * @param project ID of project mark form relates to
     * @param markform project mark form
     * @return populated project mark form
     * @throws java.sql.SQLException in the event of SQL errors
     */
    private MarkFormBean readMarkForm(int project, MarkFormBean markform) throws SQLException {
        String select = "SELECT " + markFields + " FROM MARKS WHERE MARKER_CAPACITY_ID = ? AND PROJECT_ID = ?";
        ResultSet mark = sql.selectRS(select, new Object[]{
            markform.getMarkerCapacity(),
            project
        });

        if (mark.next()) {
            markform.setMarkID(mark.getInt("MARK_ID"));
            markform.setGeneralComments(sql.getClobString(mark, "GENERAL_COMMENTS"));
            markform.setExaminerComments(sql.getClobString(mark, "COMMENTS_FOR_EXAMINERS"));
            markform.setPlagiarismSuspect(mark.getString("PLAGIARISM_SUSPECT").equalsIgnoreCase("Y"));
            markform.setAdjustment(mark.getInt("ADJUSTMENT_APPLIED"));

            mark.close();

            Vector categories = markform.getFormCategories();
            Vector<Category> populatedCategories = new Vector<Category>();

            Iterator it = categories.iterator();
            while (it.hasNext()) {
                Category cat = (Category) it.next();
                select = "SELECT CAT_COMMENT FROM CATEGORY_MARKS WHERE MARK_ID = ? AND CAT_ID = ?";
                ResultSet cats = sql.selectRS(select, new Object[]{
                    markform.getMarkID(),
                    cat.getCategoryID()
                });

                while (cats.next()) {
                    cat.setComments(sql.getClobString(cats, "CAT_COMMENT"));
                }
                cats.close();
                // find out how many options were selected for this cat

                select = "SELECT COUNT(*) FROM OPTION_MARKS WHERE MARK_ID = ? AND CAT_ID = ?";
                ResultSet optcount = sql.selectRS(select, new Object[]{
                    markform.getMarkID(),
                    cat.getCategoryID()
                });

                int totalopts = 0;

                optcount.next();
                totalopts = optcount.getInt(1);
                optcount.close();

                if (totalopts > 0) {
                    // create array to hold options selected
                    int[] opts_selected = new int[totalopts];

                    // holds current array slot to be used
                    int current_pos = 0;

                    // holds the index of the current option
                    int opt_index = 0;

                    Iterator it2 = cat.getCategoryOptions().iterator();

                    while (it2.hasNext()) {
                        Option opt = (Option) it2.next();
                        select = "SELECT COUNT(*) FROM OPTION_MARKS WHERE MARK_ID = ? AND CAT_ID = ? AND CO_ID = ?";
                        ResultSet optselected = sql.selectRS(select, new Object[]{
                            markform.getMarkID(),
                            cat.getCategoryID(),
                            opt.getOptionID()
                        });

                        optselected.next();

                        if (optselected.getInt(1) > 0) {
                            opts_selected[current_pos] = opt_index;
                            current_pos++;
                        }
                        optselected.close();
                        opt_index++;
                    }

                    cat.setOptionsSelected(opts_selected);
                }
                populatedCategories.add(cat);
            }

            markform.setFormCategories(populatedCategories);
        }

        select = "SELECT PRIZE_CAT_ID, SUPPORTING_COMMENTS FROM PRIZE_NOMINATIONS WHERE MARK_ID = ?";
        ResultSet prizenoms = sql.selectRS(select, new Object[]{
            markform.getMarkID()
        });
        while (prizenoms.next()) {
            markform.addPrizeNomination(new PrizeNomination(prizenoms.getInt(1), sql.getClobString(prizenoms, "SUPPORTING_COMMENTS")));
        }
        prizenoms.close();
        return markform;
    }

    private boolean isMarkAgreed(int supmark, int modmark) {
        if (supmark >= 40 && modmark < 40) {
            return false;
        }
        if (modmark >= 40 && supmark < 40) {
            return false;
        }
        if (Math.abs(supmark - modmark) > 10) {
            return false;
        }
        return true;
    }

    /**
     * Processes mark form, initiates save of mark form data and updates to project mark and status
     * @param project project being marked
     * @param markform project mark form
     * @return project with updated status and mark if applicable
     * @throws java.lang.Exception lang error
     */
    public Project processMarkForm(Project project, MarkFormBean markform) throws Exception {

        String select = null;
        boolean markedbyboth = false;

        updateMarkForm(project.getProjectID(), markform);

        EmailService email = new EmailService(sql);
        Map<String, Object> args = project.getProjectMap();
        args = markform.getMarkFormMap(args);
        int[] coords = project.getCoordinatorIDs();
        int[] recips = new int[coords.length + 1];
        System.arraycopy(coords, 0, recips, 0, coords.length);
        recips[recips.length - 1] = markform.getMarker().getID();
        email.sendEmail(recips, "MARKCONF", args);

        if (markform.getMarkerCapacityDesc().equals("Supervisor")) {
            project.setComments(markform.getGeneralComments());
        }

        if (project.getStatus().equals("A")) {
            if (isMarkSubmitted(project.getProjectID(), project.getMarker("Supervisor").getID())) {
                project.setStatus("S");
            }
            if (isMarkSubmitted(project.getProjectID(), project.getMarker("Moderator").getID())) {
                project.setStatus("M");
            }
        } else if (project.getStatus().equals("S") || project.getStatus().equals("M")) {
            boolean supermarked = false;
            boolean modermarked = false;

            supermarked = isMarkSubmitted(project.getProjectID(), project.getMarker("Supervisor").getID());
            modermarked = isMarkSubmitted(project.getProjectID(), project.getMarker("Moderator").getID());

            if (supermarked && modermarked) {
                markedbyboth = true;
            }
        }

        if (markedbyboth || (project.getStatus().equals("SM")) || (project.getStatus().equals("R1A"))) {
            // both super and mod have marked the project, time to work out the average
            int supermark = findMarkByMarker(project.getProjectID(), project.getMarker("Supervisor").getID());
            int modermark = findMarkByMarker(project.getProjectID(), project.getMarker("Moderator").getID());

            if (isMarkAgreed(supermark, modermark)) {
                project.setStatus("SM");
                project.setMark((supermark + modermark + 1) / 2); //+1 to ensure it rounds up
            } else {
                project.setStatus("R1A");
                project.setMark(0);
            }
        }

        if ((project.getStatus().equals("R2B")) || (project.getStatus().equals("R2C"))) {
            project.setStatus("R2C");
        }

        if ((project.getStatus().equals("R3B")) || (project.getStatus().equals("R3C"))) {
            project.setStatus("R3C");
        }

        return project;
    }

    /**
     * Used for processing the mark reconcilliation form.  Updates project mark and status.
     * @param project project being reconcilled
     * @return project with updated mark and status
     */
    public Project processReconcilliationForm(Project project, ReconciliationForm form) {

        project.setMark(form.getMark());
        String originalStatus = project.getStatus();

        if (originalStatus.equals("R1A") || originalStatus.equals("SM")) {
            project.setStatus("R1M");
        } else if (originalStatus.equals("R2C")) {
            project.setStatus("R2M");
        } else if (originalStatus.equals("R3C")) {
            project.setStatus("R3M");
        }
        project.addReconComments("[Reconciliation " + project.getStatus() + " reason]:\n" + form.getReason());
        return project;
    }

    /**
     * Establishes if a person has marked a project
     * @param project ID of project being marked
     * @param person ID of marker
     * @return true if person has submitted a mark for the project
     * false if the person has not marked the project
     * @throws java.sql.SQLException in the event of SQL errors
     */
    private boolean isMarkSubmitted(int project, int person) throws SQLException {

        boolean submitted = false;

        String select = "SELECT COUNT(*) FROM MARKS M, MARKER_CAPACITY C " +
                "WHERE M.PROJECT_ID = ? " +
                "AND M.MARKER_CAPACITY_ID = C.MARKER_CAPACITY_ID " +
                "AND C.PERSON_ID = ?";

        ResultSet submitcheck = sql.selectRS(select, new Object[]{
            project,
            person
        });

        submitcheck.next();
        if (submitcheck.getInt(1) > 0) {
            submitted = true;
        }
        submitcheck.close();
        return submitted;

    }

    /**
     * Retrieves project mark assigned by a specified marker
     * @param project ID of project
     * @param person ID of marker
     * @return mark that the person has assigned to the project
     * @throws java.sql.SQLException in the event of SQL errors
     */
    private int findMarkByMarker(int project, int person) throws SQLException {

        int mark = 0;

        String select = "SELECT M.MARK " +
                "FROM MARKS M, MARKER_CAPACITY C " +
                "WHERE M.PROJECT_ID = ? " +
                "AND M.MARKER_CAPACITY_ID = C.MARKER_CAPACITY_ID " +
                "AND C.PERSON_ID = ?";

        ResultSet markgetter = sql.selectRS(select, new Object[]{
            project,
            person
        });

        markgetter.next();
        mark = markgetter.getInt(1);
        markgetter.close();

        return mark;
    }

    /**
     * Retreives marker capacity information to associate with the project mark form
     * @param markform project mark form
     * @param project project being marked
     * @param marker ID of person marking the project
     * @return mark form with updated marker capacity information
     * @throws java.sql.SQLException in the event of SQL errors
     */
    private MarkFormBean updateMarker(MarkFormBean markform, int project, int marker) throws SQLException {

        String select = null;

        select = "SELECT C.MARKER_CAPACITY_ID, T.MARKER_DESCRIPTION, P.PERSON_ID, P.FIRST_NAME, P.SURNAME " +
                "FROM MARKER_CAPACITY C, MARKER_TYPE T, PERSON P " +
                "WHERE C.PROJECT_ID = ? " +
                "AND C.PERSON_ID = ? " +
                "AND C.UNALLOCATED_DATE IS NULL " +
                "AND C.PERSON_ID = P.PERSON_ID " +
                "AND C.MARKER_TYPE_ID = T.MARKER_TYPE_ID";

        ResultSet markerRS = sql.selectRS(select, new Object[]{
            project,
            marker
        });

        while (markerRS.next()) {
            markform.setMarkerCapacity(markerRS.getInt(1));
            markform.setMarkerCapacityDesc(markerRS.getString(2));
            markform.setMarker(new StaffBean(markerRS.getInt(3), markerRS.getString(4), markerRS.getString(5)));
        }

        markerRS.close();

        return markform;

    }

    /**
     * Retrieves all marks assigned to a project
     * @param project ID of project to retrieve marks for
     * @return marks assigned to a project.  key references the marker's capacity
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public Map<String, MarkerMark> readMarkerMarksByProjectId(int project) throws SQLException {

        String select = "SELECT T.MARKER_DESCRIPTION, P.FIRST_NAME, P.SURNAME, " +
                "P.PERSON_ID, M.MARK_DATE, M.MARK, M.PLAGIARISM_SUSPECT " +
                "FROM MARKS M, PERSON P, MARKER_CAPACITY C, MARKER_TYPE T " +
                "WHERE M.PROJECT_ID = ? " +
                "AND M.MARKER_CAPACITY_ID = C.MARKER_CAPACITY_ID " +
                "AND C.PERSON_ID = P.PERSON_ID " +
                "AND C.MARKER_TYPE_ID = T.MARKER_TYPE_ID " +
                "ORDER BY T.MARKER_TYPE_ID";

        ResultSet marks = sql.selectRS(select, new Object[]{
            project
        });

        Map<String, MarkerMark> markermarks = new HashMap<String, MarkerMark>();

        while (marks.next()) {
            markermarks.put(marks.getString(1),
                    new MarkerMark(marks.getString(2) + " " + marks.getString(3),
                    marks.getInt(4), marks.getDate(5), marks.getInt(6), "Y".equalsIgnoreCase(marks.getString(7))));
        }
        marks.close();
        return markermarks;
    }
}
