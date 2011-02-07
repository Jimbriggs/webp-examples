<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html locale="true">
<head>
<title><bean:message key="pums.listideas.title"/></title>
<html:base/>
</head>
<body bgcolor="white">

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">
    ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.
  </font>
</logic:notPresent>

<h3><bean:message key="pums.listideas.heading"/></h3>
<p><bean:message key="pums.listideas.message"/></p>



<!-- #BeginLibraryItem "/Library/Errors and messages.lbi" -->
<!-- #BeginLibraryItem "/Library/Messages.lbi" -->
<html:messages id="message" message="true">
<p><bean:write name="message"/></p>
</html:messages><!-- #EndLibraryItem --><!-- #BeginLibraryItem "/Library/Errors.lbi" -->
<html:messages id="error" message="false">
<p><bean:write name="error"/></p>
</html:messages><!-- #EndLibraryItem --><!-- #EndLibraryItem --><html:form action="/ideas/Projidea" method="post">
<table border="0" cellpadding="0" cellspacing="2">
  <tr valign="top"> 
    <td> <h2>About you and your organisation...</h2></td>
    <td> <h2>About the project idea...</h2></td>
  </tr>
  <tr valign="top"> 
    <td><table width="100%" border="1" cellspacing="0" cellpadding="1">
        <tr valign="top"> 
          <th align="left">Organisation name:</th>
          <td><html:text property="orgname" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Postal address:</th>
          <td> <html:textarea property="orgaddr" /> <br> <html:text property="orgpostcode" /> 
            &nbsp; </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Outline of what your organisation does:</th>
          <td><html:text property="orgdoes" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Contact name:</th>
          <td><html:text property="orgcontact" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Telephone number:</th>
          <td><html:text property="orgtel" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Email address:</th>
          <td><html:text property="orgemail" /> &nbsp;</td>
        </tr>
      </table></td>
    <td><table width="100%" border="1" cellspacing="0" cellpadding="1">
        <tr valign="top"> 
          <th align="left">Project title:</th>
          <td> <html:text property="projtitle" /> </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Project reference number:</th>
          <td><html:text property="projid" /></td>
        </tr>
        <tr valign="top"> 
          <th align="left">Aims and objectives:</th>
          <td> <html:textarea property="projaims" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Academic question to be answered (blank if unknown):</th>
          <td><html:textarea property="projquest" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Anticipated deliverables:</th>
          <td> <html:textarea property="projdeliver" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Student for whom project has been devised (blank if 
            unknown):</th>
          <td><html:text property="projstudent" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Status <font size="-2">(<font size="-1">A</font>pproved/<strong><font size="-1">P</font></strong>rovisional/<strong><font size="-1">W</font></strong>ithdrawn)</font>:</th>
          <td> <html:text property="projstatus" /> &nbsp; </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Date submitted:</th>
          <td><html:text property="projdate"/></td>
        </tr>
      </table></td>
  </tr>
  <tr><td><html:submit/></tr>
</table>
</html:form>
<html:javascript formName="ideaForm"/>

</body>
</html:html>
