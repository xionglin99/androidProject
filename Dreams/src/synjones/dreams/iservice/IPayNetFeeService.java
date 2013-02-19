package synjones.dreams.iservice;

public interface IPayNetFeeService {

	/**
	 * 判断网费账户是否存在
	 * 
	 * @param xiaoqu
	 * @param account
	 * @return
	 */
	boolean IsExist(String xiaoqu, String account);

	/**
	 * 获取账户余额
	 * 
	 * @param xiaoqu
	 * @param account
	 * @return
	 */
	float GetBalance(String xiaoqu, String account);

	/**
	 * 为网费账户充值
	 * 
	 * @param sno
	 * @param xiaoqu
	 * @param account
	 * @param amt
	 * @param sn
	 * @return
	 */
	boolean Pay(String sk, String xiaoqu, String account, float amt, String cpassword);
}
