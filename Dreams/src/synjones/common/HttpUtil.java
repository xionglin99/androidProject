package synjones.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public String DoConnection(String url, String requestMethod,String contentType,byte[] data) {
		URL url2;
		try {
			url2 = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) url2
					.openConnection();
			connection.setRequestMethod(requestMethod);
			connection.setReadTimeout(6 * 1000);
			//"application/xml; charset=utf-8"
			connection.setRequestProperty("Content-Type",contentType);  
			connection.setRequestProperty("Content-Length", String.valueOf(data.length));  
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			//connection.
			
			//outputStream.write(maps.);
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
			if (connection.getResponseCode() == 200) {
				InputStream inputStream = connection.getInputStream();
				byte[] inBytes = readInputStream(inputStream);
				String aString = new String(inBytes);
				//String result = new String(aString.getBytes("utf-8"),"utf-8");
				System.out.print(aString);
				return aString;
			} else {
				System.out.print(connection.getResponseMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";

	}

	public byte[] readInputStream(InputStream inputStream) throws Exception {
		byte[] buffer = new byte[1024];
		int len = -1;
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inputStream.close();
		return outSteam.toByteArray();
	}
}
