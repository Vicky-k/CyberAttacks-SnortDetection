import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Passwordver extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String s1 = req.getParameter("username");
		String s2 = req.getParameter("password");
		if(s1.equals("missouri")&&s2.equals("kansascity"))
		out.println("Login successful");
		else
		out.println("Login Unsuccessful");
	}
}