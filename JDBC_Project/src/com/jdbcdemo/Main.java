package com.jdbcdemo;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
	static Scanner inp = new Scanner(System.in);
	public static void main(String[] args) {
		
//		Bank.people_table();
		
	/*	Bank.Start();
		System.out.println("Welcome to fun Bank");
	    System.out.println("Existing user / New user");
		String user = inp.nextLine();
		switch(user.toLowerCase()) {
		case "ext" : 
			HashMap<Integer, String> accNum = Bank.getAccNum();
			System.out.println("Login");
			System.out.print("Enter your acc number : ");
			int num = inp.nextInt();
//			System.out.println(accNum);
			String getPass = accNum.get(num);
//			System.out.println(getPass);
			while(getPass == null || getPass == "") {
				System.out.println("Your account number is wrong..");
				System.out.println("Try once again !");
				System.out.print("Enter your acc number : ");
				num = inp.nextInt();
				getPass = accNum.get(num);
			}
			System.out.print("Password : ");
			String pass = inp.next();
			while(!getPass.equals(pass)) {
				System.out.println("Your password is wrong..");
				System.out.println("Try once again !");
				System.out.print("Password : ");
				pass = inp.next();
			}
			Bank.login(num, pass);
			
			
			FreeFire.atm(num);
			break;
		case "new" :
			System.out.println("Sign Up");
			System.out.print("");
			System.out.print("Username : ");
			String name = inp.nextLine();
			System.out.print("City : ");
			String city = inp.nextLine();
			System.out.print("State : ");
			String state = inp.nextLine();
			System.out.print("Country : ");
			String country = inp.nextLine();
			System.out.print("phone number : ");
			long phNum = inp.nextLong();
			System.out.print("Your account number is : ");
			int acc_num = Bank.accNum();
			System.out.println(acc_num);
			System.out.print("Create Your Pin : ");
			int pin = inp.nextInt();
			Bank.new_pin(pin);
			System.out.println("Everything is ready, lets see your luck");
			System.out.println("Type 'Go' to see how much money you'll get initially");
			String go = inp.nextLine().toLowerCase();
			int balance = 0;
			while(true) {
			    if(go.equals("go")) {
			    	int digits = 0;
//			    	for(int i = 0; i < 5; i++) {
			    		digits = (int) Math.floor(Math.random() * 9);
//			    	}
			    	String cash = "0";
			    	for(int i = 0; i < digits; i++) {
			    		cash += (int) Math.ceil(Math.random() * 9);
			    	}
			    	balance = Integer.parseInt(cash);
			        System.out.println("Your balance is " + balance + " rupees");
			        break;
		    	}else {
//			    	System.out.println("Type 'Go' only");
			    	go = inp.nextLine().toLowerCase();
		    	}
	    	}
			long card = 0;
			String x = "0";
	    	for(int i = 0; i < 16; i++) {
	    		x += (int) Math.ceil(Math.random() * 9);
	    	}
	    	card = Long.parseLong(x);
	    	System.out.print("Create your password : ");
	    	String password = inp.nextLine();
			Bank.signUp(name, balance, acc_num, card, phNum, city, state, country, password);
		}   
	}
	public static void atm(int num) {
		int pin = 0;
		System.out.println("Open ATM --> Enter 'yes'");
		String yes = inp.next();
		if(yes.equals("yes")) {
			System.out.println("1.Send Money            2.Cash Withdraw");
			System.out.println("3.Pin Change            4.Balance Inquiry");
			System.out.println("5.Deposit               6.Request Money");
			System.out.println(" ");
			System.out.print("option --> ");
			int option = inp.nextInt();
			switch(option) {
			    case 1 : 
//			    	Bank.sendMoney();
			    	break;
			    case 2 :
//			    	Bank.cashWithdraw();
			    	break;
			    case 3 :
//			    	Bank.pinChange();
			    	break;
			    case 4 :
//			    	Bank.balanceCheck();
			    	break;
			    case 5 :
//			    	System.out.println("Enter your pin");
			    	System.out.print("Enter how much you want to add --> ");
			    	int cash = inp.nextInt();
			    	while(cash > 50000) {
			    		System.out.println("Deposit limit is $50,000");
			    		System.out.print("ReEnter your money --> ");
			    		cash = inp.nextInt();
			    	}
			    	System.out.print("Enter your pin --> ");
			    	pin = inp.nextInt();
			    	boolean x = Bank.pinValid(num, pin);
			    	while(x) {
			    		System.out.println("Incorrect Pin number");
			    		System.out.println("Try again..");
			    		System.out.print("Enter your pin --> ");
				    	pin = inp.nextInt();
				    	x = Bank.pinValid(num, pin);
			    	}
				    Bank.deposit(cash, pin);
			    	break;
			    case 6 :
//			    	Bank.requestMoney();
			    	break;
			    default :
			    	break;
			}   
		}  */


	}

}
