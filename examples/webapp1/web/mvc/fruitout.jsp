<%@page contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Fruit example output page</title>
    </head>
    <body>

        <p>The banana is <c:out value="${banana.colour}"/> and <c:out value="${banana.condition}"/>

        <p>The fruit you input is a ${inputFruit.type} that is <c:out value="${inputFruit.colour}"/> and <c:out value="${inputFruit.condition}"/>

        <P><table border="1">
            <TR>
                <TH>
                    Type of fruit
                <TH>
                    Colour
                <TH>
                    Condition
            </TR>
            <c:forEach var="aFruit" items="${allFruit}">
                <TR>
                    <TD>
                        ${aFruit.type}
                    <TD>
                        ${aFruit.colour}
                    <TD>
                        <%-- shows alternative way of outputing value --%>
                        <c:out value="${aFruit.condition}"/>
                </TR>
            </c:forEach>
        </table>
    </body>
</html>
