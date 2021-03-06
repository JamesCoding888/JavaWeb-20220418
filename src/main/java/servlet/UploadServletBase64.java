package servlet;
import java.io.IOException; 
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
@WebServlet("/servlet/uploadBase64")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadServletBase64 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// cname, upload_file
		// 找到 cname 的值
		req.getParts().stream()
			.filter(part -> part.getName().equals("cname"))
			.forEach(part -> {
				try {
					String cname = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
					out.print(part.getName() + ":" + cname);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		// 找到 upload_file 的值
		// 將上傳圖片存放在 C:\Users\jamesliao\eclipse-workspace-web\picture
		req.getParts().stream()
		.filter(part -> part.getName().equals("upload_file"))
		.forEach(part -> {
			try {
				// 製作 base64 圖片碼 
				// 步驟將 InputStream -> byte[] --> base64 字串
				InputStream is = part.getInputStream();
				byte[] bytes = IOUtils.toByteArray(is);
				String base64 = Base64.getEncoder().encodeToString(bytes);
				// 建立 HTML src 標籤
				String imageHtml = "<img src='data:image/png;base64, %s'>";
				// 將 HTML src 標籤與 base64 融合
				out.print(String.format(imageHtml, base64));
				
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