package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Department;


@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: DepartmentsListSevlet 실행 :::");
		
		DepartmentsDao departmentDao = new DepartmentsDao();
		List<Department> list = departmentDao.selectDepartmentsList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);;
	}

}
