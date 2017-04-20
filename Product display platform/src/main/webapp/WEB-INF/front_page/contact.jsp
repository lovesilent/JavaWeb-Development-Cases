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

<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>WYLN设计网站</title>
<link rel="stylesheet" type="text/css" href="res/css/animate.css">
<link rel="stylesheet" type="text/css" href="res/css/style.css">

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
	<!-- <div id="header" style="z-index: 100;">
		<div class="banner_case">
			<img src="res/image/blog_background.png" width="100%" />
		</div>
	</div> -->
	<div class="wrap" style="font-family: '微软雅黑';">
		<div class="banner_case">
			<img src="res/image/blog_background.png" width="100%" />
		</div>
		<!--信息-->
		<div class="info" style="margin: 70px auto;">
			<div class="info_content">
				<p class="phot">联系我们</p>
				<div class="info_list">
					<span>公司名: ${in.name }</span>
					<div style="clear: both;"></div>
				</div>
				<div class="info_list">
					<span>公司地址: ${in.address }</span>
					<div style="clear: both;"></div>
				</div>
				<div class="info_list">
					<span>公司电话: ${in.phone }</span>
					<div style="clear: both;"></div>
				</div>
				<div class="info_list">
					<span>公司微信: ${in.wechat }</span>
					<div style="clear: both;"></div>
				</div>
				<div class="info_list">
					<span>其他描述: ${in.description }</span>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
		<p>All Rights Reserved &copy;上海WYLN</p>
	</div>

</body>
</html>