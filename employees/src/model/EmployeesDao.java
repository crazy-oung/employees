package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Employees;

public class EmployeesDao {
	
	// 사원(employees)의 리스트를 가져오는 메소드
	public List<Employees> selectEmployeesList(int num) {
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT emp_no, first_name, last_name, birth_date, hire_date, gender FROM employees limit ?";
		// 디비 연결 필요 
		Connection conn = null;
		// 쿼리 저장 필요 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Employees> list = new ArrayList<Employees>();
		
		try {
			System.out.println("::: selectEmployeesList 실행 :::");
		// select 쿼리 를 날릴 것이니까 ResultSet 필요 
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java123");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setEmpFirstName(rs.getString("first_name"));
				employees.setEmpLastName(rs.getString("last_name"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setHireDate(rs.getString("hire_date"));
				employees.setGender(rs.getString("gender"));
				list.add(employees);	
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
		
		return list;
	}
	
	// 사원(employees)의 개수를 가져오는 메소드
	public int selectEmployeesCount() {		
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM employees";
		// 디비 연결 필요 
		Connection conn = null;
		// 쿼리 저장 필요 
		PreparedStatement stmt = null;
		// select 쿼리 를 날릴 것이니까 ResultSet 필요 
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java123");
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
		
		/*
		 * 위 코드의 Exception 변수 e 에 대한 설명.
		 * 어떻게 같은 이름의 변수가 공존 하는가? 
		 * 지역변수로 서로 지역이 다르니까. 
		 * 다시말해 자바의 변수 생명 주기는 { } 이니까..!
		 * 
		 */
		
		
		return count;
	}
}
