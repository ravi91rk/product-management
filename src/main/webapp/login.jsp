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
out.println("WelCome to "+ub.getFname());
%>
<a href="Product.html">AddProduct</a>
<a href="ViewProduct">ViewProduct</a>
<a href="logout">LogOut</a>
</body>
</html>