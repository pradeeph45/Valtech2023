package departmentAndEmployees;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DepartmentServlet extends HttpServlet {
	
	private DepartmentDAO dept = new DepartmentDAOImpl();
	private EmployeeDAO emp = new EmployeeDAOImpl();

	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);
			sess.setAttribute("current", dept.firstDept());
			sess.setAttribute("dept", dept.getDepartment(dept.firstDept()));
			int current = (int) sess.getAttribute("current");
			List<Employee> emps = emp.getEmployeeByDeptId(current);
			sess.setAttribute("emps", emps);
//			System.out.println(emps.size());
			req.getRequestDispatcher("department.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sess = req.getSession();
		int current = (int) sess.getAttribute("current");
		String submit = req.getParameter("submit");

		try {
			if ("First".equals(submit)) {
				current = dept.firstDept();

			} else if ("Last".equals(submit)) {
				current = dept.lastDept();

			} else if ("Previous".equals(submit)) {
				current = dept.previousDept(current);

			} else if ("Next".equals(submit)) {
				current = dept.nextDept(current);
				
			}

			System.out.println("Current =" + current);

			sess.setAttribute("current", current);
			sess.setAttribute("dept", dept.getDepartment(current));

			List<Employee> emps = emp.getEmployeeByDeptId(current);
			sess.setAttribute("emps", emps);


			req.getRequestDispatcher("department.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
