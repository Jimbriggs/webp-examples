package help.assess;

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><!-- InstanceBegin template="/Templates/SUMS basic JSP.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<HEAD>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<META http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- InstanceBeginEditable name="doctitle" -->
<TITLE>Help for step 2</TITLE>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<html:base/>
<!-- InstanceEndEditable -->


<link href="../../css/styles.css" rel="stylesheet" type="text/css">
</HEAD>

<BODY>
<!-- #BeginLibraryItem "/Library/SUMS header.lbi" -->
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
  <TR bgcolor="#CCFFFF"> 
    <TD align="left" valign="top" bgcolor="#660066"> <h2 class="headlineLeft">University of Portsmouth</h2></TD>
    <TD bgcolor="#660066" align="right"><P><FONT color="#FFFF99" face="Verdana, Arial, Helvetica, sans-serif" class="headlineRight">SUMS</FONT></P>
    <P>      <SPAN class="subheadRight">CAM Student &amp; Unit Management System v5.0</SPAN></P>
    </TD>
  </TR>
  <TR > 
    <TD colspan="2" align="right"> <H5><A href="/sums2/index.jsp">
        
        SUMS home page</A></H5>
    </TD></TR>
</TABLE>
<!-- InstanceBeginEditable name="heading" -->
<h1>Help for step 2 </h1>
<!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
<p>In step 2 you need to provide the following information:</p>
<table border="0" cellspacing="0" cellpadding="10">
  <tr align="left" valign="top">
    <th scope="row">In each category... </th>
    <td>
      <p>Select one or more tick boxes to represent the grade(s) you wish to assign.</p>
      <p>The numeric mark associated with a box is the middle of the range (e.g. you tick 50-59 gets you 55). If you tick more than one it will take the arithmetic mean of them, so ticking 50-59 and 60-69 will give you 60. You need to select at least one box in each row - an error message will show missing category marks if you try to calculate the overall mark. </p>
      <p>Moving the mouse over the category name will create a pop-up containing a description of the category.</p>
      <p>In the near future, moving the mouse over a grade will pop-up the criteria for that grade. Until then, please refer to the <a href="http://www.pums.cam.port.ac.uk/projects/assess/index.htm">paper form</a>. </p>
      <p>The category marks are combined (using the weightings shown in the second column) to calculate the overall mark. </p>
    </td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Adjustment</th>
    <td>This allows you to adjust the overall mark by between -5 and +5 marks. </td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Comments</th>
    <td>This for your comments for the student. Currently SUMS does not implement any mechanism for passing this to the students.</td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Information for examiners </th>
    <td>This is the place for notes to be brought to the attention of the examiners. </td>
  </tr>
</table>
<!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
