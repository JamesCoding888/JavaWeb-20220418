package servlet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 得到再 C:\Users\jamesliao\eclipse-workspace-web\picture\ghost.png 的圖片並呈現在網頁上
@WebServlet("/servlet/ghost/qr/image")
public class GhostQRServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		File file = new File("C:\\Users\\jamesliao\\eclipse-workspace-web\\picture\\ghost_qrcode.png");
		ServletOutputStream out = resp.getOutputStream();
		Files.copy(file.toPath(), out); // (file.toPath(), out) -> (圖片來源端, 目的端)
		out.close();
	}
	
}
