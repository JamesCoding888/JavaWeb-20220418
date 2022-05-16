package filter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

// 測試 filter 有兩種，測試任一，請將另外註解掉
// 1. 測試 filter 不用 web.xml 的 <filter-mapping> 做配置
//@WebFilter(urlPatterns = {"/servlet/area"}) // 定義要管理的 URL
// 2. 測試，若要針對同一個 URL 自訂 Filter 的順序, 不可使用 @WebFilter 配置, 必須要在 web.xml 中手動配置
public class AreaFilterA extends HttpFilter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {		
		System.out.println("AreaFilterA");
		chain.doFilter(req, res);
	}
}
