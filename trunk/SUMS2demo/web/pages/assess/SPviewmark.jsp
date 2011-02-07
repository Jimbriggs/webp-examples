<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="/WEB-INF/tlds/SUMSAssess.tld" prefix="sumsassess" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.viewmark"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">   
    
    <div id="markform">
     
        <sumsassess:ProjectRenderer/>         
        <br/>
        <sumsassess:MarkRenderer/>

        <br/>        
        <html:link action="/assess/viewProject" paramName="project" paramProperty="projectID" paramId="PROJECT"><< back</html:link>
  
    </div>

    </tiles:put>

</tiles:insert>
