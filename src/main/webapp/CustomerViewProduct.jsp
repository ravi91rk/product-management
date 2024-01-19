<%@page import="java.util.Iterator"%>
<%@page import="com.project.First.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList <ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("al");
Iterator<ProductBean> itr=al.iterator();
if(al.size()==0){
	out.println("Product is not Availble");
}
else{
	while(itr.hasNext()){
		ProductBean pb=(ProductBean)itr.next();
		
		out.println(pb.getpCode()+"&nbsp&nbsp"+pb.getpName()+"&nbsp&nbsp"
			+pb.getPrice()+"&nbsp&nbsp"+pb.getQyt()+"&nbsp&nbsp"+
			"<a href='Buy?pcode="+pb.getpCode()+"'>Buy</a>");		
}

}
%>
<a href="logout">LogOut</a>
</body>
</html>