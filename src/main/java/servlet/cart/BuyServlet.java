package servlet.cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/servlet/cart/buy")
public class BuyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<String> products = null;
		//第一種寫法
		/*************************************************************************************
		System.out.println(session);		
		synchronized (session) {
		// 是否 product 的 session 變數已經存在 ? 
			System.out.println(session.getAttribute("products"));
			if(session.getAttribute("products") == null) { // 第一次買東西
				products = new ArrayList<>(); // ArrayList 非多執行續 Safe，因此需用 synchroized
				System.out.println(products);
			} else {
				products = (List<String>) session.getAttribute("products");				
			}
			// 取得購買商品
			String product = req.getParameter("product");
			System.out.println(product);
			// 將商品放置購物車內容中
			products.add(product);
			// 將 products 回存到 session 變數中
			session.setAttribute("products", products);		
			System.out.println(session.getAttribute("products"));
		}
		/**************************************************************************************/		
		// 第二種寫法
//		/*************************************************************************************
		// 是否 product 的 session 變數已經存在 ?
		System.out.println(session);
		System.out.println(session.getAttribute("products"));
		if (session.getAttribute("products") == null) { // 第一次買東西			
			products = new CopyOnWriteArrayList<>(); // CopyOnWriteArrayList 多執行續 Safe
			System.out.println(products);
		} else {
			products = (List<String>) session.getAttribute("products");				
		}
		// 取得購買商品
		String product = req.getParameter("product");
		System.out.println(product);
		// 將商品放置購物車內容中
		products.add(product);
		// 將 products 回存到 session 變數中
		session.setAttribute("products", products);		
		System.out.println(session.getAttribute("products"));
//		/**************************************************************************************/	
		// 重導到 "/servlet/cart/view"
		RequestDispatcher rd = req.getRequestDispatcher("/servlet/cart/view");
		rd.forward(req, resp);
	}	
}





