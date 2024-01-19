package com.project.First;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req ,HttpServletResponse res) 
	throws ServletException ,IOException{
		
		UserBean ub=new AdminLoginDAO().getAdminData(req);
		if(ub==null) {
			req.setAttribute("msg", "invalid Login process <br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs =req.getSession();  //creating new session
			hs.setAttribute("ubean", ub);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			
		}
		
		
	}

}
