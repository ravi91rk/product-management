<%@page import="com.project.First.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
out.println("Page belongs to "+cb.getFName()+"<br>");

%>
<a href="ViewAllProduct">ViewAllProduct</a>
<a href ="logout">LogOut</a>

</body>
</html>