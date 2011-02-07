<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

        <tiles:put name="title" type="string">

            <bean:message key="pums.assess.titles.addproject"/>
        
        </tiles:put>

    <tiles:put name="body" type="string">   
    
            <p>To register a new project for marking please enter the details below:</p>

            <html:form action="/assess/registerProject" method="post">
            <html:errors property="alreadyRegistered"/>
            <table cellspacing="2" cellpadding="5" width="1024">
            <tr>
            <th width="33%" class="tableHead">Student:</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="student">
            <html:option value="">--Select--</html:option>
            <html:options collection="students" property="ID" labelProperty="description"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="student"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Unit:</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="unit">
            <html:option value="">--Select--</html:option>
            <html:options collection="units" property="ID" labelProperty="description"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="unit"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Cohort:</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="cohort">
            <html:option value="">--Select--</html:option>
            <html:options collection="cohorts" property="ID" labelProperty="cohortDesc"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="cohort"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Project Title:</th>
            <td width="33%" class="table"><html:text name="projectbean" property="title"/></td>
            <td width="33%" class="table"><html:errors property="title"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Submission Date:</th>
            <td width="33%" class="table"><html:text name="projectbean" property="datesubmitted"/></td>
            <td width="33%" class="table"><html:errors property="datesubmitted"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Late Handin?</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="latehandin">     
                <html:option value="">--Select--</html:option>
                <html:option value="N">No</html:option>
                <html:option value="Y">Yes</html:option>        
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="latehandin"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Supervisor:</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="supervisor">
            <html:option value="">--Select--</html:option>
            <html:options collection="staff" property="ID" labelProperty="name"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="supervisor"/></td>
            </tr>
            <tr>
            <th width="33%" class="tableHead">Moderator:</th>
            <td width="33%" class="table">
            <html:select name="projectbean" property="moderator">
            <html:option value="">--Select--</html:option>
            <html:options collection="staff" property="ID" labelProperty="name"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="moderator"/></td>
            </tr>
            </table>
            <br/>

            <html:submit title="Register" value="Register"/>

            </html:form>    
            
            <p><html:link forward="userHome"><< back</html:link></p>

    </tiles:put>

</tiles:insert>
