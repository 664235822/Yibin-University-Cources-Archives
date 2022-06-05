<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>示例表单</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/hello2.action" method="post"><%--/springMvcDemo2为项目的根路径--%>
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
