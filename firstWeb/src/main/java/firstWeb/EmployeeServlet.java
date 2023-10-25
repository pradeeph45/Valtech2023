package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{
	private EmployeeDAO dao=new EmployeeDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess=req.getSession(true);
			sess.setAttribute("current", dao.firstId());
			req.setAttribute("emp", dao.getEmployee(dao.firstId()));
			//req.getRequestDispatcher("employee.jsp").forward(req, resp);
			resp.sendRedirect("employee.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		int current=(Integer)sess.getAttribute("current");
		String submit=req.getParameter("submit");
		if("First".equals(submit)) {
			try {
				current=dao.firstId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("Last".equals(submit)) {
			try {
				current=dao.lastId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("Next".equals(submit)) {
			try {
				current=dao.nextId(current);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("Previous".equals(submit)) {
			try {
				current=dao.previousId(current);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sess.setAttribute("current", current);
		try {
			req.setAttribute("emp", dao.getEmployee(current));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
