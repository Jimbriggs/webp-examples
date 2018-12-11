<%@ page isErrorPage="true" %>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><!-- InstanceBegin template="/Templates/FBTemplate.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="title" -->
<title>
SUMS error
</title>
<!-- InstanceEndEditable -->

<link href="../tiles/feedbackstyle.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">
<!--
-->
</style></head>
<body>
<table width="100%" class="title">
  <tr><td>
      <h1>SUMS</h1>
  </td>
</tr></table>
<!-- InstanceBeginEditable name="body" -->
<h1>Unforeseen SUMS error</h1>
<p>Apologies, but an unforeseen error has occurred in SUMS.</p>
<p>Hopefully, by <html:link forward="welcome">starting again</html:link> you will be able to continue.</p>
<p>However, if this error recurs, please copy and paste the following text into an email to <a href="mailto:Jim.Briggs@port.ac.uk">Jim.Briggs@port.ac.uk</a>:</p>
<!-- #BeginLibraryItem "/Library/error_details.lbi" -->
<table border='1' cellpadding='10' cellspacing='0'>
  <tr>
    <td>
      <p>SUMS error details:
      <ul>
        <jsp:useBean id="now" class="java.util.Date" />

        
        <li>The current date and time: ${now}</li>
        <li>The URL you were accessing: ${pageContext.request.requestURL}</li>
        <li>The error message: ${exception}</li>

      </ul>
</table>
<!-- #EndLibraryItem -->
<p>This will help us track down and fix the problem.</p>
<p>Thank you. </p>
<!-- InstanceEndEditable -->
<div class="footer">
  <p>&copy; University of Portsmouth. SUMSmaster: <a href='mailto:Jim.Briggs@port.ac.uk'>Jim.Briggs@port.ac.uk</a></p>
</div>
</body>
<!-- InstanceEnd --></html>
