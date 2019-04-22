import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;  

public class Main{
	public static void main(String args[]){  
		try {  
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cse4701s19_project2","root","");  
			//here cse4701s19_project2 is database name, root is username and password is blank
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from account");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		
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
		}
	}  
} 