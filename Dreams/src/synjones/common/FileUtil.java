package synjones.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.os.Environment;
import android.util.Log;

public class FileUtil {
	private final String tag="FileUtil";
	//private Context context;

//	public FileUtil(Context context) {
//		this.context = context;
//	}

	public void SaveToCard(String filename, String content) throws Exception {
		Log.i("fileservice", Environment.getExternalStorageDirectory()
				.getAbsolutePath());
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), filename);
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(content.getBytes());
		outputStream.close();
	}
	
	public String ReadFromFile(String filename)
	{
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), filename);
	FileInputStream inputStream;
	try {
		inputStream = new FileInputStream(file);
		String resultString=new String(new HttpUtil().readInputStream(inputStream));
		Log.i(tag, resultString);
		return resultString;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "";
	}

	}
}
