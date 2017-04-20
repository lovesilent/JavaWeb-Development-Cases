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

<title>edit-picture</title>
<link rel="stylesheet" type="text/css" href="res/css/picture.css">
<link rel="stylesheet" type="text/css" href="res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="res/themes/icon.css">
<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div>
	</div>
	<div class="picture-container clearfix">
		<ul><c:forEach items="${pics }" var="pic">
			<li>
				<div class="image-con">
					<img class="image-case" src="${pic.allUrl}">
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>

	<div align="center" style="margin: 35px;">
		<form id="jvForm" action="/webset/admin/item/edit.do" method="post">
			<table width="1000" border="0" align="center">
				<tr>
					<td>名称</td>
					<td><input type="hidden" name="id" value="${item.id }" /><input type="hidden" name="categoryId" value="${item.categoryId }" />
					<input class="easyui-validatebox" name="name" value="${item.name }" style="width: 150px"
						required="true"><font>*</font></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input class="easyui-validatebox" name="price" value="${item.price }" style="width: 150px"
						required="true"><font>*</font></td>
				</tr>
				<tr>
					<td>具体描述</td>
					<td><textarea name="description"
							style="width: 400px; height: 150px; margin: 5px 5px 5px 0;">${item.description }</textarea></td>
				</tr>
				<td></td>
				<td align="center"><a id="ok" class="easyui-linkbutton"
					iconCls="icon-ok">确认</a><a class="easyui-linkbutton"
					iconCls="icon-cancel" onclick="javascript:location.href='/webset/admin/item/show.do?cid=${item.categoryId}'">取消</a></td>
				<tr></tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	function mes(a, b, c) {
		$.messager.alert(a,
				"<div style=\"margin-top:10px;width:200px; text-align:center;color:red\">"
						+ b + "<div>", c);
	};
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
				mes('系统提示', '提交成功!', 'info');
				$("#jvForm").submit();
			}
			;
		});

	});
</script>
</html>