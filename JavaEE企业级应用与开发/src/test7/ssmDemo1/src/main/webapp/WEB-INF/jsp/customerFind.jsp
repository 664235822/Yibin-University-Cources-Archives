<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
</head>
<body>
${msg}
<form action="findCustomerById" method="POST">
	输入查询客户的username：<input type="text" name="username"/><br />
	查&nbsp;&nbsp;&nbsp;询：
	<input type="submit" value="提交" />
</form>
<br />
<a href="main">跳转主页面</a>
</body>
</html>
