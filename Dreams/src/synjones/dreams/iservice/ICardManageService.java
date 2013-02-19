package synjones.dreams.iservice;

import java.sql.Date;
import java.util.List;

import synjones.dreams.models.CardInfo;
import synjones.dreams.models.TrjnInfo;


/**
 * 校园卡管理接口
 * @author administrator
 *
 */
public interface ICardManageService {

	/***
	 * 登陆
	 * @param account 学工号
	 * @param password 密码
	 * @return String 返回cookie值
	 */
	String CheckIn(String account,String password);
	
/**
 * 获取校园卡基本信息
 * @param sk cookie值
 * @return
 */
	CardInfo GetCardInfo(String sk);
	
	/**
	 * 获取银行卡余额
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	String GetBankBalance(String cardno,String pwd);
	
	/**
	 * 获取当日流水
	 * @param cardno
	 * @return
	 */
	List<TrjnInfo> GetCurrentDayTrjn(String sk);
	
	/**
	 * 获取历史流水
	 * @param beginDate
	 * @param endDate
	 * @param cardno
	 * @return
	 */
	List<TrjnInfo> GetHistoryTrjns(String beginDate,String endDate,String sk);
	
	/**
	 * 校园卡挂失
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	Boolean SetCardLoss(String cardno,String pwd);
	
	/**
	 * 校园卡解挂
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	Boolean SetCardUnLoss(String cardno,String pwd);
	
	/**
	 * 修改查询密码
	 * @param cardno
	 * @param pwd
	 * @param newPwd
	 * @return
	 */
	Boolean ChangeQueryPwd(String cardno,String pwd,String newPwd);
	
	/**
	 * 绑定银行卡支付
	 * @param sno
	 * @param pwd
	 * @param amt
	 * @param toAccount
	 * @param trjn
	 * @return
	 */
	Boolean DoBankPay(String sno,String pwd,float amt,String toAccount,String trjn);
	
	/**
	 * 绑定银行卡向校园卡转账
	 * @param cardno
	 * @param pwd
	 * @param amt
	 * @return
	 */
	Boolean BankToCardTransfer(String cardno,String pwd,float amt);
	
	
	
	
	
	
	
	
	
}
