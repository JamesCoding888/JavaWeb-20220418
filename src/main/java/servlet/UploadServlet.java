package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
@WebServlet("/servlet/upload")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 30 // 30 MB
)
public class UploadServlet extends HttpServlet{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// cname, upload_file
		// 找到 cname 的值
		req.getParts().stream()
					  .filter(part -> part.getName()
				      .equals("cname"))
					  .forEach(part -> {
						  try {
							  String cname = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
							  out.print(part.getName() + ":" + cname);
						} catch (Exception e) {
							// TODO: handle exception
						}
					  });
		// 找到 upload_file 的值
		// 將上傳圖片存放在 C:\Users\jamesliao\eclipse-workspace-web\picture
		req.getParts().stream()
					  .filter(part -> part.getName().equals("upload_file"))
					  .forEach(part -> {
							try {
								// 取得上傳的圖片檔名
								String fname = part.getSubmittedFileName();
								// 存檔路徑 - 第一種方式
								part.write("C:\\Users\\jamesliao\\eclipse-workspace-web\\picture\\" + fname);
								// 存檔路徑 - 第二種方式
								// part.write("C:/Users/jamesliao/eclipse-workspace-web/picture/" + fname);
							} catch (Exception e) {
								e.printStackTrace();
							}
					  });	
	}
}
