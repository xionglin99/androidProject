package synjones.dreams.models;


/***
 * 校园卡流水信息
 * @author Administrator
 *
 */
public class TrjnInfo {

	private Float amount;
	private String toAccount;
	private String toMearchName;
	private Float  cardBalance;
	private Float eaccBalance;
	private String trjnType;
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getToMearchName() {
		return toMearchName;
	}
	public void setToMearchName(String toMearchName) {
		this.toMearchName = toMearchName;
	}
	public Float getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(Float cardBalance) {
		this.cardBalance = cardBalance;
	}
	public Float getEaccBalance() {
		return eaccBalance;
	}
	public void setEaccBalance(Float eaccBalance) {
		this.eaccBalance = eaccBalance;
	}
	public String getTrjnType() {
		return trjnType;
	}
	public void setTrjnType(String trjnType) {
		this.trjnType = trjnType;
	}
	
	
}
