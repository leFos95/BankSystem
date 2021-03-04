
public class Bank {

	private BankAccount[] list;
	private int total;
	
	public Bank(int size) {
		list = new BankAccount[size];
		total = 0;
	}
	
	public int getTotal() {
		return total;
	}
	
	// Find index
	public int search(int accountNumber) {
		for(int i = 0; i < total; i++)
		{
			BankAccount tempAccount = list[i]; //find the account at index i
			int tempNumber = tempAccount.getAccountNumber(); //get account number
			if(tempNumber == accountNumber) //if this is the account we are looking for
			{
				return i; //return index
			}
		}
		return -999;
	}
	
	
	
	public boolean isEmpty() {
		if(total == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(total == list.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean add(BankAccount account) {
		if(!isFull()) {
			list[total] = account;
			total++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean depositMoney(int accountNumber, double amount) {
		
		int index = search(accountNumber);
		if(index == -999) {
			return false;
		}
		else 
			list[index].deposit(amount);
		return true;
		
	}
	
//	public BankAccount getItem(int positionIn) {
//		if(positionIn < 1 || positionIn > total) {
//			return null;
//		}
//		else {
//			return (BankAccount) list[positionIn-1];
//		}
//	}
	
	public BankAccount getItem(int accountNumber) {
		int index;
		index = search(accountNumber);
		if(index == -999) {
			return null;
		}
		else {
			return list[index];
		}
	}
	
	public boolean withdrawMoney(int accountNumber, double amount) {
		boolean okToWithdraw;
		int index = search(accountNumber);
		if(index == -999) {
			return false;
		}
		else {
			okToWithdraw = list[index].withdraw(amount);
			return okToWithdraw;
		}
	}
	
	public boolean remove(int number) {
		int index = search(number);
		if(index == -999) {
			return false;
		}
		else {
			for(int i = index; i <= total-2; i++) {
				list[i] = list[i+1];
			}
			total--;
			return true;
		}
	}
	
//	public String toString() {
//		String items = "";
//		for (int i = 0; i< total; i++) {
//			items = items + list[i].toString() + " ";
//		}
//		return "[ " + items + "]";
//	}
	
	
}
