<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml;charset=UTF-8" session="false" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<response type="queryMessage">
    <user>${user.tel}</user>
    <app>
        <name><c:out value="${appName}" escapeXml="true"/></name>
    </app>
</response>