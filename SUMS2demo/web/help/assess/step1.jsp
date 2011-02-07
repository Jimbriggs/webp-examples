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
<TITLE>Help for step 1</TITLE>
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
<h1>Help for step 1 </h1>
<!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
<p>In step 1 you need to provide the following information:</p>
<table border="0" cellspacing="0" cellpadding="10">
  <tr align="left" valign="top">
    <th scope="row">Name of student / HEMIS number</th>
    <td>Hopefully self-explanatory and obtainable from the cover of the report.</td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Name of supervisor </th>
    <td>Hopefully obtainable from the cover of the report. Leave blank if unknown. </td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Brief project title </th>
    <td>Again from the cover of the report. Usually no need to type it in full. </td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Project unit </th>
    <td>Either PJE30 or PJS30. Obtainable from the cover of the report. </td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Marker's name</th>
    <td>You!</td>
  </tr>
  <tr align="left" valign="top">
    <th scope="row">Marker's status</th>
    <td>Whether you are the SUPERVISOR, MODERATOR, 3RD MARKER or REMARKER of the project </td>
  </tr>
</table>
<p>&nbsp;</p>
<!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
