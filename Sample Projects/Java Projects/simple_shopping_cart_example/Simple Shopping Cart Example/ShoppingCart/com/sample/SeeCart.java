package com.sample;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SeeCart extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		double total=0;
		boolean flag=false;
		PrintWriter out = response.getWriter();
		Cookie cookies[] = request.getCookies();
        out.println("<html><head><title>Sports Cart (Cart Status)</title></head><body><center><h2><i><u>Current Status of Cart:</u></i></center><br><table border=1 width=100%><th>Item</th><th>Quantity</th><th>Price($)</th><th>Amount($)</th>");
        for (int i = 0; i < cookies.length; i+=2)
        {
            Cookie c = cookies[i];
            String name = c.getName();
            String value = c.getValue();
			if(value.equals("ON"))
			{
				flag=true;
				out.print("<tr>");
				String tempName=cookies[i+1].getName();
				String tempValue=cookies[i+1].getValue();
				if(tempName.equals("T2"))
				{
					out.print("<td><center>Complete Cricket Kit</center></td><td><center>"+ tempValue+"</center></td><td><center>100</center></td> <td><center>"+Double.parseDouble(tempValue)*100+"</center></td>");
					total+=Double.parseDouble(tempValue)*100;
				}
				else
				if(tempName.equals("T4"))
				{
					out.print("<td><center>Complete Soccer Kit</center></td><td><center>"+ tempValue+"</center></td><td><center>100</center></td> <td><center>"+Double.parseDouble(tempValue)*100+"</center></td>");
					total+=Double.parseDouble(tempValue)*100;
				}
				else
				if(tempName.equals("T6"))
				{
					out.print("<td><center>Blue Jeans</center></td><td><center>"+ tempValue+"</center></td><td><center>50</center></td> <td><center>"+Double.parseDouble(tempValue)*50+"</center></td>");
					total+=Double.parseDouble(tempValue)*50;
				}
				else
				if(tempName.equals("T8"))
				{
					out.print("<td><center>Polo Sport</center></td><td><center>"+ tempValue+"</center></td><td><center>80</center></td> <td><center>"+Double.parseDouble(tempValue)*80+"</center></td>");
					total+=Double.parseDouble(tempValue)*80;
				}
				else
				if(tempName.equals("T10"))
				{
					out.print("<td><center>Marlboro</center></td><td><center>"+ tempValue+"</center></td><td><center>10</center></td> <td><center>"+Double.parseDouble(tempValue)*10+"</center></td>");
					total+=Double.parseDouble(tempValue)*10;
				}
				else
				if(tempName.equals("T12"))
				{
					out.print("<td><center>Dunhill</center></td><td><center>"+ tempValue+"</center></td><td><center>10</center></td> <td><center>"+Double.parseDouble(tempValue)*10+"</center></td>");
					total+=Double.parseDouble(tempValue)*10;
				}
				out.print("</tr>");
			}
        }

        out.print("</table>");
        if(flag==true)
        {
			out.print("<br><b><h3>Total Amount = "+total+"</h3></b></body> </html>");
		}
		else
		{
			out.print("<br><b><center><h3>No Item was selected !! </center></h3><body></html>");
		}
	}
}
