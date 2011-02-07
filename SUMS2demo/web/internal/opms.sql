/*
MySQL Backup
Source Host:           localhost
Source Server Version: 4.1.9-nt
Source Database:       sums
Date:                  2005/08/28 15:28:40
*/

SET FOREIGN_KEY_CHECKS=0;
use sums;
#----------------------------
# Table structure for audit
#----------------------------
CREATE TABLE `audit` (
  `audit_id` int(10) NOT NULL auto_increment,
  `person_making_change_id` int(10) NOT NULL default '0',
  `project_being_changed_id` int(10) NOT NULL default '0',
  `reason` text NOT NULL,
  `date_altered` date default '0000-00-00',
  `item_changed` varchar(128) NOT NULL default '',
  `old_value_of_item` text NOT NULL,
  `new_value_of_item` text NOT NULL,
  `time_altered` time default NULL,
  PRIMARY KEY  (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# No records for table audit
#----------------------------

#----------------------------
# Table structure for category_marks
#----------------------------
CREATE TABLE `category_marks` (
  `cat_mark_id` int(11) NOT NULL auto_increment,
  `mark_id` int(11) NOT NULL default '0',
  `cat_id` int(11) NOT NULL default '0',
  `mark` decimal(10,0) NOT NULL default '0',
  `comment` text,
  PRIMARY KEY  (`cat_mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB';
#----------------------------
# No records for table category_marks
#----------------------------

#----------------------------
# Table structure for category_option_criteria
#----------------------------
CREATE TABLE `category_option_criteria` (
  `opt_criteria_id` int(11) NOT NULL auto_increment,
  `option` int(11) NOT NULL default '0',
  `mark_category` int(11) NOT NULL default '0',
  `positive_criteria` text,
  `negative_criteria` text,
  PRIMARY KEY  (`opt_criteria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table category_option_criteria
#----------------------------


insert  into category_option_criteria values 
(134, 8, 16, null, 'No statement or very generalised with vague aims or objectives'), 
(135, 9, 16, '', 'No statement or very generalised with vague aims or objectives'), 
(136, 10, 16, '', 'No statement or very generalised with vague aims or objectives'), 
(137, 11, 16, 'Problem area outlined ', 'Insufficiently clear aims and objectives'), 
(138, 12, 16, 'Problem topic and aims and objectives apparent', 'Shows limited understanding and analysis'), 
(139, 13, 16, 'Problem topic and aims and objectives well presented, show-ing understanding and analysis. Key aspects of the context are covered', ''), 
(140, 14, 16, 'Problem topic and aims and objectives well framed and viewed in wider context', ''), 
(141, 15, 16, 'Problem is clearly shown to be challenging or shows originality and confidence in criticising assumptions', ''), 
(142, 16, 16, 'Analysis of problem adds new insights', ''), 
(143, 17, 16, 'Analysis of problem adds new insights', ''), 
(147, 8, 17, '', 'Zero or a few sources mentioned, but not reviewed'), 
(148, 9, 17, '', 'Zero or a few sources mentioned, but not reviewed'), 
(149, 10, 17, '', 'Zero or a few sources mentioned, but not reviewed'), 
(150, 11, 17, null, 'Limited or inappropriate research'), 
(151, 12, 17, 'Familiarity with key literature which is cited and presented according to convention', ''), 
(152, 13, 17, 'Detailed review and grasp of pertinent issues and a critical contextual overview of the literature. Confidence in understanding and using literature', null), 
(153, 14, 17, 'Extensive use of relevant and current literature to view topic in perspective, analyse context and develop new explanations and theories', null), 
(154, 15, 17, 'Wide reaching research showing breadth and depth of sources', null), 
(155, 16, 17, 'Review adds new insights', null), 
(156, 17, 17, 'Review adds new insights', null), 
(157, 8, 18, null, 'Little/no evidence of choice or use of method or life cycle'), 
(158, 9, 18, null, 'Little/no evidence of choice or use of method or life cycle'), 
(159, 10, 18, '', 'Little/no evidence of choice or use of method or life cycle'), 
(160, 11, 18, '', 'Poor choice of methodology and life cycle, or little/no evidence of use'), 
(161, 12, 18, 'Methodology and/or life cycle described with some evidence of use', null), 
(162, 13, 18, 'Thorough knowledge of theory and methods and uses this to underpin arguments and conclusions', null), 
(163, 14, 18, 'Credible justification for use', null), 
(164, 15, 18, 'Methodology well described, well applied and well justified', null), 
(165, 16, 18, 'Innovative methodology or application', null), 
(166, 17, 18, 'Innovative methodology or application', null), 
(167, 8, 19, null, 'No discernable requirements'), 
(168, 9, 19, null, 'No discernable requirements'), 
(169, 10, 19, null, 'No discernable requirements'), 
(170, 11, 19, null, 'Requirements are vague, unclear or disjointed'), 
(171, 12, 19, 'Partial statement of requirements. Some limited indication of how they were arrived at', null), 
(172, 13, 19, 'Full or nearly full statement of requirements. Discussion of requirements and some analysis', null), 
(173, 14, 19, 'Relative importance of requirements is stated and justified', null), 
(174, 15, 19, 'Requirements complete and consistent, well-conducted analysis', null), 
(175, 16, 19, 'Adds new insight into requirements specification', null), 
(176, 17, 19, 'Adds new insight into requirements specification', null), 
(177, 8, 20, null, 'No discernible design'), 
(178, 9, 20, null, 'No discernible design'), 
(179, 10, 20, null, 'No discernible design'), 
(180, 11, 20, null, 'Poor use of design methods, with little/no justification.  Design not adequately explained '), 
(181, 12, 20, 'Some evidence of design.  Some explanation of methods, processes and outcomes', null), 
(182, 13, 20, 'Some justification of design decisions, for some areas of development', null), 
(183, 14, 20, 'Good justification of most design decisions in most areas', null), 
(184, 15, 20, 'Full justification and critique of design decisions in all areas', null), 
(185, 16, 20, 'Adds new insight into design and/or methodology', null), 
(186, 17, 20, 'Adds new insight into design and/or methodology', null), 
(187, 8, 21, null, 'Little/no description of implementation'), 
(188, 9, 21, null, 'Little/no description of implementation'), 
(189, 10, 21, null, 'Little/no description of implementation'), 
(190, 11, 21, null, 'Superficial description of implementation'), 
(191, 12, 21, null, 'Description of implementation without much justification or reflection, or good command of techniques / tools'), 
(192, 13, 21, 'Some justification of implementation decisions made, or good command of techniques / tools used', null), 
(193, 14, 21, 'Good justification of implementation decisions. Good command of techniques / tools used', null), 
(194, 15, 21, 'Thorough justification of implementation decisions made', null), 
(195, 16, 21, 'Adds new insight into implementation', null), 
(196, 17, 21, 'Adds new insight into implementation', null), 
(197, 8, 22, null, 'Little/no evidence of testing or debugging having been carried out'), 
(198, 9, 22, null, 'Little/no evidence of testing or debugging having been carried out'), 
(199, 10, 22, null, 'Little/no evidence of testing or debugging having been carried out'), 
(200, 11, 22, null, 'Superficial description of testing and debugging'), 
(201, 12, 22, 'Description of testing and debugging carried out', null), 
(202, 13, 22, 'Some justification of approaches used for testing and debugging', null), 
(203, 14, 22, 'Good justification of approaches used in most areas', null), 
(204, 15, 22, 'Shows that tests were well planned and fully carried out. Critical discussion of results and remedial actions taken', null), 
(205, 16, 22, 'Adds new insight into verification and validation', null), 
(206, 17, 22, 'Adds new insight into verification and validation', null), 
(207, 8, 23, null, 'Little/no evidence of evaluation having been planned or carried out'), 
(208, 9, 23, null, 'Little/no evidence of evaluation having been planned or carried out'), 
(209, 10, 23, null, 'Little/no evidence of evaluation having been planned or carried out'), 
(210, 11, 23, null, 'Little attempt at evaluation '), 
(211, 12, 23, 'Description of plan for evaluating outcome. Some evidence that outcome meets requirements', null), 
(212, 13, 23, 'Evidence that artefact meets requirements with explanation where it doesn’t', null), 
(213, 14, 23, 'Justification of evaluation method', null), 
(214, 15, 23, 'Convincing evidence that project meets its objectives or explanation where it doesn’t. Shows awareness of limits of evaluation', null), 
(215, 16, 23, 'Adds new insight into evaluation', null), 
(216, 17, 23, 'Adds new insight into evaluation', null), 
(217, 8, 24, null, 'No planning evident'), 
(218, 9, 24, null, 'No planning evident'), 
(219, 10, 24, null, 'No planning evident'), 
(220, 11, 24, null, 'Sketchy generalised plan with no evidence of monitoring of progress'), 
(221, 12, 24, '', 'Sketchy generalised plan with no evidence of monitoring of progress'), 
(222, 13, 24, '', 'Sketchy generalised plan with no evidence of monitoring of progress'), 
(223, 14, 24, 'Project plan with some evidence that it has been followed', null), 
(224, 15, 24, 'Some detail in plan with evidence that it has been followed', null), 
(225, 16, 24, 'Shows a detailed plan with timescales, resources and a work schedule for most tasks.  Some evaluation of progress against plan', null), 
(226, 17, 24, 'Demonstrates understanding of issues that affected the project and how they could have been avoided', null), 
(227, 18, 24, 'Demonstrates understanding of issues that affected the project and how they could have been avoided', null), 
(228, 19, 24, 'Demonstrates understanding of issues that affected the project and how they could have been avoided', null), 
(229, 8, 25, null, 'Artefact is substantially incomplete'), 
(230, 9, 25, null, 'Artefact is substantially incomplete'), 
(231, 10, 25, null, 'Artefact is substantially incomplete'), 
(232, 11, 25, null, 'Artefact does not work or meets few of the requirements that could reasonably expected to be met in the time available'), 
(233, 12, 25, null, 'Artefact implements minimum functionality or has significant bugs'), 
(234, 13, 25, 'Artefact implements most of the requirements with only minor bugs', null), 
(235, 14, 25, 'Artefact is reasonably complete and free of significant defects', null), 
(236, 15, 25, 'Artefact exhibits good qualities of reliability, timeliness, maintainability, completeness and consistency', null), 
(237, 16, 25, 'Artefact meets all (or virtually all) of its requirements. Artefact is worthy of real use and/or distribution', null), 
(238, 17, 25, 'Artefact meets all (or virtually all) of its requirements. Artefact is worthy of real use and/or distribution', null), 
(239, 8, 26, null, 'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task'), 
(240, 9, 26, null, 'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task'), 
(241, 10, 26, null, 'No serious attempt made to address the question or problem and/or shows a serious misunderstanding of the requirements of the task'), 
(242, 11, 26, null, 'Conclusions vague, ambiguous and not based on researched material.'), 
(243, 12, 26, null, 'Some summary or statement of conclusions, but the conclusions are trite or somewhat irrelevant to the problem being addressed'), 
(244, 13, 26, 'Outcomes summarised. Conclusions mostly valid and related at least partially to the objectives. Some recommendations made', null), 
(245, 14, 26, 'Conclusions all valid and relate well to all the objectives. ?Recommendations are valid with some justification', null), 
(246, 15, 26, 'Demonstrates understanding of complex topic and places it in wider context', null), 
(247, 16, 26, 'Conclusions appropriate, original and supported by the report.  Excellent summary of project and insightful conclusions.', null), 
(248, 17, 26, 'Conclusions appropriate, original and supported by the report.  Excellent summary of project and insightful conclusions.', null), 
(249, 8, 27, null, 'Acutely deficient in all aspects'), 
(250, 9, 27, null, 'Acutely deficient in all aspects'), 
(251, 10, 27, null, 'Acutely deficient in all aspects'), 
(252, 11, 27, null, 'Deficits in length, structure, presen-tation and/or prose'), 
(253, 12, 27, 'Logical and clear structure, well organised with good use of language and supporting material', null), 
(254, 13, 27, 'Satisfactory presentation with respect to presentation, organisation, language, grammar, spelling, format, presentation, diagrams, tables etc', null), 
(255, 14, 27, 'Very good in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc', null), 
(256, 15, 27, 'Excellent in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc', null), 
(257, 16, 27, 'Outstanding quality in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc', null), 
(258, 17, 27, 'Outstanding quality in terms of organisation, structure, use and flow of language, grammar, spelling, format, presentation, diagrams, tables etc', null), 
(259, 8, 28, null, 'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.'), 
(260, 9, 28, null, 'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.'), 
(261, 10, 28, null, 'No serious attempt to address the question or problem, and/or manifests a serious misunderstanding of the requirements of the assignment. Acutely deficient in all aspects.'), 
(262, 11, 28, null, 'Some knowledge of relevant concepts and literature but significant gaps in understanding and/or knowledge.'), 
(263, 12, 28, 'Demonstrates grasp of key concepts and an ability to develop and support an argument in a pre-dominately descriptive way with valid conclusions drawn from the research', null), 
(264, 13, 28, 'Work that attempts to address the topic with some understanding and analysis, key aspects of the subject matter covered \r\n? The majority of students might normally be expected to fall within this range.', null), 
(265, 14, 28, 'Clear, balanced coherent critical and rigorous analysis of the subject matter. Detailed understanding of knowledge and theory expressed with clarity', null), 
(266, 15, 28, 'Excellent work, able to express an original reasoned argument in a lucid manner by reviewing and critiquing a wide range of material. \r\nOriginal, critical thinking based on outstanding insight, knowledge and understanding of material.', null), 
(267, 16, 28, 'Material contributes to current understanding and is of potentially publishable quality in terms of presentation and content ', null), 
(268, 17, 28, 'Material contributes to current understanding and is of potentially publishable quality in terms of presentation and content', null);
#----------------------------
# Table structure for category_option_groups
#----------------------------
CREATE TABLE `category_option_groups` (
  `opt_group_id` int(11) NOT NULL auto_increment,
  `opt_group_name` varchar(64) default NULL,
  PRIMARY KEY  (`opt_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table category_option_groups
#----------------------------


insert  into category_option_groups values 
(1, '100% - 10 Bracket'), 
(2, 'Yes / No');
#----------------------------
# Table structure for category_options
#----------------------------
CREATE TABLE `category_options` (
  `opt_id` int(11) NOT NULL auto_increment,
  `opt_label` varchar(30) NOT NULL default '',
  `opt_selected_value` decimal(10,0) NOT NULL default '0',
  `opt_group` int(11) NOT NULL default '0',
  `opt_index` int(11) NOT NULL default '0',
  PRIMARY KEY  (`opt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB';
#----------------------------
# Records for table category_options
#----------------------------


insert  into category_options values 
(8, '0-9', '5', 1, 1), 
(9, '10-19', '15', 1, 2), 
(10, '20-29', '25', 1, 3), 
(11, '30-39', '35', 1, 4), 
(12, '40-49', '45', 1, 5), 
(13, '50-59', '55', 1, 6), 
(14, '60-69', '65', 1, 7), 
(15, '70-79', '75', 1, 8), 
(16, '80-89', '85', 1, 9), 
(17, '90-100', '95', 1, 10), 
(18, 'Yes', '50', 2, 1), 
(19, 'No', '0', 2, 2);
#----------------------------
# Table structure for cohort
#----------------------------
CREATE TABLE `cohort` (
  `cohort_id` int(10) NOT NULL auto_increment,
  `cohort_description` varchar(128) NOT NULL default '',
  `project_start_date` date NOT NULL default '0000-00-00',
  `project_end_date` date NOT NULL default '0000-00-00',
  `cohort_closed` char(1) default NULL,
  PRIMARY KEY  (`cohort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# Records for table cohort
#----------------------------


insert  into cohort values 
(3, 'MSc projects 2004-2005', '2005-04-01', '2005-09-16', null);
#----------------------------
# Table structure for cohort_coordinators
#----------------------------
CREATE TABLE `cohort_coordinators` (
  `co_cord_id` int(11) NOT NULL auto_increment,
  `cohort_id` int(11) NOT NULL default '0',
  `person_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`co_cord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table cohort_coordinators
#----------------------------


insert  into cohort_coordinators values 
(1, 3, 2);
#----------------------------
# Table structure for contacts
#----------------------------
CREATE TABLE `contacts` (
  `ORGADDR` varchar(100) default NULL,
  `ORGCONTACT` varchar(50) default NULL,
  `ORGDOES` varchar(50) default NULL,
  `ORGEMAIL` varchar(50) default NULL,
  `ORGID` int(10) NOT NULL auto_increment,
  `ORGNAME` varchar(50) default NULL,
  `ORGPOSTCODE` varchar(10) default NULL,
  `ORGTEL` varchar(20) default NULL,
  PRIMARY KEY  (`ORGID`),
  UNIQUE KEY `ORGID_PK` (`ORGID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB';
#----------------------------
# No records for table contacts
#----------------------------

#----------------------------
# Table structure for emailmessages
#----------------------------
CREATE TABLE `emailmessages` (
  `MAILKEY` varchar(30) NOT NULL default '',
  `MAILVALUE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 4096 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# Records for table emailmessages
#----------------------------


insert  into emailmessages values 
('PROJECTREADY', 'The following project has been registered on the SUMS System and is ready to be marked:\r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\n\r\nTo view the project and submit your mark now click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('MARKERALERT', 'You have been assigned as {ROLE} marker for the following project, registered on the SUMS System:\r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\nProject Status: {STATUS}\r\n\r\nTo view the project, please click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('THIRDNEEDED', 'The following project has reached the stage of third marker reconciliation and requires the assignment of a third marker. \r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\n\r\nTo view the project and assign a third marker, click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('EXAMNEEDED', 'The following project has reached the stage of examiner reconciliation and requires the assignment of an examiner marker. \r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\n\r\nTo view the project and assign an examiner marker, click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('MARKCONF', 'You have submitted a project mark for the following project:\r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\n\r\nThe mark you assigned is {MARKFORMMARK}% and was calculated as follows:\r\n\r\n{CATMARKS}\r\n\r\nWeighting applied: {MARKWEIGHT}\r\n\r\nGeneral comments: {GENERALCOMMENTS}\r\n\r\nExaminer comments: {EXAMCOMMENTS}\r\n\r\nPlagiarism suspect?: {PLAGIARISM}\r\n\r\nTo view the project, click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('STATUSCHANGE', 'The status of the following project has been updated:\r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\nStatus: {STATUS}\r\nMark: {MARK}\r\nComments: {COMMENTS}\r\n\r\nTo view the project, click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('CONFALERT', '{STUDENT}\r\n\r\nYour project for {UNIT} has been marked.\r\n\r\nYour can view your project mark online by clicking the link below:\r\n\r\nhttp://localhost:8084/SUMS/assess/viewStudentMark.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('MARKERCONF', 'The markers for the following project have been updated:\r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n\r\nMarkers:\r\n\r\n{MARKERS}\r\n\r\nTo view the project, click the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n'), 
('RECONNEEDED', 'The supervisor/moderator marks for the following project differ by more than 10%.  \r\n\r\nStudent Name: {STUDENT}\r\nProject Unit: {UNIT}\r\nProject Cohort: {COHORT}\r\nProject Title: {TITLE}\r\nProject Submission Date: {DATESUBMIT}\r\n{MARKERS}\r\n\r\nOnce a reconciled mark has been agreed, you can submit it by clicking the link below:\r\n\r\n$APPURL$/assess/viewProject.do?PROJECT={ID}\r\n\r\nThis message is automatically generated from the database. In case of query, contact me.\r\n\r\nDr Jim Briggs\r\nProjects co-ordinator\r\n');
#----------------------------
# Table structure for emails
#----------------------------
CREATE TABLE `emails` (
  `EMAIL` varchar(100) NOT NULL default '',
  `USERID` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table emails
#----------------------------

#----------------------------
# Table structure for final_project
#----------------------------
CREATE TABLE `final_project` (
  `project_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) NOT NULL default '0',
  `cohort_id` int(11) NOT NULL default '0',
  `unit_id` int(11) NOT NULL default '0',
  `project_title` varchar(50) NOT NULL default '',
  `project_submitted_date` date NOT NULL default '0000-00-00',
  `late_hand_in` char(1) default NULL,
  `unit_exam_board_decision` date default NULL,
  `project_status` char(3) default NULL,
  `project_mark` decimal(11,0) default NULL,
  `project_comments` text,
  PRIMARY KEY  (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# No records for table final_project
#----------------------------

#----------------------------
# Table structure for ideas2
#----------------------------
CREATE TABLE `ideas2` (
  `PROJAIMS` text,
  `PROJAPPROVED` char(1) default NULL,
  `PROJDATE` timestamp NULL default NULL,
  `PROJDELIVER` text,
  `PROJID` int(10) NOT NULL auto_increment,
  `PROJORG` int(10) default NULL,
  `PROJQUEST` text,
  `PROJSTUDENT` varchar(100) default NULL,
  `PROJTITLE` varchar(100) default NULL,
  PRIMARY KEY  (`PROJID`),
  UNIQUE KEY `PROJID_PK` (`PROJID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB';
#----------------------------
# No records for table ideas2
#----------------------------

#----------------------------
# Table structure for mark_categories
#----------------------------
CREATE TABLE `mark_categories` (
  `CATBEGIN` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `CATDESCRIPTION` text NOT NULL,
  `CATEND` timestamp NULL default NULL,
  `CATID` int(10) NOT NULL auto_increment,
  `CATLONGNAME` varchar(100) NOT NULL default '',
  `CATNAME` varchar(30) NOT NULL default '',
  `COG_ID` int(11) NOT NULL default '0',
  `OPTION_TYPE` char(1) NOT NULL default '',
  PRIMARY KEY  (`CATID`),
  UNIQUE KEY `CATID_PK` (`CATID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# Records for table mark_categories
#----------------------------


insert  into mark_categories values 
('2005-08-09 08:31:22', 'To what extent are the problem topic and investigation well framed in the report? How challenging is the problem demonstrated to be?', null, 16, 'Statement of project’s context, aims and objectives', 'Context', 1, 'C'), 
('2005-08-09 08:31:22', 'How critical, relevant, comprehensive and current is the review? Are the sources demonstrated to be credible (or not)? Does the review incorporate all the relevant literature? Is irrelevant material left out?', null, 17, 'Critical review of relevant literature', 'Lit Review', 1, 'C'), 
('2005-08-09 08:31:23', 'To what extent does the report show that the methods used were appropriate, justified and well applied? How well does the report describe and justify appropriate methodological tools/techniques deployed or considered for deployment?', null, 18, 'Methodological approach', 'Methodology', 1, 'C'), 
('2005-08-09 08:31:23', 'How well does the report describe and justify how the specification of the problem and its solution were arrived at? Does the report describe and explain the important requirements (and why they are important)? Are the requirements complete and consistent? Has the client approved them (implicitly or explicitly)?', null, 19, 'Specification and discussion of the requirements', 'Requirements', 1, 'C'), 
('2005-08-09 08:31:24', 'How well does the report demonstrate how the solution was designed including design method(s), design process(es) and outcome(s) in areas such as system architectures, databases, user interfaces, interfaces to other systems, and other areas of IT?', null, 20, 'Analysis and discussion of the IT design', 'Design', 1, 'C'), 
('2005-08-09 08:31:24', 'How well does the report describe and justify the decisions and trade-offs made, such as selection of algorithms, data structures, usability and implementation environments as appropriate?', null, 21, 'Discussion of implementation', 'Implementation', 1, 'C'), 
('2005-08-09 08:31:24', 'How well does the report describe and justify the approach(es) to verification and validation at each stage of the project, including testing and debugging?', null, 22, 'Discussion of verification and validation', 'Validation', 1, 'C'), 
('2005-08-09 08:31:25', 'How well does the report describe and justify the means by which the outcome of the project was evaluated? How well is it shown whether the specification of the requirements has been satisfied? How well explained are areas where it hasn’t?', null, 23, 'Evaluation against requirements', 'Evaluation', 1, 'C'), 
('2005-08-09 08:31:25', 'How well does the report demonstrate the preparation of an overall project plan with timescales, resources, and a work schedule? How well does the report show evidence that it has been followed and explain deviations from it?', null, 24, 'Evidence of project planning and management', 'Planning', 1, 'C'), 
('2005-08-09 08:31:26', 'Based on the demonstration of the artefact(s) and/or the evidence of the artefact(s) presented in the report or its appendices, how well do they show the quality of the artefact(s), e.g. attributes such as reliability, timeliness, maintainability, completeness, and consistency? An artefact may be a piece of software, hardware or a detailed design for one.', null, 25, 'Attributes of the solution', 'Solution', 1, 'C'), 
('2005-08-09 08:31:26', 'To what extent are the conclusions and recommendations appropriate, original and supported by the report? How well are the outcomes of the project summarised? Are the conclusions based on analysis and understanding rather than being trite?', null, 26, 'Summary, conclusions and recommendations', 'Conclusion', 1, 'C'), 
('2005-08-09 08:31:26', 'How well presented is the report in terms of quality of prose style; page layout; appropriate division into chapters, sections and sub-sections; use of graphics and tables; punctuation, spelling, grammar and syntax; ease of reading; enjoyabil-ity of reading?', null, 27, 'Structure and presentation', 'Presentation', 1, 'C'), 
('2005-08-09 08:31:27', 'In all categories, does the report show clearly and explicitly that the student has understood the material presented and the techniques used? Does the student demonstrate appreciation of the strengths and weaknesses of the approach(es) used?', null, 28, 'Overall understanding and reflection', 'Reflection', 1, 'C');
#----------------------------
# Table structure for mark_form_categories
#----------------------------
CREATE TABLE `mark_form_categories` (
  `CATID` int(10) NOT NULL default '0',
  `CATINDEX` int(10) default NULL,
  `CATWEIGHT` decimal(10,0) default NULL,
  `FORMID` int(10) NOT NULL default '0',
  `MFCBEGIN` timestamp NULL default NULL,
  `MFCEND` timestamp NULL default NULL,
  `MFCID` int(10) NOT NULL auto_increment,
  `OPTIONAL` char(1) default NULL,
  PRIMARY KEY  (`MFCID`),
  UNIQUE KEY `MFCID_PK` (`MFCID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 4096 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# Records for table mark_form_categories
#----------------------------


insert  into mark_form_categories values 
(16, 1, '2', 2, '2005-08-08 00:41:18', null, 15, 'N'), 
(17, 2, '2', 2, '2005-08-08 00:41:48', null, 16, 'Y'), 
(18, 3, '1', 2, '2005-08-08 00:42:19', null, 17, 'N'), 
(19, 4, '3', 2, '2005-08-08 00:42:46', null, 18, 'N'), 
(20, 5, '3', 2, '2005-08-08 00:43:15', null, 19, 'N'), 
(21, 6, '3', 2, '2005-08-08 00:43:27', null, 20, 'N'), 
(22, 7, '1', 2, '2005-08-08 00:43:50', null, 21, 'N'), 
(23, 8, '2', 2, '2005-08-08 00:44:13', null, 22, 'N'), 
(24, 9, '1', 2, '2005-08-08 00:44:46', null, 23, 'N'), 
(25, 10, '3', 2, '2005-08-08 00:45:02', null, 24, 'N'), 
(26, 11, '2', 2, '2005-08-08 00:46:24', null, 25, 'N'), 
(27, 12, '2', 2, '2005-08-08 00:46:41', null, 26, 'Y'), 
(28, 13, '3', 2, '2005-08-08 00:46:55', null, 27, 'Y');
#----------------------------
# Table structure for mark_forms
#----------------------------
CREATE TABLE `mark_forms` (
  `FORMBEGIN` timestamp NULL default NULL,
  `FORMEND` timestamp NULL default NULL,
  `FORMID` int(10) NOT NULL auto_increment,
  `FORMNAME` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`FORMID`),
  UNIQUE KEY `FORMID_PK` (`FORMID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB';
#----------------------------
# Records for table mark_forms
#----------------------------


insert  into mark_forms values 
('2000-04-01 00:00:00', null, 2, 'Masters Engineering Project');
#----------------------------
# Table structure for marker_capacity
#----------------------------
CREATE TABLE `marker_capacity` (
  `marker_capacity_id` int(11) NOT NULL auto_increment,
  `project_id` int(11) NOT NULL default '0',
  `marker_type_id` int(11) NOT NULL default '0',
  `person_id` int(11) NOT NULL default '0',
  `allocated_date` date NOT NULL default '0000-00-00',
  `unallocated_date` date default NULL,
  PRIMARY KEY  (`marker_capacity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table marker_capacity
#----------------------------

#----------------------------
# Table structure for marker_type
#----------------------------
CREATE TABLE `marker_type` (
  `marker_type_id` int(11) NOT NULL auto_increment,
  `marker_description` varchar(64) NOT NULL default '',
  PRIMARY KEY  (`marker_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table marker_type
#----------------------------


insert  into marker_type values 
(1, 'Supervisor'), 
(2, 'Moderator'), 
(3, 'Third'), 
(4, 'Examiner');
#----------------------------
# Table structure for marks
#----------------------------
CREATE TABLE `marks` (
  `mark_id` int(11) NOT NULL auto_increment,
  `project_id` int(11) NOT NULL default '0',
  `marker_capacity_id` int(11) NOT NULL default '0',
  `mark` decimal(10,0) NOT NULL default '0',
  `mark_date` date NOT NULL default '0000-00-00',
  `general_comments` text NOT NULL,
  `comments_for_examiners` text,
  `general_comments_examboard` text,
  `plagiarism_unfair_act` char(1) default NULL,
  `plagiarism_comments` text,
  `unfair_act_notes` text,
  `adjustment_applied` int(11) default NULL,
  `plagiarism_suspect` char(1) default NULL,
  PRIMARY KEY  (`mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB; InnoDB free: 307';
#----------------------------
# No records for table marks
#----------------------------

#----------------------------
# Table structure for option_marks
#----------------------------
CREATE TABLE `option_marks` (
  `opt_mark_id` int(11) NOT NULL auto_increment,
  `mark_id` int(11) NOT NULL default '0',
  `cat_id` int(11) NOT NULL default '0',
  `co_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`opt_mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB';
#----------------------------
# No records for table option_marks
#----------------------------

#----------------------------
# Table structure for person
#----------------------------
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(16) NOT NULL default '',
  `password` varchar(16) NOT NULL default '',
  `first_name` varchar(64) NOT NULL default '',
  `surname` varchar(64) NOT NULL default '',
  `inactive` char(1) default NULL,
  PRIMARY KEY  (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB';
#----------------------------
# Records for table person
#----------------------------


insert  into person values 
(2, '', '', 'Jim', 'Briggs', null);
#----------------------------
# Table structure for person_email
#----------------------------
CREATE TABLE `person_email` (
  `e_mail_id` int(11) NOT NULL auto_increment,
  `person_id` int(11) NOT NULL default '0',
  `e_mail_add` varchar(128) NOT NULL default '',
  `e_mail_suspended` char(1) default NULL,
  PRIMARY KEY  (`e_mail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table person_email
#----------------------------

#----------------------------
# Table structure for person_roles
#----------------------------
CREATE TABLE `person_roles` (
  `role` int(11) NOT NULL default '0',
  `person_id` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table person_roles
#----------------------------

#----------------------------
# Table structure for prize_categories
#----------------------------
CREATE TABLE `prize_categories` (
  `prize_cat_id` int(11) NOT NULL auto_increment,
  `prize_cat_name` varchar(16) NOT NULL default '',
  `prize_value` decimal(10,0) default NULL,
  `prize_cat_criteria` text,
  PRIMARY KEY  (`prize_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table prize_categories
#----------------------------

#----------------------------
# Table structure for prize_nominations
#----------------------------
CREATE TABLE `prize_nominations` (
  `prize_nom_id` int(11) NOT NULL auto_increment,
  `prize_cat_id` int(11) NOT NULL default '0',
  `mark_id` int(11) NOT NULL default '0',
  `supporting_comments` text,
  PRIMARY KEY  (`prize_nom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table prize_nominations
#----------------------------

#----------------------------
# Table structure for roles
#----------------------------
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_description` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# No records for table roles
#----------------------------

#----------------------------
# Table structure for staff
#----------------------------
CREATE TABLE `staff` (
  `staff_no` varchar(16) NOT NULL default '',
  `person_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`staff_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table staff
#----------------------------


insert  into staff values 
('1234', 2);
#----------------------------
# Table structure for statuses
#----------------------------
CREATE TABLE `statuses` (
  `status_code` char(3) default NULL,
  `status` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; InnoDB free: 3072 kB';
#----------------------------
# Records for table statuses
#----------------------------


insert  into statuses values 
('A', 'Awaiting Mark'), 
('S', 'Supervisor Marked'), 
('M', 'Moderator Marked'), 
('SM', 'Supervisor/Moderator Marked'), 
('R1A', 'Supervisor/Moderator Reconcilliation - Awaiting Decision'), 
('R1M', 'Supervisor/Moderator Reconcilliation- Marked'), 
('R2A', 'Third Marker Reconcilliation - Awaiting 3rd Marker Assignment'), 
('R2B', 'Third Marker Reconcilliation - Awaiting 3rd Marker Mark'), 
('R2C', 'Third Marker Reconcilliation - Awaiting Decision'), 
('R2M', 'Third Marker Reconcilliation - Marked'), 
('R3A', 'Examiner Reconcilliation - Awaiting Examiner Marker Assignment'), 
('R3B', 'Examiner Reconcilliation - Awaiting Examiner Marker Mark'), 
('R3C', 'Examiner Reconcilliation - Awaiting Decision'), 
('R3M', 'Examiner Reconcilliation - Marked'), 
('C', 'Mark Confirmed'), 
('X', 'Archived');
#----------------------------
# Table structure for student
#----------------------------
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL auto_increment,
  `hemis_no` int(16) NOT NULL default '0',
  `person_id` int(11) NOT NULL default '0',
  `degree_stream` varchar(16) NOT NULL default '',
  `final_year` varchar(16) NOT NULL default '',
  PRIMARY KEY  (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB';
#----------------------------
# No records for table student
#----------------------------

#----------------------------
# Table structure for tel_number
#----------------------------
CREATE TABLE `tel_number` (
  `telephone_number_id` int(11) NOT NULL auto_increment,
  `person_id` int(11) NOT NULL default '0',
  `tel_number` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`telephone_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB';
#----------------------------
# No records for table tel_number
#----------------------------

#----------------------------
# Table structure for unit
#----------------------------
CREATE TABLE `unit` (
  `unit_id` int(11) NOT NULL auto_increment,
  `unit_code` varchar(16) NOT NULL default '',
  `unit_name` varchar(50) NOT NULL default '',
  `academic_yr_first_run` date NOT NULL default '0000-00-00',
  `academic_yr_last_run` date default NULL,
  PRIMARY KEY  (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table unit
#----------------------------


insert  into unit values 
(4, 'PJ60P', 'Masters Project', '2000-02-01', null);
#----------------------------
# Table structure for unit_mark_forms
#----------------------------
CREATE TABLE `unit_mark_forms` (
  `umfid` int(11) NOT NULL auto_increment,
  `unit_id` int(11) NOT NULL default '0',
  `form_id` int(11) NOT NULL default '0',
  `umfbegin` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `umfend` timestamp NULL default NULL,
  PRIMARY KEY  (`umfid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------
# Records for table unit_mark_forms
#----------------------------


insert  into unit_mark_forms values 
(4, 4, 2, '2005-07-26 17:27:04', null);

