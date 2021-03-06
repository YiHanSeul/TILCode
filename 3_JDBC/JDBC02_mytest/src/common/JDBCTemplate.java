package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//1.연결
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] DB 드라이버등록 실패");
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/multi";
		String id="root";
		String pw="1234";
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,id,pw);
			con.setAutoCommit(false); //auto commit을 끈다. 사용이유: 원하는 시점에 직접 커밋하려고
		} catch (SQLException e) {
			System.out.println("[Error] 커넥션 연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	//2.해제
	public static void Close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//3.저장(commit)/취소(rollback)
	public static void Commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
