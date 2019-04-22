import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;  
import java.util.Calendar;
import java.util.Random;

public class MysqlCon{
	public static void main(String args[]){  
		try {  
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cse4701s19_project2","root","");  
			//here cse4701s19_project2 is database name, root is username and password is blank
			
			//sql date object for INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			//"random" number for account number
			Random rand = new Random();
			//rand.nextInt();
			
			//query
			//INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );
			String insertQuery = " insert into account (account_no, name_on_account, balance, account_open_date)"
			        + " values (?, ?, ?, ?)";
			//SELECT what_to_select FROM which_table WHERE conditions_to_satisfy;
			String selectQuery = " select balance" + " from account" + " where account_no=(?)";
			
			//Menu for user
			Scanner sc = new Scanner(System.in); //creates scanner instance
			System.out.println("Main Menu");
			System.out.println("1 - Create Account");
			System.out.println("2 - Check Balance");
			System.out.println("3 - Deposit");
			System.out.println("4 - Withdraw");
			System.out.println("5 - Transfer");
			System.out.println("0 - Quit");
			System.out.print("Enter your choice: ");
			
			int user_choice = sc.nextInt(); 
			sc.nextLine();
			int acct_no;
			while(user_choice!=0) {
				switch (user_choice) {
				case 1: { //create account " insert into account (account_no, name_on_account, balance, account_open_date)"
					System.out.print("Name on account: ");
					String account_name = sc.nextLine();
					System.out.print("Enter Initial Balance: ");
					int init_balance = sc.nextInt();
					//double balance = Integer.doubleValue(init_balance);
					sc.nextLine();
					acct_no = rand.nextInt(1000);
					
					//create sql insert statement
					PreparedStatement preparedStmt = con.prepareStatement(insertQuery);
					preparedStmt.setInt(1, acct_no);
					preparedStmt.setString(2, account_name);
					preparedStmt.setInt(3, init_balance);
					preparedStmt.setDate(4, startDate);
					preparedStmt.execute(); //execute insert statement
					
					//print to user
					System.out.println("---Account successfully created---");
					System.out.println("Account number: " + acct_no);
					System.out.println("Name on account: " + account_name);
					System.out.println("Balance: " + init_balance);
					System.out.println("Account opened on: " + startDate);
					System.out.println("------");
					break;
				}
				case 2: { //check balance
					System.out.println("Please enter account number: ");
					int entered_acc_no = sc.nextInt();
					sc.nextLine();
					//String selectQuery = " select balance" + " from account" + " where (?)";
					//create sql insert statement
					PreparedStatement preparedStmt2 = con.prepareStatement(selectQuery);
					preparedStmt2.setInt(1, entered_acc_no);
					preparedStmt2.execute(); //execute insert statement
					break;
				}
				case 3: { //deposit
					break;
				}
				case 4: { //withdraw
					break;
				}
				case 5: { //transfer
					break;
				}
				}
				System.out.println("Main Menu");
				System.out.println("1 - Create Account");
				System.out.println("2 - Check Balance");
				System.out.println("3 - Deposit");
				System.out.println("4 - Withdraw");
				System.out.println("5 - Transfer");
				System.out.println("0 - Quit");
				System.out.print("Enter your choice: ");
				user_choice = sc.nextInt();
				sc.nextLine();
				
			} 
		} catch(Exception e) { 
			System.out.println(e);
		} 
		/*
		Scanner sc = new Scanner(System.in); //creates scanner instance
		int counter = 1;
		System.out.println("Main Menu");
		System.out.println("1 - Create Account");
		System.out.println("2 - Check Balance");
		System.out.println("3 - Deposit");
		System.out.println("4 - Withdraw");
		System.out.println("5 - Transfer");
		System.out.println("0 - Quit");
		System.out.print("Enter your choice: ");
		int user_choice = sc.nextInt(); 
		sc.nextLine();
		Account newAccount;
		while(user_choice!=0) {
			switch (user_choice) {
			case 1: { //create account
				System.out.print("Name on account: ");
				String account_name = sc.nextLine();
				System.out.print("Enter Initial Balance: ");
				int init_balance = sc.nextInt();
				sc.nextLine();
				newAccount = new Account(account_name, init_balance);
				break;
			}
			case 2: { //check balance
				System.out.println("Please enter account number: ");
				int entered_acc_no = sc.nextInt();
				sc.nextLine();
				
				double bal = newAccount.checkBalance(entered_acc_no);
				break;
			}
			case 3: { //deposit
				break;
			}
			case 4: { //withdraw
				break;
			}
			case 5: { //transfer
				break;
			}
			}
			System.out.println("Main Menu");
			System.out.println("1 - Create Account");
			System.out.println("2 - Check Balance");
			System.out.println("3 - Deposit");
			System.out.println("4 - Withdraw");
			System.out.println("5 - Transfer");
			System.out.println("0 - Quit");
			System.out.print("Enter your choice: ");
			user_choice = sc.nextInt();
			sc.nextLine();
		}*/
	}  
} 