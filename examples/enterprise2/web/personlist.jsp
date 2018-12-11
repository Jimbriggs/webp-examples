<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : personlist
    Created on : 11-Nov-2010, 16:16:30
    Author     : briggsj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person list</title>
    </head>
    <body>
        <h1>List of people in the database</h1>
        <c:forEach var="msg" items="${messages}">
            <p>${msg}</p>
        </c:forEach>
        <h2>People</h2>
        <table border="1" cellpadding="3" cellspacing="0">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Last Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${plist}">
                    <tr>
                        <td>${p.firstname}</td>
                        <td>${p.lastname}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Addresses</h2>
        <table border="1" cellpadding="3" cellspacing="0">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First line</th>
                    <th>Second line</th>
                    <th>City</th>
                    <th>Postcode</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="a" items="${alist}">
                    <tr>
                        <td>${a.id}
                        <td>${a.firstline}
                        <td>${a.secondline}
                        <td>${a.city}
                        <td>${a.postcode}
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
