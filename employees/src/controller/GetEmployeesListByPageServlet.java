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

@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: GetEmployeesListByPageServlet 실행! :::");
		int currentPage = 1;
		int rowPerPage = 5;
 
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		System.out.println("currentPage: "+currentPage);
		System.out.println("rowPerPage: "+rowPerPage);
		
		EmployeesDao employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		int rowCount = employeesDao.selectEmployeesRowCount();
		int lastPage = rowCount/rowPerPage;
		if(rowCount%rowPerPage != 0) {
			lastPage++;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		
		System.out.println("employeesListByPage.jsp 로 반환");
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}

}
