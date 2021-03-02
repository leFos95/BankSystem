
public class BankAccount {

	private String accountNumber;
	private String accountName;
	private double balance;
	
	public BankAccount(String accountNumber, String accountName) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		balance = 0;
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
