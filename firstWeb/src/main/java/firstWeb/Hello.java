package firstWeb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Driver Class = "+config.getInitParameter("driver-class"));
		System.out.println("JDBC Url = "+config.getInitParameter("jdbc-url"));
		System.out.println("Username = "+config.getInitParameter("username"));
		System.out.println("Password = "+config.getInitParameter("password"));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		resp.getWriter().print("Hello");
	}

}
