package synjones.dreams.service;

import java.util.HashMap;
import java.util.Map;


import synjones.common.FileUtil;
import synjones.common.HttpUtil;
import synjones.common.XmlUtil;
import android.util.Log;

public class HttpWebService {

	/**
	 * 手机归属地查询
	 * 
	 * @param phone
	 * @return
	 */
	public HttpWebService(){}
	public HttpWebService(String url,String sendDate)
	{
		setUrl(url);
		setSendDate(sendDate.getBytes());
	}
	
	private String getphonerequeString = "";

	private  String ContentType = "application/soap+xml; charset=utf-8";
	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}
	
	private byte[] SendDate;

	public byte[] getSendDate() {
		return SendDate;
	}
	public void setSendDate(byte[] sendDate) {
		SendDate = sendDate;
	}

	private String Domain = "http://ykt.nwpu.edu.cn";
	private String Url="";
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}

	private String RequestMethod = "POST";
	public String getRequestMethod() {
		return RequestMethod;
	}

	public void setRequestMethod(String method) {
		RequestMethod = method;
	}

	//private final String contenttype = "application/soap+xml; charset=utf-8";
	
	
	

	private HttpUtil httpUtil;
	private XmlUtil xmlUtil;
	private final String tag = "HttpWebService";

	public String DoRequest()
	{   httpUtil=new HttpUtil();
		return httpUtil.DoConnection(Domain+Url, RequestMethod, ContentType, SendDate);
	}
	public String GetPhoneAddr(String url, String phone) {
		String sendDataString = getSendDataString(phone);
		Log.i(tag, sendDataString);
		httpUtil = new HttpUtil();
		String resultString = httpUtil.DoConnection(url, "POST", ContentType,
				sendDataString.getBytes());
		return resultString;
	}

	private String getSendDataString(String phone) {
		if ("".equals(getphonerequeString)) {
			getphonerequeString = new FileUtil().ReadFromFile("soap.xml");
		}
		xmlUtil = new XmlUtil();
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("mobile", phone);
		return xmlUtil.ReplaceXml(getphonerequeString, maps);

	}
}
