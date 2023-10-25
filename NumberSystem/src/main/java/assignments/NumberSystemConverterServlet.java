package assignments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NumberSystemConverterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numberSystem = request.getParameter("number");
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		int sum = n1 + n2;
		PrintWriter out=response.getWriter();
		String binary,octal,hex;
		
		if ("Binary".equals(numberSystem)) {

			 binary = Integer.toBinaryString(sum);
			 request.setAttribute("result",binary);
			 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
//			 out.println("The Result is "+binary);

		}
		else if("Octal".equals(numberSystem)) {
			 octal=Integer.toOctalString(sum);
			 request.setAttribute("result",octal);
			 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
//			 out.println("The Result is "+octal);
		}
		else if("Hexadecimal".equals(numberSystem)) {
			hex=Integer.toHexString(sum);
//			 out.println("The Result is "+hex);
			request.setAttribute("result",hex);
			 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}
	}

}

