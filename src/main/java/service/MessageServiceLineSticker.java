package service;
import java.io.DataOutputStream; 
import java.net.HttpURLConnection;
import java.net.URL;
// James Line 的 token: bBI6xHXkzdGvByMcaq3Fk90XFa1YhDhZ943trR3XoXI
// 段老師 JavaWeb20220418 的 token: 4XGBZDsHPktsnlr86pWfLjafzINTthGvHENxerDj9ec
public class MessageServiceLineSticker {	
		private String token = "4XGBZDsHPktsnlr86pWfLjafzINTthGvHENxerDj9ec";		
		
		public int pushMessageAndWebImage(String content, String webImageUrl) {
			// 推播程序 ...
			// 設定發送位置
			String lineNotifyUrl = "https://notify-api.line.me/api/notify";
			int httpCode = 0;
			try {
				// 將要發送的訊息轉為 byte[] 並寫編碼
				byte[] postData = ("message=" + content + "&imageThumbnail=" + webImageUrl + "&imageFullsize=" + webImageUrl).getBytes("UTF-8");
				// 建立 URL 物件
				URL url = new URL(lineNotifyUrl);
				// 建立 HttpURLConnection 連線物件
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				// 定義授權 Header
				// Bearer 支援 TLS 進階版的 SSL 加密技術
				conn.setRequestProperty("Authorization", "Bearer " + token);
				//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setUseCaches(false);
				// 發送並回應
				try(DataOutputStream oos = new DataOutputStream(conn.getOutputStream())) {
					oos.write(postData);
					oos.flush();
				}
				if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					httpCode = conn.getResponseCode();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 回應碼
			return httpCode;
		}
		
		public int pushMessageAndSticker(String content, String stickerPackageId, String stickerId) {
			// 推播程序 ...
			// 設定發送位置
			String lineNotifyUrl = "https://notify-api.line.me/api/notify";
			int httpCode = 0;
			try {
				// 將要發送的訊息轉為 byte[] 並寫編碼
				byte[] postData = ("message=" + content + "&stickerPackageId=" + stickerPackageId + "&stickerId=" + stickerId).getBytes("UTF-8");
				// 建立 URL 物件
				URL url = new URL(lineNotifyUrl);
				// 建立 HttpURLConnection 連線物件
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				// 定義授權 Header
				// Bearer 支援 TLS 進階版的 SSL 加密技術
				conn.setRequestProperty("Authorization", "Bearer " + token);
				//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setUseCaches(false);
				// 發送並回應
				try(DataOutputStream oos = new DataOutputStream(conn.getOutputStream())) {
					oos.write(postData);
					oos.flush();
				}
				if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					httpCode = conn.getResponseCode();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 回應碼
			return httpCode;
		}
		
		public int pushMessage(String content) {
			// 推播程序 ...
			// 設定發送位置
			String lineNotifyUrl = "https://notify-api.line.me/api/notify";
			int httpCode = 0;
			try {
				// 將要發送的訊息轉為 byte[] 並寫編碼
				byte[] postData = ("message=" + content).getBytes("UTF-8");
				// 建立 URL 物件
				URL url = new URL(lineNotifyUrl);
				// 建立 HttpURLConnection 連線物件
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				// 定義授權 Header
				// Bearer 支援 TLS 進階版的 SSL 加密技術
				conn.setRequestProperty("Authorization", "Bearer " + token);
				//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setUseCaches(false);
				// 發送並回應
				try(DataOutputStream oos = new DataOutputStream(conn.getOutputStream())) {
					oos.write(postData);
					oos.flush();
				}
				if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					httpCode = conn.getResponseCode();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 回應碼
			return httpCode;
		}
}
