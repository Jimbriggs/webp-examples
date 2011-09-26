<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>Hello JSP Page with JSTL</title></head>
<body>

<P>Hello <c:out value="${param.name}"/>?

</body>
</html>