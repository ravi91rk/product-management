package com.project.First;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException ,IOException
	{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expire ..!");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			ProductBean pb=new ProductBean();
			pb.setpCode(req.getParameter("pcode"));
			pb.setpName(req.getParameter("pname"));
			pb.setPrice( Float.parseFloat(req.getParameter("price")));
			pb.setQyt(Integer.parseInt(req.getParameter("qty")));
			
			int k= new AddProductDAO().addProduct(pb);
			if(k>0) {
				req.setAttribute("msg", "Product Added Succesfully....!");
				req.getRequestDispatcher("Addproduct.jsp").forward(req, res);
			}
			
		}
		
		
		
	}

}
