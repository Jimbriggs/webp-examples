<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : rellist
    Created on : 14-Nov-2011, 16:16:30
    Author     : briggsj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relationship list</title>
    </head>
    <body>
        <h1>List of relationships in the database</h1>
        <c:forEach var="msg" items="${messages}">
            <p>${msg}</p>
        </c:forEach>
        <h2>Relationships</h2>
        <table border="1" cellpadding="3" cellspacing="0">
            <thead>
                <tr>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Label</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${rlist}">
                    <tr>
                        <td>${r.source.fullName}</td>
                        <td>${r.destination.fullName}</td>
                        <td>${r.label}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
