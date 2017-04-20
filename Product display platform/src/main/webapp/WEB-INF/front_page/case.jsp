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

<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>WYLN设计网站</title>
<link rel="stylesheet" type="text/css" href="res/css/animate.css">
<link rel="stylesheet" type="text/css" href="res/css/style.css">

<script src="res/js/jquery.min.js"></script>
<script src="res/js/jquery.form.js"></script>
<script src="res/js/jquery.classycountdown.min.js"></script>
</head>
<body>
	<div class="navbar">
		<ul class="nav">
			<li><a class="btn1" href="/webset/show/contact.shtml">联系我们</a></li>
			<li><a href="/webset/show/case.shtml">商品</a></li>
			<li><a href="/webset/show/index.shtml">首页</a></li>
		</ul>
		<div class="mobile-nav">
			<div class="click">
				<img src="res/image/logo_rocket.png" id="click-img" />
			</div>
			<ul class="mobile-ul">
				<a href="/webset/show/contact.shtml">
					<li>开始</li>
				</a>
				<a href="/webset/show/case.shtml">
					<li>商品</li>
				</a>
				<a href="/webset/show/index.shtml">
					<li>首页</li>
				</a>
			</ul>
		</div>
		<div class="logo-wapper">
			<div class="top-logo">
				<div class="ih-item circle effect4 left_to_right">
					<a href="#" style="display: block; height: 96px;">
						<div class="img"
							style="width: 61px; height: 60px; position: absolute; left: 14px; top: 17px;">
							<img src="res/image/logo-rocket.png" alt="img"
								style="border-radius: 0;">
						</div>
						<div class="info"
							style="width: 75px; height: 75px; background: none; position: absolute; top: 8px; left: 8px;">
							<img src="res/image/logo_rocket.png" alt="img"
								style="border-radius: 0; width: 100%; height: 100%;">
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>


	<div id="header" style="z-index: 100;">
		<div class="banner_case">
			<img src="res/image/blog_background.png" width="100%" />
		</div>
	</div>
	<div class="container">
		<div class="case_column">
			<c:forEach items="${categorys }" var="category">
				<div class="column">
					<a href="/webset/show/case.shtml?cid=${category.id }">${category.name }</a>
				</div>
			</c:forEach>
			
		</div>
		<div class="case_show">
			<ul>
				<c:forEach items="${pagination.list }" var="item">
				<li><a href="/webset/show/detail.shtml?iid=${item.id }"> 
					<img class="con_image" src="${item.picurl }">
					<p>${item.name }/${item.price}¥</p>
				</a></li>
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
	</div>

	<div id="footer">
		<p>All Rights Reserved &copy;上海WYLN</p>
	</div>

</body>
</html>