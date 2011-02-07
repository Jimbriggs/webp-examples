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
<TITLE>Edit a project contact</TITLE>
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
<!-- InstanceBeginEditable name="heading" --><!-- #BeginLibraryItem "/Library/Message header.lbi" -->
<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
<font color="red">
ERROR: Application resources not loaded -- check servlet container logs for error messages.
</font>
</logic:notPresent><!-- #EndLibraryItem --><!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
        <h1>Edit contact</h1>
        <!-- #BeginLibraryItem "/Library/Errors and messages.lbi" -->
<!-- #BeginLibraryItem "/Library/Messages.lbi" -->
<html:messages id="message" message="true">
<p><bean:write name="message"/></p>
</html:messages><!-- #EndLibraryItem --><!-- #BeginLibraryItem "/Library/Errors.lbi" -->
<html:messages id="error" message="false">
<p><bean:write name="error"/></p>
</html:messages><!-- #EndLibraryItem --><!-- #EndLibraryItem --><logic:messagesPresent>
            <P><FONT color='red'>Please correct the errors indicated below and resubmit the form</font></p>
        </logic:messagesPresent>

        <html:form action="/ideas/SaveContact"> <%-- onsubmit="return validateIdeaForm(this)"--%>
            <table border="0" cellpadding="0" cellspacing="2">
                <tr valign="top"> 
                    <td width="50%"> 
                    <h2>About you and your organisation...</h2></td>
                    
                </tr>
                <tr valign="top"> 
                    <td width="50%"> 
                    <table width="100%" border="1" cellspacing="0" cellpadding="1">

                        <tr valign="top"> 
                            <th align="left">Organisation name:</th>
                            <td><html:errors property="orgname"/>
                                <html:text property="orgname"  size="50" maxlength="50"/>
                                <BR>Reference number: 
                                <html:errors property="orgid"/>
                                <html:text property='orgid'/>
                            </td>
                        </tr>
                        <tr valign="top"> 
                            <th align="left">Postal address:</th>
                            <td><html:errors property="orgaddr"/>
                                <html:textarea property="orgaddr" cols="50"
                                rows="5" /> <br>
                                Postcode 
                                <html:errors property="orgpostcode"/>
                                <html:text property="orgpostcode" size="50" maxlength="50"/> 
                            </td>
                        </tr>
                        <tr valign="top"> 
                            <th align="left">Outline of what your organisation does:</th>
                            <td>
                            <html:errors property="orgdoes"/>
                            <html:textarea property="orgdoes"  cols="50"
                            rows="2" /></td>
                        </tr>
                        <tr valign="top"> 
                            <th align="left">Contact name:</th>
                            <td><html:errors property="orgcontact"/>
                            <html:text property="orgcontact"  size="50"
                            maxlength="50"/></td>
                        </tr>
                        <tr valign="top"> 
                            <th align="left">Telephone number:</th>
                            <td>
                            <html:errors property="orgtel"/>
                            <html:text property="orgtel"  size="20" maxlength="20"/> </td>
                        </tr>
                        <tr valign="top"> 
                            <th align="left">Email address:</th>
                            <td>
                            <html:errors property="orgemail"/>
                            <html:text property="orgemail"  size="25"
                            maxlength="50"/> </td>
                        </tr>
                        <tr valign="top">
                            <th align="left">&nbsp;</th>
                            <td>&nbsp;</td>
                        </tr>

                    </table></td>
                </tr>
                <tr valign="top">
                    <td width="50%" align="left"><font size="-1">Note that the contents of this 
                    form will be held in a database and made available to students via the 
                    web. We cannot guarantee either that a student will choose to do the project, 
                    or, if one does, that they will achieve the desired results.</font></td>
                </tr>
                <tr valign="top"> 
                    <td width="50%" align="right"> 
                        <html:submit /> 
                    </td>
                </tr>
            </table>
        </html:form>
        <%--html:javascript formName="contactForm"/--%>
<!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
