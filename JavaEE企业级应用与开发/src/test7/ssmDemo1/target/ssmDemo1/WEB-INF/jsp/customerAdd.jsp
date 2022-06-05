<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
    ${msg}
	<form action="addCustomer" method="POST">
		用户名：<input type="text" name="username"/><br />
		职业：
                 <input type="text" name="jobs"/><br />
		电话号码：
		<input type="text" name="phone"/><br />
		<input type="submit" value="添加" />
	</form>
	<br />
	<a href="main">跳转主页面</a>

</body>
</html>
