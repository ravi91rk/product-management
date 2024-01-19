package com.project.First;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException ,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expire");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
		else
		{
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> itr=al.iterator();
			
			while(itr.hasNext()) {
				ProductBean pb=itr.next();
				if(pcode.equals(pb.getpCode())) {
					req.setAttribute("data", pb);
					break;
				}
				
			}
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}
}
