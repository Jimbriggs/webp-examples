<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.projectadded"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">   
    
    <table cellspacing="2" cellpadding="5" width="1024">
    <tr>
    <th class="tableHead">Student:</th>
    <td class="table">${projectbean.studentTxt}</td>
    <tr>
    <th class="tableHead">Unit:</th>
    <td class="table">${projectbean.unitTxt}</td>
    </tr>
    <tr>
    <th class="tableHead">Cohort:</th>
    <td class="table">${projectbean.cohortTxt}</td>
    </tr>
    <tr>
    <th class="tableHead">Project Title:</th>
    <td class="table">${projectbean.title}</td>
    </tr>
    <tr>
    <th class="tableHead">Submission Date:</th>
    <td class="table">${projectbean.datesubmitted}</td>
    </tr>
    <tr>
    <th class="tableHead">Late Handin?</th>
    <td class="table">${projectbean.latehandin}</td>
    </tr>
    <tr>
    <th class="tableHead">Supervisor:</th>
    <td class="table">${projectbean.markers.Supervisor.name}</td>
    </tr>
    <tr>
    <th class="tableHead">Moderator:</th>
    <td class="table">${projectbean.markers.Moderator.name}</td>
    </tr>
    </table>
    
    <p><html:link forward="userHome"><< back</html:link></p>
    
    </tiles:put>

</tiles:insert>
