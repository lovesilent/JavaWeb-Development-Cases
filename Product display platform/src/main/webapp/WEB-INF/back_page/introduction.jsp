<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>信息管理</title>
<link rel="stylesheet" type="text/css"
	href="res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="res/themes/icon.css">
<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>

<style>
* {
	margin: 0
}

.easyui-tree a {
	text-decoration: none;
	color: #FF9933
}

input {
	width: 200px;
	margin: 5px;
}

font {
	color: red
}
</style>
</head>
<body>
	<div
		style="width: 700px; height: 500px; float: left; border: 1px solid #99BBE8; font-size: 14px; margin: 8px; color: #4180D1; font-family: Tahoma, Verdana, 微软雅黑, 新宋体;">
		<div
			style="background-image: url(res/themes/default/images/datagrid_title_bg.png); width: 700px; height: 25px; border-bottom: 1px solid #99BBE8;"></div>
		<div style="width: 700px; float: left;">
			<br>
			<h1 align="center" style="color: #15428B;">联系我们</h1>
			<div align="center" style="margin: 20px;">

				<form name="frm">
					<table width="400" border="0" align="center">
						<tr>
							<td>店家</td>
							<td><input id="name" name="name" value="${in.name}"
								class="easyui-validatebox" required="true"><font>*</font></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input id="address" name="address" value="${in.address}"
								class="easyui-validatebox" required="true"><font>*</font></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input id="phone" name="phone" value="${in.phone}"
								class="easyui-validatebox" required="true"><font>*</font></td>
						</tr>
						<tr>
							<td>微信</td>
							<td><input id="wechat" name="wechat" value="${in.wechat}"
								class="easyui-validatebox" required="true"><font>*</font></td>
						</tr>
						<tr>
							<td>其他描述</td>
							<td><textarea id="description" name="description"
									style="width: 200px; height: 120px; margin: 5px;">${in.description }</textarea></td>
						</tr>

						<td></td>
						<td align="center"><a id="ok" class="easyui-linkbutton"
							iconCls="icon-ok">确认</a><a class="easyui-linkbutton"
							iconCls="icon-reload" onclick="javascript:document.frm.reset()">重置</a></td>
						<tr>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	function mes(a, b, c) {
		$.messager.alert(a,
				"<div style=\"margin-top:10px;width:200px; text-align:center;color:red\">"
						+ b + "<div>", c);
	};
	function msgShow(title, msgString, msgType) {
		$.messager.alert(title, msgString, msgType,function(){
			if(msgType=='info'){
				window.parent.$('#mm-tabupdate').click();
			}
		});
	}
	$(function() {
		$('#tt').tree({
			onClick : function(node) {
				$('#tt').tree('beginEdit', node.target);
			}
		});
		$(".easyui-tree li a").click(function() {
			var name = $(this).attr("id") + ":" + $(this).text();
			$("h3").text(name);
		});
	});
	$(function() {

		$("#ok").click(function() {
			var i = 1;
			$(".easyui-validatebox").each(function() {
				if ($(this).val() == "") {
					mes('系统提示', '请把信息填写完整!', 'warning');
					i = 0;
					return false;
				}
			});
			if (i == 1) {
				var url = "/webset/admin/information/edit.do";
				var params = {"name":$('#name').val(), "address":$('#address').val(), "phone":$('#phone').val(), "wechat":$('#wechat').val(), "description":$('#description').val()};
				$.messager.confirm('Confirm','您确定要修改基本信息嘛?',function(confirm){
				    if (confirm){
				    		$.post(url,params,function(data){
				    			msgShow('系统提示',data.message+'<br/>确认后将自动刷新!','info');
							close();
						},"json");
				    }
				});
			}
		});

	});
</script>
</html>