<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>
        主页
    </title>
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/demo.css">
    <script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<input type="hidden" id="ctx" value="${ctx}">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
<div data-options="region:'west',split:true,title:'West'" style="width:150px">
    <!-- 导航菜单 -->
    <div id="tree" class="easyui-accordion" data-options="animate:false,fit:true,border:true">
    </div>
</div>
<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" style="">
        <div title="主页" style="">
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#tree').tree({
            checkbox: false,
            url:'${ctx}/menu/tree?id=0',
            onBeforeExpand: function (node, param) {
                $('#tree').tree('options').url = '${ctx}/menu/tree?id=' + node.id;// change the url
            },
            onClick: function (node) {
                var url = node.attributes.url;
                $('#tabs').tabs('add',{
                    title:node.text,
                    href:url,
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

    });
</script>
</body>
</html>