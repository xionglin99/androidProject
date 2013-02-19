package synjones.dreams.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import synjones.common.HttpUtil;
import synjones.common.WebServiceHelper;
import android.util.Log;
import android.widget.SlidingDrawer;
import synjones.dreams.android.R.string;
import synjones.dreams.iservice.ICardManageService;
import synjones.dreams.models.CardInfo;
import synjones.dreams.models.TrjnInfo;

import org.ksoap2.serialization.SoapObject;

//一卡通相关操作服务类
public class CardManageService extends BaseService implements ICardManageService  {
	
	
	
	
	
	
	public CardInfo GetCardInfoDemo(String CardNo) {
		CardInfo cardInfo = new CardInfo();
		cardInfo.setBankBalance("100");
		cardInfo.setBankNo("6220202000");
		cardInfo.setSno("0090052");
		cardInfo.setCardBalance("10");
		cardInfo.setCardNo(CardNo);
		return cardInfo;
	}

	
	

	public CardInfo GetCardInfoWeb(String cardno) {
		 HttpUtil httpUtil = new HttpUtil();
		String headString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r<soap:Body>\r";
		String footString = "\r</soap:Body>\r</soap:Envelope>";
		String getCardWebServiceUrlString = "http://192.168.18.20:8901/GDSC/CardProxyService.asmx?op=GetCardInfo";

		// CardInfo cardInfo=new CardInfo();
		String requeString = headString
				+ "<GetCardInfo xmlns=\"http://tempuri.org/\">\r<account>"
				+ cardno + "</account>\r</GetCardInfo>";
		requeString += footString;
		Log.i("Test", requeString);
		String resultString = httpUtil.DoConnection(getCardWebServiceUrlString,
				"POST", "application/xml; charset=utf-8",
				requeString.getBytes());
		return paresXmsStrToCardInfo(resultString);

	}

	/**
	 * 验证卡号密码
	 * 
	 * @param cardno
	 * @param password
	 * @return boolean
	 */
	public boolean VerifyAccountDemo(String cardno, String password) {
		return true;
	}

	/**
	 * 支付
	 * 
	 * @return boolean
	 */
	public boolean DoPay() {
		return true;
	}

	private CardInfo paresXmsStrToCardInfo(String xmlString) {
		return new CardInfo();
	}

	public CardInfo GetCardInfo(String sk) {
//		String wsdlString = "http://192.168.18.20:8901/GDSC/CardProxyService.asmx?wsdl";
//		String nameSpaceString = "http://tempuri.org/";
//		String getCardInfoMethod = "GetCardInfo";
//		WebServiceHelper helper = new WebServiceHelper(nameSpaceString,
//				wsdlString, getCardInfoMethod);
//		helper.Put("account", cardno);
//		SoapObject resultObject = (SoapObject) helper.doGetWebSoapObject();
//		String snoString = resultObject.getProperty("sno").toString();
//		CardInfo cardInfo = new CardInfo();
//		cardInfo.setSno(snoString);
		String urlString="/SynCard/GetCardInfo";
		String sendDateString=CookieKey+"="+sk;
		HttpWebService webService=new HttpWebService(urlString,sendDateString);
		String resultString= webService.DoRequest();
		return new CardInfo();
	}

	public String CheckIn(String account, String password) {
		// WebServiceHelper helper = new WebServiceHelper(nameSpaceString,
		// wsdlString, "VerifyAccount");
		// helper.Put("account", cardno);
		// helper.Put("password", password);
		// SoapObject result = (SoapObject) helper.doGetWebSoapObject();
		// return result.getProperty(0).toString().equals("true");
		// return cardno.equals("255790") && password.equals("123456");
		String url = "/Account/CheckIn";
		String sendData = "account=" + account + "&&password=" + password;
		
		HttpWebService webService=new HttpWebService(url, sendData);
		return webService.DoRequest();
	}
	
	public String IsCheckIn(String sk)
	{
		HttpWebService webService=new HttpWebService("/Account/IsCheckIn", CookieKey+"="+sk);
		return webService.DoRequest();
	}
	
	public void CheckOut(String sk)
	{
		HttpWebService webService=new HttpWebService("/Account/CheckOut",CookieKey+"="+sk);
		webService.DoRequest();
	}
	

	public String GetHelloWord() {

		return "";
	}

	@Override
	public String GetBankBalance(String cardno, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrjnInfo> GetCurrentDayTrjn(String sk) {
		// TODO Auto-generated method stub
		HttpWebService webService=new HttpWebService("/SynCard/GetCurrentTrjn",CookieKey+"="+sk);
		String jsonString= webService.DoRequest();
		return new ArrayList<TrjnInfo>();
	}

	@Override
	public List<TrjnInfo> GetHistoryTrjns(String beginDate, String endDate,
			String sk) {
		// TODO Auto-generated method stub
		String urlString="/SynCard/GetHistoryTrjn";
		String sendDateString="startTime="+beginDate+"&endTime="+endDate+"&"+CookieKey+"="+sk;
		HttpWebService webService=new HttpWebService(urlString,sendDateString);
		webService.DoRequest();
		return null;
	}

	@Override
	public Boolean SetCardLoss(String sk, String pwd) {
		// TODO Auto-generated method stub
		String urlString="/SynCard/HangupCard";
		String sendDateString="cpassword="+pwd+"&"+CookieKey+"="+sk;
		HttpWebService webService=new HttpWebService(urlString, sendDateString);
		webService.DoRequest();
		return null;
	}

	@Override
	public Boolean SetCardUnLoss(String cardno, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ChangeQueryPwd(String sk, String pwd, String newPwd) {
		// TODO Auto-generated method stub
		String urlString="/SynCard/ChangeQueryPwd";
		String sendDateString="oldPwd="+pwd+"&newPwd="+newPwd+"&"+CookieKey+"="+sk;
		HttpWebService webService=new  HttpWebService(urlString,sendDateString);
		String resultString=webService.DoRequest();
		return null;
	}

	@Override
	public Boolean DoBankPay(String sno, String pwd, float amt,
			String toAccount, String trjn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean BankToCardTransfer(String sk, String pwd, float amt) {
		// TODO Auto-generated method stub
		String urlString="/SynPay/BankToCard";
		String sendDateString="cpassword="+pwd+"&amount="+amt+"&"+CookieKey+"="+sk;
		HttpWebService webService=new HttpWebService(urlString,sendDateString);
		webService.DoRequest();
		return null;
	}
}
