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

<TABLE border=1 cellspacing=0 cellpadding=2>
<logic:iterate id="item" name="ideas">
<TR>
<TD>
<bean:write name="item" property="PROJID" filter="true"/>
<TD>
<html:link forward="showidea" paramId="idea" paramName="item" paramProperty="PROJID">
<bean:write name="item" property="PROJTITLE" filter="true"/>
</html:link>
<TD>
<bean:write name="item" property="ORGCONTACT" filter="true"/>
(<bean:write name="item" property="PROJORG" filter="true"/>)
<TD>
<bean:write name="item" property="PROJSTUDENT" filter="true"/>&nbsp;
<TD>
<bean:write name="item" property="PROJDATE" filter="true" format="d MMM yyyy"/>
<TD>
<bean:write name="item" property="PROJAPPROVED" filter="true"/>&nbsp;
</TR>
</logic:iterate>
</TABLE>

</body>
</html:html>
