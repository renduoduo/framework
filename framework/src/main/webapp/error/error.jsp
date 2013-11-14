<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/xml;charset=UTF-8" isErrorPage="true" %>
<%response.setStatus(200);%>
<%
    String uri = (String)request.getAttribute("javax.servlet.forward.request_uri");
    Logger logger = LoggerFactory.getLogger("com.emagsoftware.egmgs");
    Throwable ex = null;
    if (exception != null)
        ex = exception;
    if (request.getAttribute("javax.servlet.error.exception") != null)
        ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
    String resultCode = "-1";
    String resultMsg = "-1";

    boolean isPrintStackTrace = request.getParameter("mgs_show_error") != null;
    StringWriter stringWriter = null;
    if(isPrintStackTrace){
        stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
    }
    logger.error("Request Error - URI:"+uri,ex);
%>
<?xml version="1.0" encoding="UTF-8"?>
<response>
    <resultCode><%=resultCode%></resultCode>
    <resultMsg><%=resultMsg%></resultMsg>
    <%if(isPrintStackTrace){%>
    <StackTrace>
        <![CDATA[<%=stringWriter.toString()%>]]>
    </StackTrace>
    <%}%>
</response>
