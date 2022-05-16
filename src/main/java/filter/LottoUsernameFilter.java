package filter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
@WebFilter(urlPatterns = {"/servlet/lotto"}) // 定義要管理的 URL
public class LottoUsernameFilter extends HttpFilter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("執行 LottoUsernameFilter");
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		res.setCharacterEncoding("utf-8");
		
//		PrintWriter out = res.getWriter();
//		out.print("我是 LottoUsernameFilter");
		chain.doFilter(req, res);
		
	}
}
