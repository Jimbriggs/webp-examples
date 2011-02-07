<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

        <tiles:put name="title" type="string">

            <bean:message key="pums.assess.titles.entermark"/>
        
        </tiles:put>

    <tiles:put name="body" type="string">   
    
            <p>Please select the marker to enter marks for</p>

            <html:form action="/assess/enterMarkSubmit" method="post">
            <table cellspacing="2" cellpadding="5" width="1024">
            <tr>
            <th class="tableHead" width="33%" valign="top">Marker:</th>
            <td class="table" width="33%" valign="top">
            
            <c:if test="${project.status=='A'||project.status=='S'||project.status=='M'||project.status=='SM'||project.status=='R1A'}">
                <html:radio name="staffbean" property="ID" value="${project.markers.Supervisor.ID}"/>&nbsp;${project.markers.Supervisor.name}<br/>
                <html:radio name="staffbean" property="ID" value="${project.markers.Moderator.ID}"/>&nbsp;${project.markers.Moderator.name}<br/>
            </c:if>
            
            <c:if test="${project.status=='R2B'||project.status=='R2C'}">
                <c:if test="${project.markers.Third != ''}">
                    <html:radio name="staffbean" property="ID" value="${project.markers.Third.ID}"/>&nbsp;${project.markers.Third.name}<br/>
                </c:if>                        
            </c:if>
            
            <c:if test="${project.status=='R3B'||project.status=='R3C'}">
                 <c:if test="${project.markers.Examiner != ''}">
                    <html:radio name="staffbean" property="ID" value="${project.markers.Examiner.ID}"/>&nbsp;${project.markers.Examiner.name}<br/>
                </c:if>                        
            </c:if>
            
            </td>
            <td class="table" width="33%" valign="top"><html:errors property="ID"/></td>
            </tr>
            </table>
            <br/>

            <html:submit title="Enter Marks" value="Enter Marks"/>

            </html:form>    
            
            <p><html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link></p>

    </tiles:put>

</tiles:insert>
