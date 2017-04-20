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

<title>pictureAdmin</title>
<link rel="stylesheet" type="text/css" href="res/css/picture.css">
<link rel="stylesheet" type="text/css"
	href="res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="res/themes/icon.css">
<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>
</head>
<body>
	<div>
		<a href="/webset/admin/item/aopen.do?cid=${cid}"> <input
			type="button" value="添加"
			style="float: left; margin-left: 40px; margin-right: 10px; font-size: 16px">
		</a>
	</div>
	<div>
		<a href="/webset/admin/column/show.do"><input type="button"
			value="后退" style="font-size: 16px"></a>
	</div>
	<div class="picture-container clearfix">
		<ul>
			<c:forEach items="${pagination.list }" var="item">
				<li>
					<div class="image-con">
						<img class="image-case" src="${item.picurl }">
					</div> <input type="text" value="${item.name }" class="case"> <a
					href="/webset/admin/item/eopen.do?iid=${item.id}"><input
						type="button" value="编辑"></a> <a
					href="/webset/admin/item/del.do?iid=${item.id}&cid=${cid}"><input
						type="button" value="删除"></a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="dig_c pb15 clearfix">
		<span class="inb_a"> 
			<c:forEach
				items="${pagination.pageView}" var="page">
						${page}
			</c:forEach>
		</span>
	</div>
</body>
</html>