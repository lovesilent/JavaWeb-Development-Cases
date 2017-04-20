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

<title>个人网站</title>
<link href="res/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="res/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="res/themes/default/easyui.css" />
<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>
</head>
<body>
	<div id="w" class="easyui-window" title="登录系统" collapsible="false"
		minimizable="false" maximizable="false"
		style="width: 300px; height: 180px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="jvForm" action="/webset/login/login.do" method="post">
					<div <c:if test="${empty error }">style="display:none"</c:if>>${error}</li>
					</div>
					<table cellpadding=4>
						<tr>
							<td>账号：</td>
							<td><input id="username" name="username" type="text"
								class="easyui-validatebox" required="true" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input id="password" name="password" type="Password"
								class="easyui-validatebox" required="true" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)" onclick="login()"> 确定</a> <a
					id="btnCancel" class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function login() {
			$('#jvForm').submit();
		}
	</script>
</body>
</html>