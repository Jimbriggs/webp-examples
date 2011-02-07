<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.studentmarks"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">  
    
    <h4>Your Project Marks</h4>
    
    <table cellspacing="2" cellpadding="5" width="1024">
        <tr>
            <th class="tableHead">Unit</th>
            <th class="tableHead">Cohort</th>
            <th class="tableHead">Project Title</th>
            <th class="tableHead">Supervisor</th>
            <th class="tableHead">&nbsp</th>
        </tr>
        <logic:empty name="projects">
        <tr>
            <td class="table" colspan="5">
                You currently have no marks to view
            </td>
        </tr>        
        </logic:empty>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td class="table" >${project.unitTxt}</td>
                <td class="table" >${project.cohortTxt}</td>
                <td class="table" >${project.title}</td>
                <td class="table" >${project.markers.Supervisor.name}</td>  
                <td class="table"><html:link action="/assess/viewStudentMark" paramName="project" paramProperty="projectID" paramId="PROJECT"><img src="../../images/view.gif" border="0" alt="View Mark"/></html:link></td>   
            </tr>            
        </c:forEach>
    </table>

    </tiles:put>

</tiles:insert>
