REM This DDL was reverse engineered by
REM TOra, Version 1.2.4
REM
REM at:   Jim-Dell-LAPTOP
REM from: SQL*Net, an Oracle Release 0.1.0.2.0 instance
REM
REM on:   Thu 29. Sep 13:10:37 2005
REM
REM Generating CREATE statements for:
REM
REM USER:OPMS
REM TABLE FAMILY:OPMS.AUDIT
REM TABLE FAMILY:OPMS.CATEGORY_MARKS
REM TABLE FAMILY:OPMS.CATEGORY_OPTION_CRITERIA
REM TABLE FAMILY:OPMS.CATEGORY_OPTION_GROUPS
REM TABLE FAMILY:OPMS.CATEGORY_OPTIONS
REM TABLE FAMILY:OPMS.COHORT
REM TABLE FAMILY:OPMS.COHORT_COORDINATORS
REM TABLE FAMILY:OPMS.CONTACTS
REM TABLE FAMILY:OPMS.EMAILMESSAGES
REM TABLE FAMILY:OPMS.EMAILS
REM TABLE FAMILY:OPMS.FINAL_PROJECT
REM TABLE FAMILY:OPMS.IDEAS2
REM TABLE FAMILY:OPMS.MARK_CATEGORIES
REM TABLE FAMILY:OPMS.MARK_FORM_CATEGORIES
REM TABLE FAMILY:OPMS.MARK_FORMS
REM TABLE FAMILY:OPMS.MARKER_CAPACITY
REM TABLE FAMILY:OPMS.MARKER_TYPE
REM TABLE FAMILY:OPMS.MARKS
REM TABLE FAMILY:OPMS.OPTION_MARKS
REM TABLE FAMILY:OPMS.PERSON
REM TABLE FAMILY:OPMS.PERSON_EMAIL
REM TABLE FAMILY:OPMS.PERSON_ROLES
REM TABLE FAMILY:OPMS.PRIZE_CATEGORIES
REM TABLE FAMILY:OPMS.PRIZE_NOMINATIONS
REM TABLE FAMILY:OPMS.ROLES
REM TABLE FAMILY:OPMS.STAFF
REM TABLE FAMILY:OPMS.STATUSES
REM TABLE FAMILY:OPMS.STUDENT
REM TABLE FAMILY:OPMS.TEL_NUMBER
REM TABLE FAMILY:OPMS.UNIT
REM TABLE FAMILY:OPMS.UNIT_MARK_FORMS
REM SEQUENCE:OPMS.AUDIT_0
REM SEQUENCE:OPMS.AUDIT_1
REM SEQUENCE:OPMS.CATEGORY_MARKS_0
REM SEQUENCE:OPMS.CATEGORY_MARKS_1
REM SEQUENCE:OPMS.CATEGORY_OPTION_CRITERIA_0
REM SEQUENCE:OPMS.CATEGORY_OPTION_CRITERIA_1
REM SEQUENCE:OPMS.CATEGORY_OPTION_GROUPS_0
REM SEQUENCE:OPMS.CATEGORY_OPTION_GROUPS_1
REM SEQUENCE:OPMS.CATEGORY_OPTIONS_0
REM SEQUENCE:OPMS.CATEGORY_OPTIONS_1
REM SEQUENCE:OPMS.COHORT_0
REM SEQUENCE:OPMS.COHORT_1
REM SEQUENCE:OPMS.COHORT_COORDINATORS_0
REM SEQUENCE:OPMS.COHORT_COORDINATORS_1
REM SEQUENCE:OPMS.COHORT_COORDINATORS_2
REM SEQUENCE:OPMS.CONTACTS_0
REM SEQUENCE:OPMS.CONTACTS_1
REM SEQUENCE:OPMS.FINAL_PROJECT_0
REM SEQUENCE:OPMS.FINAL_PROJECT_1
REM SEQUENCE:OPMS.IDEAS2_0
REM SEQUENCE:OPMS.IDEAS2_1
REM SEQUENCE:OPMS.MARK_CATEGORIES_0
REM SEQUENCE:OPMS.MARK_CATEGORIES_1
REM SEQUENCE:OPMS.MARK_FORM_CATEGORIES_0
REM SEQUENCE:OPMS.MARK_FORM_CATEGORIES_1
REM SEQUENCE:OPMS.MARK_FORMS_0
REM SEQUENCE:OPMS.MARK_FORMS_1
REM SEQUENCE:OPMS.MARKER_CAPACITY_0
REM SEQUENCE:OPMS.MARKER_CAPACITY_1
REM SEQUENCE:OPMS.MARKER_TYPE_0
REM SEQUENCE:OPMS.MARKER_TYPE_1
REM SEQUENCE:OPMS.MARKS_0
REM SEQUENCE:OPMS.MARKS_1
REM SEQUENCE:OPMS.OPTION_MARKS_0
REM SEQUENCE:OPMS.OPTION_MARKS_1
REM SEQUENCE:OPMS.PERSON_0
REM SEQUENCE:OPMS.PERSON_1
REM SEQUENCE:OPMS.PERSON_EMAIL_0
REM SEQUENCE:OPMS.PERSON_EMAIL_1
REM SEQUENCE:OPMS.PRIZE_CATEGORIES_0
REM SEQUENCE:OPMS.PRIZE_CATEGORIES_1
REM SEQUENCE:OPMS.PRIZE_NOMINATIONS_0
REM SEQUENCE:OPMS.PRIZE_NOMINATIONS_1
REM SEQUENCE:OPMS.ROLES_0
REM SEQUENCE:OPMS.ROLES_1
REM SEQUENCE:OPMS.STUDENT_0
REM SEQUENCE:OPMS.STUDENT_1
REM SEQUENCE:OPMS.TEL_NUMBER_0
REM SEQUENCE:OPMS.TEL_NUMBER_1
REM SEQUENCE:OPMS.UNIT_0
REM SEQUENCE:OPMS.UNIT_1
REM SEQUENCE:OPMS.UNIT_MARK_FORMS_0
REM SEQUENCE:OPMS.UNIT_MARK_FORMS_1
REM TABLE CONTENTS:OPMS.AUDIT
REM TABLE CONTENTS:OPMS.CATEGORY_MARKS
REM TABLE CONTENTS:OPMS.CATEGORY_OPTION_CRITERIA
REM TABLE CONTENTS:OPMS.CATEGORY_OPTION_GROUPS
REM TABLE CONTENTS:OPMS.CATEGORY_OPTIONS
REM TABLE CONTENTS:OPMS.COHORT
REM TABLE CONTENTS:OPMS.COHORT_COORDINATORS
REM TABLE CONTENTS:OPMS.CONTACTS
REM TABLE CONTENTS:OPMS.EMAILMESSAGES
REM TABLE CONTENTS:OPMS.EMAILS
REM TABLE CONTENTS:OPMS.FINAL_PROJECT
REM TABLE CONTENTS:OPMS.IDEAS2
REM TABLE CONTENTS:OPMS.MARK_CATEGORIES
REM TABLE CONTENTS:OPMS.MARK_FORM_CATEGORIES
REM TABLE CONTENTS:OPMS.MARK_FORMS
REM TABLE CONTENTS:OPMS.MARKER_CAPACITY
REM TABLE CONTENTS:OPMS.MARKER_TYPE
REM TABLE CONTENTS:OPMS.MARKS
REM TABLE CONTENTS:OPMS.OPTION_MARKS
REM TABLE CONTENTS:OPMS.PERSON
REM TABLE CONTENTS:OPMS.PERSON_EMAIL
REM TABLE CONTENTS:OPMS.PERSON_ROLES
REM TABLE CONTENTS:OPMS.PRIZE_CATEGORIES
REM TABLE CONTENTS:OPMS.PRIZE_NOMINATIONS
REM TABLE CONTENTS:OPMS.ROLES
REM TABLE CONTENTS:OPMS.STAFF
REM TABLE CONTENTS:OPMS.STATUSES
REM TABLE CONTENTS:OPMS.STUDENT
REM TABLE CONTENTS:OPMS.TEL_NUMBER
REM TABLE CONTENTS:OPMS.UNIT
REM TABLE CONTENTS:OPMS.UNIT_MARK_FORMS
REM USER GRANTS:OPMS

PROMPT CREATE TABLE audit

CREATE TABLE "AUDIT"
(
    audit_id                         NUMBER   (11)                    NOT NULL
  , person_making_change_id          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , project_being_changed_id         NUMBER   (11)                    DEFAULT 0 NOT NULL
  , reason                           CLOB                             
  , date_altered                     DATE                             
  , item_changed                     VARCHAR2 (128)                   NOT NULL
  , old_value_of_item                CLOB                             
  , new_value_of_item                CLOB                             
  , time_altered                     DATE                             
)
;

PROMPT CREATE UNIQUE INDEX primary00027 ON audit

CREATE UNIQUE INDEX primary00027 ON "AUDIT"
(
    audit_id
)
;

PROMPT ALTER TABLE "AUDIT" ADD CONSTRAINT primary00027 PRIMARY KEY

ALTER TABLE "AUDIT" ADD CONSTRAINT primary00027 PRIMARY KEY
(
    audit_id
)
ENABLE;

PROMPT CREATE TABLE category_marks

CREATE TABLE category_marks
(
    cat_mark_id                      NUMBER   (11)                    NOT NULL
  , mark_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , cat_id                           NUMBER   (11)                    DEFAULT 0 NOT NULL
  , mark                             NUMBER   (10)                    DEFAULT 0 NOT NULL
  , "COMMENT"                        CLOB                             
)
;

PROMPT CREATE UNIQUE INDEX primary00028 ON category_marks

CREATE UNIQUE INDEX primary00028 ON category_marks
(
    cat_mark_id
)
;

PROMPT ALTER TABLE category_marks ADD CONSTRAINT primary00028 PRIMARY KEY

ALTER TABLE category_marks ADD CONSTRAINT primary00028 PRIMARY KEY
(
    cat_mark_id
)
ENABLE;

PROMPT CREATE TABLE category_option_criteria

CREATE TABLE category_option_criteria
(
    opt_criteria_id                  NUMBER   (11)                    NOT NULL
  , "OPTION"                         NUMBER   (11)                    DEFAULT 0 NOT NULL
  , mark_category                    NUMBER   (11)                    DEFAULT 0 NOT NULL
  , positive_criteria                CLOB                             
  , negative_criteria                CLOB                             
)
;

PROMPT CREATE UNIQUE INDEX primary00029 ON category_option_criteria

CREATE UNIQUE INDEX primary00029 ON category_option_criteria
(
    opt_criteria_id
)
;

PROMPT ALTER TABLE category_option_criteria ADD CONSTRAINT primary00029 PRIMARY KEY

ALTER TABLE category_option_criteria ADD CONSTRAINT primary00029 PRIMARY KEY
(
    opt_criteria_id
)
ENABLE;

PROMPT CREATE TABLE category_option_groups

CREATE TABLE category_option_groups
(
    opt_group_id                     NUMBER   (11)                    NOT NULL
  , opt_group_name                   VARCHAR2 (64)                    
)
;

PROMPT CREATE UNIQUE INDEX primary00030 ON category_option_groups

CREATE UNIQUE INDEX primary00030 ON category_option_groups
(
    opt_group_id
)
;

PROMPT ALTER TABLE category_option_groups ADD CONSTRAINT primary00030 PRIMARY KEY

ALTER TABLE category_option_groups ADD CONSTRAINT primary00030 PRIMARY KEY
(
    opt_group_id
)
ENABLE;

PROMPT CREATE TABLE category_options

CREATE TABLE category_options
(
    opt_id                           NUMBER   (11)                    NOT NULL
  , opt_label                        VARCHAR2 (30)                    NOT NULL
  , opt_selected_value               NUMBER   (10)                    DEFAULT 0 NOT NULL
  , opt_group                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , opt_index                        NUMBER   (11)                    DEFAULT 0 NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00031 ON category_options

CREATE UNIQUE INDEX primary00031 ON category_options
(
    opt_id
)
;

PROMPT ALTER TABLE category_options ADD CONSTRAINT primary00031 PRIMARY KEY

ALTER TABLE category_options ADD CONSTRAINT primary00031 PRIMARY KEY
(
    opt_id
)
ENABLE;

PROMPT CREATE TABLE cohort

CREATE TABLE cohort
(
    cohort_id                        NUMBER   (11)                    NOT NULL
  , cohort_description               VARCHAR2 (128)                   NOT NULL
  , project_start_date               DATE                             
  , project_end_date                 DATE                             
  , cohort_closed                    VARCHAR2 (1)                     
)
;

PROMPT CREATE UNIQUE INDEX primary00032 ON cohort

CREATE UNIQUE INDEX primary00032 ON cohort
(
    cohort_id
)
;

PROMPT ALTER TABLE cohort ADD CONSTRAINT primary00032 PRIMARY KEY

ALTER TABLE cohort ADD CONSTRAINT primary00032 PRIMARY KEY
(
    cohort_id
)
ENABLE;

PROMPT CREATE TABLE cohort_coordinators

CREATE TABLE cohort_coordinators
(
    co_cord_id                       NUMBER   (11)                    NOT NULL
  , cohort_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00000 ON cohort_coordinators

CREATE UNIQUE INDEX primary00000 ON cohort_coordinators
(
    co_cord_id
)
;

PROMPT ALTER TABLE cohort_coordinators ADD CONSTRAINT primary00000 PRIMARY KEY

ALTER TABLE cohort_coordinators ADD CONSTRAINT primary00000 PRIMARY KEY
(
    co_cord_id
)
ENABLE;

PROMPT CREATE TABLE contacts

CREATE TABLE contacts
(
    orgaddr                          VARCHAR2 (100)                   
  , orgcontact                       VARCHAR2 (50)                    
  , orgdoes                          VARCHAR2 (50)                    
  , orgemail                         VARCHAR2 (50)                    
  , orgid                            NUMBER   (11)                    NOT NULL
  , orgname                          VARCHAR2 (50)                    
  , orgpostcode                      VARCHAR2 (10)                    
  , orgtel                           VARCHAR2 (20)                    
)
;

PROMPT CREATE UNIQUE INDEX primary00034 ON contacts

CREATE UNIQUE INDEX primary00034 ON contacts
(
    orgid
)
;

PROMPT ALTER TABLE contacts ADD CONSTRAINT primary00034 PRIMARY KEY

ALTER TABLE contacts ADD CONSTRAINT primary00034 PRIMARY KEY
(
    orgid
)
ENABLE;

PROMPT CREATE TABLE emailmessages

CREATE TABLE emailmessages
(
    mailkey                          VARCHAR2 (30)                    NOT NULL
  , mailvalue                        CLOB                             
)
;

PROMPT CREATE TABLE emails

CREATE TABLE emails
(
    email                            VARCHAR2 (100)                   NOT NULL
  , userid                           CLOB                             
)
;

PROMPT CREATE TABLE final_project

CREATE TABLE final_project
(
    project_id                       NUMBER   (11)                    NOT NULL
  , student_id                       NUMBER   (11)                    DEFAULT 0 NOT NULL
  , cohort_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , unit_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , project_title                    VARCHAR2 (50)                    NOT NULL
  , project_submitted_date           DATE                             
  , late_hand_in                     VARCHAR2 (1)                     
  , unit_exam_board_decision         DATE                             
  , project_status                   VARCHAR2 (3)                     
  , project_mark                     NUMBER   (11)                    
  , project_comments                 CLOB                             
)
;

PROMPT CREATE UNIQUE INDEX primary00035 ON final_project

CREATE UNIQUE INDEX primary00035 ON final_project
(
    project_id
)
;

PROMPT ALTER TABLE final_project ADD CONSTRAINT primary00035 PRIMARY KEY

ALTER TABLE final_project ADD CONSTRAINT primary00035 PRIMARY KEY
(
    project_id
)
ENABLE;

PROMPT CREATE TABLE ideas2

CREATE TABLE ideas2
(
    projaims                         CLOB                             
  , projapproved                     VARCHAR2 (1)                     
  , projdate                         DATE                             
  , projdeliver                      CLOB                             
  , projid                           NUMBER   (11)                    NOT NULL
  , projorg                          NUMBER   (11)                    
  , projquest                        CLOB                             
  , projstudent                      VARCHAR2 (100)                   
  , projtitle                        VARCHAR2 (100)                   
)
;

PROMPT CREATE UNIQUE INDEX primary00036 ON ideas2

CREATE UNIQUE INDEX primary00036 ON ideas2
(
    projid
)
;

PROMPT ALTER TABLE ideas2 ADD CONSTRAINT primary00036 PRIMARY KEY

ALTER TABLE ideas2 ADD CONSTRAINT primary00036 PRIMARY KEY
(
    projid
)
ENABLE;

PROMPT CREATE TABLE mark_categories

CREATE TABLE mark_categories
(
    catbegin                         DATE                             NOT NULL
  , catdescription                   CLOB                             
  , catend                           DATE                             
  , catid                            NUMBER   (11)                    NOT NULL
  , catlongname                      VARCHAR2 (100)                   NOT NULL
  , catname                          VARCHAR2 (30)                    NOT NULL
  , cog_id                           NUMBER   (11)                    DEFAULT 0 NOT NULL
  , option_type                      VARCHAR2 (1)                     NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00037 ON mark_categories

CREATE UNIQUE INDEX primary00037 ON mark_categories
(
    catid
)
;

PROMPT ALTER TABLE mark_categories ADD CONSTRAINT primary00037 PRIMARY KEY

ALTER TABLE mark_categories ADD CONSTRAINT primary00037 PRIMARY KEY
(
    catid
)
ENABLE;

PROMPT CREATE TABLE mark_form_categories

CREATE TABLE mark_form_categories
(
    catid                            NUMBER   (11)                    DEFAULT 0 NOT NULL
  , catindex                         NUMBER   (11)                    
  , catweight                        NUMBER   (10)                    
  , formid                           NUMBER   (11)                    DEFAULT 0 NOT NULL
  , mfcbegin                         DATE                             
  , mfcend                           DATE                             
  , mfcid                            NUMBER   (11)                    NOT NULL
  , optional                         VARCHAR2 (1)                     
)
;

PROMPT CREATE UNIQUE INDEX primary00038 ON mark_form_categories

CREATE UNIQUE INDEX primary00038 ON mark_form_categories
(
    mfcid
)
;

PROMPT ALTER TABLE mark_form_categories ADD CONSTRAINT primary00038 PRIMARY KEY

ALTER TABLE mark_form_categories ADD CONSTRAINT primary00038 PRIMARY KEY
(
    mfcid
)
ENABLE;

PROMPT CREATE TABLE mark_forms

CREATE TABLE mark_forms
(
    formbegin                        DATE                             
  , formend                          DATE                             
  , formid                           NUMBER   (11)                    NOT NULL
  , formname                         VARCHAR2 (255)                   NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00039 ON mark_forms

CREATE UNIQUE INDEX primary00039 ON mark_forms
(
    formid
)
;

PROMPT ALTER TABLE mark_forms ADD CONSTRAINT primary00039 PRIMARY KEY

ALTER TABLE mark_forms ADD CONSTRAINT primary00039 PRIMARY KEY
(
    formid
)
ENABLE;

PROMPT CREATE TABLE marker_capacity

CREATE TABLE marker_capacity
(
    marker_capacity_id               NUMBER   (11)                    NOT NULL
  , project_id                       NUMBER   (11)                    DEFAULT 0 NOT NULL
  , marker_type_id                   NUMBER   (11)                    DEFAULT 0 NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , allocated_date                   DATE                             
  , unallocated_date                 DATE                             
)
;

PROMPT CREATE UNIQUE INDEX primary00040 ON marker_capacity

CREATE UNIQUE INDEX primary00040 ON marker_capacity
(
    marker_capacity_id
)
;

PROMPT ALTER TABLE marker_capacity ADD CONSTRAINT primary00040 PRIMARY KEY

ALTER TABLE marker_capacity ADD CONSTRAINT primary00040 PRIMARY KEY
(
    marker_capacity_id
)
ENABLE;

PROMPT CREATE TABLE marker_type

CREATE TABLE marker_type
(
    marker_type_id                   NUMBER   (11)                    NOT NULL
  , marker_description               VARCHAR2 (64)                    NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00041 ON marker_type

CREATE UNIQUE INDEX primary00041 ON marker_type
(
    marker_type_id
)
;

PROMPT ALTER TABLE marker_type ADD CONSTRAINT primary00041 PRIMARY KEY

ALTER TABLE marker_type ADD CONSTRAINT primary00041 PRIMARY KEY
(
    marker_type_id
)
ENABLE;

PROMPT CREATE TABLE marks

CREATE TABLE marks
(
    mark_id                          NUMBER   (11)                    NOT NULL
  , project_id                       NUMBER   (11)                    DEFAULT 0 NOT NULL
  , marker_capacity_id               NUMBER   (11)                    DEFAULT 0 NOT NULL
  , mark                             NUMBER   (10)                    DEFAULT 0 NOT NULL
  , mark_date                        DATE                             
  , general_comments                 CLOB                             
  , comments_for_examiners           CLOB                             
  , general_comments_examboard       CLOB                             
  , plagiarism_unfair_act            VARCHAR2 (1)                     
  , plagiarism_comments              CLOB                             
  , unfair_act_notes                 CLOB                             
  , adjustment_applied               NUMBER   (11)                    
  , plagiarism_suspect               VARCHAR2 (1)                     
)
;

PROMPT CREATE UNIQUE INDEX primary00042 ON marks

CREATE UNIQUE INDEX primary00042 ON marks
(
    mark_id
)
;

PROMPT ALTER TABLE marks ADD CONSTRAINT primary00042 PRIMARY KEY

ALTER TABLE marks ADD CONSTRAINT primary00042 PRIMARY KEY
(
    mark_id
)
ENABLE;

PROMPT CREATE TABLE option_marks

CREATE TABLE option_marks
(
    opt_mark_id                      NUMBER   (11)                    NOT NULL
  , mark_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , cat_id                           NUMBER   (11)                    DEFAULT 0 NOT NULL
  , co_id                            NUMBER   (11)                    DEFAULT 0 NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00043 ON option_marks

CREATE UNIQUE INDEX primary00043 ON option_marks
(
    opt_mark_id
)
;

PROMPT ALTER TABLE option_marks ADD CONSTRAINT primary00043 PRIMARY KEY

ALTER TABLE option_marks ADD CONSTRAINT primary00043 PRIMARY KEY
(
    opt_mark_id
)
ENABLE;

PROMPT CREATE TABLE person

CREATE TABLE person
(
    person_id                        NUMBER   (11)                    NOT NULL
  , user_name                        VARCHAR2 (16)                    
  , password                         VARCHAR2 (16)                    
  , first_name                       VARCHAR2 (64)                    NOT NULL
  , surname                          VARCHAR2 (64)                    NOT NULL
  , inactive                         VARCHAR2 (1)                     
)
;

PROMPT CREATE UNIQUE INDEX primary00044 ON person

CREATE UNIQUE INDEX primary00044 ON person
(
    person_id
)
;

PROMPT ALTER TABLE person ADD CONSTRAINT primary00044 PRIMARY KEY

ALTER TABLE person ADD CONSTRAINT primary00044 PRIMARY KEY
(
    person_id
)
ENABLE;

PROMPT CREATE TABLE person_email

CREATE TABLE person_email
(
    e_mail_id                        NUMBER   (11)                    NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , e_mail_add                       VARCHAR2 (128)                   NOT NULL
  , e_mail_suspended                 VARCHAR2 (1)                     
)
;

PROMPT CREATE UNIQUE INDEX primary00045 ON person_email

CREATE UNIQUE INDEX primary00045 ON person_email
(
    e_mail_id
)
;

PROMPT ALTER TABLE person_email ADD CONSTRAINT primary00045 PRIMARY KEY

ALTER TABLE person_email ADD CONSTRAINT primary00045 PRIMARY KEY
(
    e_mail_id
)
ENABLE;

PROMPT CREATE TABLE person_roles

CREATE TABLE person_roles
(
    role                             NUMBER   (11)                    DEFAULT 0 NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
)
;

PROMPT CREATE TABLE prize_categories

CREATE TABLE prize_categories
(
    prize_cat_id                     NUMBER   (11)                    NOT NULL
  , prize_cat_name                   VARCHAR2 (16)                    NOT NULL
  , prize_value                      NUMBER   (10)                    
  , prize_cat_criteria               CLOB                             
)
;

PROMPT CREATE UNIQUE INDEX primary00046 ON prize_categories

CREATE UNIQUE INDEX primary00046 ON prize_categories
(
    prize_cat_id
)
;

PROMPT ALTER TABLE prize_categories ADD CONSTRAINT primary00046 PRIMARY KEY

ALTER TABLE prize_categories ADD CONSTRAINT primary00046 PRIMARY KEY
(
    prize_cat_id
)
ENABLE;

PROMPT CREATE TABLE prize_nominations

CREATE TABLE prize_nominations
(
    prize_nom_id                     NUMBER   (11)                    NOT NULL
  , prize_cat_id                     NUMBER   (11)                    DEFAULT 0 NOT NULL
  , mark_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , supporting_comments              CLOB                             
)
;

PROMPT CREATE UNIQUE INDEX primary00047 ON prize_nominations

CREATE UNIQUE INDEX primary00047 ON prize_nominations
(
    prize_nom_id
)
;

PROMPT ALTER TABLE prize_nominations ADD CONSTRAINT primary00047 PRIMARY KEY

ALTER TABLE prize_nominations ADD CONSTRAINT primary00047 PRIMARY KEY
(
    prize_nom_id
)
ENABLE;

PROMPT CREATE TABLE roles

CREATE TABLE roles
(
    role_id                          NUMBER   (11)                    NOT NULL
  , role_description                 VARCHAR2 (32)                    NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00048 ON roles

CREATE UNIQUE INDEX primary00048 ON roles
(
    role_id
)
;

PROMPT ALTER TABLE roles ADD CONSTRAINT primary00048 PRIMARY KEY

ALTER TABLE roles ADD CONSTRAINT primary00048 PRIMARY KEY
(
    role_id
)
ENABLE;

PROMPT CREATE TABLE staff

CREATE TABLE staff
(
    staff_no                         VARCHAR2 (16)                    NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00049 ON staff

CREATE UNIQUE INDEX primary00049 ON staff
(
    staff_no
)
;

PROMPT ALTER TABLE staff ADD CONSTRAINT primary00049 PRIMARY KEY

ALTER TABLE staff ADD CONSTRAINT primary00049 PRIMARY KEY
(
    staff_no
)
ENABLE;

PROMPT CREATE TABLE statuses

CREATE TABLE statuses
(
    status_code                      VARCHAR2 (3)                     
  , status                           VARCHAR2 (100)                   
)
;

PROMPT CREATE TABLE student

CREATE TABLE student
(
    student_id                       NUMBER   (11)                    NOT NULL
  , hemis_no                         NUMBER   (11)                    DEFAULT 0 NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , degree_stream                    VARCHAR2 (16)                    NOT NULL
  , final_year                       VARCHAR2 (16)                    NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00050 ON student

CREATE UNIQUE INDEX primary00050 ON student
(
    student_id
)
;

PROMPT ALTER TABLE student ADD CONSTRAINT primary00050 PRIMARY KEY

ALTER TABLE student ADD CONSTRAINT primary00050 PRIMARY KEY
(
    student_id
)
ENABLE;

PROMPT CREATE TABLE tel_number

CREATE TABLE tel_number
(
    telephone_number_id              NUMBER   (11)                    NOT NULL
  , person_id                        NUMBER   (11)                    DEFAULT 0 NOT NULL
  , tel_number                       VARCHAR2 (20)                    NOT NULL
)
;

PROMPT CREATE UNIQUE INDEX primary00051 ON tel_number

CREATE UNIQUE INDEX primary00051 ON tel_number
(
    telephone_number_id
)
;

PROMPT ALTER TABLE tel_number ADD CONSTRAINT primary00051 PRIMARY KEY

ALTER TABLE tel_number ADD CONSTRAINT primary00051 PRIMARY KEY
(
    telephone_number_id
)
ENABLE;

PROMPT CREATE TABLE unit

CREATE TABLE unit
(
    unit_id                          NUMBER   (11)                    NOT NULL
  , unit_code                        VARCHAR2 (16)                    NOT NULL
  , unit_name                        VARCHAR2 (50)                    NOT NULL
  , academic_yr_first_run            DATE                             
  , academic_yr_last_run             DATE                             
)
;

PROMPT CREATE UNIQUE INDEX primary00052 ON unit

CREATE UNIQUE INDEX primary00052 ON unit
(
    unit_id
)
;

PROMPT ALTER TABLE unit ADD CONSTRAINT primary00052 PRIMARY KEY

ALTER TABLE unit ADD CONSTRAINT primary00052 PRIMARY KEY
(
    unit_id
)
ENABLE;

PROMPT CREATE TABLE unit_mark_forms

CREATE TABLE unit_mark_forms
(
    umfid                            NUMBER   (11)                    NOT NULL
  , unit_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , form_id                          NUMBER   (11)                    DEFAULT 0 NOT NULL
  , umfbegin                         DATE                             NOT NULL
  , umfend                           DATE                             
)
;

PROMPT CREATE UNIQUE INDEX primary00053 ON unit_mark_forms

CREATE UNIQUE INDEX primary00053 ON unit_mark_forms
(
    umfid
)
;

PROMPT ALTER TABLE unit_mark_forms ADD CONSTRAINT primary00053 PRIMARY KEY

ALTER TABLE unit_mark_forms ADD CONSTRAINT primary00053 PRIMARY KEY
(
    umfid
)
ENABLE;

PROMPT CREATE SEQUENCE audit_0

CREATE SEQUENCE audit_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE audit_1

CREATE SEQUENCE audit_1
   START WITH       121
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_marks_0

CREATE SEQUENCE category_marks_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_marks_1

CREATE SEQUENCE category_marks_1
   START WITH       401
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_option_criteria_0

CREATE SEQUENCE category_option_criteria_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_option_criteria_1

CREATE SEQUENCE category_option_criteria_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_option_groups_0

CREATE SEQUENCE category_option_groups_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_option_groups_1

CREATE SEQUENCE category_option_groups_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_options_0

CREATE SEQUENCE category_options_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE category_options_1

CREATE SEQUENCE category_options_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE cohort_0

CREATE SEQUENCE cohort_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE cohort_1

CREATE SEQUENCE cohort_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE cohort_coordinators_0

CREATE SEQUENCE cohort_coordinators_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE cohort_coordinators_1

CREATE SEQUENCE cohort_coordinators_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE cohort_coordinators_2

CREATE SEQUENCE cohort_coordinators_2
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE contacts_0

CREATE SEQUENCE contacts_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE contacts_1

CREATE SEQUENCE contacts_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE final_project_0

CREATE SEQUENCE final_project_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE final_project_1

CREATE SEQUENCE final_project_1
   START WITH       521
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE ideas2_0

CREATE SEQUENCE ideas2_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE ideas2_1

CREATE SEQUENCE ideas2_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_categories_0

CREATE SEQUENCE mark_categories_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_categories_1

CREATE SEQUENCE mark_categories_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_form_categories_0

CREATE SEQUENCE mark_form_categories_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_form_categories_1

CREATE SEQUENCE mark_form_categories_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_forms_0

CREATE SEQUENCE mark_forms_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE mark_forms_1

CREATE SEQUENCE mark_forms_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marker_capacity_0

CREATE SEQUENCE marker_capacity_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marker_capacity_1

CREATE SEQUENCE marker_capacity_1
   START WITH       1041
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marker_type_0

CREATE SEQUENCE marker_type_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marker_type_1

CREATE SEQUENCE marker_type_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marks_0

CREATE SEQUENCE marks_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE marks_1

CREATE SEQUENCE marks_1
   START WITH       41
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE option_marks_0

CREATE SEQUENCE option_marks_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE option_marks_1

CREATE SEQUENCE option_marks_1
   START WITH       401
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE person_0

CREATE SEQUENCE person_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE person_1

CREATE SEQUENCE person_1
   START WITH       281
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE person_email_0

CREATE SEQUENCE person_email_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE person_email_1

CREATE SEQUENCE person_email_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE prize_categories_0

CREATE SEQUENCE prize_categories_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE prize_categories_1

CREATE SEQUENCE prize_categories_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE prize_nominations_0

CREATE SEQUENCE prize_nominations_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE prize_nominations_1

CREATE SEQUENCE prize_nominations_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE roles_0

CREATE SEQUENCE roles_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE roles_1

CREATE SEQUENCE roles_1
   START WITH       21
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE student_0

CREATE SEQUENCE student_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE student_1

CREATE SEQUENCE student_1
   START WITH       521
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE tel_number_0

CREATE SEQUENCE tel_number_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE tel_number_1

CREATE SEQUENCE tel_number_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE unit_0

CREATE SEQUENCE unit_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE unit_1

CREATE SEQUENCE unit_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE unit_mark_forms_0

CREATE SEQUENCE unit_mark_forms_0
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CREATE SEQUENCE unit_mark_forms_1

CREATE SEQUENCE unit_mark_forms_1
   START WITH       1
   INCREMENT BY     1
   MINVALUE         1
   NOMAXVALUE
   CACHE            20
   NOCYCLE
   NOORDER
;

PROMPT CONTENTS OF category_marks

INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('215','22','17','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('216','22','18','25',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('217','22','19','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('218','22','20','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('219','22','21','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('220','22','22','25',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('221','22','23','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('222','22','24','5',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('223','22','25','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('224','22','26','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('225','22','27','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('226','22','28','25',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('214','22','16','15',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('144','15','16','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('145','15','17','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('146','15','18','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('147','15','19','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('148','15','20','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('149','15','21','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('150','15','22','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('151','15','23','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('152','15','24','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('153','15','25','95',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('154','15','26','95',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('155','15','27','95',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('156','15','28','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('94','10','18','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('95','10','19','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('96','10','20','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('97','10','21','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('98','10','22','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('99','10','23','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('100','10','24','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('101','10','25','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('102','10','26','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('103','10','27','85',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('104','10','28','95',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('92','10','16','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('93','10','17','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('266','23','16','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('267','23','17','60',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('268','23','18','55',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('269','23','19','40',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('270','23','20','30',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('271','23','21','25',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('272','23','22','35',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('273','23','23','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('274','23','24','55',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('275','23','25','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('276','23','26','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('277','23','27','35',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('278','23','28','25',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('357','28','16','35',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('358','28','17','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('359','28','18','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('360','28','19','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('361','28','20','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('362','28','21','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('363','28','22','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('364','28','23','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('365','28','24','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('366','28','25','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('367','28','26','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('368','28','27','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('369','28','28','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('370','13','16','55',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('371','13','17','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('372','13','18','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('373','13','19','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('374','13','20','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('375','13','21','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('376','13','22','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('377','13','23','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('378','13','24','75',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('379','13','25','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('380','13','26','65',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('381','13','27','45',NULL);
INSERT INTO category_marks (CAT_MARK_ID,MARK_ID,CAT_ID,MARK,"COMMENT") VALUES ('382','13','28','45',NULL);
COMMIT;

PROMPT CONTENTS OF category_option_criteria

INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('134','8','16',NULL,'No statement or very generalised with vague aims or objectives');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('135','9','16',NULL,'No statement or very generalised with vague aims or objectives');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('136','10','16',NULL,'No statement or very generalised with vague aims or objectives');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('137','11','16','Problem area outlined ','Insufficiently clear aims and objectives');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('138','12','16','Problem topic and aims and objectives apparent','Shows limited understanding and analysis');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('139','13','16','Problem topic and aims and objectives well presented, show-ing understanding and analysis. Key aspects of the context are covered',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('140','14','16','Problem topic and aims and objectives well framed and viewed in wider context',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('141','15','16','Problem is clearly shown to be challenging or shows originality and confidence in criticising assumptions',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('142','16','16','Analysis of problem adds new insights',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('143','17','16','Analysis of problem adds new insights',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('147','8','17',NULL,'Zero or a few sources mentioned, but not reviewed');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('148','9','17',NULL,'Zero or a few sources mentioned, but not reviewed');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('149','10','17',NULL,'Zero or a few sources mentioned, but not reviewed');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('150','11','17',NULL,'Limited or inappropriate research');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('151','12','17','Familiarity with key literature which is cited and presented according to convention',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('152','13','17','Detailed review and grasp of pertinent issues and a critical contextual overview of the literature. Confidence in understanding and using literature',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('153','14','17','Extensive use of relevant and current literature to view topic in perspective, analyse context and develop new explanations and theories',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('154','15','17','Wide reaching research showing breadth and depth of sources',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('155','16','17','Review adds new insights',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('156','17','17','Review adds new insights',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('157','8','18',NULL,'Little/no evidence of choice or use of method or life cycle');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('158','9','18',NULL,'Little/no evidence of choice or use of method or life cycle');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('159','10','18',NULL,'Little/no evidence of choice or use of method or life cycle');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('160','11','18',NULL,'Poor choice of methodology and life cycle, or little/no evidence of use');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('161','12','18','Methodology and/or life cycle described with some evidence of use',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('162','13','18','Thorough knowledge of theory and methods and uses this to underpin arguments and conclusions',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('163','14','18','Credible justification for use',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('164','15','18','Methodology well described, well applied and well justified',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('165','16','18','Innovative methodology or application',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('166','17','18','Innovative methodology or application',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('167','8','19',NULL,'No discernable requirements');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('168','9','19',NULL,'No discernable requirements');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('169','10','19',NULL,'No discernable requirements');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('170','11','19',NULL,'Requirements are vague, unclear or disjointed');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('171','12','19','Partial statement of requirements. Some limited indication of how they were arrived at',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('172','13','19','Full or nearly full statement of requirements. Discussion of requirements and some analysis',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('173','14','19','Relative importance of requirements is stated and justified',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('174','15','19','Requirements complete and consistent, well-conducted analysis',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('175','16','19','Adds new insight into requirements specification',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('176','17','19','Adds new insight into requirements specification',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('177','8','20',NULL,'No discernible design');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('178','9','20',NULL,'No discernible design');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('179','10','20',NULL,'No discernible design');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('180','11','20',NULL,'Poor use of design methods, with little/no justification.  Design not adequately explained ');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('181','12','20','Some evidence of design.  Some explanation of methods, processes and outcomes',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('182','13','20','Some justification of design decisions, for some areas of development',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('183','14','20','Good justification of most design decisions in most areas',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('184','15','20','Full justification and critique of design decisions in all areas',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('185','16','20','Adds new insight into design and/or methodology',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('186','17','20','Adds new insight into design and/or methodology',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('187','8','21',NULL,'Little/no description of implementation');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('188','9','21',NULL,'Little/no description of implementation');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('189','10','21',NULL,'Little/no description of implementation');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('190','11','21',NULL,'Superficial description of implementation');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('191','12','21',NULL,'Description of implementation without much justification or reflection, or good command of techniques / tools');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('192','13','21','Some justification of implementation decisions made, or good command of techniques / tools used',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('193','14','21','Good justification of implementation decisions. Good command of techniques / tools used',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('194','15','21','Thorough justification of implementation decisions made',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('195','16','21','Adds new insight into implementation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('196','17','21','Adds new insight into implementation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('197','8','22',NULL,'Little/no evidence of testing or debugging having been carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('198','9','22',NULL,'Little/no evidence of testing or debugging having been carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('199','10','22',NULL,'Little/no evidence of testing or debugging having been carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('200','11','22',NULL,'Superficial description of testing and debugging');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('201','12','22','Description of testing and debugging carried out',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('202','13','22','Some justification of approaches used for testing and debugging',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('203','14','22','Good justification of approaches used in most areas',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('204','15','22','Shows that tests were well planned and fully carried out. Critical discussion of results and remedial actions taken',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('205','16','22','Adds new insight into verification and validation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('206','17','22','Adds new insight into verification and validation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('207','8','23',NULL,'Little/no evidence of evaluation having been planned or carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('208','9','23',NULL,'Little/no evidence of evaluation having been planned or carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('209','10','23',NULL,'Little/no evidence of evaluation having been planned or carried out');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('210','11','23',NULL,'Little attempt at evaluation ');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('211','12','23','Description of plan for evaluating outcome. Some evidence that outcome meets requirements',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('212','13','23','Evidence that artefact meets requirements with explanation where it doesn',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('213','14','23','Justification of evaluation method',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('214','15','23','Convincing evidence that project meets its objectives or explanation where it doesn’t. Shows awareness of limits of evaluati',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('215','16','23','Adds new insight into evaluation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('216','17','23','Adds new insight into evaluation',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('217','8','24',NULL,'No planning evident');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('218','9','24',NULL,'No planning evident');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('219','10','24',NULL,'No planning evident');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('220','11','24',NULL,'Sketchy generalised plan with no evidence of monitoring of progress');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('221','12','24',NULL,'Sketchy generalised plan with no evidence of monitoring of progress');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('222','13','24',NULL,'Sketchy generalised plan with no evidence of monitoring of progress');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('223','14','24','Project plan with some evidence that it has been followed',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('224','15','24','Some detail in plan with evidence that it has been followed',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('225','16','24','Shows a detailed plan with timescales, resources and a work schedule for most tasks.  Some evaluation of progress against plan',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('226','17','24','Demonstrates understanding of issues that affected the project and how they could have been avoided',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('227','18','24','Demonstrates understanding of issues that affected the project and how they could have been avoided',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('228','19','24','Demonstrates understanding of issues that affected the project and how they could have been avoided',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('229','8','25',NULL,'Artefact is substantially incomplete');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('230','9','25',NULL,'Artefact is substantially incomplete');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('231','10','25',NULL,'Artefact is substantially incomplete');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('232','11','25',NULL,'Artefact does not work or meets few of the requirements that could reasonably expected to be met in the time available');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('233','12','25',NULL,'Artefact implements minimum functionality or has significant bugs');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('234','13','25','Artefact implements most of the requirements with only minor bugs',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('235','14','25','Artefact is reasonably complete and free of significant defects',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('236','15','25','Artefact exhibits good qualities of reliability, timeliness, maintainability, completeness and consistency',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('237','16','25','Artefact meets all (or virtually all) of its requirements. Artefact is worthy of real use and/or distribution',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('238','17','25','Artefact meets all (or virtually all) of its requirements. Artefact is worthy of real use and/or distribution',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('239','8','26',NULL,'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('240','9','26',NULL,'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('241','10','26',NULL,'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('242','11','26',NULL,'Conclusions vague, ambiguous and not based on researched material.');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('243','12','26',NULL,'Some summary or statement of conclusions, but the conclusions are trite or somewhat irrelevant to the problem being addressed');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('244','13','26','Outcomes summarised. Conclusions mostly valid and related at least partially to the objectives. Some recommendations made',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('245','14','26','Conclusions all valid and relate well to all the objectives. ?Recommendations are valid with some justification',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('246','15','26','Demonstrates understanding of complex topic and places it in wider context',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('247','16','26','Conclusions appropriate, original and supported by the report.  Excellent summary of project and insightful conclusions.',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('248','17','26','Conclusions appropriate, original and supported by the report.  Excellent summary of project and insightful conclusions.',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('249','8','27',NULL,'Acutely deficient in all aspects');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('250','9','27',NULL,'Acutely deficient in all aspects');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('251','10','27',NULL,'Acutely deficient in all aspects');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('252','11','27',NULL,'Deficits in length, structure, presen-tation and/or prose');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('253','12','27','Logical and clear structure, well organised with good use of language and supporting material',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('254','13','27','Satisfactory presentation with respect to presentation, organisation, language, grammar, spelling, format, presentation, diagrams, tables etc',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('255','14','27','Very good in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('256','15','27','Excellent in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('257','16','27','Outstanding quality in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('258','17','27','Outstanding quality in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('259','8','28',NULL,'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('260','9','28',NULL,'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('261','10','28',NULL,'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('262','11','28',NULL,'Some knowledge of relevant concepts and literature but significant gaps in understanding and/or knowledge.');
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('263','12','28','Demonstrates grasp of key concepts and an ability to develop and support an argument in a pre-dominately descriptive way with valid conclusions drawn from the research',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('264','13','28','Work that attempts to address the topic with some understanding and analysis, key aspects of the subject matter covered 
? The majority of students might normally be expected to fall within this range.',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('265','14','28','Clear, balanced coherent critical and rigorous analysis of the subject matter. Detailed understanding of knowledge and theory expressed with clarity',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('266','15','28','Excellent work, able to express an original reasoned argument in a lucid manner by reviewing and critiquing a wide range of material. 
Original, critical thinking based on outstanding insight, knowledge and understanding of material.',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('267','16','28','Material contributes to current understanding and is of potentially publishable quality in terms of presentation and content ',NULL);
INSERT INTO category_option_criteria (OPT_CRITERIA_ID,"OPTION",MARK_CATEGORY,POSITIVE_CRITERIA,NEGATIVE_CRITERIA) VALUES ('268','17','28','Material contributes to current understanding and is of potentially publishable quality in terms of presentation and content',NULL);
COMMIT;

PROMPT CONTENTS OF category_option_groups

INSERT INTO category_option_groups (OPT_GROUP_ID,OPT_GROUP_NAME) VALUES ('1','100% - 10 Bracket');
INSERT INTO category_option_groups (OPT_GROUP_ID,OPT_GROUP_NAME) VALUES ('2','Yes / No');
COMMIT;

PROMPT CONTENTS OF category_options

INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('8','0-9','5','1','1');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('9','10-19','15','1','2');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('10','20-29','25','1','3');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('11','30-39','35','1','4');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('12','40-49','45','1','5');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('13','50-59','55','1','6');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('14','60-69','65','1','7');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('15','70-79','75','1','8');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('16','80-89','85','1','9');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('17','90-100','95','1','10');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('18','Yes','50','2','1');
INSERT INTO category_options (OPT_ID,OPT_LABEL,OPT_SELECTED_VALUE,OPT_GROUP,OPT_INDEX) VALUES ('19','No','0','2','2');
COMMIT;

PROMPT CONTENTS OF cohort

INSERT INTO cohort (COHORT_ID,COHORT_DESCRIPTION,PROJECT_START_DATE,PROJECT_END_DATE,COHORT_CLOSED) VALUES ('3','MSc projects 2004-2005',TO_DATE('2005-04-01 00:00:00','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),NULL);
COMMIT;

PROMPT CONTENTS OF cohort_coordinators

INSERT INTO cohort_coordinators (CO_CORD_ID,COHORT_ID,PERSON_ID) VALUES ('1','3','157');
COMMIT;

PROMPT CONTENTS OF contacts

COMMIT;

PROMPT CONTENTS OF emailmessages

INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('PROJECTREADY','The following project has been registered on the SUMS System and is ready to be marked:

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}

To view the project and submit your mark now click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('MARKERALERT','You have been assigned as {ROLE} marker for the following project, registered on the SUMS System:

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}
Project Status: {STATUS}

To view the project, please click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('THIRDNEEDED','The following project has reached the stage of third marker reconciliation and requires the assignment of a third marker. 

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}

To view the project and assign a third marker, click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('EXAMNEEDED','The following project has reached the stage of examiner reconciliation and requires the assignment of an examiner marker. 

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}

To view the project and assign an examiner marker, click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('MARKCONF','You have submitted a project mark for the following project:

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}

The mark you assigned is {MARKFORMMARK}% and was calculated as follows:

{CATMARKS}

Weighting applied: {MARKWEIGHT}

General comments: {GENERALCOMMENTS}

Examiner comments: {EXAMCOMMENTS}

Plagiarism suspect?: {PLAGIARISM}

To view the project, click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('STATUSCHANGE','The status of the following project has been updated:

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}
Status: {STATUS}
Mark: {MARK}
Comments: {COMMENTS}

To view the project, click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('CONFALERT','{STUDENT}

Your project for {UNIT} has been marked.

Your can view your project mark online by clicking the link below:

http://localhost:8084/SUMS/assess/viewStudentMark.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('MARKERCONF','The markers for the following project have been updated:

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}

Markers:

{MARKERS}

To view the project, click the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}


This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
INSERT INTO emailmessages (MAILKEY,MAILVALUE) VALUES ('RECONNEEDED','The supervisor/moderator marks for the following project differ by more than 10%.  

Student Name: {STUDENT}
Project Unit: {UNIT}
Project Cohort: {COHORT}
Project Title: {TITLE}
Project Submission Date: {DATESUBMIT}
{MARKERS}

Once a reconciled mark has been agreed, you can submit it by clicking the link below:

$APPURL$/assess/viewProject.do?PROJECT={ID}

This message is automatically generated from the database. In case of query, contact me.

Dr Jim Briggs
Projects co-ordinator
');
COMMIT;

PROMPT CONTENTS OF emails

COMMIT;

PROMPT CONTENTS OF final_project

INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('458','214','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('459','215','3','4','E-Learning Cryptography',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('460','216','3','4','News Portal ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('461','217','3','4','Website for parents of bilingual children ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('462','218','3','6','On-screen keyboard for non-verbal disabled user',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('463','219','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('464','220','3','4','Stereoscopic animation',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('465','221','3','4','High Speed Run version 7',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('466','222','3','4','Officiating scheduling system',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'S','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('467','223','3','4','Interactive web site for Maternity Services',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('468','224','3','4',' Interactive and educational financial budget game',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('469','225','3','4','Website for Event Management Booking System',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('470','226','3','6','SIMULATION OF MULTI HOP ADHOC NETWORK WITH MULTIPL',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('471','227','3','4','Youth Participation Survey',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('472','228','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('473','229','3','4',' Interactive multimedia website',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('474','230','3','4','Sterescopic Showreel',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('475','231','3','4','Virtual Community for Research Staff in UoP',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','prob dns');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('476','232','3','4','E - learning programme for Sharps Safety',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('477','233','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('478','234','3','4','Web page for Paediatric Department',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('479','235','3','4','Audio/Video Production Resource for E-Learning',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','prob ecf');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('480','236','3','4','Website depicting the growth of the festival',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('481','237','3','4','Software Tool for Formal Presentation of Fuzzy Sys',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('482','238','3','4','American football rankings ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'M','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('483','239','3','4','Sports coaching interactive web site ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('484','240','3','4',' Designing a Web Survey Management System',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'S','0','comment');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('485','241','3','4','Ordering Search Results by Accessibility',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'M','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('486','242','3','4','e-questionnaire software evaluation',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('487','243','3','4','Online project marking',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'R2A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('488','244','3','4','Motion Capture Rig for Stroke Rehabilitation',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','prob ecf');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('489','245','3','4','CBL and test on correct referencing',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('490','246','3','4','Database for recording the useage of the drug TNFa',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('491','247','3','4','Whole Hand Haptic Medical Task Investigation',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','poss ecf');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('492','248','3','4','Officiating assessment system ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','probable ECF');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('493','249','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('494','250','3','4','Industrial Placements Website',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late; prob ecf');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('495','251','3','4','Haptic Medical Task Investigation',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('496','252','3','4','Automated Belbin test',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('497','253','3','4','Developing accessible WebCT CMS Materials ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('498','254','3','4','Headtracked Virtual Reality demonstration',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('499','255','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('500','256','3','4','Computing facilities database',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('501','257','3','4','Remote configuration tool for an iPayment system',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('502','258','3','4','An Accessible Search Engine',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('503','259','3','4','CAL website for HCI guidelines',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('504','260','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('505','261','3','4','Personal Academic Bibliography tool ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('506','262','3','4','Exercise Machine to Drive Virtual Enviornment',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('507','263','3','1','How Small Businesses and Home Users can protect th',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('508','264','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('509','265','3','4','Research data collection system',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('510','266','3','4','Data Dictionary Tool for Oracle database',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('511','267','3','4','Motion Capture Demonstration and Tutorial ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late; prob ecf');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('512','268','3','4','Crime reduction website',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('513','269','3','4','Health Care Facilities Database Pi 392',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('514','270','3','4','Asset Management /Stock Control database ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('515','271','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('516','272','3','4','Paediatric Cystic Fibrosis Database',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('517','273','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('518','274','3','6','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('519','275','3','4','American football rules in XML ',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0','late');
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('456','212','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
INSERT INTO final_project (PROJECT_ID,STUDENT_ID,COHORT_ID,UNIT_ID,PROJECT_TITLE,PROJECT_SUBMITTED_DATE,LATE_HAND_IN,UNIT_EXAM_BOARD_DECISION,PROJECT_STATUS,PROJECT_MARK,PROJECT_COMMENTS) VALUES ('457','213','3','1','Topic unknown',TO_DATE('2005-09-16 00:00:00','YYYY-MM-DD HH24:MI:SS'),'N',NULL,'A','0',NULL);
COMMIT;

PROMPT CONTENTS OF ideas2

COMMIT;

