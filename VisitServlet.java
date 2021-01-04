

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VisitServlet extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		String user=req.getParameter("uname");	
		
		out.println("Sorry "+user);
		out.println("<br>site is under constrution");
	}
}














