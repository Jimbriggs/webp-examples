<%-- 
    Document   : index
    Created on : 11-Nov-2010, 15:23:52
    Author     : briggsj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person application</title>
    </head>
    <body>
        <h1>Person application</h1>
        <p>This application adds the ability to select an address for a person</p>
        <p>Add to and list people in the database</p>
        <form name="NewPerson" action="addNewPersonServlet">
            <table border="1" cellpadding="3" cellspacing="0">
                <tbody>
                    <tr>
                        <td>First name</td>
                        <td><input type="text" name="firstname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last name</td>
                        <td><input type="text" name="lastname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><select name="addressId">
                                <c:forEach var="a" items="${alist}">
                                    <option value="${a.id}" >${a}</option>
                                </c:forEach>

                                <option value="0">No address</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add" />
                    </tr>
                </tbody>
            </table>
        </form>
        <P>Add new address
        <form name="NewAddress" action="addNewAddressServlet">
            <table border="1" cellpadding="3">
                <thead>

                </thead>
                <tbody>
                    <tr>
                        <td>First line</td>
                        <td><input type="text" name="firstline" value="" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Second line</td>
                        <td><input type="text" name="secondline" value="" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Postcode</td>
                        <td><input type="text" name="postcode" value="" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add" />
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
