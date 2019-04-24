import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;  
import java.util.Calendar;
import java.util.Random;

public class MySQLConnection{
	public static void main(String args[]){  
		try {  
			//Class.forName("com.mysql.jdbc.Driver"); -> throws error
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse4701s19_project2","root","");  
			//cse4701s19_project2 is database name, root is username and password is blank
			
			//sql date object for INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			//"random" number for account number
			Random rand = new Random();
			
			//create INSERT query
			//INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );
			String insertQuery = " insert into account (account_no, name_on_account, balance, account_open_date)" + " values (?, ?, ?, ?)";
			
			//Visual menu for user
			Scanner sc = new Scanner(System.in); //creates scanner instance
			System.out.println("Main Menu");
			System.out.println("1 - Create Account");
			System.out.println("2 - Check Balance");
			System.out.println("3 - Deposit");
			System.out.println("4 - Withdraw");
			System.out.println("5 - Transfer");
			System.out.println("0 - Quit");
			System.out.print("Enter your choice: ");
			
			int user_choice = sc.nextInt(); //records their choice
			sc.nextLine();
			int acct_no; 
			while(user_choice!=0) { //if they choose 0, quit
				switch (user_choice) {
				case 1: { //create account " insert into account (account_no, name_on_account, balance, account_open_date)"
					System.out.print("Name on account: ");
					String account_name = sc.nextLine();
					System.out.print("Enter Initial Balance: ");
					int init_balance = sc.nextInt();
					//double balance = Integer.doubleValue(init_balance); //figure out how to cast to double later
					sc.nextLine();
					acct_no = rand.nextInt(1000);
					
					//create sql INSERT statement
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
					System.out.print("Please enter account number: ");
					int acc_no = sc.nextInt();
					sc.nextLine();
					Statement stmt = con.createStatement();
					//String selectQuery = " select balance from account where account_no = ?";
					//String selectQuery = " select * from account";
					//String selectQuery = " select balance" + " from account" + " where account_no = ?";
					//String sql = "SELECT balance FROM account WHERE account_no = " + entered_acc_no;
					//create sql insert statement
					ResultSet rs = stmt.executeQuery( "SELECT * FROM account WHERE account_no = " + acc_no);
					//PreparedStatement preparedStmt2 = con.prepareStatement(" select balance from account");
					//PreparedStatement statement = con.prepareStatement("SELECT balance FROM account WHERE account_no = ?"); 
					//PreparedStatement preparedStmt2 = con.prepareStatement(selectQuery);
					//preparedStmt2.setInt(1, acc_no);
					//statement.setInt(1, acc_no);
					
					//String query = "SELECT * FROM account";
					// create the java statement
				    //Statement st = con.createStatement();
					//ResultSet rs = preparedStmt2.executeQuery();
					//ResultSet rs = stmt.executeQuery();
					//ResultSet rs = statement.executeQuery();
				      
				    // iterate through the java result set
					if(rs.next()) {
						do {
					    	int id = rs.getInt("account_no");
					        String name = rs.getString("name_on_account");
					        int bal = rs.getInt("balance");
					        Date dateCreated = rs.getDate("account_open_date");
					        
					        // print the results
					        System.out.println("---Checking account balance---");
							System.out.println("Account number: " + id);
							System.out.println("Name on account: " + name);
							System.out.println("Balance: " + bal);
							System.out.println("Account opened on: " + dateCreated);
							System.out.println("------");
						} while (rs.next());
					} else {
						System.out.println("ERROR: Account Does Not Exist. Please enter valid account number.");
					}
					break;
				}
				case 3: { //deposit
					System.out.println("This feature is not finished yet.");
					break;
				}
				case 4: { //withdraw
					System.out.println("This feature is not finished yet.");
					break;
				}
				case 5: { //transfer
					System.out.println("This feature is not finished yet.");
					break;
				}
				default:
					System.out.println("ERROR: Option Does Not Exist. Please enter valid number.");
				} //end of switch
				System.out.println("");
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
	}  
} 