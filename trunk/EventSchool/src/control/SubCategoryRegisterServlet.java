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
import models.SubCategory;
import DB.CategoryDAO;
import DB.ProductDAO;
import DB.SubCategoryDAO;

/**
 * Servlet implementation class Horas
 */
@WebServlet("/registerSubCategory")
public class SubCategoryRegisterServlet extends HttpServlet {
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
		
		String nomeSubCategoria = request.getParameter("nomeSubCategoria");
		int idCategoria = Integer.parseInt(request.getParameter("categorias"));
		
		Category category = CategoryDAO.getCategory(idCategoria);

		SubCategory subCategory = new SubCategory();
		subCategory.setNome(nomeSubCategoria);
		subCategory.setCategory(category);
		
		SubCategoryDAO.addSubCategory(subCategory);
				
		RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
		view.forward(request, response);
	}

}
