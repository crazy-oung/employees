package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptEmpDao;
import vo.DeptEmp;

@WebServlet("/departmentEmployees/getDeptEmpListByPage")
public class GetDeptEmpListByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: GetDeptEmpListByPageServlet 실행:::");
		int currentPage = 1;
		int rowPerPage = 5;
				
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		// 받아온 값 확인
		System.out.println("rowPerPage: "+request.getParameter("rowPerPage")+", currentPage: "+request.getParameter("currentPage"));
		System.out.println(rowPerPage+" "+currentPage);
		List<DeptEmp> list = new ArrayList<DeptEmp>();
		DeptEmpDao deptEmpDao = new DeptEmpDao();
		list = deptEmpDao.selectDeptEmpListByPage(currentPage, rowPerPage);
		int lastPage = deptEmpDao.selectDeptEmpRowCount() / rowPerPage;
		if(deptEmpDao.selectDeptEmpRowCount() % rowPerPage != 0) {
			lastPage++;
		}
		System.out.println(lastPage);
		request.setAttribute("list", list);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/departments/deptEmpListByPage.jsp").forward(request, response);
	}

}
