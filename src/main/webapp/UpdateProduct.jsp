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
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("Welcome to "+ub.getFname()+"<br>");
%>
<a href="Product.html">AddProduct</a>
<a href="ViewProduct">ViewAllProduct</a>
<a href=logout>LogOut</a>
</body>
</html>