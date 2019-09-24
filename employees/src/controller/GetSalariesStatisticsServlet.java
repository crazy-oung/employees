package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalariesDao;


@WebServlet("/salaries/getSalariesStatistics")
public class GetSalariesStatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: TitlesListDistinctServlet 실행 :::");
		
		SalariesDao salariesDao = new SalariesDao();
		Map<String, Long> map = salariesDao.selectSalariesStatistics();

		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/views/salaries/salariesStatistics.jsp").forward(request, response);
	}

}
