package com.project.First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/CustRegister")
public class CustomerRegisterServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req ,HttpServletResponse res)
	throws ServletException ,IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		int k=new CustomerRegisterDAO().insertData(req);
		if(k>0) {
			req.setAttribute("msg", "Customer Data Insert Succussfully..!");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
		
		
		
	}

}
