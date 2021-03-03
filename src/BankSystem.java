import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}
		
		if(e.getSource() == displayButton) {
			String numberEntered = accountNumberField.getText();
			
		}
		
		if(e.getSource() == removeButton) {
			String numberEntered = accountNumberField.getText();
			
			if(numberEntered.length() == 0) {
				displayArea1.setText("Account number must be entered");
			}
			else if(Integer.parseInt(numberEntered) > 1 || Integer.parseInt(numberEntered)> size) {
				displayArea1.setText("Invalid account number");
			}
		}
		
		if(e.getSource() == depositButton) {
			String numberEntered = accountNumberField2.getText();
			String amountEntered = amountField.getText();
			
			if(numberEntered.length() == 0 || amountEntered.length() <= 0) {
				displayArea2.setText("Account number and amount must be entered");
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
			String numberEntered = accountNumberField2.getText();
			
			if(numberEntered.length() == 0) {
				displayArea2.setText("Account number must be entered");
			}
		}
		
		if(e.getSource() == quitButton) {
			System.exit(0);
		}
		
	}

}
