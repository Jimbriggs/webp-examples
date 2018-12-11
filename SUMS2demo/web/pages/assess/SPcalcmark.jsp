<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="/WEB-INF/tlds/SUMSAssess.tld" prefix="sumsassess" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.confmark"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">   
    
    <div id="markform">
    <html:form action="/assess/submitMark" enctype="application/x-www-form-urlencoded" method="post">    
     
        <sumsassess:ProjectRenderer/>         
        <br/>
        <sumsassess:MarkRenderer/>
 
        <br/>
        <table cellpadding="5" width="100%" border="1">   
        <tr>
        <th>Save Record? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <html:submit value="Save"/></th>    
        </tr>
        </table>  
        
        </html:form>
        <br/>        
        <html:link forward="viewMarkForm"><< return to form</html:link>
  
    </div>

    </tiles:put>

</tiles:insert>
