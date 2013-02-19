package synjones.dreams.service;

import synjones.dreams.iservice.IPayPowerFeeService;

public class PayPowerfeeService extends BaseService implements
		IPayPowerFeeService {

	@Override
	public boolean IsExist(String xiaoqu, String bulid, String room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float GetBalance(String xiaoqu, String bulid, String room) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Pay(String sk, String xiaoqu, String build, String room,
			String cpassword, float amt) {
		// TODO Auto-generated method stub
		String urlString = "/SynPay/PayPowerFee";
		String sendDateString = "cpassword=" + cpassword + "&buildnum=" + build
				+ "&roomnum=" + room + "&amount=" + amt + "&"
				+ GetCookieString(sk);
		HttpWebService webService = new HttpWebService(urlString,
				sendDateString);
		String resultString = webService.DoRequest();
		return false;
	}

}
