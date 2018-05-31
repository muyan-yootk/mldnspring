<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/plugins/basepath.jsp"/>
<title>EchoMVC</title>
</head>
<body>
<h1>消息内容：${echoMsg}</h1>
<h1>消息级别：${echoLevel}</h1>
<h1>发送日期：${echoPubdate}</h1>
<h1>消息标签：${echoTags}</h1> 
<img src="images/dandan.gif"/>
</body>
</html>