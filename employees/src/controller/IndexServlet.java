package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;


@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
    private DeptManagersDao deptManagerDao;
    private DeptEmpDao deptEmpDao;
    private SalariesDao salariesDao;
    private TitlesDao titlesDao;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: IndexServlet 실행 :::");
		
		//로그인 확인
		HttpSession session = request.getSession();
		System.out.println("sessionEmpNo: "+session.getAttribute("sessionEmpNo"));
		
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
      
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
      
		deptManagerDao = new DeptManagersDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagersRowCount();
      
		deptEmpDao = new DeptEmpDao();
      	int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
      
      	salariesDao = new SalariesDao();
      	int salariesRowCount = salariesDao.selectSalariesRowCount();
      
      	titlesDao = new TitlesDao();
      	int titlesRowCount = titlesDao.selectTitlesRowCount();
      
      	
      	System.out.println("emp테이블의 총 갯수 : " + employeesRowCount);
      
      	System.out.println("departments테이블의 총 갯수 : " + departmentsRowCount);
      	System.out.println("deptManager테이블의 총 갯수 : " + deptManagerRowCount);
      	System.out.println("deptEmp테이블의 총 갯수 : " + deptEmpRowCount);
      	System.out.println("salaries테이블의 총 갯수 : " + salariesRowCount);
      	System.out.println("titles테이블의 총 갯수 : " + titlesRowCount);
      
      	// 총 갯수를 받기위해 request에 count를 저장함
      	request.setAttribute("employeesRowCount", employeesRowCount);
      	request.setAttribute("departmentsRowCount", departmentsRowCount);
      	request.setAttribute("deptManagerRowCount", deptManagerRowCount);
      	request.setAttribute("deptEmpRowCount", deptEmpRowCount);
      	request.setAttribute("salariesRowCount", salariesRowCount);
      	request.setAttribute("titlesRowCount", titlesRowCount);
      
      	// request와 response를 받아서 index.jsp로 포워딩 
      	request.getRequestDispatcher("./WEB-INF/views/index.jsp").forward(request, response);

	}

}
