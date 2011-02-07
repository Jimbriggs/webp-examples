<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

   <bean:message key="pums.assess.titles.projects"/>
            
    </tiles:put>

    <tiles:put name="body" type="string">   
   
 <%--   <html:form action="/assess/showProjects">
    <table>
    <tr><th>Filters
    <tr><td>Unit:<td><html:select property="units"><html:options collection="units" labelProperty="label" property="value"/></html:select>
    <tr><td><html:submit/>
    </table>
    </html:form>
    --%>
   <table width="100%" border="0" cellpadding="5" cellspacing="2">  
    
       <tr>
           <th valign="top" class="tableHead">Student Name</th>
           <th valign="top" class="tableHead">Project Title</th>
           <th valign="top" class="tableHead">Cohort</th>
           <th valign="top" class="tableHead">Unit</th>
           <th valign="top" class="tableHead" colspan="2">Status</th> 
       </tr>
       
       <c:forEach items="${allocations}" var="project">   
     
        
   <c:set var="super" value="true" scope="page" />
         
   <tr> 
       <td valign="top" class="table">${project.studentTxt}</td>
       <td valign="top" class="table">${project.title}</td>
       <td valign="top" class="table">${project.cohortTxt}</td>
       <td valign="top" class="table">${project.unitTxt}</td>                
       <td valign="top" class="table">${project.statusDesc}<BR>
       Sup: ${project.supervisorName}
       <c:if test="${project.status eq 'M' || project.status eq 'A'}">
       UNMARKED
       </c:if><BR>
       Mod: ${project.moderatorName}
       <c:if test="${project.status eq 'S' || project.status eq 'A'}">
       UNMARKED
       </c:if></td>
       <td valign="top" class="table">
      <html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><img src="../../images/view.gif" border="0" alt="View Project"/></html:link></td>   
   </tr>
                      
              
       </c:forEach>     
  
       <c:if test="${super!='true'}">
           <tr>    
               <td colspan="6" class="table">None</td>
           </tr>
       </c:if>
    
   </table>
    <p>
    ${fn:length(allocations)} projects
   <p><html:link forward="userHome"><< back</html:link></p>
        
    </tiles:put>

</tiles:insert>
