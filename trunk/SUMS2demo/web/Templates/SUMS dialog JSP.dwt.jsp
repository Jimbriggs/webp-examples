package Templates;

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<META http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- TemplateBeginEditable name="doctitle" -->
<TITLE>Untitled Document</TITLE>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<html:base/>
<!-- TemplateEndEditable -->


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
<!-- TemplateBeginEditable name="heading" --><!-- TemplateEndEditable --><!-- #BeginLibraryItem "/Library/Errors and messages.lbi" --> <!-- #BeginLibraryItem "/Library/Messages.lbi" -->
<html:messages id="message" message="true">
  <p>
    <bean:write name="message"/>
  </p>
</html:messages>
<!-- #EndLibraryItem --><!-- #BeginLibraryItem "/Library/Errors.lbi" -->
<html:messages id="error" message="false">
  <p>
    <bean:write name="error"/>
  </p>
</html:messages>
<!-- #EndLibraryItem --><!-- #EndLibraryItem --><!-- TemplateBeginEditable name="body" -->body<!-- TemplateEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
</HTML>
