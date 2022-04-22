package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/lucky/number")
public class LuckyNumberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		
		Random random = new Random();
		int randomLuckyNumber = random.nextInt(100) + 1;
		PrintWriter out = res.getWriter();					
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='color: red'>");
		out.println("得到 Lucky Number (1 ~ 100): " + randomLuckyNumber);
		out.println("<h3 style='color: blue'>");
		out.println(String.format("得到 Lucky Number (1 ~ 100): %d", randomLuckyNumber));
		out.println("</h1>");
		out.println("</body>");
		out.print("</html>");	
	}
}
