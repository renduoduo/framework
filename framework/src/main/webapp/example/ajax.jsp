<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>列表</title>
</head>
<body>
<input type="hidden" id="ctx" value="<%=basePath%>">
<table id="dg" class="easyui-datagrid" title="Basic DataGrid" style="height:600px"
       data-options="rownumbers:true,
       pagination:true,
       checkOnSelect:true,
       collapsible:true,
       url:'list',
       method:'get',
       idField:'cks',
       frozenColumns:[[{field:'cks',checkbox:true}]]">
    <thead>
    <tr>
        <th data-options="field:'userName',width:80">用户名</th>
        <th data-options="field:'sex',width:100">性别</th>
        <th data-options="field:'age',width:100">年龄</th>
        <th data-options="field:'address',width:100">地址</th>
    </tr>
    </thead>
</table>
<div id="w" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:400px;padding:10px;">
        <div style="padding:10px 0 10px 60px">
            <form id="ff" method="post">
                <table>
                    <tr>
                        <td>姓名:</td>
                        <td><input class="easyui-validatebox" type="text" name="userName" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td><input class="easyui-validatebox" type="text" name="sex" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input class="easyui-validatebox" type="text" name="age" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>地址:</td>
                        <td><textarea name="address" style="height:60px;"></textarea></td>
                    </tr>
                </table>
            </form>
        </div>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>
</div>
<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            buttons:[{
                iconCls:'icon-search',
                handler:function(){
                    alert('search');
                }
            },{
                iconCls:'icon-add',
                handler:function(){
                    $('#w').window('open');
                }
            },{
                iconCls:'icon-edit',
                handler:function(){
                    alert('edit');
                }
            }]
        });
    })

    function submitForm(){
        $('#ff').form('submit',{
            url: $("#ctx").val()+'/loveTalk/save',
            onSubmit: function(){
                //进行表单验证
                //如果返回false阻止提交
            },
            success:function(data){
                var json = $.parseJSON(data)
                if(json.success){
                    $.messager.alert('温馨提示',json.message, 'info');
                    $('#w').window('close');
                    //刷新数据
                    $("#dg").datagrid('reload');
                }else{
                    $.messager.alert('温馨提示', json.message, 'info');
                }
            }
        });
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>