<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
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
    <TITLE>Project marking step 2</TITLE>
    <!-- InstanceEndEditable -->
    <!-- InstanceBeginEditable name="head" -->
    <html:base/>
    <!-- InstanceEndEditable -->

    
    <link href="../../css/styles.css" rel="stylesheet" type="text/css">
    <link href="../../popup.js">
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
    <SCRIPT language="JAVASCRIPT" type="TEXT/JAVASCRIPT">		

    stdBrowser = (document.getElementById) ? true : false

    function popUp(evt, currElem) {
    popUpWin = (stdBrowser) ? document.getElementById(currElem).style : eval("document." + currElem)
    if (document.all) {
    popUpWin.pixelTop = parseInt(evt.y)+2
    popUpWin.pixelLeft = Math.max(2,parseInt(evt.x)-125)
    }
    else {
    if (stdBrowser) {
    popUpWin.top = parseInt(evt.pageY)+2 + "px"
    popUpWin.left = Math.max(2,parseInt(evt.pageX)-125) + "px"
    }
    else {
    popUpWin.top = parseInt(evt.pageY)+2
    popUpWin.left = Math.max(2,parseInt(evt.pageX)-125)
    }
    }
    popUpWin.visibility = "visible"
    } 

    function popDown(currElem) {
    popUpWin = (stdBrowser) ? document.getElementById(currElem).style : eval("document." + currElem)
    popUpWin.visibility = "hidden"
    }

    </SCRIPT>
    
    <h1>Project marking</h1>
    <h3>Step 2 of 4: Enter category marks and comments</h3>
    <!-- InstanceEndEditable --><!-- InstanceBeginEditable name="body" -->
    
    <html:form action="/assess/calcMark" enctype="application/x-www-form-urlencoded" method="post">
        <p>
            <html:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
        </p>
        <p><html:link page="/help/assess/step2.jsp" target="_blank">Help</html:link>
        </p>
        <nested:nest property="student">
            <table border="1" cellspacing="0" cellpadding="5" width="100%">
                <tr>
                    <th align="left" valign="top">Name of student /  HEMIS number</th>
                    <td valign="top"><nested:text property="studentName"/> <html:errors property="studentName"/>
                    <th align="left" valign="top">Name of supervisor                 
                    <td valign="top">
                    <nested:text property="supervisor"/>
                    <nested:errors property="supervisor"/>                
                </tr>
                <tr>
                    <th align="left" valign="top">Brief project title </th>
                    <td valign="top">
                    <nested:text property="projectTitle"/> 
                    <nested:errors property="projectTitle"/>           
                    <th align="left" valign="top">Marker's name<td valign="top">
                    <nested:text property="marker"/>
                    <nested:errors property="marker"/>
                </tr>
                <tr>
                    <th align="left" valign="top">Project unit </th>
                    <td valign="top"><nested:hidden property="unit"/>${markForm.student.unit}
                    <nested:errors property="unit"/>
                    <th align="left" valign="top">Marker's status               
                    <td valign="top">
                    <table width="100%"  border="1" cellspacing="0" cellpadding="1">
                        <tr align="center" valign="top">
                            <td width="25%">Sup
                                <nested:radio property="status" value="Supervisor"/>
                            </td>
                            <td width="25%">Mod
                                <nested:radio property="status" value="Moderator"/>
                            </td>
                            <td width="25%">3rd
                                <nested:radio property="status" value="3rd marker"/>
                            </td>
                            <td width="25%">Rem
                                <nested:radio property="status" value="Re-marker"/>
                            </td>
                        </tr>
                    </table>
                </tr>
                <tr>
                    <th align="left" valign="top">Overall mark </th>
                    <td valign="top">
                    <html:text property="totalMark" readonly="true" size="3" value="???"/>
                    <th align="left" valign="top">Prize for consideration </th>
                    <td valign="top">[Prize nomination to go here]</td>
                </tr>           
                
            </table>
        </nested:nest>
        <p>Assess the project with reference to the procedures set out in <a href="http://www.pums.cam.port.ac.uk/projects/docs/projmark.htm" target="_blank">&quot;How to mark a project&quot;</a>.</p>
        <table border='1' cellpadding='3' cellspacing='0' width='99%'>
            <tr valign="top">
                <th align=left>Category
                <th>Weight</th>
                <logic:iterate id="range" name="markForm" property="grades"><th>${range-5}-${range+4}</th></logic:iterate>
            <th>Category mark</tr>      
            <logic:iterate id="cat" name="markForm" property="catNames">
                <nested:nest property="categories(${cat})">
                    <tr valign="top">
                        <!--th align=left onmouseover="popUp(event,'${markForm.categories[cat].shortname}')" onmouseout="popDown('${markForm.categories[cat].shortname}')">${markForm.categories[cat].longname}
                        -->
                        <th align=left name="_th${markForm.categories[cat].shortname}" onmouseover="CommentShow('_th${markForm.categories[cat].shortname}', '${markForm.categories[cat].shortname}')" onmouseout="CommentHide('${markForm.categories[cat].shortname}')">
                            ${markForm.categories[cat].longname}
                            <SPAN class=popUpStyle id="${markForm.categories[cat].shortname}">
                                <strong>${markForm.categories[cat].longname}:</strong> ${markForm.categories[cat].description}
                            </SPAN>
                        </th>
                        <td align=center>${markForm.categories[cat].weight}</td>
                        <nested:hidden property="weight"/>
                        <logic:iterate id="range" name="markForm" property="gradeStrings">
                            <td align=center>
                            <logic:present name="markForm" property="categories(${cat})">
                                <nested:multibox property="marks" value="${range}"/>
                            </logic:present>
                        </logic:iterate>
                        <td align=left>
                        <c:if test="${markForm.categories[cat].mark > 0}">
                            <bean:write name="markForm" property="categories(${cat}).mark"/>
                        </c:if>
                        <td><html:errors property="${cat}"/>&nbsp;</td>
                    </tr>
                </nested:nest>
            </logic:iterate>
            <tr valign="top">
                <th colspan='2'>&nbsp;</th>
                <logic:iterate id="range" name="markForm" property="grades"><th>${range-5}-${range+4}</th></logic:iterate>
                <td>&nbsp;
            </tr>
            <tr valign="top">
            <th colspan=2 align=left>Adjustment
            (You probably want to come back to fill this in after you've gone to the next page to see the computed mark.)            
            <td colspan=10 align=center>
            <table border=0>
                <tr>
                <c:forEach var="adj" items="-5,-4,-3,-2,-1,0,1,2,3,4,5">
                    <td align=center>${adj}
                </c:forEach>
                <tr>
                <c:forEach var="adj" items="-5,-4,-3,-2,-1,0,1,2,3,4,5">
                    <td align=center><html:radio name="markForm" property="adjustment" value="${adj}"/>
                </c:forEach>
            </table>
            
            <tr>
            <th colspan='2' align=left valign=top>CALCULATED MARK             
            <td colspan='11'><html:text property="totalMark" readonly="true" size="3" value="???"/>
            (Currently you need to submit the form to see the calculated value) 
            <tr>
            <th colspan='2' align=left valign=top>General comments justifying the mark.
            In particular, stress areas of strength and weakness that do not necessarily match with the categories above.
            <span class="smaller">These may be notified to the student.</span>
            (min 250 characters)
            <td colspan='11'><html:textarea property="comments" cols="80" rows="10"/>
            <tr>
            <th colspan='2' align=left valign=top>Anything that needs to be brought to the attention of the examiners  (please give reasons).
            <span class="smaller">These will not normally be notified to the student, but may be revealed as a result of disciplinary or other proceedings.</span>
            <td colspan='11'><html:textarea property="examiners" cols="80" rows="5"/>
            <tr>
            <th align=left colspan=2>Tick here if PLAGIARISM or another unfair act is suspected (give details above)
            <td colspan='11'><html:checkbox property="unfair"/>
            <tr valign="top">
            <th colspan=2 align=left>Click  to calculate mark. (You will have the opportunity to return here and revise it.)
            <td colspan=11>
            <html:submit value="Calculate mark"/>
        </table>
        <!--html:javascript/-->
    </html:form></p>
    <!-- InstanceEndEditable -->
    <p class="smallprint">V${APPINFO["app.version"]}; C${APPINFO["db.key"]}; MS${APPINFO["mail.session"]}; MT${APPINFO["mail.test"]}</p>
</BODY>
<!-- InstanceEnd --></HTML>
