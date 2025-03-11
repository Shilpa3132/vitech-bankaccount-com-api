package vitech.bankaccount.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customers")
public class Bankmodel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String customerName;
	private String bank;
	private String acctype; 
	private String branchName;
	private Long accountNum; 
	private Integer atmPin;
	private String ifscCode; 
	private float depositAmount;
	private String mailId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public Integer getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(Integer atmPin) {
		this.atmPin = atmPin;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public float getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(float depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "Bankmodel [id=" + id + ", customerName=" + customerName + ", bank=" + bank + ", acctype=" + acctype
				+ ", branchName=" + branchName + ", accountNum=" + accountNum + ", atmPin=" + atmPin + ", ifscCode="
				+ ifscCode + ", depositAmount=" + depositAmount + ", mailId=" + mailId + "]";
	}
	public Bankmodel(Integer id, String customerName, String bank, String acctype, String branchName, Long accountNum,
			Integer atmPin, String ifscCode, float depositAmount, String mailId) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.bank = bank;
		this.acctype = acctype;
		this.branchName = branchName;
		this.accountNum = accountNum;
		this.atmPin = atmPin;
		this.ifscCode = ifscCode;
		this.depositAmount = depositAmount;
		this.mailId = mailId;
	}
	public Bankmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
