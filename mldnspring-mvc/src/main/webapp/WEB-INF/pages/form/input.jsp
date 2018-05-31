<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/pages/plugins/basepath.jsp"/>
<title>EchoMVC</title>
</head>
<body>
<%
	String show_url = "pages/form/show.action" ;
%>
<form action="<%=show_url%>" method="post">
	消息内容：	<input type="text" name="msg" value="www.mldn.cn"><br>
	消息级别：	<select id="level" name="level">
				<option value="0">紧急</option>
				<option value="1">普通</option>
				<option value="2">延迟</option>
			</select><br>
	发送日期：	<input type="text" name="pubdate" value="2025-12-11"><br>
	消息标签：	<input type="checkbox" name="tags" value="政治">政治
			<input type="checkbox" name="tags" value="经济">经济
			<input type="checkbox" name="tags" value="文化">文化
	<button type="submit">发送</button>
</form>
</body>
</html>