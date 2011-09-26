<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEBAPP1 home page</title>
    </head>
    <body>
        
        <H1>WEBAPP1 home page</H1>
        <TABLE border="1" cellspacing="0" cellpadding="5">
            <TR valign="top">
                <TD bgcolor="#FFFFFF"><H2>Jim's example programs</H2>
                    
                    <H3>Introductory</H3>
                    <UL>
                        <LI><A href="helloYou.html">helloYou</A></LI>
                        <LI><A href="helloMime.html">helloMIME</A> </LI>
                        <LI><A href="hellojsp.html">hello JSP</A></LI>
                    </UL>
                    <H3>MVC example</H3>
                    <UL>
                        <LI> 
                            <A href="/webapp1/mvc/fruitin.jsp">Show fruit</A>
                        </LI>
                        <LI>
                            <A href="/webapp1/showFruit?type=lemon&colour=purple&amp;condition=stale">Show fruit quick example</A>
                        </LI>
                    </UL>
                    <!--
                    <H3>Tomcat</H3>
                    <UL>
                        <LI><A href="/servlets-examples/">Tomcat servlet examples</A> </LI>
                        <LI><A href="/jsp-examples/">Tomcat JSP examples</A> </LI>
                        <LI><A href="/tomcat-docs/">Tomcat documentation</A> </LI>
                        <LI><a href="/logon/">Logon example</a> (TED, Husted) </LI>
                        <LI><a href="/struts-examples/welcome.do">Struts examples</a></LI>
                        <LI><a href="/struts-mailreader/Welcome.do">Struts Mailreader example</a> </LI>
                    </UL>
                    -->
                </TD>
            </TR>
        </TABLE>
        
    </body>
</html>
