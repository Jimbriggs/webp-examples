<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

        <tiles:put name="title" type="string">

            <bean:message key="pums.assess.titles.supervisor"/>
        
        </tiles:put>

    <tiles:put name="body" type="string">   
    
            <p>Please select a member of staff to assign as supervisor</p>
            
            <html:form action="/assess/supervisorAssign" method="post">
            <table width="1024" cellspacing="2" cellpadding="5">
            <tr>
            <th width="33%" class="tableHead">Supervisor:</th>
            <td width="33%" class="table">
            <html:select name="staffbean" property="ID">
            <html:option value="">--Select--</html:option>
            <html:options collection="staff" property="ID" labelProperty="name"/>
            </html:select>
            </td>
            <td width="33%" class="table"><html:errors property="ID"/></td>
            </tr>
            </table>
            <br/>

            <html:submit title="Assign" value="Assign"/>

            </html:form>   
     
            <p><html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link></p>

    </tiles:put>

</tiles:insert>
