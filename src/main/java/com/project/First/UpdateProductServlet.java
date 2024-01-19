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
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException, ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expire...! ");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
		else {
			String pcode=req.getParameter("code");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> itr=al.iterator();
			while(itr.hasNext()) {
				ProductBean pb=(ProductBean)itr.next();
				
				if(pcode.equals(pb.getpCode())) {
					pb.setPrice(Float.parseFloat(req.getParameter("price")));
					pb.setQyt(Integer.parseInt(req.getParameter("qyt")));
					int k=new UpdateProductDAO().updateProduct(pb);
					if(k>0) {
						req.setAttribute("msg", "ProductUpdate succesFully");
						
						
					}//if end
					break;
				}// if  ended
			}// while ended
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
	}

}
