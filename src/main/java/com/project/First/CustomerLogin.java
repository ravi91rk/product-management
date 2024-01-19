package com.project.First;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLogin extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		
		CustomerBean cb= new CustomerLoginDAO().getDetails(req);
		if(cb==null) {
			req.setAttribute("msg", "Customer Login Inviled");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustLogin.jsp").forward(req, res);
			
		}
		
	}

}
