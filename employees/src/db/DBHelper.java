package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 마리아 디비 데이터베이스 employees에 접근하는 메소드를 정의
public class DBHelper {
	//디비와 연결하기
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");		
		return conn;
	}
	
	// 디비와 연결 닫어 주기
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		if(conn != null) {
			try {
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	}
}
