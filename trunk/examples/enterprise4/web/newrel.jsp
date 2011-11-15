<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : newrel
    Created on : 14-Dec-2010, 15:01:48
    Author     : briggsj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new relationship</title>
    </head>
    <body>
        <h1>Add new relationship</h1>
        <form name="addNewRelationship" action="addNewRelationshipServlet" method="POST">
            <p>
                Source: 
                <select name="source">
                    <c:forEach var="p" items="${plist}">
                        <option value="${p.id}">${p}</option>
                    </c:forEach>
                </select>
                ${errors.source}
            </p>
            <p>
                Destination: 
                <select name="destination">
                    <c:forEach var="p" items="${plist}">
                        <option value="${p.id}">${p}</option>
                    </c:forEach>
                </select>
                ${errors.destination}
            </p>
            <p>Label:
                <input type="text" name="label" value="" />
                ${errors.label}
            </p>
            <p>
                <input type="submit" value="Add" />
        </form>
    </body>
</html>
