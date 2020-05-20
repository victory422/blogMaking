package board;

import java.sql.*;

public class BoardDBConn {
	
	public static Connection getConnection(){
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/blogproject?" +
								"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "1234";
			
			con = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection error");
		}
		
		return con;
	}
	
	public static void close(Connection con){
		try {
			if(!con.isClosed()){
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			if(!stmt.isClosed()){
				stmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset){
		
			try {
				if(!rset.isClosed()){
				rset.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void commit(Connection con){
		try {
			if(!con.isClosed()){
				con.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con){
		try {
			if(!con.isClosed()){
				con.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
