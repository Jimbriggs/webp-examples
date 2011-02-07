<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.allocations"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">   
    
    <h4>Projects Supervised</h4>
    
    <table cellpadding="5" cellspacing="2" border="0" width="100%">  
    
    <tr>
        <th valign="top" width="20%" class="tableHead">Student Name</th>
        <th valign="top" width="20%" class="tableHead">Project Title</th>
        <th valign="top" width="20%" class="tableHead">Cohort</th>
        <th valign="top" width="20%" class="tableHead">Unit</th>
        <th valign="top" width="20%" class="tableHead" colspan="2">Status</th> 
    </tr>
       
    <c:forEach items="${allocations}" var="allocation">   
     
        <c:if test="${allocation.markers.Supervisor.ID==userbean.personID}">   
        
        <c:set var="super" value="true" scope="page" />
         
        <tr> 
            <td valign="top" width="20%" class="table">${allocation.studentTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.title}</td>
            <td valign="top" width="20%" class="table">${allocation.cohortTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.unitTxt}</td>                
            <td valign="top" width="20%" class="table">${allocation.statusDesc}</td>
            <td valign="top" width="20%" class="table"><html:link action="/assess/viewProject" paramName="allocation" paramProperty="projectID" paramId="PROJECT"><img src="../../images/view.gif" border="0" alt="View Project"/></html:link></td>   
        </tr>
        
        </c:if>

        </c:forEach>     
  
        <c:if test="${super!='true'}">
        <tr>    
            <td colspan="6" class="table">None</td>
        </tr>
        </c:if>
    
    </table>
    
    <h4>Projects Moderated</h4>
    
    <table cellpadding="5" cellspacing="2" border="0" width="1024">  
    
    <tr>
        <th valign="top" width="20%" class="tableHead">Student Name</th>
        <th valign="top" width="20%" class="tableHead">Project Title</th>
        <th valign="top" width="20%" class="tableHead">Cohort</th>
        <th valign="top" width="20%" class="tableHead">Unit</th>
        <th valign="top" width="40%" class="tableHead" colspan="2">Status</th> 
    </tr>
    
    <c:forEach items="${allocations}" var="allocation">   
     
        <c:if test="${allocation.markers.Moderator.ID==userbean.personID}">   
        
        <c:set var="moder" value="true" scope="page" />
         
        <tr> 
            <td valign="top" width="20%" class="table">${allocation.studentTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.title}</td>
            <td valign="top" width="20%" class="table">${allocation.cohortTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.unitTxt}</td>                
            <td valign="top" width="20%" class="table">${allocation.statusDesc}</td>
            <td valign="top" width="20%" class="table"><html:link action="/assess/viewProject" paramName="allocation" paramProperty="projectID" paramId="PROJECT"><img src="../../images/view.gif" border="0"/></html:link></td>   
        </tr>
        
        </c:if>

        </c:forEach>    
   
        <c:if test="${moder!='true'}">
        <tr>    
            <td colspan="6" class="table">None</td>
        </tr>
        </c:if>
    
    </table>
    
    <h4>Other Marking Allocations</h4>
    
    <table cellpadding="5" cellspacing="2" border="0" width="1024">  
    
    <tr>
        <th valign="top" width="20%" class="tableHead">Student Name</th>
        <th valign="top" width="20%" class="tableHead">Project Title</th>
        <th valign="top" width="20%" class="tableHead">Cohort</th>
        <th valign="top" width="20%" class="tableHead">Unit</th>
        <th valign="top" width="40%" class="tableHead" colspan="2">Status</th>         
    </tr>
    
    <c:forEach items="${allocations}" var="allocation">   
     
        <c:if test="${(allocation.markers.Moderator.ID!=userbean.personID) && (allocation.markers.Supervisor.ID!=userbean.personID)}">   
        
        <c:set var="other" value="true" scope="page" />
         
        <tr> 
            <td valign="top" width="20%" class="table">${allocation.studentTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.title}</td>
            <td valign="top" width="20%" class="table">${allocation.cohortTxt}</td>
            <td valign="top" width="20%" class="table">${allocation.unitTxt}</td>                
            <td valign="top" width="20%" class="table">${allocation.statusDesc}</td>
            <td valign="top" width="20%" class="table"><html:link action="/assess/viewProject" paramName="allocation" paramProperty="projectID" paramId="PROJECT"><img src="../../images/view.gif" border="0"/></html:link></td>   
        </tr>
        
        </c:if>

        </c:forEach>   
    
        <c:if test="${other!='true'}">
        <tr>    
            <td colspan="6" class="table">None</td>
        </tr>
        </c:if>
    
    </table>
    
    <p><html:link forward="userHome"><< back</html:link></p>

        </tiles:put>

</tiles:insert>
