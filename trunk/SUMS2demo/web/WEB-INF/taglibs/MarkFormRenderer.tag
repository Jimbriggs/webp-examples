package WEB-INF.tags;

<%@tag description="Renders the Mark Form in to a table" pageEncoding="UTF-8"%>

<%-- Taglib directives can be specified here: --%>

    <%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
    <%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

    <SCRIPT language="JAVASCRIPT" type="TEXT/JAVASCRIPT">		
        
        function CommentShow(anchor_id, com_id)
{
	if(msoBrowserCheck()) 
		{
		c = document.all(com_id);
		a = document.all(anchor_id);
     /*           document.write('CommentShow: c=' + c + '(' + com_id + ') a=' + a + '(' + anchor_id + ')' ) */
		if (null != c && null == c.length && null != a && null == a.length)
			{
/*                        document.write('CommentShow2:' + c) */
                        var cw = c.offsetWidth;
			var ch = c.offsetHeight;
			var aw = a.offsetWidth;
			var ah = a.offsetHeight;
			var x  = a.offsetLeft;
			var y  = a.offsetTop;
			var el = a;
			while (el.tagName != "BODY") 
				{
				el = el.offsetParent;
				x = x + el.offsetLeft;
				y = y + el.offsetTop;
				}
			var bw = document.body.clientWidth;
			var bh = document.body.clientHeight;
			var bsl = document.body.scrollLeft;
			var bst = document.body.scrollTop;
			if (x + cw + ah / 2 > bw + bsl && x + aw - ah / 2 - cw >= bsl ) 
				{ c.style.left = x + aw - ah / 2 - cw; }
			else 
				{ c.style.left = x + ah / 2; }
			if (y + ch + ah / 2 > bh + bst && y + ah / 2 - ch >= bst ) 
				{ c.style.top = y + ah / 2 - ch; }
			else 
				{ c.style.top = y + ah / 2; }
			c.style.visibility = "visible";
}	}	}

function CommentHide(com_id) 
{
	if(msoBrowserCheck())
		{
		c = document.all(com_id);
		if (null != c && null == c.length)
		{
		c.style.visibility = "hidden";
		c.style.left = -1000;
		c.style.top = -1000;
		} } 
}

function msoBrowserCheck()
{
        ms = navigator.appVersion.indexOf("MSIE");
	vers = navigator.appVersion.substring(ms + 5, ms + 6);
	ie4 = (ms > 0) && (parseInt(vers) >= 4);
	return ie4;
}


        stdBrowser = (document.getElementById) ? true : false

        // www.sean.co.uk

        function pausecomp(millis) {
            date = new Date();
            var curDate = null;

            do { var curDate = new Date(); } 
            while(curDate-date < millis);
        } 
    
        function popUp(evt, currElem) {
            //pausecomp(500);
            popUpWin = (stdBrowser) ? document.getElementById(currElem).style : eval("document." + currElem)
            if (document.all) {
                //document.write(".ALL")
                popUpWin.pixelTop = parseInt(evt.y)+2
                popUpWin.pixelLeft = Math.max(2,parseInt(evt.x)-125)
            } else {
                if (stdBrowser) {
                    //document.write(".PX")
                    popUpWin.top = parseInt(evt.pageY)+2 + "px"
                    popUpWin.left = Math.max(2,parseInt(evt.pageX)-125) + "px"
                } else {
                    //document.write(".pageX")
                    popUpWin.top = parseInt(evt.pageY)+2
                    popUpWin.left = Math.max(2,parseInt(evt.pageX)-125)
                }
            }
            popUpWin.visibility = "visible"
        } 

        function popDown(currElem) {
        popUpWin = (stdBrowser) ? document.getElementById(currElem).style : eval("document." + currElem)
        popUpWin.visibility = "hidden"
        }
       
    </SCRIPT>

  <nested:root name="markform"> 
  
      <table cellpadding="5" width="100%" border="1"> 
          <tr>
              <th>Category</th>
              <th><div align="center">Weight</div></th>
           
              <c:choose>    
                  <c:when test="${markform.allOptionsSame && markform.formCategories[0].optionType!='S'}">       
                      <c:forEach begin="0" end="${markform.formCategories[0].optCount-1}" var="optID">            
                          <th><div align="center">${markform.formCategories[0].categoryOptions[optID].label}</div></th>                
                      </c:forEach>                            
                  </c:when>                
                  <c:otherwise>                              
                      <th colspan="${markform.mostOptions}"><div align="center">Options</div></th>                                  
                  </c:otherwise>                              
              </c:choose>
            
              <th>Comments (optional) <span class="smaller">[These may be notified to the student.]</span></th>
              <th>Category Mark</th>
          </tr>        

          <c:set var="capped" value=""/>
          <c:forEach begin="0" end="${markform.catCount-1}" var="catID">
    
              <c:choose>  
                  <c:when test="${markform.formCategories[catID].critical}">
                      <tr class="criticalCat">
                      <c:set var="capped" value="critical"/>
                  </c:when>
                  <c:when test="${markform.formCategories[catID].optional}">
                      <tr class="optionalCat">
                  </c:when>
                  <c:otherwise>
                      <tr>
                  </c:otherwise>
              </c:choose> 
        
                  <th align=left onmouseover="popUp(event,'cat${catID}')" onmouseout="popDown('cat${catID}')">
                      ${markform.formCategories[catID].longName}
                      <c:if test="${markform.formCategories[catID].optional}">
                          (optional)
                      </c:if>
                      <span class=popUpStyle id="cat${catID}">
                          <strong>${markform.formCategories[catID].longName}:</strong> ${markform.formCategories[catID].description}
                      </span>
                  </th>
                  <td align="center">${markform.formCategories[catID].weight}</td>

                  <nested:nest property="formCategories[${catID}]">  
         
                      <c:choose>    
    
                          <c:when test="${markform.formCategories[catID].optionType=='S'}">
                              <td colspan="${markform.mostOptions}">
                                  <nested:select property="optionsSelected"> 
                                      <html:option value="-1">-- Select -- </html:option>
                                      <c:forEach begin="0" end="${markform.formCategories[catID].optCount-1}" var="optID">                                   
                                          <html:option value="${optID}">${markform.formCategories[catID].categoryOptions[optID].label}</html:option>                        
                                      </c:forEach>                          
                                  </nested:select>
                              </td>                 
                          </c:when>
        
                          <c:otherwise>
                              <c:choose>
                                  <c:when test="${markform.formCategories[catID].optCount > 0}">
            
                                      <c:forEach begin="0" end="${markform.formCategories[catID].optCount-1}" var="optID">

                                          <!--align="center" id="_td${catID}opt${optID}" onmouseover="CommentShow('_td${catID}opt${optID}', 'cat${catID}opt${optID}')" onmouseout="CommentHide('cat${catID}opt${optID}')"-->
                                          <td align="center" id="_td${catID}opt${optID}" onmouseover="popUp(event, 'cat${catID}opt${optID}')" onmouseout="popDown('cat${catID}opt${optID}')">
                                              <c:if test="${!markform.allOptionsSame||!markform.allOptionsMulti}">
                    
                                                  <strong>${markform.formCategories[catID].categoryOptions[optID].label}</strong><br/>

                                              </c:if>

                                              <nested:equal property="optionType" value="C">
                                                  <nested:multibox property="optionsSelected" value="${optID}"/>
                                              </nested:equal>

                                              <nested:equal property="optionType" value="R">
                                                  <nested:radio property="optionsSelected" value="${optID}"/>
                                              </nested:equal>

                                              <span class=popUpStyle id="cat${catID}opt${optID}">
                                                  Mark value: ${markform.formCategories[catID].categoryOptions[optID].value}%<br/>
                                                  <span class="posCri">${markform.formCategories[catID].categoryOptions[optID].positiveCriteria}</span>
                                                  <span class="negCri">${markform.formCategories[catID].categoryOptions[optID].negativeCriteria}</span>
                                              </span>

                                          </td>

                                      </c:forEach>            
                                  </c:when>
                                  <c:otherwise>
                                      <td>No options associated with this category</td>
                                  </c:otherwise>
                              </c:choose>
                              <c:if test="${!markform.allOptionsSame}">                      
                                  <c:forEach begin="${markform.formCategories[catID].optCount}" end="${markform.mostOptions-1}">                    
                                      <td>&nbsp;</td>
                                  </c:forEach>          
                              </c:if>
                              
                          </c:otherwise>
                
                      </c:choose>
        
                      <td><nested:textarea property="comments"/></td>
                      <td>
                          <html:errors property="${markform.formCategories[catID].name}"/>
                          <c:if test="${markform.formCategories[catID].mark!=-1}">
                              ${markform.formCategories[catID].mark}
                          </c:if>
                          &nbsp;
                      </td>
            
                  </nested:nest>
        
              </tr>       
    
          </c:forEach>  
          <c:choose>
              <c:when test="${markform.allOptionsSame && markform.formCategories[0].optionType!='S'}">  
                  <td colspan="2">&nbsp;</td>
                  <c:forEach begin="0" end="${markform.formCategories[0].optCount-1}" var="optID">            
                      <td align="center"><strong>${markform.formCategories[0].categoryOptions[optID].label}</strong></td>                
                  </c:forEach>  
                  <td colspan="2">&nbsp;</td>        
              </c:when> 
          </c:choose>

          <tr>
              <th colspan="2">Mark Adjustment (You probably want to come back to fill this in after you've gone to the next page to see the computed mark.)</th>
              <td colspan="${markform.mostOptions}">
                  <table border="0" cellpadding="5" align="center">       
                      <tr>
                          <c:forEach var="adj" items="-5,-4,-3,-2,-1,0,1,2,3,4,5">
                              <td align=center>${adj}</td>
                          </c:forEach>
                      </tr>
                      <tr>
                          <c:forEach var="adj" items="-5,-4,-3,-2,-1,0,1,2,3,4,5">
                              <td align=center><html:radio name="markform" property="adjustment" value="${adj}"/></td>
                          </c:forEach>
                      </tr>                
                  </table>          
              </td>
              <td colspan="2">&nbsp;</td>        
          </tr>
          <tr>
              <th colspan="2">CALCULATED MARK</th>
              <td colspan="${markform.mostOptions}">                
                  <c:if test="${markform.projectMark!=-1}">
                      ${markform.projectMark}%
                  </c:if>
                  (Submit the form to see the calculated value)
              </td>
              <td colspan="2">&nbsp;</td>        
          </tr>
          <tr>
              <th colspan="2">General comments justifying the mark
              (min 15 characters here, 250 total including category comments above).
              In particular, stress areas of strength and weakness that do not necessarily match with the categories above.
              <span class="smaller">[These may be notified to the student.] </span>
              </th>
              <td colspan="${markform.mostOptions}"><nested:textarea property="generalComments" cols="50" rows="10"/></td>
              <td colspan="2"><html:errors property="generalComments"/>&nbsp;</td>        
          </tr>
          <tr>
              <th colspan="2">Anything that needs to be brought to the attention of the examiners (please give reasons).
                  <span class="smaller">[These will not normally be notified to the student, but may be revealed as a result of disciplinary or other proceedings.]</span>
              </th>
              <td colspan="${markform.mostOptions}"><nested:textarea property="examinerComments" cols="50" rows="10"/></td>
              <td colspan="2"><html:errors property="examinerComments"/>&nbsp;</td>        
          </tr>
          <tr>
              <th colspan="2">Tick here if PLAGIARISM or another unfair act is suspected (give details above)</th>
              <td colspan="${markform.mostOptions}"><nested:checkbox property="plagiarismSuspect"/></td>
              <td colspan="2"><html:errors property="plagiarismSuspect"/>&nbsp;</td>        
          </tr>    
          <tr>
              <th colspan="2">Click to calculate mark. (You will have the opportunity to return here and revise it.)</th>
              <td colspan="${markform.mostOptions}"><html:submit value="Calculate mark"/></td>
              <td colspan="2">&nbsp;</td>        
          </tr>    
      </table>   
         
  </nested:root>