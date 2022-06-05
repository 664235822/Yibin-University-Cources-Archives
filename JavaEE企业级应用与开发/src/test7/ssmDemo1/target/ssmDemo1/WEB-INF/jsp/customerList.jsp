<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>名称</td>
			<td>职业</td>
			<td>电话</td>
		</tr>
		<tr>

		</tr>
		<!-- JSTL标签，请参考本书的相关内容 -->
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.username}</td>
				<td>${customer.jobs}</td>
				<td>${customer.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="main">跳转主页面</a>
</body>
</html>
