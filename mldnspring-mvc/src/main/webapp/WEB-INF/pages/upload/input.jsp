<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/pages/plugins/basepath.jsp"/>
<title>EchoMVC</title>
</head>
<body>
<%
	String upload_url = "pages/upload/upload.action" ;
%>
<form action="<%=upload_url%>" method="post" enctype="multipart/form-data">
	请输入信息：<input type="text" name="msg" value="www.mldn.cn"><br>
	请选择图片：<input type="file" name="photo"><br>
	<button type="submit">发送</button>
</form> 
</body>
</html>