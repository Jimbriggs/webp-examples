<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.reconform"/>
        
    </tiles:put>

    <tiles:put name="body" type="string">   
    
        <h4>Current Marks</h4>

        <table cellpadding="5" cellspacing="2" width="1024">  
            <tr>  
                <th class="tableHead" width="25%">Marker</th>
                <th class="tableHead" width="25%">Marker Capacity</th>
                <th class="tableHead" width="25%">Date Marked</th>
                <th class="tableHead" width="25%">Mark</th>                            
            </tr>
            <c:forEach items="${project.markermarks}" var="mark">    
                <c:if test="${!(mark.key=='Third' && project.status=='R3C')&&!(mark.key=='Examiner' && project.status=='R2C')}">
                    <tr> 
                        <td class="table" width="25%">${mark.value.marker}</td>
                        <td class="table" width="25%">${mark.key} Marker</td>
                        <td class="table" width="25%">${mark.value.markdate}</td>
                        <td class="table" width="25%">${mark.value.mark}%</td>                      
                    </tr>
                </c:if>
            </c:forEach>                           
        </table>
            
        <p>Please enter the reconciled mark below:</p>    
                
        <html:form action="/assess/reconcilliationFormSubmit" method="post">
                
            <table cellpadding="5" cellspacing="2" width="1024">
                <tr>
                    <th class="tableHead" width="25%">Reconciled Mark</th>
                    <td class="table" width="25%"><html:text property="mark" maxlength="3" size="3"/>&nbsp;%</td>
                    <td class="table" width="50%"><html:errors property="mark"/>&nbsp;</td>
                </tr>
                <tr>
                    <th class="tableHead">Justification (e.g. what criteria did you take into account?)</th>
                    <td class="table"><html:textarea property="reason" rows="10" cols="80"/></td>
                    <td class="table"><html:errors property="reason"/>&nbsp;</td>
                </tr>
                <c:if test="${project.needoverride}">
                    <tr>
                        <th class="tableHead" width="25%">Override Procedure</th>
                        <td class="table" width="25%">
                            <html:select name="project" property="overrideReconMark">
                                <html:option value="0">No</html:option>
                                <html:option value="1">Yes</html:option>
                            </html:select>
                        </td>
                        <td class="table" width="50%">&nbsp;</td>
                    </tr>
                </c:if>
            </table>

            <p>By submitting this form I confirm that this mark has been agreed by all of the markers listed above.</p>

            <html:submit value="Submit Mark"/>
                    
        </html:form>
               
        <p><html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link></p>
                
    </tiles:put>

</tiles:insert>
