<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<html>
<head><title>Fatal error</title></head>
<body>

    <%-- <jsp:useBean id="beanInstanceName" scope="session" class="beanPackage.BeanClassName" /> --%>
    <%-- <jsp:getProperty name="beanInstanceName"  property="propertyName" /> --%>
    <H1>Fatal error</H1>
    <html:errors/>
    <p>End of error report
    <h1>Messages</h1>
    <html:messages id="message" message="true">
        <bean:write name="message"/>
    </html:messages>

    <p>End of messages
</body>
</html>
