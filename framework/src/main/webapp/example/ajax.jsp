<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>列表</title>
</head>
<body>
<input type="hidden" id="ctx" value="${ctx}">
<table id="dg" class="easyui-datagrid" title="Basic DataGrid" style="height:600px"
       data-options="rownumbers:true,
       pagination:true,
       checkOnSelect:true,
       collapsible:true,
       url:'${ctx}/user/userList',
       method:'get',
       idField:'cks',
       frozenColumns:[[{field:'cks',checkbox:true}]],toolbar:'#tb'">
    <thead>
    <tr>
        <th data-options="field:'NAME',width:80">用户名</th>
        <th data-options="field:'SEX',width:100">性别</th>
        <th data-options="field:'TEL',width:100">电话</th>
        <th data-options="field:'ADDRESS',width:100">地址</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
    <div>
        Date From: <input class="easyui-datebox" style="width:80px">
        To: <input class="easyui-datebox" style="width:80px">
        Language:
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="aa()">查询</a>
    </div>
</div>
<div id="w" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:400px;padding:10px;">
        <div style="padding:10px 0 10px 60px">
            <form id="ff" method="post">
                <table>
                    <tr>
                        <td>姓名:</td>
                        <td><input class="easyui-validatebox" type="text" name="NAME" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td><input class="easyui-validatebox" type="text" name="SEX" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>电话:</td>
                        <td><input class="easyui-validatebox" type="text" name="TEL" data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>地址:</td>
                        <td><textarea name="ADDRESS" style="height:60px;"></textarea></td>
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
    function add(){
        $('#w').window('open');
    }
    function aa(){
        $('#dg').datagrid('load', {
            name: 'easyui'
        });

    }
    $(function(){

    })

    function submitForm(){
        $('#ff').form('submit',{
            url: '${ctx}/loveTalk/save',
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