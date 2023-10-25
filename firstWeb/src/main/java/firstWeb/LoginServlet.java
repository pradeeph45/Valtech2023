package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().print("User Name = "+request.getParameter("name") + "Password = "+request.getParameter("password"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if("root".equals(name) && "root".equals(password)){
			request.setAttribute("message", "Hi root... How have you been");
		}
		else {
			request.setAttribute("message","Only root is a valid user");
		}
		request.getRequestDispatcher("LoginResults.jsp").forward(request, response);
				
	}
}

/* TODO if name and password is wrong show the login page with message
 * if name is less than 4 chars then add message and login page
 * if password is less than 8 chars then add message and login page*/
