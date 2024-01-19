<%@page import="com.project.First.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub= (UserBean)session.getAttribute("ubean");
String msg=(String)request.getAttribute("msg");
out.println("Page belongd to "+ub.getFname()+"<br>");
out.println(msg);
%>
<a href ="Product.html">AddProduct</a>
<a href="ViewAllProduct.jsp">ViewAllProduct</a>
<a href="logout">LogOut</a>
</body>
</html>