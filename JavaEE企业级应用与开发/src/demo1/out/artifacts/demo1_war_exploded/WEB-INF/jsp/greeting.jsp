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
    <title>springMVCDemo</title>
  </head>
  <body>
  欢迎：${userName==null?"游客":userName}<%--当访问时，会查看request请求域中有无name参数的值，null值为”游客“--%>
  </body>
</html>
