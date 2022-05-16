package filter;
import java.io.IOException; 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/servlet/*")
public class WatermarkFilter  extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyResponse myResponse = new MyResponse(res);
		chain.doFilter(req, myResponse); // 貍貓換太子  res 變成 myResponse
		// 取得回傳的 HTML 原始碼
		String html = myResponse.getHTMLSource();
		// (1) 針對 html 的路徑是在 "/servlet/*" 裡面的程式碼，其回傳頁面有 <body 的，由 <body bgcolor='red' 取代		 
		// html = html.replaceAll("<body", "<body bgcolor='red' ");
		// (2) 針對 html 的路徑是在 "/servlet/*" 裡面的程式碼，其回傳頁面有 <body 的，由 浮水印 取代
		html = html.replaceAll("<body", "<body background='/JavaWeb-20220418/image/watermark.jpg' ");
		// 將資料重寫回給瀏覽器
		res.getWriter().print(html);
		
	}	
}
