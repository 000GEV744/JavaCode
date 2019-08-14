package comm.example;
import  java.io.Serializable;
public class Account implements Serializable{

	private String accountNumber;
	private double amount;
	
	
	public Account() {
		super();
	}

	public Account(String accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
	
	public Account createAccount(String accountNumber, double amount) throws AccountNotValid{
		this.accountNumber=accountNumber;
		this.amount=amount;
		if(amount<10000) {
			throw new AccountNotValid("not a valid amount, account can't be created");
		}
		return new Account(accountNumber,amount);
	}
	
	
}
