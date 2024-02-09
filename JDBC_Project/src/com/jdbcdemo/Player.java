package com.jdbcdemo;
import java.sql.*;

public final class Player {
	private static final String url = "jdbc:mysql://localhost:3306/freefire";
	private static String userName; // if I use final I have to initialize here itself.
	private static String password;
//	private static final String password = null; // even it seems right as it is final we can't reassign it in constructor.
	
	private Player(String userName, String password) {
		Player.userName = userName;
		Player.password = password;
	}
	public static void obj() {
		Player p = new Player("root", "8778363157");
	}
//	
	// create
	public static void CreateTable() {
		Player.obj();
		String query = "create table player(id int primary key,"
				+ "playerName varchar(50) unique key, matchesPlayed int,"
				+ "kills int, matchWon int, weapon varchar(30))";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			int affected_row = st.executeUpdate(query);
			
			System.out.println(affected_row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// insert
	public static void insertRecords(int id, String name, int matches, int kills, int won, String weapon) {
		Player.obj();
		String query = "insert into player values(?, ?, ?, ?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,  id);
			ps.setString(2, name);
			ps.setInt(3,  matches);
			ps.setInt(4,  kills);
			ps.setInt(5,  won);
			ps.setString(6, weapon);
			
			int affected_row = ps.executeUpdate();
			System.out.println(affected_row);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// update
		public static void update(String column, int changeable, String where, int value) {
			Player.obj();
			String query = "update player set " + column + " = ? where " + where + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, changeable);
				ps.setInt(2, value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void update(String column, int changeable, String where, String value) {
			Player.obj();
			String query = "update player set " + column + " = ? where " + where + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, changeable);
				ps.setString(2, value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void update(String column, String changeable, String where, int value) {
			Player.obj();
			String query = "update player set " + column + " = ? where " + where + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, changeable);
				ps.setInt(2, value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void update(String column, String changeable, String where, String value) {
			Player.obj();
			String query = "update player set " + column + " = ? where " + where + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, changeable);
				ps.setString(2, value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// delete
		public static void delete(String column, int value) {
			Player.obj();
			String query = "delete from player where " + column + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,  value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}  
		public static void delete(String column, String value) {
			Player.obj();
			String query = "delete from player where " + column + " = ?";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,  value);
				
				int affected_row = ps.executeUpdate();
				System.out.println(affected_row);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}  

		//show
		public static void show(String table) {
			Player.obj();
			String query = "select * from " + table;
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, userName, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					System.out.println("Player id        : " + rs.getInt(1));
					System.out.println("Player           : " + rs.getString(2));
					System.out.println("Matches played   : " + rs.getInt(3));
					System.out.println("Matches won      : " + rs.getInt(5));
					System.out.println("Total Kills      : " + rs.getInt(4));
					System.out.println("Most used Weapon : " + rs.getString(6));
					System.out.println("--------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
