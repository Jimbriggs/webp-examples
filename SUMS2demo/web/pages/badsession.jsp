<html><!-- InstanceBegin template="/Templates/FBTemplate.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="title" -->
<title>
Session timed out
</title>
<!-- InstanceEndEditable -->

<link href="../tiles/feedbackstyle.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<table width="100%" class="title">
  <tr><td>
      <h1>SUMS</h1>
  </td>
</tr></table>
<!-- InstanceBeginEditable name="body" --> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<h1>SUMS error</h1>
<p>Sorry, but your SUMS session has been idle for more than ${sessionMaxInactive} minutes and had to be closed.</p>
<p>However, you can <html:link forward="welcome">start again</html:link> 
if you wish. Marks you entered will NOT have been recorded.</p>
<!-- InstanceEndEditable -->
<div class="footer">
  <p>&copy; University of Portsmouth. Sumsmaster: <a href='mailto:Jim.Briggs@port.ac.uk'>Jim.Briggs@port.ac.uk</a></p>
</div>
</body>
<!-- InstanceEnd --></html>