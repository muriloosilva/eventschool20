package control;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Product;
import DB.CategoryDAO;
import DB.ProductDAO;

/**
 * Servlet implementation class Horas
 */
@WebServlet("/registerCategory")
public class CategoryRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCategoria = request.getParameter("nomeCategoria");
		
		Category category = new Category();
		category.setNome(nomeCategoria);
		
		CategoryDAO.addCategory(category);
				
		RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
		view.forward(request, response);
	}

}
