<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.audit"/>
    
    </tiles:put>

    <tiles:put name="body" type="string"> 
     
    <table cellpadding="5" cellspacing="2" width="1024">  
    
    <tr>  
            <th class="tableHead" width="10%" valign="top">Date</th>            
            <th class="tableHead" width="10%" valign="top">Time</th>    
            <th class="tableHead" width="15%" valign="top">Changed By</th>
            <th class="tableHead" width="15%" valign="top">Item Impacted</th>
            <th class="tableHead" width="25%" valign="top">Original Value</th>     
            <th class="tableHead" width="25%" valign="top">New Value</th>   
         </tr>
    
    <logic:notEmpty name="audit">      
         
        <c:forEach items="${audit}" var="change">    
        <tr> 
            <td class="table" width="10%" valign="top"><fmt:formatDate value="${change.dateChanged}" type="date"/></td>
            <td class="table" width="10%" valign="top"><fmt:formatDate value="${change.timeChanged}" type="time" pattern="HH:mm:ss"/></td>
            <td class="table" width="15%" valign="top">${change.changedBy.name}</td>
            <td class="table" width="15%" valign="top">${change.itemChanged}</td>            
            <td class="table" width="25%" valign="top">${change.oldValue}</td>                            
            <td class="table" width="25%" valign="top">${change.newValue}</td>   
        </tr>
        </c:forEach>   
                 
    </logic:notEmpty>
    <logic:empty name="audit">
        <tr>
            <td colspan="5" class="table">No history</td>
        </tr>
    </logic:empty>
    
    </table>
    
    <p><html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link></p>

        </tiles:put>

</tiles:insert>
