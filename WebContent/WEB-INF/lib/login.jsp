<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="staticFile/jquery-2.2.2.min.js" type="text/javascript">
</script>
<style type="text/css">
	lable{
		width:100px;
	}
	li{
		list-style-type:none;
	}
	.inputText{
		width:300px;
	}
</style>
<script>
	function aaa(){
		var code = $("#code").val();
		var name = $("#name").val();
		var password = $("#password").val();
		if(code == ""){
			alert('编号不能为空');
			return;
		}
		if(name == ""){
			alert('姓名不能为空');
			return;
		}
		if(password == ""){
			alert('密码不能为空');
			return;
		}
 		$.post('User',{
			code:code,
			name:name,
			password:password
		},function(text,status){
			alert('保存成功');
		});
	}
</script>
</head>
<body>
	<ul>
		<li><lable>用户编号:</lable><input id="code" type="text" class="inputText"/></li>
		<li><lable>用户名称:</lable><input id="name" type="text" class="inputText"/></li>
		<li><lable>密码:</lable><input id="password" type="password" class="inputText"/></li>
	</ul>
	<input type="button" width = "80px" value="注册" onclick='aaa()'>
</p></body>
</html>