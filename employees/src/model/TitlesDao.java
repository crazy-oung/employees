package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;

public class TitlesDao {
	
	//직책만 조회(중복 제거 하고 )
	public List<String> selectTitlesListDistinct(){
		System.out.println("::: selectTitlesListDistinct 실행 :::");
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select distinct title from titles";
				
		try {			 
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				list.add(title);				
			}			
		}catch(Exception e) {
			// 가져오다 예외 발생시 예외 콘솔창에 출력
			e.printStackTrace();
		} finally {
			//반납
			try {
				DBHelper.close(rs, stmt, conn);				
			}catch(Exception e) {
				// 반납하다 예외 발생시 예외 콘솔창에 출력
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 개수를 가져오는 메소드
	public int selectTitlesRowCount() {
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM titles";
		// 디비 연결 필요 
		Connection conn = null;
		// 쿼리 저장 필요 
		PreparedStatement stmt = null;
		// select 쿼리 를 날릴 것이니까 ResultSet 필요 
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) {
			// 가져오다 예외 발생시 예외 콘솔창에 출력
			e.printStackTrace();
		} finally {
			//반납
			try {
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e) {
				// 반납하다 예외 발생시 예외 콘솔창에 출력
				e.printStackTrace();
			}
		}
		
		return count;
	}
}
