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
    <TITLE>Project marking step 1</TITLE>
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
    <h1>Project marking</h1>
    <h3>Step 1 of 4: Enter basic details</h3>
<!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
    <jsp:useBean id="units" class="jim.pums.assess.bus.ProjectMarkFactory"/>
    <c:set var="user" value="${pageContext.request.remoteUser}"/>
    
    <p align="left">
        <html:link page="/help/assess/step1.jsp" target="_blank">Help</html:link>
        <html:form action="/assess/genForm" enctype="application/x-www-form-urlencoded" method="post">

        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th align="left" valign="top">Name of student /  HEMIS number</th>
                <td valign="top"><html:text property="studentName"/> <html:errors property="studentName"/>
                <th align="left" valign="top">Name of supervisor                 
                <td valign="top">
                <html:text property="supervisor"/>
                <html:errors property="supervisor"/>                
            </tr>
            <tr>
                <th align="left" valign="top">Brief project title </th>
                <td valign="top">
                <html:text property="projectTitle"/> 
                <html:errors property="projectTitle"/>           
                <th align="left" valign="top">Marker's name<td valign="top">
                <html:text property="marker"/>
                <html:errors property="marker"/>
            </tr>
            <tr>
                <th align="left" valign="top">Project unit </th>
                <td valign="top"><html:select property="unit" size="1">
                    <html:options name="units" property="allUnits"  />
                </html:select> <html:errors property="unit"/>
                <th align="left" valign="top">Marker's status               
                <td valign="top">
                Sup <html:radio property="status" value="Supervisor"/>
                Mod <html:radio property="status" value="Moderator"/>
                3rd <html:radio property="status" value="3rd marker"/>
                Rem <html:radio property="status" value="Re-marker"/>
                <html:errors property="status"/>
            </tr>           
            <tr><th colspan=4 align="left" valign="top"><html:submit/>
</table>
    </html:form><!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
