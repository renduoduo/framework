<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js"></script>
    <sitemesh-decorator:head/>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
    <div style="margin:10px 0;"></div>
    <ul id="tt" class="easyui-tree">
        <li>
            <span>My Documents</span>
            <ul>
                <li data-options="state:'closed'">
                    <span>Photos</span>
                    <ul>
                        <li>
                            <span>Friend</span>
                        </li>
                        <li>
                            <span>Wife</span>
                        </li>
                        <li>
                            <span>Company</span>
                        </li>
                    </ul>
                </li>
                <li>
                    <span>Program Files</span>
                    <ul>
                        <li>Intel</li>
                        <li>Java</li>
                        <li>Microsoft Office</li>
                        <li>Games</li>
                    </ul>
                </li>
                <li>index.html</li>
                <li>about.html</li>
                <li>welcome.html</li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" style="">
        <div title="Tab1" style="">
        </div>
    </div>
</div>
<script type="text/javascript">
    $('#tt').tree({
        onClick: function(node){
            // add a new tab panel
            alert();
            $('#tabs').tabs('add',{
                title:'New Tab',
                href：'/framework/loveTalk/list',
                closable:true,
                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler:function(){
                        alert('refresh');
                    }
                }]
            });
        }
    });
</script>
</body>
</html>