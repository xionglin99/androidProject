package synjones.dreams.iservice;

public interface IPayNetFeeService {

	/**
	 * �ж������˻��Ƿ����
	 * 
	 * @param xiaoqu
	 * @param account
	 * @return
	 */
	boolean IsExist(String xiaoqu, String account);

	/**
	 * ��ȡ�˻����
	 * 
	 * @param xiaoqu
	 * @param account
	 * @return
	 */
	float GetBalance(String xiaoqu, String account);

	/**
	 * Ϊ�����˻���ֵ
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
