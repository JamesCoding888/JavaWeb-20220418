package guestbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.entity.Guestbook;
import guestbook.service.JPAService;
@WebServlet("/guestbook/get")
public class GetGuestbook extends HttpServlet{
	
	private JPAService service = new JPAService();
	

	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Guestbook guestbook = service.getGuestbookById(id);	
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_view.jsp");
		req.setAttribute("guestbooks", service.queryGuestbook());		
		req.setAttribute("button_name", "update"); // 改成 update
		// 1) 不建議這樣做，如果表單有很多個欄位，那我不就要在這底下做很多個物件呼叫
		req.setAttribute("id", guestbook.getId()); // // 傳給 jsp 並收到 form 表單中使用
		req.setAttribute("username", guestbook.getUsername()); // 傳給 jsp 並收到 form 表單中使用
		req.setAttribute("content", guestbook.getContent()); // 傳給 jsp 並收到 form 表單中使用
		// 2) 建議這樣做		
		req.setAttribute("guestbook", guestbook); // 傳給 jsp 並放到 form 表單中使用
		
		
		rd.forward(req, resp);
		


		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	

}
