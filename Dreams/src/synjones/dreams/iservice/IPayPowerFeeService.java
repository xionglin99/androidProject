package synjones.dreams.iservice;


public interface IPayPowerFeeService {

	/**
	 * 判断房间是否存在
	 * 
	 * @param xiaoqu
	 *            校区
	 * @param bulid
	 *            公寓楼
	 * @param room
	 *            房间号
	 * @return boolean
	 */
	boolean IsExist(String xiaoqu, String bulid, String room);

	/**
	 * 获取房间电费余额
	 * 
	 * @param xiaoqu
	 *            校区
	 * @param bulid
	 *            公寓楼
	 * @param room
	 *            房间号
	 * @return String
	 */
	float GetBalance(String xiaoqu, String bulid, String room);

	/**
	 * 给房间加电
	 * 
	 * @param sno
	 *            学工号
	 * @param xiaoqu
	 *            校区
	 * @param bulid
	 *            公寓楼
	 * @param room
	 *            房间号
	 * @param sn
	 *            流水号
	 * @param amt
	 *            金额
	 * @return boolean
	 */
	boolean Pay(String sk, String xiaoqu, String bulid, String room,
			String cpassword, float amt);
}
