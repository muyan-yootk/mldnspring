<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/pages/plugins/basepath.jsp"/>
<title>EchoMVC</title>
</head>
<body>
<%
	String show_url = "pages/emp/show.action" ;
%> 
<form action="<%=show_url%>" method="post" enctype="multipart/form-data">
	雇员编号：	<input type="text" name="empno" value="7369"><br>
	雇员姓名：	<input type="text" name="ename" value="小高不高"><br>
	雇员工资：	<input type="text" name="salary" value="1.1"><br>
	雇佣日期：	<input type="text" name="hiredate" value="3025-12-11"><br>
	部门编号：	<input type="text" name="dept.deptno" value="10"><br>
	部门名称：	<input type="text" name="dept.dname" value="要饭部"><br>
	雇员照片：	<input type="file" name="photo"><br>
	<button type="submit">发送</button>
</form>
</body>
</html>