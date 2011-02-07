<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insert page="../tiles/layout.jsp" flush="true">

    <tiles:put name="title" type="string">

        <bean:message key="pums.assess.titles.selectstudent"/>
    
    </tiles:put>

    <tiles:put name="body" type="string">   

        <p>This page is temporary, it is used to emulate the logon process for students to be implemented at the higher levels of the SUMS system.</p>

        <html:form action="/assess/studentHome">

        <select name="ID">
            <option value="">--Select--</option>
            <option value="1">Steven Powell</option>            
            <option value="4">Matthew Webb</option>            
        </select>

        <input type="submit" value="Login" name="Login"/>
        
        </html:form>       

    </tiles:put>

</tiles:insert>


        
    
