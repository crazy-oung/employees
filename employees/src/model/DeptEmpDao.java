package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.DeptEmp;
import vo.Employees;

public class DeptEmpDao {
	
	
	//deptEmp 에서 사원 목록 조회하는 메소드
	public List<DeptEmp> selectDeptEmpListByPage(int currentPage, int rowPerPage) {
		
		List<DeptEmp> list = new ArrayList<DeptEmp>();
		String sql = "SELECT d.dept_no, d.dept_name, e.emp_no, de.from_date, de.to_date, e.first_name, e.last_name " + 
				"FROM dept_emp de INNER JOIN employees e INNER JOIN departments d " + 
				"ON d.dept_no = de.dept_no AND e.emp_no = de.emp_no ORDER BY d.dept_no ASC, e.first_name ASC, e.last_name ASC " + 
				"limit ?,?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			int beginRow = (currentPage-0)*rowPerPage;
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				DeptEmp deptEmp = new DeptEmp();
				deptEmp.setEmployees();
				deptEmp.getEmployees().setEmpNo(rs.getInt("e.emp_no"));
				deptEmp.getEmployees().setLastName(rs.getString("e.last_name"));
				deptEmp.getEmployees().setFirstName(rs.getString("e.first_name"));
				deptEmp.setDepartment();
				deptEmp.getDepartment().setDeptNo(rs.getString("d.dept_no"));
				deptEmp.getDepartment().setDeptName(rs.getString("d.dept_name"));
				deptEmp.setFromDate(rs.getString("de.from_date"));
				deptEmp.setToDate(rs.getString("de.to_date"));
				list.add(deptEmp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				rs.close();
				conn.close();
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 데이터 개수를 가져오는 메소드
	public int selectDeptEmpRowCount() {
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM dept_emp";
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
