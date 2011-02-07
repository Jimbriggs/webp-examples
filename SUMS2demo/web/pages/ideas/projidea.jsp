<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html:html>
    <head><title>Edit idea</title>
        <html:base/>
    </head>
    <body>
        <h1>Edit idea</h1>

        <logic:messagesPresent>
            <%--bean:message key="pums.errors.header"/--%>
            <ul>
                <html:messages id="message">
                    <li><bean:write name="message"></bean:write>
                    </li>
                </html:messages>
            </ul><hr>
        </logic:messagesPresent>

        <html:form action="/Projidea"> <%-- onsubmit="return validateIdeaForm(this)"--%>
            <table border="0" cellpadding="0" cellspacing="2">
                <tr valign="top"> 
                    <td width="50%"> 
                    <h2>About you and your organisation...</h2></td>
                    <td width="50%"> 
                    <h2>About the project idea...</h2></td>
                </tr>
                <tr valign="top"> 
                <td width="50%"> 
                <table width="100%" border="1" cellspacing="0" cellpadding="1">

                    <tr valign="top"> 
                        <th align="left">Organisation name:</th>
                        <td><html:errors property="orgname"/>
                            <html:text property="orgname"  size="50" maxlength="50"/>
                            <BR>Reference number: 
                            <html:errors property="orgid"/>
                            <html:text property='orgid'/>
                        </td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Postal address:</th>
                        <td><html:errors property="orgaddr"/>
                            <html:textarea property="orgaddr" cols="50"
                            rows="5" /> <br>
                            Postcode 
                            <html:errors property="orgpostcode"/>
                            <html:text property="orgpostcode" size="50" maxlength="50"/> 
                        </td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Outline of what your organisation does:</th>
                        <td>
                        <html:errors property="orgdoes"/>
                        <html:textarea property="orgdoes"  cols="50"
                        rows="2" /></td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Contact name:</th>
                        <td><html:errors property="orgcontact"/>
                        <html:text property="orgcontact"  size="50"
                        maxlength="50"/></td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Telephone number:</th>
                        <td>
                        <html:errors property="orgtel"/>
                        <html:text property="orgtel"  size="20" maxlength="20"/> </td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Email address:</th>
                        <td>
                        <html:errors property="orgemail"/>
                        <html:text property="orgemail"  size="25"
                        maxlength="50"/> </td>
                    </tr>

                </table></td>
                <td width="50%">
                <table width="100%" border="1" cellspacing="0" cellpadding="1">
                    <tr valign="top"> 
                        <th align="left">Project title:</th>
                        <td>
                            <html:errors property="projtitle"/>
                            <html:text property="projtitle" size="50" maxlength="50"/>
                            <BR>Reference number: 
                            <html:text property='projid' />
                        </td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Aims and objectives:</th>
                        <td>
                        <html:errors property="projaims"/>
                        <html:textarea property="projaims"  cols="50"
                        rows="6" /></td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Academic question to be answered (blank if unknown):</th>
                        <td>
                        <html:errors property="projquest"/>
                        <html:textarea property="projquest"  cols="50"
                        rows="2" /></td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Anticipated deliverables:</th>
                        <td>
                        <html:errors property="projdeliver"/>
                        <html:textarea property="projdeliver"  cols="50"
                        rows="2" /></td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Student for whom project has been devised (blank if 
                        unknown):</th>
                        <td>
                        <html:errors property="projstudent"/>
                        <html:text property="projstudent"  size="50"
                        maxlength="50"/></td>
                    </tr>
                    <tr valign="top"> 
                    <th align="left">Status <font size="-2">(<font size="-1">A</font>pproved/<strong><font size="-1">P</font></strong>rovisional/<strong><font size="-1">W</font></strong>ithdrawn)</font>:</th>
                    <td>
                    <html:errors property="projstatus"/>
                    <html:text property="projstatus"  size="1"
                    maxlength="1"/> </td>
                    </tr>
                    <tr valign="top"> 
                        <th align="left">Date submitted/last updated:</th>
                        <td>
                        <html:errors property="projdate"/>
                        <html:text property="projdate" size="12"/></td>
                    </tr>
                </table></td>
                </tr>
                <tr valign="top">
                    <td width="50%" align="left"><font size="-1">Note that the contents of this 
                    form will be held in a database and made available to students via the 
                    web. We cannot guarantee either that a student will choose to do the project, 
                    or, if one does, that they will achieve the desired results.</font></td>
                    <td width="50%">&nbsp;</td>
                </tr>
                <tr valign="top"> 
                    <td width="50%" align="right"> 
                        <html:submit /> 
                    </td>
                    <td width="50%">
                    <html:reset/></td>
                </tr>
            </table>
        </html:form>
        <html:javascript formName="ideaForm"/>
    </body>
</html:html>
