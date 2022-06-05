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
  首页！<br>
  跳转表单页面1<a href="form1.action">点击</a><br>
  跳转表单页面2<a href="form2.action">点击</a><br>
  静态链接跳转，未经过dispatcherServlet<a href="html/NewFile.html">点击</a><br>
  跳转表单页面11（测试@RequestParam注解与普通形参接受参数的异同）<a href="form11.action">点击</a><br>

  </body>
</html>
