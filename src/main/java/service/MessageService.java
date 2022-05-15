package service;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class MessageService {	
		private String token = "";		
		public int pushMessage(String content) {
			// 推播程序 ...
			// 設定發送位置
			String lineNotifyUrl = "https://notify-api.line.me/api/notify";
			int httpCode = 0;
			try {
				// 將要發送的訊息轉為 byte[] 並寫編碼 
				// "message=" + content -> 明碼
				byte[] postData = ("message=" + content).getBytes("utf-8");
				// 建立 URL 物件
				URL url = new URL(lineNotifyUrl);
				// 建立 HttpURLConnection 連線物件
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); 
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setRequestMethod("POST");
				// 定義授權 Header
				// Bearer 支援 TLS 進階版的 SLL 加密技術
				httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);
				httpURLConnection.setUseCaches(false);
				// 發送並回應
				try(DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream())) {
					dataOutputStream.write(postData);
					dataOutputStream.flush();										
				} 
				if(httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					httpCode = httpURLConnection.getResponseCode();				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			 
			// 回應碼		
			return httpCode;			
		}		
}
