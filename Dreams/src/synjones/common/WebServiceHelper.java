package synjones.common;
import java.util.HashMap;
import java.util.Map;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
public class WebServiceHelper {
	private String serviceNamespace;
	private String serviceMethod;
	private String WSDL;

	public WebServiceHelper(String serviceNamespace, String WSDL,
			String serviceMehtod) {
		this.WSDL = WSDL;
		this.serviceMethod = serviceMehtod;
		this.serviceNamespace = serviceNamespace;
	}

	public Object doGetWebSoapObject() {
		// 实例化Soap对象
		SoapObject request = new SoapObject(serviceNamespace, serviceMethod);
		// 加请求参数
		if (postDataMap != null && !postDataMap.isEmpty()) {
			for (Map.Entry<String, String> entry : postDataMap.entrySet()) {
				request.addProperty(entry.getKey(), entry.getValue());
			}
		}
		// 获得序列化的Soap
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.bodyOut = request;// envelope.setOutputSoapObject(request);
		envelope.dotNet = true;
		HttpTransportSE transportSE = new HttpTransportSE(WSDL);
		try {
			transportSE.call(serviceNamespace + serviceMethod, envelope);
			return envelope.getResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<String, String> postDataMap;

	public void Put(String key, String value) {
		if (postDataMap == null)
			postDataMap = new HashMap<String, String>();
		postDataMap.put(key, value);
	}

}
