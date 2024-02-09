package com.jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
	private static final String link = "jdbc:mysql://localhost:3306/fun_atm";
	private static String user;
	private static String pass;
	
	private Bank(String username, String password) {
		Bank.user = username;
		Bank.pass = password;
	}
	public static void Start() {
		Bank acc = new Bank("root", "8778363157");
	}
	
	//create table
	public static void people_table() {
		String query = "create table people\r\n"
				+ "("
				+ "id int primary key auto_increment,"
				+ "user_name varchar(50) not null,"
				+ "acc_balance bigint not null default 0,"
				+ "acc_num bigint not null unique,"
				+ "card_num bigint not null unique,"
				+ "acc_pin int not null,"
				+ "ph_num bigint not null unique,"
				+ "city varchar(50) not null,"
				+ "state varchar(50) not null,"
				+ "country varchar(50) not null,"
				+ "password varchar(40) not null"
				+ ")";
		Connection con = null;
			try {
				con = DriverManager.getConnection(link, user, pass);
				Statement st = con.createStatement();
				st.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Something wrong with table creation...");
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
	}
	// New Account Number
	public static int accNum(){
    	String acc_num = "";
    	for(int i = 0; i < 7; i++) {
    		acc_num += (int) Math.floor(Math.random() * 9);
    	}
    	int num = Integer.parseInt(acc_num);
        return num;
    }
	// New Pin
	private static int newPin;
	public static void new_pin(int a) {
		newPin = a;
	}
    public static void signUp(String username, int balance, int acc_num, long cardNum, long phone, String city, String state, String country, String acc_pass) {
    	int setPin = newPin;
    	String query = "insert into people(user_name, acc_balance, acc_num, card_num, acc_pin, ph_num, city, state, country, password) "
    			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	try {
			Connection con = DriverManager.getConnection(link, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setInt(2, balance);
			ps.setInt(3, acc_num);
			ps.setLong(4, cardNum);
			ps.setInt(5, setPin);
			ps.setLong(6, phone);
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setString(9, country);
			ps.setString(10, acc_pass);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}9
//		}
    }
    public static void login(int acc_num, String acc_pass) {
    	String query = "select * from people where acc_num = " + acc_num + " and password = '" + acc_pass + "'";
    	try {
			Connection con = DriverManager.getConnection(link, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println(" ");
			while(rs.next()) {
				System.out.println("Welcome to Fun Bank Mr." + rs.getString(2));
				System.out.println(" ");
				System.out.println("Your Account Number : " + rs.getInt(4));
				System.out.println("Balance in your account : " + rs.getInt(3) + " $ dollars");
				String debit = "" + rs.getLong(5);
				String split = "";
				for(int i = 0; i < debit.length(); i++) {
					if(i == 4 || i == 8 || i == 12) {
						split += " " + debit.charAt(i);
					}else {
						split += debit.charAt(i);
					}
				}
				System.out.println("Your debit car number : " + split);
				System.out.println("Your Mobile Number is " + rs.getLong(7));
				System.out.println("You are from " + rs.getString(8) +
						" city" + " in " + rs.getString(9) + " in " + rs.getString(10));
				System.out.println(" ");
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
    }
    // Login validation.
    public static HashMap<Integer, Integer> arr;
    public static int checkAcc;
    public static int checkPin;
    
    public static HashMap<Integer, String> getAccNum() {
    	String query = "select acc_num, password, acc_pin from people";
    	HashMap<Integer, String> array = new HashMap<Integer, String>();
    	HashMap<Integer, Integer> pin = new HashMap<Integer, Integer>();
    	try {
			Connection con = DriverManager.getConnection(link, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println(" ");
			while(rs.next()) {
				array.put(rs.getInt(1), rs.getString(2));
				pin.put(rs.getInt(1), rs.getInt(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        arr = pin;
		return array;
    }
    
    public static boolean pinValid(int accNum, int pin) {
        checkAcc = accNum;
    	checkPin = pin;
    	int getAccPin = arr.get(checkAcc);
    	if(getAccPin != checkPin) {
    		return true;
    	}else {
    		return false;
    	}
    } 
    
    public static int deposit(int cash, int pin) {
    	String query = "update people set acc_balance = acc_balance + " + cash + " where acc_pin = " + pin;
    	Connection con;
		try {
			con = DriverManager.getConnection(link, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate(query);
			System.out.println("Amount added to Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return 0;
	}
	
}

