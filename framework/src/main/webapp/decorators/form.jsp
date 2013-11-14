<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sitemesh-decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>
        <sitemesh-decorator:title/>
    </title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/demo.css">
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
    <sitemesh-decorator:head/>
</head>
<body>
<div style="margin:10px 0;">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">Open</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">Close</a>
</div>
<div id="w" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
    <sitemesh-decorator:body />
</div>
</html>