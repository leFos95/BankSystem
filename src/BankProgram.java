
public class BankProgram {

	public static void main(String[] args) {
		
		char choice;
		int size;
		System.out.print("Number of the accounts: ");
		size = EasyScanner.nextInt();
		
		Bank myBank = new Bank(size);
		
		System.out.println();
		
		do {
			System.out.println();
			System.out.println("1. Create new account");
			System.out.println("2. Remove an account");
			System.out.println("3. Deposit money");
			System.out.println("4. Withdraw money");
			System.out.println("5. Check account details");
			System.out.println("6. Quit");
			System.out.println();
			System.out.print("Enter your choice [1-6]: ");
			
			
			choice = EasyScanner.nextChar();
			System.out.println();

			
			switch(choice) {
			case '1': option1(myBank);
			break;
			case '2': option2(myBank);
			break;
			case '3': option3(myBank);
			break;
			case '4': option4(myBank);
			break;
			case '5': option5(myBank);
			break;
			case '6': break;
			}
		}while(choice != '6');
	}
	
	static void option1(Bank bankIn) {
		System.out.print("Enter account number: ");
		int number = EasyScanner.nextInt();
		System.out.print("Enter account name: ");
		String name = EasyScanner.nextString();
		
		BankAccount account = new BankAccount(number, name);
		
		boolean ok = bankIn.add(account);
		if(!ok) {
			System.out.println("There was a problem");
		}
		else {
			System.out.println("Account created");
		}
	
	}
	
	static void option2(Bank bankIn) {
		System.out.print("Enter account number: ");
		int number = EasyScanner.nextInt();
		boolean ok = bankIn.remove(number);
		if(!ok) {
			System.out.println("No such account number");
		}
		else {
			System.out.println("Account was successfully removed!");
		}
	}
	
	static void option3(Bank bankIn) {
		System.out.print("Enter account number: ");
		int number = EasyScanner.nextInt();
		System.out.print("Enter amount to deposit: ");
		double amount = EasyScanner.nextDouble();
		boolean ok = bankIn.depositMoney(number, amount);
		if(!ok) {
			System.out.println("No such account number");
		}
		else {
			System.out.println("Money were deposited successfully!");
		}
	}
	
	static void option4(Bank bankIn) {
		System.out.print("Enter account number: ");
		int number = EasyScanner.nextInt();
		System.out.print("Enter amount to withdraw: ");
		double amount = EasyScanner.nextDouble();
		boolean ok = bankIn.withdrawMoney(number, amount);
		if(!ok) {
			System.out.println("No such account number or insufficient funds");
		}
		else {
			System.out.println("Money were withdrawn successfully!");
		}
	}
	
	static void option5(Bank bankIn) {
		
		System.out.print("Enter account number: ");
		int number = EasyScanner.nextInt();
		BankAccount account = bankIn.getItem(number);
		if(account == null) {
			System.out.println("No such account number");
		}
		else {
			System.out.println("Account number: " + account.getAccountNumber());
			System.out.println("Account name: " + account.getAccountName());
			System.out.println("Balance: " + account.getBalance());
			System.out.println();
		}
	}
	
}
