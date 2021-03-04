import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BankSystem extends JFrame implements ActionListener {
	
	private int size;
	private Bank myBank;
	private JButton addButton = new JButton("Add User");
	private JButton displayButton = new JButton("Display Users");
	private JButton removeButton = new JButton("Remove User");
	
	private JTextField accountNumberField = new JTextField(20);
	private JTextField accountNameField = new JTextField(20);
	private JTextField accountNumberField2 = new JTextField(10);
	private JTextField amountField = new JTextField(8);
	
	private JButton saveAndQuitButton = new JButton ("Save and Quit");
	private JButton quitButton = new JButton("Quit without Saving");
	private JButton depositButton = new JButton("Deposit");
	private JButton withdrawButton = new JButton("Withdraw");
	private JButton checkDetailsButton = new JButton("Details");
	
	private JTextArea displayArea1 = new JTextArea(8,45);
	private JTextArea displayArea2 = new JTextArea(8,45);
	
	
	public BankSystem(int numberIn) {
		size = numberIn;
		myBank = new Bank(size);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bank System");
		setSize(545, 480);
		setLocation(400,100);
		getContentPane().setBackground(Color.darkGray);
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
		add(accountNumberField);
		accountNumberField.setBorder(new TitledBorder("Account Number"));
		add(accountNameField);
		accountNameField.setBorder(new TitledBorder("Account Name"));
		add(addButton);
		addButton.setBackground(Color.lightGray);
		addButton.setBorder(raisedBevel);
		add(displayButton);
		displayButton.setBorder(raisedBevel);
		displayButton.setBackground(Color.lightGray);
		add(removeButton);
		removeButton.setBackground(Color.lightGray);
		removeButton.setBorder(raisedBevel);
		add(saveAndQuitButton);
		saveAndQuitButton.setBackground(Color.lightGray);
		saveAndQuitButton.setBorder(raisedBevel);
		add(quitButton);
		quitButton.setBackground(Color.lightGray);
		quitButton.setBorder(raisedBevel);
		
		displayArea1.setBorder(new TitledBorder(new LineBorder(Color.black), "User" + "s", TitledBorder.CENTER, TitledBorder.TOP));
		
		JScrollPane p1 = new JScrollPane(displayArea1);
		add(p1);
		add(accountNumberField2);
		accountNumberField2.setBorder(new TitledBorder("Account Number"));
		add(amountField);
		amountField.setBorder(new TitledBorder("Amount"));
		add(depositButton);
		depositButton.setBackground(Color.lightGray);
		depositButton.setBorder(raisedBevel);
		add(withdrawButton);
		withdrawButton.setBackground(Color.lightGray);
		withdrawButton.setBorder(raisedBevel);
		add(checkDetailsButton);
		checkDetailsButton.setBackground(Color.lightGray);
		checkDetailsButton.setBorder(raisedBevel);
		
		displayArea2.setBorder(new TitledBorder(new LineBorder(Color.black),"Payments", TitledBorder.CENTER, TitledBorder.TOP));

		
		JScrollPane p2 = new JScrollPane(displayArea2);
		add(p2);
		addButton.addActionListener(this);
		displayButton.addActionListener(this);
		removeButton.addActionListener(this);
		depositButton.addActionListener(this);
		checkDetailsButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			String numberEntered = accountNumberField.getText();
			String nameEntered = accountNameField.getText();

			
			if(numberEntered.length() == 0 || nameEntered.length() == 0) {
				displayArea1.setText("Account number and account name must be entered");
			}
			else if (Integer.parseInt(numberEntered) < 1 | Integer.parseInt(numberEntered) > size) {
				displayArea1.setText("There are only " + size + " accounts to be entered");
			}
			else if(myBank.search(Integer.parseInt(numberEntered)) != -999) {
				displayArea1.setText("The " + Integer.parseInt(numberEntered) + " already exists");
			}
			else {
				BankAccount account = new BankAccount(Integer.parseInt(numberEntered), nameEntered);
				myBank.add(account);
				accountNumberField.setText("");
				accountNameField.setText("");
				displayArea1.setText("New user " + numberEntered + " successfully added");
			}
		}
		
		if(e.getSource() == displayButton) {
			int i;
			if(myBank.isEmpty()) {
				displayArea1.setText("There are no current accounts");
			}
			else {
				displayArea1.setText("Account number" + "\t" + "Account name" + "\n");
				for(i = 1; i <= myBank.getTotal(); i++) {
					displayArea1.append(myBank.getItem(i).getAccountNumber() + "\t" + "\t" + myBank.getItem(i).getAccountName() + "\n");
				}
			}
			
		}
		
		if(e.getSource() == removeButton) {
			String numberEntered = accountNumberField.getText();
			
			if(numberEntered.length() == 0) {
				displayArea1.setText("Account number must be entered");
			}
			else if(Integer.parseInt(numberEntered) < 1 || Integer.parseInt(numberEntered) > size) {
				displayArea1.setText("Invalid account number");
			}
			else if(myBank.search(Integer.parseInt(numberEntered)) == -999) {
				displayArea1.setText("Account number " + numberEntered + " does not exist");
			}
			else {
				myBank.remove(Integer.parseInt(numberEntered));
				displayArea1.setText("User with account number: " + " < " + Integer.parseInt(numberEntered) + "> " + " has been removed");
			}
			
		}
		
		if(e.getSource() == depositButton) {
			String numberEntered = accountNumberField2.getText();
			String amountEntered = amountField.getText();
			boolean ok;

			if(numberEntered.length() == 0 || amountEntered.length() <= 0) {
				displayArea2.setText("Account number and amount must be entered");
			}
			else if(Integer.parseInt(numberEntered) < 1 || Integer.parseInt(numberEntered) > size) {
				displayArea2.setText("invalid account number");
			}
			else if(myBank.search(Integer.parseInt(numberEntered)) == -999) {
				displayArea2.setText("User with account number: " + " < " + Integer.parseInt(numberEntered) + "> " + " does not exists");
			}
			else {
				ok = myBank.depositMoney(Integer.parseInt(numberEntered), Integer.parseInt(amountEntered));
				if(!ok) {
					displayArea2.setText("No such account number");
				}
				else {
					displayArea2.setText("Payment recorded");
				}
			}
		}
		
		if(e.getSource() == withdrawButton) {
			String numberEntered = accountNumberField2.getText();
			String amountEntered = amountField.getText();
			
			if(numberEntered.length() == 0 || amountEntered.length() <= 0) {
				displayArea2.setText("Account number and amount must be entered");
			}
		}
		
		if(e.getSource() == checkDetailsButton) {
			int i;
			String numberEntered = accountNumberField2.getText();
			
			if(numberEntered.length() == 0) {
				displayArea2.setText("Account number must be entered");
			}
			else if(Integer.parseInt(numberEntered) < 1 || Integer.parseInt(numberEntered) > size) {
				displayArea2.setText("Invalid account number");
			}
			else if(myBank.search(Integer.parseInt(numberEntered)) == -999) {
				displayArea2.setText("Account number: " + Integer.parseInt(numberEntered) + " does not exist");
			}
			else {
				BankAccount account = myBank.getItem(Integer.parseInt(numberEntered));
				if(account.getBalance() == 0) {
					displayArea2.setText("No payments made for this user");
				}
				else {
					NumberFormat nf = NumberFormat.getCurrencyInstance();
					String s;
					displayArea2.setText("Account number" + "\t" + "Amount" + "\n");
					for(i = 1; i <= myBank.getTotal(); i++) {
						s = nf.format(account.getBalance());
						displayArea2.append("" + account.getAccountNumber() + "\t\t" + s + "\n");
					}
				}
			}
		}
		
		if(e.getSource() == quitButton) {
			System.exit(0);
		}
		
	}

}
