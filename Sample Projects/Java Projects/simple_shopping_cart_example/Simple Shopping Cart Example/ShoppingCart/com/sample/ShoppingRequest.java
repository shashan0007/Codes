package com.sample;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingRequest extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Sports Cart</title></head><body><form method=\"POST\" action=\"http://localhost:8080/examples/servlet/AddCart\""
		+"<p><font size=\"5\">G3 Shopping Cart</font></p><p><font size=\"4\">Sports :</font></p><p>&nbsp;&nbsp;&nbsp; 1: Complete Cricket&nbsp; kit&nbsp;($100)&nbsp;&nbsp;&nbsp;"
		+"<input type=\"checkbox\" name=\"T1\" value=\"ON\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantity<input type=\"text\" name=\"T2\" size=\"7\"></p>"
		+"<p>&nbsp;&nbsp;&nbsp; 2: Complete Soccer&nbsp; kit ($100)&nbsp;&nbsp;&nbsp;&nbsp;"
		+"<input type=\"checkbox\" name=\"T3\" value=\"ON\">&nbsp;&nbsp;&nbsp;&nbsp; Quantity"+"<input type=\"text\" name=\"T4\" size=\"7\"></p><p><font size=\"4\">Perfumes :</font></p><p>&nbsp;&nbsp;&nbsp; 1: Blue Jeans($50)<input type=\"checkbox\" name=\"T5\" value=\"ON\">&nbsp;&nbsp;&nbsp; Quantity<input type=\"text\" name=\"T6\" size=\"7\"></p><p>&nbsp;&nbsp;&nbsp; 2: Polo Sport($80)<input type=\"checkbox\" name=\"T7\" value=\"ON\">&nbsp;&nbsp;&nbsp;&nbsp;Quantity <input type=\"text\" name=\"T8\" size=\"7\"></p><p><font size=\"4\">Cigarettes :</font></p><p>&nbsp;&nbsp;&nbsp; 1: Marlboro($10)<input type=\"checkbox\" name=\"T9\" value=\"ON\">&nbsp;&nbsp;&nbsp;&nbsp;Quantity <input type=\"text\" name=\"T10\" size=\"7\"></p><p>&nbsp;&nbsp;&nbsp; 2: Dunhill($10)<input type=\"checkbox\" name=\"T11\" value=\"ON\">&nbsp;&nbsp;&nbsp;&nbsp;Quantity <input type=\"text\" name=\"T12\" size=\"7\"></p><blockquote>  <blockquote><blockquote><p><input type=\"submit\" value=\"Add to Cart\" name=\"B3\"></p>    </blockquote></blockquote></blockquote></form></body></html>");
	}
}
