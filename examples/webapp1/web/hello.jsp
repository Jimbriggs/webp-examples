<%@page contentType="text/html"%>
<html>
<head><title>Hello JSP Page</title></head>
<body>

<P>Hello <%= request.getParameter("name") %>

</body>
</html>