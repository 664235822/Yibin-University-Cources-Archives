<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>${pageContext.request.contextPath }
	没注册的用户，请<a href="${pageContext.request.contextPath }/index/register">注册</a>！<br>
	已注册的用户，去<a href="${pageContext.request.contextPath }/index/login">登录</a>！
</body>
</html>
