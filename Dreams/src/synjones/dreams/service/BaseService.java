package synjones.dreams.service;

public class BaseService {
	public String CookieKey = "iPlantinfo";

	public String GetCookieString(String sk) {

		return CookieKey + "=" + sk;
	}
}
