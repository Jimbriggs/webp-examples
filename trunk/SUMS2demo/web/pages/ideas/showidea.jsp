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

<html:errors/>

<logic:present name="item">

<table border="0" cellpadding="0" cellspacing="2">
  <tr valign="top"> 
    <td> <h2>About you and your organisation...</h2></td>
    <td> <h2>About the project idea...</h2></td>
  </tr>
  <tr valign="top"> 
    <td><table width="100%" border="1" cellspacing="0" cellpadding="1">
        <tr valign="top"> 
          <th align="left">Organisation name:</th>
          <td><bean:write name="item" property="orgname" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Postal address:</th>
          <td> <bean:write name="item" property="orgaddr" /> <br> <bean:write name="item" property="orgpostcode" /> 
            &nbsp; </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Outline of what your organisation does:</th>
          <td><bean:write name="item" property="orgdoes" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Contact name:</th>
          <td><bean:write name="item" property="orgcontact" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Telephone number:</th>
          <td><bean:write name="item" property="orgtel" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Email address:</th>
          <td><bean:write name="item" property="orgemail" /> &nbsp;</td>
        </tr>
      </table></td>
    <td><table width="100%" border="1" cellspacing="0" cellpadding="1">
        <tr valign="top"> 
          <th align="left">Project title:</th>
          <td> <bean:write name="item" property="projtitle" /> </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Project reference number:</th>
          <td><bean:write name="item" property="projid" /></td>
        </tr>
        <tr valign="top"> 
          <th align="left">Aims and objectives:</th>
          <td> <bean:write name="item" property="projaims" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Academic question to be answered (blank if unknown):</th>
          <td><bean:write name="item" property="projquest" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Anticipated deliverables:</th>
          <td> <bean:write name="item" property="projdeliver" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Student for whom project has been devised (blank if 
            unknown):</th>
          <td><bean:write name="item" property="projstudent" /> &nbsp;</td>
        </tr>
        <tr valign="top"> 
          <th align="left">Status <font size="-2">(<font size="-1">A</font>pproved/<strong><font size="-1">P</font></strong>rovisional/<strong><font size="-1">W</font></strong>ithdrawn)</font>:</th>
          <td> <bean:write name="item" property="projapproved" /> &nbsp; </td>
        </tr>
        <tr valign="top"> 
          <th align="left">Date submitted:</th>
          <td><bean:write name="item" property="projdate" format="d MMM yyyy"/></td>
        </tr>
      </table></td>
  </tr>
</table>
</logic:present>
<logic:notPresent name="item">

</logic:notPresent>

</body>
</html:html>
