<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	没注册的用户，请<a href="user/registerGo">注册</a>！<br>
	已注册的用户，去<a href="user/loginGo">登录</a>！<br>
	静态HTML网页跳转<a href="html/NewFile.html">点击</a><br>
	请求转发<a href="user/forwardGo">点击</a>！<br>
	重定向<a href="user/redirectGo">点击</a>！<br>
	重定向到不需要DispatcherServlet处理的静态资源<a href="user/redirectGoStatic">点击</a><br>

</body>
</html>
