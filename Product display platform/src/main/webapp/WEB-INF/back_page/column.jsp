<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>projectAdmin</title>
<link rel="stylesheet" type="text/css"
	href="res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="res/themes/icon.css">
<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>
</head>
<body>
	<input type="button" id="add_open" value="添加" />
	<table id="tt" class="easyui-datagrid"
		style="width: 400px; height: auto;">
		<thead>
			<tr>
				<th field="栏目" width="100">栏目</th>
				<th field="查看" width="100">查看</th>
				<th field="编辑" width="100">编辑</th>
				<th field="删除" width="100">删除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${columns}" var="column">
				<%-- <input type="hidden" name="id" value="${column.id}" />  --%>
				<tr>
					<td><input type="text" value="${column.name}"
						readonly="readonly" /></td>
					<td><a href="/webset/admin/item/show.do?cid=${column.id}" >查看</a></td>
					<td><input type="button" value="编辑"
						onclick='edit(this, ${column.id})' /></td>
					<td><input type="button" value="删除"
						onclick='del(${column.id})' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="w" class="easyui-window" title="添加新栏目" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style=" width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新栏目：</td>
						<td><input id="txtNewColumn" type="text" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
</body>
<script>
	//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
	function msgShow(title, msgString, msgType) {
		$.messager.alert(title, msgString, msgType,function(){
			if(msgType=='info'){
				window.parent.$('#mm-tabupdate').click();
			}
		});
	}
	//设置删除
	function del(id){
		var url = "/webset/admin/column/del.do";
		var params = {"column_id":id};
		$.messager.confirm('Confirm','您确定要删除该条栏目嘛?',function(confirm){
		    if (confirm){
		    		$.post(url,params,function(data){
					msgShow('系统提示',data.message+'<br/>确认后将自动刷新!','info');
					close();
				},"json");
		    }
		});
	}
	//设置修改
	function edit(ttd,id){
		var text = ttd.parentNode.parentNode.parentNode.firstChild.firstChild.firstChild;
		if(ttd.value=='编辑'){
			$(text).removeAttr("readonly");
			ttd.value = '保存';
		}else{
			var url = "/webset/admin/column/edit.do";
			var params = {"id":id,"name":text.value};
			$.messager.confirm('Confirm','您确定要修改该条栏目嘛?',function(confirm){
			    if (confirm){
			    		$.post(url,params,function(data){
						msgShow('系统提示',data.message+'<br/>确认后将自动刷新!','info');
						close();
					},"json");
			    }
			});
			/* $(text).attr("readonly","readonly");
			ttd.value = '编辑'; */
		}
		
		
	}
	$(function() {
		//初始化窗口
		$('#w').window({
			title : '添加新栏目',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 140,
			resizable : false
		}); 
		//设置添加
		$('#add_open').click(function() {
			$('#w').window('open');
		});
		//添加确认
		$('#btnEp').click(function() {
			var column = $('#txtNewColumn');
			if (column.val() == '') {
                msgShow('系统提示', '请输入栏目名！', 'warning');
                return false;
            }
			var url = "/webset/admin/column/add.do";
			var params = {"column_name":column.val()};
			$.post(url,params,function(data){
				 msgShow('系统提示',data.message+'<br/>确认后将自动刷新!','info');
				 column.val('');
	             close();
			},"json");
			
		});
		//添加取消
		$('#btnCancel').click(function() {
			$('#w').window('close');
		})
	});
</script>
</html>