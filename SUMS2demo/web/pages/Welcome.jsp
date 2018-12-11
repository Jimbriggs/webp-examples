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
<TITLE>Welcome to SUMS</TITLE>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->

<html:base/>
<!-- InstanceEndEditable -->


<link href="../css/styles.css" rel="stylesheet" type="text/css">
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
<!-- InstanceBeginEditable name="heading" --><h3><bean:message key="pums.welcome.heading"/></h3>

<!-- #BeginLibraryItem "/Library/Message header.lbi" -->
<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application"> <font color="red"> ERROR: Application resources not loaded -- check servlet container logs for error messages. </font> </logic:notPresent>
<!-- #EndLibraryItem --><!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
<table width="100%"  border="1" cellspacing="0" cellpadding="10">
  <tr align="left" valign="top">
    <td width="15%" bgcolor="#FFFFCC">
      <h4>Menu
      </h4>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><html:link forward="userHome">Project marking</html:link> </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td><html:link action="/assess/InitLoadCohort">Load cohort</html:link> (admin only) </td>
        </tr>        
      </table>
    </td>
    <td>
      <h1>
        <bean:message key="pums.welcome.message"/>
</h1>
      <h2>This is the prototype SUMS system</h2>
      <p>Please report problems with it to <a href="mailto:Jim.Briggs@port.ac.uk">Jim Briggs</a>  </p>
    </td>
  </tr>
</table>
<!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
