<%-- 
    Document   : index
    Created on : 11-Nov-2010, 15:23:52
    Author     : briggsj
--%>

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
        <p>Add to and list people in the database</p>
        <form name="New person" action="addNewPersonServlet">
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
                        <td><input type="submit" value="Add" />
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
