<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function testJson() {
		//获取输入的值pname为id
		var pname = $("#pname").val();
		var password = $("#password").val();
		var page = $("#page").val();
		$.ajax({
			//请求路径
			url : "${pageContext.request.contextPath }/testJson",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : JSON.stringify({pname:pname,password:password,page:page}),
			//定义发送请求的数据格式为JSON字符串
			contentType : "application/json;charset=utf-8",
			//定义回调响应的数据格式为JSON字符串，该属性可以省略
			dataType : "json",
			//成功响应的结果
			success : function(data){/*data是请求后台的Controller方法处理后的返回结果 */
				if(data != null){
					//返回一个Person对象
					//alert("输入的用户名:" + data.pname + "，密码：" + data.password + "，年龄：" +  data.page);
					//ArrayList<Person>对象
					/**for(var i = 0; i < data.length; i++){
						alert(data[i].pname);
					}**/
					//返回一个Map<String, Object>对象
					//alert(data.pname);//pname为key
					//返回一个List<Map<String, Object>>对象
					for(var i = 0; i < data.length; i++){
						alert("Ajax异步请求，返回json数据。用户名:" +data[i].pname+"，密码：" +data[i].password+"，年龄：" +  data[i].page);
					}
				}
			}

		});
	}
</script>
</head>
<body>
	<form action="">
		用户名：<input type="text" name="pname" id="pname"/><br>
		密码：<input type="password" name="password" id="password"/><br>
		年龄：<input type="text" name="page" id="page"/><br>
		<input type="button" value="测试" onclick="testJson()"/>
	</form>
</body>
</html>