package com.project.First;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Paybill")
public class PayBillServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws 	ServletException ,IOException
	{
		int k=new PayBillDAO().papBill(req);
		if(k>0) {
			req.setAttribute("msg", "Payment  SuccesFully.!");
			req.getRequestDispatcher("Payment.jsp").forward(req, res);
			
		}
	}
}
