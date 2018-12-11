<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">
    
    <tiles:put name="title" type="string">
        
        <bean:message key="pums.assess.titles.userhome"/>
        
    </tiles:put>
    
    
    <tiles:put name="body" type="string">  
        <p>Hello ${userbean.name}</p>
        <h4>Options</h4>
        
        <table border="0" cellspacing="3">
            <tr valign="top">
                <td valign="top">
                    <ul>
                        <li>
                            <html:link action="/assess/showProjects">
                                <strong>My projects to mark</strong> submitted in last 3 months
                            </html:link>
                            <!-- Fix for SUMS-13 -->
                            <ul>
                                <li><html:link action="/assess/showProjects?months=6">... 6 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=12">... 12 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=18">... 18 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=99999">... ever</html:link></li>
                                
                            </ul>
                        </li>
                        <li> 
                            <html:link action="/assess/showProjects?status=U">
                                <strong>My <i>unmarked</i> projects</strong> submitted in last 3 months
                            </html:link>
                            <ul>
                                <li><html:link action="/assess/showProjects?months=6&status=U">... 6 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=12&status=U">... 12 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=18&status=U">... 18 months</html:link></li>
                                <li><html:link action="/assess/showProjects?months=99999&status=U">... ever</html:link></li>
                            </ul>
                        </li> 
                    </ul>
                    
                </td>
                <td valign="top">
                    <ul>
                        <li> 
                            <html:link action="/assess/showProjects?person=0">
                                <strong>All projects</strong> submitted in last 3 months
                            </html:link>
                            <ul>
                                <li><html:link action="/assess/showProjects?person=0&months=6">... 6 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=12">... 12 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=18">... 18 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=99999">... ever</html:link></li>
                            </ul>
                        </li>
                        
                        <li> 
                            <html:link action="/assess/showProjects?person=0&status=U">
                                <strong>All <i>unmarked</i> projects</strong> submitted in last 3 months
                            </html:link>
                            <ul>
                                <li><html:link action="/assess/showProjects?person=0&months=6&status=U">... 6 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=12&status=U">... 12 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=18&status=U">... 18 months</html:link></li>
                                <li><html:link action="/assess/showProjects?person=0&months=99999&status=U">... ever</html:link></li>
                            </ul>
                        </li>           
                        
                        <li>
                            <html:link action="/assess/showAgreedMarks?person=0&months=3">
                                <strong>All agreed marks</strong> in last 3 months
                            </html:link>
                            <ul>
                                <li><html:link action="/assess/showAgreedMarks?person=0&months=6">... 6 months</html:link></li>
                                <li><html:link action="/assess/showAgreedMarks?person=0&months=12">... 12 months</html:link></li>
                                <li><html:link action="/assess/showAgreedMarks?person=0&months=18">... 18 months</html:link></li>
                                <li><html:link action="/assess/showAgreedMarks?person=0&months=99999">... ever</html:link></li>
                            </ul>
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
    </tiles:put>
    
    </tiles:insert>
    