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
@WebServlet("/deleteProduct")
public class DeteletProductServlet  extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException ,IOException {
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Inviled...");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			int k=new DeleteProductDAO().deleteProduct(req);
			if(k>0) {
				req.setAttribute("msg", "ProductSuccesFully Deleted...!");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
			
		
			
		}
		
			
		}
		
		
		
	}


