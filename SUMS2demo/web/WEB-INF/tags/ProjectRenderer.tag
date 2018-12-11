package WEB-INF.tags;

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
           <table cellpadding="5" cellspacing="2" width="100%" border="0"> 
            <tr>
                <th width="24%" class="tableHead">Name of Student</th>
                <td width="24%" class="table">${project.studentTxt}</td>
                <td width="4%">&nbsp;</td>
                <th width="24%" class="tableHead">Supervisor</th>
                <td width="24%" class="table">${project.markers.Supervisor.name}</td>           
            </tr>
            <tr>
                <th width="24%" class="tableHead">Project title</th>
                <td width="24%" class="table">${project.title}</td>
                <td width="4%">&nbsp;</td>
                <th width="24%" class="tableHead">Project unit</th>
                <td width="24%" class="table">${project.unitTxt}</td>           
            </tr>    
            <tr>
                <th width="24%" class="tableHead">Calculated mark</th>
                <td width="24%" class="table">
                <c:if test="${markform.projectMark!=-1}">
                    ${markform.projectMark}%
                </c:if>
                <c:if test="${markform.projectMark==-1}">
                    Awaiting calculation
                </c:if>
                </td>
                <td width="4%">&nbsp;</td>
                <th width="24%" class="tableHead">Cohort</th>
                <td width="24%" class="table">${project.cohortTxt}</td>           
            </tr>  
            <tr>
                <th width="24%" class="tableHead">Marker</th>
                <td width="24%" class="table">${markform.marker.name}</td>
                <td width="4%">&nbsp;</td>
                <th width="24%" class="tableHead">Capacity</th>
                <td width="24%" class="table">${markform.markerCapacityDesc} Marker</td>                 
            </tr>   
        </table>
