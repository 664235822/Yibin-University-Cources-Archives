<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/16
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>welcome</title>
  </head>
  <body>
  欢迎页面！
  欢迎：${user==null?"游客":user.username}<%--当访问时，会查看request请求域中有无user参数的值，null值为”游客“--%>

  </body>
</html>
