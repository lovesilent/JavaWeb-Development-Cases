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

<title>add-picture</title>
<link rel="stylesheet" type="text/css" href="res/css/picture.css">
<link rel="stylesheet" type="text/css" href="res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="res/themes/icon.css">

<script src="res/js/jquery-1.4.4.min.js"></script>
<script src="res/js/jquery.form.js"></script>
<script src="res/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div class="picture-container clearfix">
    <ul id="pictures">
    </ul>
	</div>


	<div align="center" style="margin: 35px;">

		<form id="jvForm" action="/webset/admin/item/add.do" method="post">
			<table width="1000" border="0" align="center">
				<tr>
					<td>上传图片:</td>
					<td><input id="file0" onchange="uploadPic()" class="fileInput"
						type="file" name="pic" /><input id="urls" name="urls"
						type="hidden" /><input name="cid" type="hidden" value="${cid}"/></td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input name="name" class="easyui-validatebox"
						style="width: 150px" required="true"><font>*</font></td>
				</tr>
				<tr>
					<td>价格:</td>
					<td><input name="price" class="easyui-validatebox"
						style="width: 150px" required="true"><font>*</font></td>
				</tr>

				<tr>
					<td>具体描述:</td>
					<td><textarea name="description"
							style="width: 400px; height: 150px; margin:5px 5px 5px 0;"></textarea></td>
				</tr>
				<td></td>
				<td align="center"><a id="ok" class="easyui-linkbutton"
					iconCls="icon-ok">确认</a><a class="easyui-linkbutton"
					iconCls="icon-cancel" onclick="javascript:location.href='/webset/admin/item/show.do?cid=${cid}'">取消</a></td>
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
				var urls = new Array();
				$("input[name='url']").each(function(){
					urls.push($(this).val());
				});
				$("#urls").val(urls);
				$("#jvForm").submit();
			}
			;
		});

	});

	function uploadPic() {
		//添加图片占位
		//定义参数
		var options = {
			url : "/webset/admin/upload/uploadPic.do",
			dataType : "json",
			type : "post",
			success : function(data) {
				//回调 二个路径  
				//url
				//path
				/* $("#allImgUrl").attr("src", data.url); */
				/* $("#path").val(data.path); */
				var html ='<li><input type="hidden" name="url" value="'+ data.path +'"/>' 
				+ '<div class="image-con" ><img class="image-case" src="'+data.url+'"/></div>'
				+ '<input type="button" onclick="del(this)" value="删除"/></li>';
				$("#pictures").append(html);
			}
		};
		//jquery.form使用方式
		$("#jvForm").ajaxSubmit(options);
	}
	
	function del(ti){
		var parent = ti.parentNode;
		parent.parentNode.removeChild(parent);
	}
</script>
</html>