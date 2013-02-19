package synjones.dreams.iservice;

import java.sql.Date;
import java.util.List;

import synjones.dreams.models.CardInfo;
import synjones.dreams.models.TrjnInfo;


/**
 * У԰������ӿ�
 * @author administrator
 *
 */
public interface ICardManageService {

	/***
	 * ��½
	 * @param account ѧ����
	 * @param password ����
	 * @return String ����cookieֵ
	 */
	String CheckIn(String account,String password);
	
/**
 * ��ȡУ԰��������Ϣ
 * @param sk cookieֵ
 * @return
 */
	CardInfo GetCardInfo(String sk);
	
	/**
	 * ��ȡ���п����
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	String GetBankBalance(String cardno,String pwd);
	
	/**
	 * ��ȡ������ˮ
	 * @param cardno
	 * @return
	 */
	List<TrjnInfo> GetCurrentDayTrjn(String sk);
	
	/**
	 * ��ȡ��ʷ��ˮ
	 * @param beginDate
	 * @param endDate
	 * @param cardno
	 * @return
	 */
	List<TrjnInfo> GetHistoryTrjns(String beginDate,String endDate,String sk);
	
	/**
	 * У԰����ʧ
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	Boolean SetCardLoss(String cardno,String pwd);
	
	/**
	 * У԰�����
	 * @param cardno
	 * @param pwd
	 * @return
	 */
	Boolean SetCardUnLoss(String cardno,String pwd);
	
	/**
	 * �޸Ĳ�ѯ����
	 * @param cardno
	 * @param pwd
	 * @param newPwd
	 * @return
	 */
	Boolean ChangeQueryPwd(String cardno,String pwd,String newPwd);
	
	/**
	 * �����п�֧��
	 * @param sno
	 * @param pwd
	 * @param amt
	 * @param toAccount
	 * @param trjn
	 * @return
	 */
	Boolean DoBankPay(String sno,String pwd,float amt,String toAccount,String trjn);
	
	/**
	 * �����п���У԰��ת��
	 * @param cardno
	 * @param pwd
	 * @param amt
	 * @return
	 */
	Boolean BankToCardTransfer(String cardno,String pwd,float amt);
	
	
	
	
	
	
	
	
	
}
