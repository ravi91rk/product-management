package com.project.First;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req ,HttpServletResponse res)
	throws ServletException ,IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expaire .... !");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			hs.removeAttribute("al");
			hs.removeAttribute("ubean");
			hs.invalidate();
			req.setAttribute("msg", "LogOut SuccecssFully..! ");
		}
		req.getRequestDispatcher("Home.jsp").forward(req, res);
		
	}

}
