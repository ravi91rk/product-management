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
@WebServlet("/billing")
public class BillingServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException ,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null) {
			req.setAttribute("msg","Session Expaire..! ");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{	
			int qyt=Integer.parseInt(req.getParameter("qty"));
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> itr=al.iterator();
			String pcode=req.getParameter("pcode");
			while(itr.hasNext()) {
				ProductBean pb=(ProductBean)itr.next();
				if(pcode.equals(pb.getpCode())) {
					if(pb.getQyt()>=qyt) {
						req.setAttribute("qyt", qyt);
						req.setAttribute("pb", pb);
						
						req.getRequestDispatcher("Billing.jsp").forward(req, res);
						break;
						
					}	
					else
					{
						req.setAttribute("msg","Quentity Out of stock");
						req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
					}
					
				}
					
			}
			
				
			
			
		}
		
		
		
		
		
	}

}
