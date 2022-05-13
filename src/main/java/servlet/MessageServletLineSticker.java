package servlet;
import java.io.IOException;   
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MessageServiceLineSticker;
@WebServlet("/servlet/message/linesticker")
public class MessageServletLineSticker extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 接收前端來的資料
		String content = req.getParameter("content");
		String stickerPackageId = req.getParameter("stickerPackageId");
		String stickerId = req.getParameter("stickerId");
		String webImageUrl = req.getParameter("webImageUrl");
		// 建立推播服務
		MessageServiceLineSticker messageServiceLineSticker = new MessageServiceLineSticker();
		// 進行訊息推播並回傳 httpCode 狀態值
		//int httpCode = messageServiceLineSticker.pushMessageAndSticker(content);
		//int httpCode = messageServiceLineSticker.pushMessageAndSticker(content, stickerPackageId, stickerId);
		int httpCode = messageServiceLineSticker.pushMessageAndWebImage(content, webImageUrl);
		// 最後將必要訊息收集並重導給 jsp 去呈現
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/message_resultLineSticker.jsp");
		req.setAttribute("content", content);
		req.setAttribute("stickerId", stickerId);
		req.setAttribute("webImageUrl", webImageUrl);
		req.setAttribute("httpCode", httpCode);
		rd.forward(req, resp);
	}
}
