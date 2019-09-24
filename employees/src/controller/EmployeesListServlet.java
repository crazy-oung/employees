package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

@WebServlet(
		"/employees/GetEmployeesList")
public class EmployeesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: EmployeesListServlet 실행 :::");
		
		//url 처리
		int limit = 30;
		if(request.getParameter("limit") !=null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		System.out.println("limit: "+limit);
		EmployeesDao employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesList(limit);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("::: EmployeesListServlet 실행 :::");
//		int num = 30;
//		if(request.getParameter("num") !=null) {
//			num = Integer.parseInt(request.getParameter("num"));
//		}
//		EmployeesDao employeesDao = new EmployeesDao();
//		List<Employees> list = employeesDao.selectEmployeesList(num);
//
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
//		;
//	}

}
