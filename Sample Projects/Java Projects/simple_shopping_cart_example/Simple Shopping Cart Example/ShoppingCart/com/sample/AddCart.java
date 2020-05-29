package com.sample;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCart extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Cookie c[]=new Cookie[12];
		for(int a=0;a<12;a++)
		{
		    String value = request.getParameter("T"+(a+1));
		     c[a]= new Cookie("T"+(a+1), value);
		    response.addCookie(c[a]);
        }

        // set a cookie
		response.sendRedirect("http://localhost:8080/examples/servlet/SeeCart");
        //out.println("<html><body><form method=\"POST\" action=\"http://localhost:8080/examples/servlet/SeeCart\"><input type=\"submit\" value=\"View Cart\" name=\"B3\"></form></body></html>");

	}
}
