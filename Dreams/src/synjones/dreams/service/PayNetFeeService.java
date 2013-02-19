package synjones.dreams.service;

import synjones.dreams.iservice.IPayNetFeeService;

public class PayNetFeeService extends BaseService implements IPayNetFeeService {

	@Override
	public boolean IsExist(String xiaoqu, String account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float GetBalance(String xiaoqu, String account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Pay(String sk, String xiaoqu, String cpassword, float amt,
			String sn) {
		// TODO Auto-generated method stub
		String urlString = "/SynPay/PayPowerFee";
		String sendDateString = "cpassword=" + cpassword + "&amount=" + amt
				+ "&" + GetCookieString(sk);
		HttpWebService webService = new HttpWebService(urlString,
				sendDateString);
		webService.DoRequest();
		return false;
	}

}
