package WEB-INF.tags;

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- Taglib directives can be specified here: --%>

    <%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
    <%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

    <nested:root name="markform">
    <table cellpadding="5" width="100%" border="1">         
    <tr>
        <c:if test="${markform.nomCount>0}">
        <th colspan="3">Prize Nominations <html:errors property="prizeerr"/></th>
        </c:if>
        <c:if test="${markform.nomCount==0}">
        <th colspan="2">Prize Nominations <html:errors property="prizeerr"/></th>
        </c:if>        
    </tr>
    <tr>
        <th>Prize</th>
        <th>Justification</th>
        <c:if test="${markform.nomCount>0}">
        <th>Delete</th>
        </c:if>
    </tr>
    <c:if test="${markform.nomCount>0}">
    <c:forEach begin="0" end="${markform.nomCount-1}" var="nomID">
    <tr>
        <td>
        <c:forEach items="${prizes}" var="prize">
            <c:if test="${markform.prizeNominations[nomID].prizeID==prize.prizeID}">
                ${prize.name}                
            </c:if>
        </c:forEach> 
        </td>
        <nested:nest property="prizeNominations[${nomID}]">  
        <td>${markform.prizeNominations[nomID].justification}</td>
        <td align="right"><div align="center"><nested:checkbox property="delete" value="Yes"/></div></td>
        </nested:nest>
    </tr>   
    </c:forEach>
    </c:if>
    <tr>
        <td valign="top">
            <html:select name="markform" property="prizeID">
            <html:option value="0">--Select--</html:option>
            <html:options collection="prizes" property="prizeID" labelProperty="description"/>
            </html:select>
        </td>
        <td valign="top">
            <html:textarea name="markform" property="justification" cols="25" rows="3"/>
        </td>
        <c:if test="${markform.nomCount>0}">
        <td>&nbsp;</td>
        </c:if>
    </tr> 
    </table>
    </nested:root>