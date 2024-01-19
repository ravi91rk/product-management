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

@SuppressWarnings("serial")
@WebServlet("/Buy")
public class CustomerBuyServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse res) 
	throws ServletException ,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null) {
			req.setAttribute("msg","SessionExpire...!");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
		else
		{
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> itr=al.iterator();
			while(itr.hasNext()) {
				ProductBean pb=(ProductBean)itr.next();
				if(pcode.equals(pb.getpCode())) {
					req.setAttribute("pb", pb); break;
					
					
				}
			}
			req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
			
		}
		
		
	}

}
