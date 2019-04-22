import java.util.Random;

public class Account {
	private int acct_no;
	private double balance;
	private String name;
	private java.util.Date account_open_date;
	
	Random rand = new Random();
	
	public Account(){
		account_open_date = new java.util.Date();	
		acct_no = rand.nextInt();
	}
	
	public Account(String input_name, int init_balance) {
		account_open_date = new java.util.Date();	
		acct_no = rand.nextInt();
		name = input_name;
		balance = (double)init_balance;
		acctCreated();
	}
	
	public double checkBalance(int id) {
		if(id==acct_no) {
			return this.balance;
		} else {
			System.out.println("Invalid account number.");
			return -1;
		}
	}
	
	public Boolean acctCreated() {
		System.out.println("---Account successfully created---");
		System.out.println("Account number: " + this.acct_no);
		//System.out.println(counter);
		//counter++;
		System.out.println("Name on account: " + this.name);
		//System.out.println(account_name);
		System.out.println("Balance: " + this.balance);
		//System.out.println(init_balance);
		System.out.println("Account opened on: " + this.account_open_date);
		System.out.println("------");
		//open date
		return true;
	}
}