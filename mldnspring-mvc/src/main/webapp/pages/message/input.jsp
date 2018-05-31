<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/plugins/basepath.jsp"/>
<title>EchoMVC</title>
</head>
<body>
<%
	String echo_url = "pages/message/echo.action" ;
%>
<form action="<%=echo_url%>" method="post">
	请输入信息：<input type="text" name="msg" value="www.mldn.cn">
	<button type="submit">发送</button>
</form>
</body>
</html>