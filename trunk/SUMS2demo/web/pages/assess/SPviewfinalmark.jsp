<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="/WEB-INF/tlds/SUMSAssess.tld" prefix="sumsassess" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.viewfinalmark"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">  
 
    
        <table  border="0" cellpadding="5" cellspacing="2" width="1024">
        <tr>
        <td width="200px" class="tableHead"><strong>Student:</strong></td>
        <td colspan="4" width="400px" class="table">${project.studentTxt}</td>
        <tr>
        <td width="200px" class="tableHead"><strong>Unit:</strong></td>
        <td colspan="4" width="400px" class="table">${project.unitTxt}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Cohort:</strong></td>
        <td colspan="4" width="400px" class="table">${project.cohortTxt}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Project Title:</strong></td>
        <td colspan="4" width="400px" class="table">${project.title}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Submission Date:</strong></td>
        <td colspan="4" width="400px" class="table">${project.datesubmitted}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Late Handin?</strong></td>
        <td colspan="4" width="400px" class="table">${project.latehandin}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Supervisor</strong></td>
        <td colspan="4" width="400px" class="table">${project.markers.Supervisor.name}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Moderator</strong></td>
        <td colspan="4" width="400px" class="table">${project.markers.Moderator.name}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Project Comments</strong></td>
        <td colspan="4" width="400px" class="table">${project.comments}</td>
        </tr>
        <tr>
        <td width="200px" class="tableHead"><strong>Project Mark</strong></td>
        <td colspan="4" width="400px" class="table"><strong>${project.mark}%</strong></td>
        </tr>

        </table>
    
    <br/>
    
        <a href="javascript:history.go(-1);"><< back</a>

    </tiles:put>

</tiles:insert>
