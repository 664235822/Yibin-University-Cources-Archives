<%--
  Created by IntelliJ IDEA.
  User: 86178
  Date: 2022/3/19
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  </head>
  <body>
    <form action="">
      用户名：<input type="text" name="pname" id="pname"/><br>
      密码：<input type="password" name="password" id="password"/><br>
      年龄：<input type="text" name="page" id="page"/><br>
      <input type="button" value="测试" onclick="testJson()"/>
    </form>
    <script type="text/javascript">
      function testJson() {
        //获取输入的值panme为id
        var pname = $("#pname").val();
        var password = $("#password").val();
        var page = $("#page").val();
        $.ajax({
          url:"${pageContext.request.contextPath}/testJson",
          type:"post",
          data:JSON.stringify({pname:pname,password:password,page:page}),
          contentType:"application/json;charset=utf-8",
          dataType:"json",
          success:function (data) {
            if (data != null){
              for (var i = 0;i < data.length;i++){
                alert(data[i].pname);
              }
            }
          }
        })
      }
    </script>
  </body>
</html>
