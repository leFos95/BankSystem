
public class BankAccountTester {

	public static void main(String[] args) {
		
		double amount;
		boolean ok;
		BankAccount account1 = new BankAccount(12345, "Susan");
		
		System.out.print("Enter amount to deposit: ");
		amount = EasyScanner.nextDouble();
		account1.deposit(amount);
		
		System.out.println("Deposit was made");
		System.out.println("Balance = " + account1.getBalance());
		System.out.println();
		
		System.out.print("Enter amount to withdraw: ");
		amount = EasyScanner.nextDouble();
		ok = account1.withdraw(amount);
		if(ok) {
			System.out.println("Withdraw was made");
		}
		else {
			System.out.println("Insufficient funds");
		}
		
		System.out.println("Balance = " + account1.getBalance());
		System.out.println();
	}
}
