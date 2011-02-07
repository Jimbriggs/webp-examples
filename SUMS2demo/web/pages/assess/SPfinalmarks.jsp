<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

   <table width="100%" border="1" cellpadding="3" cellspacing="0">  
    
       <tr>
           <th valign="top" class="tableHead">Student Name</th>
           <th valign="top" class="tableHead">HEMIS</th>
           <th valign="top" class="tableHead">Project Title</th>
           <th valign="top" class="tableHead">Cohort</th>
           <th valign="top" class="tableHead">Unit</th>
           <th valign="top" class="tableHead">Status</th> 
           <th valign="top" class="tableHead">Mark</th>
           <th valign="top" class="tableHead">Late?</th>
           <th valign="top" class="tableHead">Suspect?</th>
       </tr>
       
       <c:forEach items="${allocations}" var="project">   
     
        
   <c:set var="super" value="true" scope="page" />
         
   <tr> 
       <td valign="top" class="table">${project.student.name}</td>
       <td valign="top" class="table">${project.student.hemis}</td>
       <td valign="top" class="table">${project.title}</td>
       <td valign="top" class="table">${project.cohortTxt}</td>
       <td valign="top" class="table">${project.unit.unitCode}&nbsp;</td>                
       <td valign="top" class="table">${project.statusDesc}</td>
       <td valign="top" class="table">${project.mark}</td>
       <td valign="top" class="table">
           <c:if test="${project.latehandin != 'N'}">
             ${project.latehandin}
           </c:if>&nbsp;
       </td>
       <td valign="top" class="table">
           <c:if test="${project.markermarks.Supervisor.plagiarismSuspect}">
               S
           </c:if>
           <c:if test="${project.markermarks.Moderator.plagiarismSuspect}">
               M
           </c:if>&nbsp;
       </td>
       
   </tr>
                                                                       
                                                               
       </c:forEach>     
    
   </table>
    <p>
    ${fn:length(allocations)} projects

