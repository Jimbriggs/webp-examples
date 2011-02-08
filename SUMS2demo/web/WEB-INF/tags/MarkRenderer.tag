package WEB-INF.tags;

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nested:root name="markform">
    <table cellpadding="5" width="100%" border="1">         
        <tr>
            <th colspan="2">Prize Nominations <html:errors property="prizeerr"/></th>
        </tr>
        <tr>
            <th>Prize</th>
            <th>Justification</th>
        </tr>
        <c:choose>
            <c:when test="${markform.nomCount>0}">
                <c:forEach begin="0" end="${markform.nomCount-1}" var="nomID">
                    <tr>
                        <td>
                            <c:forEach items="${prizes}" var="prize">
                                <c:if test="${markform.prizeNominations[nomID].prizeID==prize.prizeID}">
                                    ${prize.name}                
                                </c:if>
                            </c:forEach> 
                        </td>
                        <td>${markform.prizeNominations[nomID].justification}</td>
                    </tr>   
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="2">No nominations entered</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</nested:root>
        <br/>
        <table cellpadding="5" width="100%" border="1"> 
            <tr>
                <th>Category</th>
                <th>Weight</th>
                <th>Mark</th>
                <th>Marks Assigned</th>
                <th>Comments</th>
            </tr>
        
            <c:set var="capped" value=""/>
            <c:forEach items="${markform.formCategories}" var="category">
                <c:choose>  
                    <c:when test="${category.critical && category.mark < 40}">
                        <tr class="criticalCat">
                        <c:set var="capped" value="1"/>
                    </c:when>
                    <c:when test="${category.optional}">
                        <tr class="optionalCat">
                    </c:when>
                    <c:otherwise>
                        <tr>
                    </c:otherwise>
                </c:choose> 
                    <th>${category.longName}</th>
   
                    <c:choose>
                        <c:when test="${(!(category.optional && (category.mark ==-1)))}">
                            <td>${category.weight}</td>
                            <td>${category.mark}</td>
                            <td>
                                <c:forEach items="${category.optionsSelected}" var="option">            
                                    ${category.categoryOptions[option].value}&nbsp;&nbsp;
                                </c:forEach>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>N/A</td>
                            <td>No mark</td>
                            <td>N/A</td>                
                        </c:otherwise>
                    </c:choose>
                    <td>${category.comments}&nbsp;</td>
                </tr>
            </c:forEach>    
            <tr>
                <th>Adjustment</th>
                <td colspan="4">${markform.adjustment}</td>
            </tr>
            <tr>
                <th>CALCULATED MARK</th>
                <c:choose>
                    <c:when test="${capped > 0}">
                        <td class="criticalCat" colspan="4">${markform.projectMark}% - capped due to failure in critical category</td
                    </c:when>
                    <c:otherwise>
                        <td colspan="4">${markform.projectMark}%</td>
                    </c:otherwise>
                </c:choose>
        
            </tr>
            <tr>
                <th>General Comments</th>
                <td colspan="4">${markform.generalComments}&nbsp;</td>   
            </tr>
            <tr>
                <th>Anything that needs to be brought to the attention of the examiners</th>
                <td colspan="4">${markform.examinerComments}&nbsp;</td>   
            </tr>
            <tr>
                <th>Plagiarism or another unfair act is suspected</th>
                <td colspan="4">
                    <c:if test="${markform.plagiarismSuspect}">
                        Yes
                    </c:if>
                    <c:if test="${!markform.plagiarismSuspect}">
                        No
                    </c:if>
                </td>    
            </tr> 
        </table> 