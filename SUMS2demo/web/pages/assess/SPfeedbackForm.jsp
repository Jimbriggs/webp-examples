<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

        <tiles:put name="title" type="string">

            <bean:message key="pums.assess.titles.feedback"/>
        
        </tiles:put>

    <tiles:put name="body" type="string">   
    
            <h4>Marker comments</h4>

                <table cellpadding="5" cellspacing="2" width="100%">  
                     <tr>  
                        <th class="tableHead" width="25%">Supervisor</th>
                        <th class="tableHead" width="25%">Moderator</th>
                        <logic:notEmpty name="Thirdmarkform">
                        <th class="tableHead" width="25%">Third marker</th>
                        </logic:notEmpty>
                        <logic:notEmpty name="Examinermarkform">
                        <th class="tableHead" width="25%">External examiner</th>     
                        </logic:notEmpty>
                     </tr>
                    <tr valign="top">
                         <td width="25%" class="table">
                            ${Supervisormarkform.generalComments}
                            <logic:empty name="Supervisormarkform" property="generalComments">
                                None
                            </logic:empty>
                      </td>
                         <td width="25%" class="table">
                            ${Moderatormarkform.generalComments}   
                            <logic:empty name="Moderatormarkform" property="generalComments">
                                None
                            </logic:empty>
                      </td>
                         <logic:notEmpty name="Thirdmarkform">
                         <td width="25%" class="table">                             
                            ${Thirdmarkform.generalComments} 
                            <logic:empty name="Thirdmarkform" property="generalComments">
                                None
                            </logic:empty>                                                   
                         </td>
                         </logic:notEmpty>
                         <logic:notEmpty name="Examinermarkform">
                         <td width="25%" class="table">                             
                            ${Examinermarkform.generalComments}  
                            <logic:empty name="Examinermarkform" property="generalComments">
                                None
                            </logic:empty>
                         </td>
                         </logic:notEmpty>
    </table>      
    
                <h4>Moderated comments</h4>
                
                <html:form action="/assess/moderateFeedbackSubmit" method="post">
                
                    <table cellpadding="5" cellspacing="2" width="100%">
                        <th class="tableHead" width="33%" valign="top">Student feedback</th>
                        <td class="table" width="33%" valign="top"><html:textarea name="projectbean" property="comments" cols="80" rows="20"/></td>
                        <td class="table" width="33%" valign="top">&nbsp<html:errors property="comments"/></td>
                  </table>
                    <br/>
                    <html:submit value="Save Feedback"/>
                    
                </html:form>
                
                <p><html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link></p>
                
    </tiles:put>

</tiles:insert>
