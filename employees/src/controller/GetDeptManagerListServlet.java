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
import model.DeptManagersDao;
import vo.DeptEmp;
import vo.DeptManager;


@WebServlet("/departmentManager/getDeptManagerList")
public class GetDeptManagerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptManagersDao dmd = new DeptManagersDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: GetDeptManagerListServlet 실행:::");
		
		List<DeptManager> list = new ArrayList<DeptManager>();

		list = dmd.selectDeptManagerList();
		
		request.setAttribute("list", list);
			
		request.getRequestDispatcher("/WEB-INF/views/departments/deptManagerList.jsp").forward(request, response);
		
		
	}

}
