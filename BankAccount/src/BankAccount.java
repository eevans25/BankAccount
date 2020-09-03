import java.util.Scanner;

public class BankAccount {
	private String owner;
	private double balance;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Assigning value to String owner
		System.out.println("What is your name: ");
		String name = scan.next();
		name += scan.nextLine();
		
		//Assigning value to double balance
		System.out.println("How much do you want to initially deposit: ");
		double initialBalance = scan.nextDouble();
		
		//Value over 0 must be inputed
		while(initialBalance <= 0) {
				System.out.println("Please enter an amount: ");
				initialBalance = scan.nextDouble();
		}
		
		//Creates new BankAccount object
		BankAccount account = new BankAccount(name, initialBalance);
		System.out.println("Success. You have opened a new bank account!");
		
		//Can either deposit, withdraw, or check the balance of the account. Can also quit the program
		boolean loop = true;
		while(loop) {
			System.out.println("Do you want to deposit or withdraw money? [Type Deposit, Withdraw, Check Balance, or Quit]");
			String input = scan.nextLine();
			input += scan.nextLine();
			if(input.equals("Deposit")) {
				System.out.println("How much do you want to deposit: ");
				double depositAmnt = scan.nextDouble();
				account.deposit(depositAmnt);
			} else if(input.equals("Withdraw")) {
				System.out.println("How much do you want to withdraw: ");
				double withdrawAmnt = scan.nextDouble();
				account.withdraw(withdrawAmnt);
			} else if(input.equals("Quit")) {
				System.out.println("Thank you for banking with us!");
				loop = false;
			} else if(input.equals("Check Balance")) {
				account.checkBalance();
			} else {
				System.out.println("Please try again.");
			}
		}
		scan.close();
	}
	
	//No Constructor Argument
	public BankAccount() {
		owner = "Null";
		balance = 0;
	}
	
	//BankAccount Constructor
	public BankAccount(String owner, double balance) {
		this.owner = owner;
		this.balance = balance;
	}
	
	//Prints statement stating what the account balance is
	public void checkBalance() {
		System.out.println(owner +", Your balance is " +balance);
	}
	
	//Deposits money to account and states new balance
	//If input is equal or less than 0, deposit is rejected and current balance is restated
	public double deposit(double money) {
		if(money <= 0) {
			System.out.println("You cannot deposit this.");
			System.out.println(owner +", Your current balance is " +balance);
			return balance;
		} else {
			balance += money;
			System.out.println(owner +", Your new balance is " +balance);
			return balance;
		}
	}
	
	//Withdraws money from account and states new balance
	//If input is equal or less than 0 or is greater than balance, withdrawal is rejected and current balance is restated
	public double withdraw(double money) {
		if(money <=0 || money > balance) {
			System.out.println("You cannot withdraw this.");
			System.out.println(owner +", Your current balance is " +balance);
			return balance;
		} else {
			balance -= money;
			System.out.println(owner +", Your new balance is " +balance);
			return balance;
		}
	}
	
}
