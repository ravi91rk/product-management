package com.project.First;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/ViewProduct")
public class ViewProductServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req ,HttpServletResponse res)
	throws ServletException ,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expire....!");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			ArrayList<ProductBean> al=new ViewproductDAO().viewData();
			hs.setAttribute("al",al);
			RequestDispatcher rd= req.getRequestDispatcher("ViewAllProduct.jsp");
			rd.forward(req, res);
			
		}
	}

}
