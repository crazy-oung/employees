package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Employees;

public class EmployeesDao {
	
	 // 사원의 최대 갯수를 구하는 메소드
	   public int selectEmpNo(String str) {
		   System.out.println("::: selectEmpNo 실행 :::");
		   int empNo = 0;
		    Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = null;
			if(str.equals("max")) {
				sql = "SELECT MAX(emp_no) FROM employees";
			} else if(str.equals("min")) {
				sql = "SELECT MIN(emp_no) FROM employees";
			}
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					empNo = rs.getInt(1);
					}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBHelper.close(rs, stmt, conn);
			}
		   return empNo;
	   }
	   
	   // 검색을할때, 시작과 끝을 선택해서 그 리스트를 보여주는 메서드
	   public List<Employees> selectEmployeesListBetween(int begin, int end) {
		   System.out.println("::: selectEmployeesListBetween 실행 :::");
			List<Employees> list = new ArrayList<Employees>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, begin);
				stmt.setInt(2, end);
				rs = stmt.executeQuery();
				while(rs.next()) {
						Employees employees = new Employees();
						employees.setEmpNo(rs.getInt("emp_no"));
						employees.setBirthDate(rs.getString("birth_date"));
						employees.setFirstName(rs.getString("first_name"));
						employees.setLastName(rs.getString("last_name"));
						employees.setGender(rs.getString("gender"));
						employees.setHireDate(rs.getString("hire_date"));
						list.add(employees);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBHelper.close(rs, stmt, conn);
			}
			return list;
		}
	   
	   // group by로 성별에 따른 직원 수 리스트
	   public List<Map<String, Object>> selectEmployeesCountGroupByGender() {
		   System.out.println("::: selectEmployeesCountGroupByGender 실행 :::");
		   List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "SELECT gender, count(gender) as cnt from employees GROUP BY gender";
		   
		   try {
			   conn = DBHelper.getConnection();
			   stmt = conn.prepareStatement(sql);
			   rs = stmt.executeQuery();
			   while(rs.next()) {
				   Map<String, Object> map = new HashMap<String, Object>();
				   map.put("gender", rs.getString("gender"));
				   map.put("cnt", rs.getInt("cnt"));
				   list.add(map);
			   }
			   
		   } catch(Exception e) {
			   e.printStackTrace();
		   } finally {
			   DBHelper.close(rs, stmt, conn);
		   }
		   return list;
	   }
	
	//사원 목록을 정렬해서 보여주는 메소드
	public List<Employees> selectEmployeesListOrderBy(String order){
		// 확인
		System.out.println("::: selectEmployeesListOrderBy 실행 :::");
		// 쿼리 작성 
		String sql = "";
		// 디비 연결 필요 
		Connection conn = null;
		// 쿼리 저장 필요 
		PreparedStatement stmt = null;
		// select 쿼리 를 날릴 것이니까 ResultSet 필요 
		ResultSet rs = null;		
		List<Employees> list = new ArrayList<Employees>();
		
		// 매개변수 값에 따라 데이터 정렬 쿼리 동적 저장
		if(order.equals("asc")) {
			sql = "SELECT emp_no, first_name, last_name, birth_date, hire_date, gender FROM employees order by first_name, last_name asc limit 50";
		}else {
			sql = "SELECT emp_no, first_name, last_name, birth_date, hire_date, gender FROM employees order by first_name desc, last_name asc limit 50";
		}
		try {
			
		//jdbc 사용하여 마리아디비 연결
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
		// 쿼리 저장. 실행
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
			
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
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
				//연결종료
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		return list;
		
	}
	
	// 사원(employees)의 리스트를 가져오는 메소드
	public List<Employees> selectEmployeesList(int num) {
		System.out.println("::: selectEmployeesList 실행 :::");
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
		// select 쿼리 를 날릴 것이니까 ResultSet 필요 
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
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
	public int selectEmployeesRowCount() {		
		System.out.println("::: selectEmployeesRowCount 실행 :::");
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
