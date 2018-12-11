<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">

<title>SUMS - <tiles:getAsString name="title"/></title>

    <html:base/>
    <link href="../../css/styles.css" rel="stylesheet" type="text/css">
    
</head>

<body>

<tiles:insert page="header.jsp"/>

<h3><tiles:getAsString name="title"/></h3>

<tiles:insert attribute="body" />
<tiles:insert page="footer.jsp"/>

</body>
</html>
