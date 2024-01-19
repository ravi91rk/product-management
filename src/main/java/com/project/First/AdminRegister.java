package com.project.First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/Admin")
public class AdminRegister extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{	
		
		UserBean ub= new UserBean();
		ub.setUser(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setEmail(req.getParameter("mid"));
		ub.setPhon(Long.parseLong(req.getParameter("phon")));
		
		int k=new AdminRegisterDAO().insertData(ub);
		if(k>0) {
			req.setAttribute("msg", "Data inserted ...!");
			req.getRequestDispatcher("InsertData.jsp").forward(req, res);
			
		}
		
	}

}
