package synjones.dreams.test;

import synjones.common.HttpUtil;
import synjones.dreams.service.CardManageService;
import synjones.dreams.service.HttpWebService;
import android.test.AndroidTestCase;

public class HttpUtilTest extends AndroidTestCase {

	public void TestDoConnection()
	{
		HttpUtil util=new HttpUtil();
	    String getData=util.DoConnection("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo",
				"POST","application/xml; charset=utf-8","".getBytes());
	    //System.out.println("123");
	    System.out.print(getData);
	    //assertEquals(getData, "test");
	//assertEquals(expected, actual)
	}
	
	public void TestCheckIn()
	{
 CardManageService service=new CardManageService();
 String resultString=service.CheckIn("123", "123");
	}
}
