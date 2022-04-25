package servlet;
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/bmi")
public class BMIHttpServlet extends HttpServlet {	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		Double bmi = null;
		res.setCharacterEncoding("utf-8"); // servlet utf-8
		res.setContentType("text/html;charset=utf-8"); // client utf-8
		PrintWriter out = res.getWriter();
		out.println("call by get");
		bmi = Integer.valueOf(height)/Math.sqrt(Double.valueOf(weight));
		out.printf("BMI: %.2f, based on call by get", bmi);
		
		// 第二種方式 (支援陣列)
		// 案例1: h=170&w=60 得到 170 與 60
		// 案例2: h=170,171,172&w=60,61,62 得到 [170,171,172] 與 [60,61,62]
//		/*
		Map<String, String[]> map = req.getParameterMap();
		String[] heights = map.get("h");
		String[] weights = map.get("w");
		out.println("<p>");
		out.println("heights = " + Arrays.toString(heights));
		out.println("<p>");
		out.println("weights = " + Arrays.toString(weights));
//		*/
		// 第三種方式 (支援陣列)
		/*
		String[] heights = req.getParameterValues("h");
		String[] weights = req.getParameterValues("w");
		out.println("<p>");
		out.println("heights = " + Arrays.toString(heights));
		out.println("<p>");
		out.println("weights = " + Arrays.toString(weights));
		out.println("<p>");
		// 得到所有參數名
		Enumeration<String> names = req.getParameterNames();
		out.println("得到參數名稱:");
		while (names.hasMoreElements()) {
			out.println(names.nextElement() + " ");
		}
		*/
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		Double bmi = null;

		PrintWriter out = res.getWriter();
		out.println("call by post");
		bmi = Integer.valueOf(height)/Math.sqrt(Double.valueOf(weight));		
		out.printf("BMI: %.2f, based on call by post", bmi);
	}

}
