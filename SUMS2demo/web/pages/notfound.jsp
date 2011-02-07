<html><!-- InstanceBegin template="/Templates/FBTemplate.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="title" -->
<title>Viewpoint error</title>
<!-- InstanceEndEditable -->

<link href="../tiles/feedbackstyle.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">
<!--
-->
</style></head>
<body>
<table width="100%" class="title">
  <tr><td>
      <h1>Viewpoint</h1>
  </td>
</tr></table>
<!-- InstanceBeginEditable name="body" -->
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<h2>Problems in accessing Viewpoint</h2>
<p><html:errors/></p>
<!-- #BeginLibraryItem "/Library/access_problems.lbi" --><h1>Access problems? </h1>
<p>The URL that you received in the email message that you were sent is of the form:</p>
<p align="center">http://www.viewpoint.port.ac.uk/myviewpoint.do?anonymiser=NNNNNNNNNN</p>
<p>You need to make sure that the URL in your browser matches the one that you received in the email. Your anonymiser code is the NNNNNNNNNN part of your code. Make sure that the anonymiser part of the URL in your browser has 10 characters (letters and numbers). If it appears shorter, it may be that your email program has split it over two lines.</p>
<html:form method="GET" action="/myviewpoint.do">
  Type (or paste) your 10-character anonymiser code here
    <input type="text" name="anonymiser" size="10" maxlength="10">
  and click on Go.
  <input type="submit" name="Submit" value="Go">
</html:form>
<!-- #EndLibraryItem --><!-- InstanceEndEditable -->
<div class="footer">
  <p>&copy; University of Portsmouth. Viewmaster: <a href='mailto:viewpoint@port.ac.uk'>viewpoint@port.ac.uk</a></p>
</div>
</body>
<!-- InstanceEnd --></html>