






package synjones.dreams.service;

import java.util.ArrayList;

import java.util.List;


import org.ksoap2.serialization.SoapObject;

import synjones.common.WebServiceHelper;


public class WeatherReportService {

	private final String nameSpaceString="http://WebXml.com.cn/";
	private final String wsdlString="http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
	private final String gerProviceMethod="getSupportProvince";
	private final String getCityMethod="getSupportCity";
	private final String getWeatherCityString="getWeatherbyCityName";
	
	public List<String> GetProvinces(){
	List<String> provinceList=new ArrayList<String>();
		WebServiceHelper webServiceHelper=new WebServiceHelper(nameSpaceString, wsdlString, gerProviceMethod);
		SoapObject result=(SoapObject)webServiceHelper.doGetWebSoapObject();
		int count=result.getPropertyCount();
		for(int i=0;i<count;i++)
		{
			provinceList.add(result.getProperty(i).toString());
		}
		return provinceList;
	}
	
	public List<String> GetCitys(String province) {
		List<String> cityStrings=new ArrayList<String>();
		WebServiceHelper webServiceHelper=new WebServiceHelper(nameSpaceString, wsdlString, getCityMethod);
//		Map<String, String> postData=new HashMap<String, String>();
//		postData.put("byProvinceName", province);
		webServiceHelper.Put("byProvinceName", province);
		SoapObject result=(SoapObject)webServiceHelper.doGetWebSoapObject();
		int count=result.getPropertyCount();
		for(int i=0;i<count;i++)
		{
			cityStrings.add(result.getProperty(i).toString());
		}
		return cityStrings;
		
	}
	
	public String GetWeatherInfo(String cityName) {
		WebServiceHelper webServiceHelper=new WebServiceHelper(nameSpaceString,wsdlString,getWeatherCityString);
//		Map<String, String> postData=new HashMap<String, String>();
//		postData.put("theCityName", cityName);
		webServiceHelper.Put("theCityName", cityName);
		SoapObject result=(SoapObject)webServiceHelper.doGetWebSoapObject();
		String weatherString="";
		for (int i = 0; i < result.getPropertyCount(); i++) {
			weatherString+=result.getProperty(i).toString()+"\n";
		}
		return weatherString;
	}
}


