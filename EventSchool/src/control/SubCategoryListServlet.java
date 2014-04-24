package control;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import models.Category;
import models.Product;
import models.SubCategory;
import DB.CategoryDAO;
import DB.ProductDAO;
import DB.SubCategoryDAO;

/**
 * Servlet implementation class Horas
 */
@WebServlet("/subCategoryList")
public class SubCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		List<SubCategory> listSubCategory = SubCategoryDAO.getSubCategories(idCategoria);
		if(listSubCategory == null){
			pw.println("<option>Nenhuma SubCategoria Cadastrada</option>");
		}
		else{
			Iterator<SubCategory> iteratorSubCategory = listSubCategory.iterator();
			
			while(iteratorSubCategory.hasNext()){
				SubCategory subCategory = iteratorSubCategory.next();
				pw.println("<option value='"+subCategory.getId()+"'>"+subCategory.getNome()+"</option>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
				
		//RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
		//view.forward(request, response);
	}

}
