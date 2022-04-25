package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
// WebServlet 配置資訊
// 本程式的服務網址: 請參考 (1) web.xml 的配置設定 or (2) @WebServlet("xxx")
// 當 (1) 和 (2) 同時配置服務網址時，以 (1) 為主
@WebServlet("/TodayServlet") 
public class TodayServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("utf-8"); // servlet utf-8
		res.setContentType("text/html;charset=utf-8"); // client utf-8		
		PrintWriter out = res.getWriter();		
		out.print("Today is my day! " + new Date());
	}
}

