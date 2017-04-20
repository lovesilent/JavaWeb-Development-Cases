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
<script src="res/js/jquery.knob.js"></script>
<script src="res/js/jquery.throttle.js"></script>
<script src="res/js/drag.js"></script>
<script src="res/js/jquery.lettering.js"></script>
<script src="res/js/jquery.textillate.js"></script>
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
		<div class="banner">
			<div class="jumbotron">
				<h1 class="glow in tlt">CREATE</h1>
				<p>相信我们&nbsp会为您定制出您满意的作品</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="countmain">
			<div class="countdown"></div>
		</div>
		<div class="cases">
			<div class="title cf">
				<ul class="title-list fr cf ">
					<li class="on"><c:if test="${empty categorys}">暂无</c:if> <c:if
							test="${categorys.size() > 0 }">${categorys.get(0).name }</c:if></li>
					<li><c:if test="${categorys.size() <=1 }">暂无</c:if> <c:if
							test="${categorys.size() > 1 }">${categorys.get(1).name }</c:if></li>
					<li><c:if test="${categorys.size() <=2 }">暂无</c:if> <c:if
							test="${categorys.size() > 2 }">${categorys.get(2).name }</c:if></li>
					<li><c:if test="${categorys.size() <=3 }">暂无</c:if> <c:if
							test="${categorys.size() > 3 }">${categorys.get(3).name }</c:if></li>
					<p></p>
				</ul>
			</div>
			<div class="product-wrap">
				<!--案例1-->
				<div class="product showon">
					<ul class="cf">
						<c:forEach items="${items_0 }" var="item">
							<li class="anli-list"><img src="${item.picurl}"></li>
						</c:forEach>
					</ul>
					<c:if test="${categorys.size() > 0 and not empty items_0 }">
						<div class="morecase" onclick="morecase(this)">
							<form>
								<input type="hidden" name="cid"
									value="${items_0.get(0).categoryId}" /> <input type="hidden"
									name="pageNum" value="2" />
							</form>
							<p>更多案例>></p>
						</div>
					</c:if>
				</div>
				<!--案例2-->
				<div class="product">
					<ul class="cf">
						<c:forEach items="${items_1 }" var="item">
							<li class="anli-list"><img src="${item.picurl}"></li>
						</c:forEach>
					</ul>
					<c:if test="${categorys.size() > 1 and not empty items_1}">
						<div class="morecase" onclick="morecase(this)">
							<form>
								<input type="hidden" name="cid"
									value="${items_1.get(0).categoryId}" /> <input type="hidden"
									name="pageNum" value="2" />
							</form>
							<p>更多案例>></p>
						</div>
					</c:if>
				</div>
				<!--案例3-->
				<div class="product">
					<ul class="cf">
						<c:forEach items="${items_2 }" var="item">
							<li class="anli-list"><img src="${item.picurl}"></li>
						</c:forEach>
					</ul>
					<c:if test="${categorys.size() > 2 and not empty items_2}">
						<div class="morecase" onclick="morecase(this)">
							<form>
								<input type="hidden" name="cid"
									value="${items_2.get(0).categoryId}" /> <input type="hidden"
									name="pageNum" value="2" />
							</form>
							<p>更多案例>></p>
						</div>
					</c:if>
				</div>
				<!--案例4-->
				<div class="product">
					<ul class="cf">
						<c:forEach items="${items_3 }" var="item">
							<li class="anli-list"><img src="${item.picurl}"></li>
						</c:forEach>
					</ul>
					<c:if test="${categorys.size() > 3 and not empty items_3}">
						<div class="morecase" onclick="morecase(this)">
							<form>
								<input type="hidden" name="cid"
									value="${items_3.get(0).categoryId}" /> <input type="hidden"
									name="pageNum" value="2" />
							</form>
							<p>更多案例>></p>
						</div>
					</c:if>
				</div>
			</div>

		</div>
		<div class="startpost">
			<p>联系我们,并且下单后,我们会有专门客服与您沟通</p>

			<p>You don't understand it well enough.</p>

			<div class="process">
				<img src="res/image/start-order.png"> <img
					src="res/image/start-chat.png"> <img
					src="res/image/start-design.png">
			</div>
			<div class="processtxt">
				<span>下单</span> <span>沟通</span> <span>设计</span>
			</div>
		</div>
	</div>


	<div id="footer">
		<p>All Rights Reserved &copy;上海WYLN</p>
	</div>
</body>
<script type="text/javascript">
	$(function () {
        //文字渐入
        $('.jumbotron h1').textillate({in: {effect: 'flipInY'}});
        $('.jumbotron p').textillate({in: {effect: 'flipInY'}});
        setTimeout(function () {
            $('.fade').addClass('in');
        }, 250);
        setTimeout(function () {
            $('h1.glow').removeClass('in');
        }, 2000);

        //开始设计按钮滑动
        $('#drag').drag();

        //计时器插件
        $('.countdown').ClassyCountdown({
            theme: "flat-colors",
            end: '1388468325',
            now: '1378441323',
            labels: true,
            style: {
                element: "",
                textResponsive: .5,
                days: {
                    gauge: {
                        thickness: .02,
                        bgColor: "rgba(0,0,0,0.05)",
                        fgColor: "#1abc9c"
                    },
                    textCSS: 'font-family:\'Open Sans\'; font-size:25px; font-weight:300; color:#34495e;'
                },
                hours: {
                    gauge: {
                        thickness: .02,
                        bgColor: "rgba(0,0,0,0.05)",
                        fgColor: "#2980b9"
                    },
                    textCSS: 'font-family:\'Open Sans\'; font-size:25px; font-weight:300; color:#34495e;'
                },
                minutes: {
                    gauge: {
                        thickness: .02,
                        bgColor: "rgba(0,0,0,0.05)",
                        fgColor: "#8e44ad"
                    },
                    textCSS: 'font-family:\'Open Sans\'; font-size:25px; font-weight:300; color:#34495e;'
                },
                seconds: {
                    gauge: {
                        thickness: .02,
                        bgColor: "rgba(0,0,0,0.05)",
                        fgColor: "#f39c12"
                    },
                    textCSS: 'font-family:\'Open Sans\'; font-size:25px; font-weight:300; color:#34495e;'
                }


            },
            onEndCallback: function () {
                console.log("Time out!");
            }
        });
    
        //设计案例切换
        $('.title-list li').mouseover(function () {
            var liindex = $('.title-list li').index(this);
            $(this).addClass('on').siblings().removeClass('on');
            $('.product-wrap div.product').eq(liindex).fadeIn(0).siblings('div.product').hide();
            var liWidth = $('.title-list li').width() * 25 / 23;
            $('.cases .title-list p').stop(false, true).animate({'left': liindex * liWidth + 'px'}, 300);
        });

    });


    /*更多案例当前页面加载*/
    function morecase(obj) {
      	//定义参数
		var options = {
			url : "/webset/show/findMore.shtml",
			dataType : "json",
			type : "post",
			success : function(data) {
				//回调 二个路径  
				//url
				//path
				/* $("#allImgUrl").attr("src", data.url); */
				/* $("#path").val(data.path); */
				var urls = data.urls;
				if(!urls.isEmpry){
					var maindiv = obj.previousElementSibling;
					for(var i=0;i<urls.length;i++){
						var lii = document.createElement("li");
						lii.className="anli-list";
			            lii.innerHTML = "<img src='" + urls[i] + "'>";
			            maindiv.appendChild(lii);
					}
					var pagenum = $(obj).find("input:[name='pageNum']");
		            pagenum.val(parseInt(pagenum.val())+1);
				}
			}
		};
		//jquery.form使用方式
		$(obj).find("form").ajaxSubmit(options);
    }

    //控制logo变换
    var h = 0;
    $("#click-img").click(function () {
        h++;
        if (h % 2 != 0) {
            $(".mobile-ul").fadeIn();
            $("#click-img").rotate({
                angle: 90 * (h - 1),
                animateTo: 90 * h,
                duration: 500
            });
        }
        else {
            $("#click-img").rotate({
                angle: -90 * (h - 1),
                animateTo: -90 * h,
                duration: 500
            });
            $(".mobile-ul").fadeOut();
        }
    })
</script>
</html>
