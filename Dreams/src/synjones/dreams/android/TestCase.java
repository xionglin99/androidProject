package synjones.dreams.android;

import java.util.List;
import synjones.dreams.models.CardInfo;
import synjones.dreams.service.CardManageService;
import synjones.dreams.service.WeatherReportService;
import android.test.AndroidTestCase;
import android.util.Log;

public class TestCase extends AndroidTestCase {

	public void test() {
		CardManageService service = new CardManageService();
		CardInfo cardInfo = service.GetCardInfoWeb("255790");
	 //String targetString=Properties.getProperty("target");
		
//		
//		HttpUtil util = new HttpUtil();
//		String getData = util
//				.DoConnection(
//						"http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo",
//						"POST", "".getBytes());
//		// System.out.println("123");
//		System.out.print(getData);
//		// String
//		// urlString="http://192.168.18.20:8901/GDSC/CardProxyService.asmx/HelloWorld";
//		String urlString = "http://192.168.18.20:8901/GDSC/CardProxyService.asmx?op=GetCardInfo";
//		try {
//			String webString = util.DoConnection(urlString, "POST",
//					"".getBytes());
//			System.out.print(webString);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// assertEquals(getData, "test");
	}

	public void TestGetCardInfo2() {
		CardManageService service = new CardManageService();
		CardInfo cardInfo = service.GetCardInfoWeb("255790");
		assertEquals(null, cardInfo);
	}
	
	
	private final String Tag = "ServiceTest";

	public void TestGetCardInfo() {
		CardManageService service = new CardManageService();
		CardInfo snoString = service.GetCardInfo("255790");
		assertEquals("0090052", snoString.getSno());
	}
	
	public void TestHelloWord()
	{
		CardManageService service=new CardManageService();
		String hello=service.GetHelloWord();
		assertEquals(hello, "Hello World");
	}

	public void TestGetProvice() {
		WeatherReportService service = new WeatherReportService();
		List<String> proviceStrings = service.GetProvinces();
		Log.i(Tag, proviceStrings.toString());
		assertEquals("123123", proviceStrings);
	}

	public void TestGetCitys() {
		WeatherReportService service = new WeatherReportService();
		List<String> cityList = service.GetCitys("ºþ±±");
		Log.i(Tag, cityList.toString());
		assertEquals("123213", cityList);
	}

	public void TestGetCityWeather() {
		WeatherReportService service = new WeatherReportService();
		String weatherString = service.GetWeatherInfo("Îäºº");
		Log.i(Tag, weatherString);
		assertEquals("easdfds", weatherString);
	}
}
