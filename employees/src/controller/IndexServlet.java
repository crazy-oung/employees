package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		EmployeesDao employeesdao = new EmployeesDao();
		//사원수 출력해주는 dao메소드 호출하여 받은 값을 employeesRowCount에 저장 
		int employeesRowCount = employeesdao.selectEmployeesCount();
		System.out.println(employeesRowCount);
		
		request.setAttribute("employeesRowCount",employeesRowCount);
		
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}

}
