<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><!-- InstanceBegin template="/Templates/SUMS basic JSP.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<HEAD>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<META http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- InstanceBeginEditable name="doctitle" -->
    <TITLE>Calculated project mark</TITLE>
    <!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
    <html:base/>
    <!-- InstanceEndEditable -->


<link href="../../css/styles.css" rel="stylesheet" type="text/css">
</HEAD>

<BODY>
<!-- #BeginLibraryItem "/Library/SUMS header.lbi" -->
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
  <TR bgcolor="#CCFFFF"> 
    <TD align="left" valign="top" bgcolor="#660066"> <h2 class="headlineLeft">University of Portsmouth</h2></TD>
    <TD bgcolor="#660066" align="right"><P><FONT color="#FFFF99" face="Verdana, Arial, Helvetica, sans-serif" class="headlineRight">SUMS</FONT></P>
    <P>      <SPAN class="subheadRight">CAM Student &amp; Unit Management System v5.0</SPAN></P>
    </TD>
  </TR>
  <TR > 
    <TD colspan="2" align="right"> <H5><A href="/sums2/index.jsp">
        
        SUMS home page</A></H5>
    </TD></TR>
</TABLE>
<!-- InstanceBeginEditable name="heading" -->
    <h1>Project marking</h1>
    <h3>Step 3 of 4: Confirm marks and submit </h3>
    <!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
    <html:form action="/assess/sendmail">
        <p>
          <html:link page="/help/assess/step3.jsp" target="_blank">Help</html:link>
        </p>
        <p>If any of the following details are incorrect (or the mark needs adjusting), press BACK and amend the previous form. </p>
        <table border="1" cellpadding="3" cellspacing="0">
            <tr valign="top">
                <th align=left>Name of student 
                <td>
                    <span class='emphasis'>${markForm.student.studentName}&nbsp;</span>
                </td>
                <th align="left">Name of supervisor</th>
                <td>${markForm.student.supervisor}</td>
            </tr>
            <tr valign="top">
                <th align=left>Project title 
                <td>${markForm.student.projectTitle}</td>
                <th align="left">Marker's name</th>
                <td><span class='emphasis'>${markForm.student.marker}</span></td>
            </tr>
            <tr valign="top">
                <th align=left>Project unit       
                <td>${markForm.student.unit}&nbsp;</td>
                <th align="left">Marker's status </th>
                <td>${markForm.student.status}</td>
            </tr>
            <tr valign="top">
              <th align=left>Overall mark             
              <td><span class="emphasis">${markForm.totalMark}</span>
                <input type="button" value="Back" onclick="javascript:history.go(-1)"/>
              </td>
              <th align="left">Prize for consideration </th>
              <td>[Prize nomination to go here]</td>
            </tr>
            <logic:iterate id="cat" name="markForm" property="catNames"> </logic:iterate>
        </table>
        <h3>Breakdown of marks        </h3>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr valign="top">
                <th align=left>Category        
                <th>Weight</th>
                <th>Mark</th>
                <th align="center">Boxes ticked </th>
            </tr>
            <logic:iterate id="cat" name="markForm" property="catNames">
            <tr valign="top">
                <th align=left>${cat}
                <td align=center>
                    <bean:write name="markForm" property="categories(${cat}).weight"/>
                </td>
                <td align=right>
                    <bean:write name="markForm" property="categories(${cat}).mark"/>
                </td>
                <td align="center">
                    <logic:present name="markForm" property="categories(${cat})}">
                        <logic:iterate id="mk" name="markForm" property="categories(${cat}).marks">${mk}&nbsp; </logic:iterate>
                    </logic:present>
                </td>
            </tr>
            </logic:iterate>
            <tr valign="top">
            <th align=left colspan='2'>Adjustment
            <td align=right>${markForm.adjustment}
            <td align=center>${markForm.adjustment}
            <tr valign="top">
      <th align=left colspan='2'>            WEIGHTED MARK
      <td align=right>              ${markForm.totalMark}
      </td>
            <td align=center> 
            <c:if test="${markForm.unfair}"><span class='alert'>Plagiarism / Unfair act</span></c:if>&nbsp;</td>
          </tr>
        </table>
        <h4>General comments. <span class="smaller">These may be notified to the student. </span></h4>
        <html:textarea property="comments" name="markForm" readonly="true"  cols="80" rows="20"/>
        <h4>Anything that needs to be brought to the attention of the examiners (please give reasons). <span class="smaller">These will not normally be notified to the student, but may be revealed as a result of disciplinary or other proceedings.</span> </h4>
        <p>
        <html:textarea property="examiners" name="markForm" readonly="true"  cols="80" rows="10"/>
        </p>
        <p>${markForm.student.date}</p>
        <p>Please 
          <input type="button" value="print" onclick="javascript:window.print()"> 
        or save a copy of this for your records.</p>
        <p>
          <html:submit value="Submit confirmed mark"/>
		  <input type="button" value="Back" onclick="javascript:history.go(-1)"/>
    </html:form>
    <!-- InstanceEndEditable -->
<p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
