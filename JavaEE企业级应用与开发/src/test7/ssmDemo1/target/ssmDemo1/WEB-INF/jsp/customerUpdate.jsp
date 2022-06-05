<%--
  Created by IntelliJ IDEA.
  User: zz664
  Date: 2022/4/14
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新客户信息</title>
</head>
<body>
${msg}
<form action="updateCustomer" method="post">
    用户名:<input type="text" name="username"/><br/>
    职业:<input type="text" name="jobs"/><br/>
    电话号码:<input type="text" name="phone"/><br/>
    <input type="submit" value="更新"/><br/>
    <a href="main">跳转主页面</a>
</form>
</body>
</html>
