package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import model.TitlesDao;
import vo.Employees;

@WebServlet("/titles/titlesListDistinct")
public class TitlesListDistinctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: TitlesListDistinctServlet 실행 :::");
		
		TitlesDao titlesDao = new TitlesDao();
		List<String> list = titlesDao.selectTitlesListDistinct();

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesList.jsp").forward(request, response);
	}

}
