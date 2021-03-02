
public class BankAccount {

	private String accountName;
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber, String accountName) {
		accountName = this.accountName;
		accountNumber = this.accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAccountName(String accountName) {
		accountName = this.accountName;
	}
	
	public void setAccountNumber(String accountNumber) {
		accountNumber = this.accountNumber;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public boolean withdraw(double amount) {
		if(amount > balance) {
			return false;
		}
		else {
			balance = balance - amount;
			return true;
		}
	}
}
