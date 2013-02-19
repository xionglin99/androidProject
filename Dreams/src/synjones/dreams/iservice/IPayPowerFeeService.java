package synjones.dreams.iservice;


public interface IPayPowerFeeService {

	/**
	 * �жϷ����Ƿ����
	 * 
	 * @param xiaoqu
	 *            У��
	 * @param bulid
	 *            ��Ԣ¥
	 * @param room
	 *            �����
	 * @return boolean
	 */
	boolean IsExist(String xiaoqu, String bulid, String room);

	/**
	 * ��ȡ���������
	 * 
	 * @param xiaoqu
	 *            У��
	 * @param bulid
	 *            ��Ԣ¥
	 * @param room
	 *            �����
	 * @return String
	 */
	float GetBalance(String xiaoqu, String bulid, String room);

	/**
	 * ������ӵ�
	 * 
	 * @param sno
	 *            ѧ����
	 * @param xiaoqu
	 *            У��
	 * @param bulid
	 *            ��Ԣ¥
	 * @param room
	 *            �����
	 * @param sn
	 *            ��ˮ��
	 * @param amt
	 *            ���
	 * @return boolean
	 */
	boolean Pay(String sk, String xiaoqu, String bulid, String room,
			String cpassword, float amt);
}
