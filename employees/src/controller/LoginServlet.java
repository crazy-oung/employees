package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: LoginServlet doGet 실행 :::");
		request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request, response);	
	}
	
	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: LoginServlet doPost 실행 :::");
		
		System.out.println("sessionEmpNo: "+request.getParameter("sessionEmpNo"));
		System.out.println("firstName: "+request.getParameter("firstName"));
		System.out.println("lastName: "+request.getParameter("lastName"));
		
		// 올바르지 못한 입력값
		if(request.getParameter("sessionEmpNo") == "") {
			request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request, response);
			return;
		}
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("sessionEmpNo"));
		

		
		HttpSession session = request.getSession();
		Employees employees = new Employees();
		employees.setFirstName(firstName);
		employees.setLastName(lastName);
		employees.setEmpNo(empNo);
		
		EmployeesDao employeesDao = new EmployeesDao();
		int sessionEmpNo = employeesDao.login(employees);
		
		// 올바르지 못한 정보
		if(sessionEmpNo ==0) {
			request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request, response);
			return;
		}
		//포워딩 확인
		System.out.println("getRequestDispatcher ./WEB-INF/views/index.jsp");
		
		session.setAttribute("sessionEmpNo", sessionEmpNo);
		response.sendRedirect(request.getContextPath()+"/");
	}

}
