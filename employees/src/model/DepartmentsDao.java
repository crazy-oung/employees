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
import vo.Department;

public class DepartmentsDao {
	
	// 부서별 사원수를 알려주는 메소드
	public List<Map<String, Object>> selectDepartmentsCountByDeptNo(){
		System.out.println("::: selectDepartmentsCountByDeptNo 실행 :::");
      List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      final String sql =
      "SELECT d.dept_no, d.dept_name, COUNT(d.dept_no) FROM dept_emp de INNER join departments d "
      + "ON de.dept_no = d.dept_no WHERE de.to_date = '9999-01-01' GROUP BY de.dept_no ORDER BY COUNT(d.dept_no) desc";
      
      try {
         conn = DBHelper.getConnection();
         stmt =conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         while(rs.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("deptNo",rs.getString("d.dept_no"));
            map.put("deptName",rs.getString("d.dept_name"));
            map.put("deptCount", rs.getString("COUNT(d.dept_no)"));
            list.add(map);
         }
      }   catch   (Exception e){
      }   finally   {
         DBHelper.close(rs, stmt, conn);
      }
      return list;
   }
	
	// 부서테이블의  데이터 개수를 가져오는 메소드
	public int selectDepartmentsRowCount() {	
		System.out.println("::: selectDepartmentsRowCount 실행 :::");
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM departments";
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
				//연결종료
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
	
	public List<Department> selectDepartmentsList(){
		System.out.println("::: selectDepartmentsList 실행 :::");
		List<Department> list = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select dept_no, dept_name from departments";
				
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");			 
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Department department = new Department();
				department.setDeptName(rs.getString("dept_name"));
				department.setDeptNo(rs.getString("dept_no"));
				list.add(department);				
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
}
