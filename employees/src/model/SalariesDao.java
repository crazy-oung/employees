package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	
	//연봉 통계 집계
	public Map<String, Long> selectSalariesStatistics(){
		System.out.println("::: selectSalariesStatistics 실행 :::");
		// 알기 쉽게 키워드를 사용하는 맵을 선언
		Map<String, Long> map = new HashMap<String, Long>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 집계함수 쿼리 작성
		String sql = "select count(salary), avg(salary), sum(salary), max(salary), min(salary), std(salary) from salaries";
				
		try {			 
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				map.put("count", rs.getLong("count(salary)"));
				map.put("avg", rs.getLong("avg(salary)"));	
				map.put("max", rs.getLong("max(salary)"));	
				map.put("sum", rs.getLong("sum(salary)"));	
				map.put("min", rs.getLong("min(salary)"));	
				map.put("std", rs.getLong("std(salary)"));	
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
		
		return map;
	}
	
	// 개수를 가져오는 메소드
	public int selectSalariesRowCount() {
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM salaries";
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
