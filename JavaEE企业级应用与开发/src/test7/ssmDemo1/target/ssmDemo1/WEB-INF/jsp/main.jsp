<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统主页</title>
</head>
<body>
当前用户：${USER_SESSION.username}
<a href="logout">退出</a>
<br/>
<a href="toFindCustomerById">查看一个客户</a>
<br/>
<a href="toAddCustomer">添加客户</a>
<br/>
<a href="listCustomers">查看所有客户</a>
<br/>
<a href="toUpdateCustomer">更新客户信息</a>
<br/>
<a href="toDeleteCustomerById">删除客户信息</a>

</body>
</html>
