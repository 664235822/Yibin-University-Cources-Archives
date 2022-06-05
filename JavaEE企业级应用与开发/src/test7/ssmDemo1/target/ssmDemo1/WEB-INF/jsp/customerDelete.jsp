<%--
  Created by IntelliJ IDEA.
  User: zz664
  Date: 2022/4/14
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除客户信息</title>
</head>
<body>
${msg}
<form action="deleteCustomerById" method="post">
    用户名:<input type="text" name="username"/><br/>
    <input type="submit" value="删除"/>
    <a href="main">跳转主页面</a>
    <br/>
</form>
</body>
</html>
