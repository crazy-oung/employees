package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Department;
import vo.DeptEmp;
import vo.DeptManager;
import vo.Employees;

public class DeptManagersDao {
	
	public List<DeptManager> selectDeptManagerList(){
		List<DeptManager> list = new ArrayList<DeptManager>();
		String sql = "SELECT e.emp_no, CONCAT(e.first_name,' ',e.last_name) name, d.dept_no, d.dept_name, dm.from_date, dm.to_date "
				+ "FROM dept_manager dm JOIN employees e JOIN departments d "
				+ "WHERE e.emp_no = dm.emp_no AND d.dept_no = dm.dept_no ORDER BY  dm.to_date DESC, dm.emp_no ASC";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				DeptManager dm = new DeptManager();
				dm.setEmployees(new Employees());
				dm.getEmployees().setEmpNo(rs.getInt("e.emp_no"));
				dm.getEmployees().setName(rs.getString("name"));
				dm.setDepartment(new Department());
				dm.getDepartment().setDeptNo(rs.getString("d.dept_no"));
				dm.getDepartment().setDeptName(rs.getString("d.dept_name"));
				dm.setFromDate(rs.getString("dm.from_date"));
				dm.setToDate(rs.getString("dm.to_date"));
				list.add(dm);
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
	
	// 부서(departments)의 개수를 가져오는 메소드
	public int selectDeptManagersRowCount() {
		// 수를 저장하여 반환 할 변수 
		int count = 0;
		// 쿼리 작성 
		final String sql = "SELECT COUNT(*) FROM dept_manager";
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
