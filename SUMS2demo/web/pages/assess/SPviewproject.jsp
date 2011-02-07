<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">
    
    <tiles:put name="title" type="string">
        
        <bean:message key="pums.assess.titles.viewproject"/>
        
    </tiles:put>
    
    <tiles:put name="body" type="string">   
        <table>
            <tr>
            <td valign="top">
                <table  border="0" cellpadding="5" cellspacing="2">
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
                    
                    <c:if test="${project.status=='R1A'||(fn:contains(project.status,'M')&&(project.status!='M'))||fn:contains(project.status,'C')||fn:contains(project.status,'P')}">
                        <c:set var="showmarks" value="true" scope="page" />
                    </c:if>  
                    
                    <nested:root name="project">
                        
                        <tr>
                            <td width="200px" class="tableHead"><strong>Supervisor</strong></td>
                            <td width="150px" class="table">
                                ${project.markers.Supervisor.name}      
                            </td>
                            <td class="tableHead" width="75px"><strong>Mark</strong></td>
                            <td class="table" width="100px">
                                <c:if test="${(project.markermarks.Supervisor!=null)&&(showmarks=='true')}">
                                    ${project.markermarks.Supervisor.mark}%
                                </c:if>
                                <c:if test="${(project.markermarks.Supervisor!=null)&&(showmarks!='true')}">
                                    Unavailable
                                </c:if>
                                <c:if test="${project.markermarks.Supervisor==null}">
                                    Not assigned
                                </c:if>
                            </td>
                            <td class="table" width="75px">
                                <c:if test="${(project.markermarks.Supervisor!=null)&&(showmarks=='true')}">
                                    <nested:nest property="markermarks.Supervisor">
                                        <nested:link action="/assess/viewMark" paramProperty="personID" paramId="MARKER"><img src="../../images/view.gif" border="0" alt="View ${project.markers.Supervisor.name}'s Mark Form"/></nested:link>
                                    </nested:nest>
                                </c:if> &nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td width="200px" class="tableHead"><strong>Moderator</strong></td>
                            <td width="150px" class="table">
                                ${project.markers.Moderator.name}      
                            </td>
                            <td class="tableHead" width="75px"><strong>Mark</strong></td>
                            <td class="table" width="100px">
                                <c:if test="${(project.markermarks.Moderator!=null)&&(showmarks=='true')}">
                                    ${project.markermarks.Moderator.mark}%
                                </c:if>
                                <c:if test="${(project.markermarks.Moderator!=null)&&(showmarks!='true')}">
                                    Unavailable
                                </c:if>
                                <c:if test="${project.markermarks.Moderator==null}">
                                    Not assigned
                                </c:if>
                            </td>
                            <td class="table" width="75px">
                                <c:if test="${(project.markermarks.Moderator!=null)&&(showmarks=='true')}">
                                    <nested:nest property="markermarks.Moderator">
                                        <nested:link action="/assess/viewMark" paramProperty="personID" paramId="MARKER"><img src="../../images/view.gif" border="0" alt="View ${project.markers.Moderator.name}'s Mark Form"/></nested:link>
                                    </nested:nest>
                                </c:if> &nbsp;
                            </td>
                        </tr>
                        <c:if test="${project.markers.Third!=null}">
                            <tr>
                                <td width="200px" class="tableHead"><strong>Third Marker</strong></td>
                                <td width="150px" class="table">
                                    ${project.markers.Third.name}      
                                </td>
                                <td class="tableHead" width="75px"><strong>Mark</strong></td>
                                <td class="table" width="100px">
                                    <c:if test="${(project.markermarks.Third!=null)&&(showmarks=='true')}">
                                        ${project.markermarks.Third.mark}%
                                    </c:if>
                                    <c:if test="${(project.markermarks.Third!=null)&&(showmarks!='true')}">
                                        Unavailable
                                    </c:if>
                                    <c:if test="${project.markermarks.Third==null}">
                                        Not assigned
                                    </c:if>
                                </td>
                                <td class="table" width="75px">
                                    <c:if test="${(project.markermarks.Third!=null)&&(showmarks=='true')}">
                                        <nested:nest property="markermarks.Third">
                                            <nested:link action="/assess/viewMark" paramProperty="personID" paramId="MARKER"><img src="../../images/view.gif" border="0" alt="View ${project.markers.Third.name}'s Mark Form"/></nested:link>
                                        </nested:nest>
                                    </c:if> &nbsp;
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${project.markers.Examiner!=null}">
                            <tr>
                                <td width="200px" class="tableHead"><strong>Examiner Marker</strong></td>
                                <td width="150px" class="table">
                                    ${project.markers.Examiner.name}      
                                </td>
                                <td class="tableHead" width="75px"><strong>Mark</strong></td>
                                <td class="table" width="100px">
                                    <c:if test="${(project.markermarks.Examiner!=null)&&(showmarks=='true')}">
                                        ${project.markermarks.Examiner.mark}%
                                    </c:if>
                                    <c:if test="${(project.markermarks.Examiner!=null)&&(showmarks!='true')}">
                                        Unavailable
                                    </c:if>
                                    <c:if test="${project.markermarks.Examiner==null}">
                                        Not assigned
                                    </c:if>
                                </td>
                                <td class="table" width="75px">
                                    <c:if test="${(project.markermarks.Examiner!=null)&&(showmarks=='true')}">
                                        <nested:nest property="markermarks.Examiner">
                                            <nested:link action="/assess/viewMark" paramProperty="personID" paramId="MARKER"><img src="../../images/view.gif" border="0" alt="View ${project.markers.Examiner.name}'s Mark Form"/></nested:link>
                                        </nested:nest>
                                    </c:if> &nbsp;
                                </td>
                            </tr>
                        </c:if>
                        
                    </nested:root>
                    <tr>
                        <td width="200px" class="tableHead"><strong>Status:</strong></td>
                        <td colspan="4" width="400px" class="table">${project.statusDesc}</td>
                    </tr>
                    <tr>
                        <td width="200px" class="tableHead"><strong>AGREED MARK:</strong></td>
                        <td colspan="4" width="400px" class="table">
                        <c:choose>
                            <c:when test="${project.mark>0}">
                                ${project.mark}%&nbsp;
                            </c:when>
                            <c:otherwise>
                                Not assigned
                            </c:otherwise>        
                        </c:choose>
                    </tr>
                </table>
            </td>
            <td width="25">&nbsp;</td>    
            <td valign="top" width="200px">
                <table  border="1" cellpadding="5" width="100%">
                    <tr><th bgcolor="#FFFF99">Marker Options</th></tr>      
                    
                    <!-- Any User Options //-->

                    <c:if test="${project.status=='C'}">
                        <tr><td><html:link forward="viewFinalMark">View Final Project Mark</html:link></td></tr>
                    </c:if>
                    
                    <!-- End of Any User Options //-->
        
                    <!-- Supervisor Options //-->

                    <c:if test="${project.markers.Supervisor.ID==userbean.personID}">
                        
                        <c:if test="${project.status=='A'||project.status=='S'||project.status=='M'}">
                            <tr><td><html:link action="/assess/loadMarkForm">Add/Update Project Mark</html:link></td></tr>
                        </c:if>   
                        
                        <c:if test="${project.status=='R1A'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            <tr><td><html:link action="/assess/reconStage2">Can't reconcile - ask for a third marker</html:link></td></tr>
                        </c:if>   
                        
                        <c:if test="${project.status=='SM'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Amend agreed mark (e.g. across class boundary)</html:link></td></tr>
                        </c:if>   
                        
                        <c:if test="${project.status=='R2C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            <tr><td><html:link action="/assess/reconStage3">Can't reconcile - ask for another marker</html:link></td></tr>
                        </c:if> 
                        
                        <c:if test="${project.status=='R3C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            
                        </c:if> 
                        
                        <c:if test="${project.status=='SM'||project.status=='R1M'||project.status=='R2M'||project.status=='R3M'||project.status=='C'}">
                            <tr><td><html:link action="/assess/moderateFeedback">Moderate Student Feedback</html:link></td></tr>
                        </c:if>
                        
                        <c:if test="${project.status=='SM'||project.status=='R2M'||project.status=='R3M'}">
                            <tr><td><html:link action="/assess/confirmMark">Confirm Project Mark</html:link></td></tr>
                        </c:if>
                        
                        <c:if test="${project.status=='R2A'||project.status=='R2B'||project.status=='R3A'||project.status=='R3B'}">
                            <tr><td>None</td></tr>
                        </c:if>
                        
                    </c:if>   
                    
                    <!-- End of Supervisor Options //-->
        
                    <!-- Co-ordinator Standard Options //-->
        
                    <c:if test="${project.markers.Supervisor.ID!=userbean.personID}">
                        <c:forEach items="${project.coordinators}" var="coordinator">
                            <c:if test="${coordinator.ID == userbean.personID}">
                                
                                <c:if test="${project.status=='R1A'}">
                                    <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                                    <tr><td><html:link action="/assess/reconStage2">Can't reconcile - ask for a third marker</html:link></td></tr>
                                </c:if>   
                                
                                <c:if test="${project.status=='R2C'}">
                                    <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                                    <tr><td><html:link action="/assess/reconStage3">Can't reconcile - ask for another marker</html:link></td></tr>
                                </c:if> 
                                
                                <c:if test="${project.status=='R3C'}">
                                    <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                                </c:if> 
                                
                                <c:if test="${project.status=='SM'}">
                                    <tr><td><html:link action="/assess/reconcilliationForm">Amend agreed mark (e.g. across class boundary)</html:link></td></tr>
                                </c:if>   
                                
                                <c:if test="${project.status=='SM'||project.status=='R2M'||project.status=='R3M'||project.status=='C'}">
                                    <tr><td><html:link action="/assess/moderateFeedback">Moderate Student Feedback</html:link></td></tr>
                                </c:if>
                                
                                <c:if test="${project.status=='SM'||project.status=='R2M'||project.status=='R3M'}">
                                    <tr><td><html:link action="/assess/confirmMark">Confirm Project Mark</html:link></td></tr>
                                </c:if>
                                
                                <c:if test="${project.status=='R2A'||project.status=='R2B'||project.status=='R3A'||project.status=='R3B'}">
                                    <tr><td>None</td></tr>
                                </c:if>
                                
                            </c:if>
                        </c:forEach>
                    </c:if> 
                    
                    <!-- End of Co-ordinator Standard Options //-->

                    <!-- Moderator Options //-->

                    <c:if test="${project.markers.Moderator.ID==userbean.personID}">
                        
                        <c:if test="${project.status=='A'||project.status=='M'||project.status=='S'}">
                            <tr><td><html:link action="/assess/loadMarkForm">Add/Update Project Mark</html:link></td></tr>
                        </c:if>
                        
                        <c:if test="${project.status=='SM'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Amend agreed mark (e.g. across class boundary)</html:link></td></tr>
                        </c:if>   
                        
                        <c:if test="${project.status=='R1A'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            <tr><td><html:link action="/assess/reconStage2">Can't reconcile - ask for a third marker</html:link></td></tr>
                        </c:if>   
                        
                        <c:if test="${project.status=='R2C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            <tr><td><html:link action="/assess/reconStage3">Can't reconcile - ask for another marker</html:link></td></tr>
                        </c:if> 
                        
                        <c:if test="${project.status=='R3C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                        </c:if> 
                        
                        <c:if test="${project.status=='R2A'||project.status=='R2B'||project.status=='R3A'||project.status=='R3B'}">
                            <tr><td>None</td></tr>
                        </c:if>
                        
                    </c:if>
                    
                    <!-- End of Moderator Options //-->
        
                    <!-- Third Marker Options //-->
        
                    <c:if test="${project.markers.Third.ID==userbean.personID}">    
                        
                        <c:if test="${project.status=='R2C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                            <tr><td><html:link action="/assess/reconStage3">Can't reconcile - ask for another marker</html:link></td></tr>
                        </c:if> 
                        
                        <c:if test="${project.status=='R2B'}">
                            <tr><td><html:link action="/assess/loadMarkForm">Add/Update Project Mark</html:link></td></tr>
                        </c:if>
                        
                        <c:if test="${project.status=='R3A'||project.status=='R3B'}">
                            <tr><td>None</td></tr>
                        </c:if>
                        
                    </c:if>
                    
                    <!-- End of Third Marker Options //-->
        
                    <!-- Examiner Options //-->
        
                    <c:if test="${project.markers.Examiner.ID==userbean.personID}">        
                        
                        <c:if test="${project.status=='R3B'}">
                            <tr><td><html:link action="/assess/loadMarkForm">Add/Update Project Mark</html:link></td></tr>
                        </c:if>
                        
                        <c:if test="${project.status=='R3C'}">
                            <tr><td><html:link action="/assess/reconcilliationForm">Enter Reconciled Mark</html:link></td></tr>
                        </c:if> 
                        
                    </c:if>
                    
                    <!-- End of Examiner Marker Options //-->

                </table>
                
                <br/>
                
                <!-- Co-ordinator Admin Options //-->
        
                <c:forEach items="${project.coordinators}" var="coordinator">
                    <c:if test="${coordinator.ID == userbean.personID}">
                        <table  border="1" cellpadding="5" width="100%">
                            <tr><th bgcolor="#FFFF99">Co-ordinator Options</th></tr>
                            <c:if test="${project.status=='A'||project.status=='S'||project.status=='M'||project.status=='SM'||project.status=='R1A'||project.status=='R2B'||project.status=='R2C'||project.status=='R3B'||project.status=='R3C'}">
                                <tr><td><html:link action="/assess/enterMark">Enter Project Mark</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='A'||project.status=='M'}">
                                <tr><td><html:link action="/assess/supervisor">Change Supervisor</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='A'||project.status=='S'}">
                                <tr><td><html:link action="/assess/moderator">Change Moderator</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='R2A'}">
                                <tr><td><html:link action="/assess/thirdMarker">Assign Third Marker</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='R2B'}">
                                <tr><td><html:link action="/assess/thirdMarker">Change Third Marker</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='R3A'}">
                                <tr><td><html:link action="/assess/examinerMarker">Assign Examiner Marker</html:link></td></tr>                     
                            </c:if>
                            <c:if test="${project.status=='R3B'}">
                                <tr><td><html:link action="/assess/examinerMarker">Change Examiner Marker</html:link></td></tr>                     
                            </c:if>
                            <tr><td><html:link action="/assess/viewAudit">View Project Audit Trail</html:link></td></tr>
                            <tr><td><html:link href="/sums3/showExReport.do?projectId=${project.projectID}">View full project details</html:link></td></tr>
                            <c:if test="${project.markers['Supervisor'].ID > 0}">
                                <tr><td><html:link action="/assess/showMark?PROJECT=${project.projectID}&MARKER=${project.markers['Supervisor'].ID}">Show supervisor's mark</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.markers['Moderator'].ID > 0}">
                                <tr><td><html:link action="/assess/showMark?PROJECT=${project.projectID}&MARKER=${project.markers['Moderator'].ID}">Show moderator's mark</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.markers['Third'].ID > 0}">
                                <tr><td><html:link action="/assess/showMark?PROJECT=${project.projectID}&MARKER=${project.markers['Third'].ID}">Show third marker's mark</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.markers['Examiner'].ID > 0}">
                                <tr><td><html:link action="/assess/showMark?PROJECT=${project.projectID}&MARKER=${project.markers['Examiner'].ID}">Show examiner's mark</html:link></td></tr>
                            </c:if>
                            <c:if test="${project.status=='SM'||project.status=='R1M'||project.status=='R2M'||project.status=='R3M'||project.status=='C'}">
                                <tr><td><html:link action="/assess/moderateFeedback">Moderate Student Feedback</html:link></td></tr>
                            </c:if>
                        </table>            
                    </c:if>
                </c:forEach>
                
                <!-- End of Co-ordinator Admin Options //-->
        
            </td>
        </table>
        
        <br/>
        
        <html:link action="/assess/showAllocations"><< back</html:link>
        
    </tiles:put>
    
</tiles:insert>
