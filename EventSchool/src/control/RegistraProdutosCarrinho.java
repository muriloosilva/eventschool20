package control;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import util.ListProduct;
import DB.ProductDAO;

/**
 * Servlet implementation class RegistraProdutosDeInteresse
 */
@WebServlet("/adicionarCarrinho")
public class RegistraProdutosCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraProdutosCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = 0;
		String scod = request.getParameter("cod");
		if(scod != null){
			cod = Integer.parseInt(scod);
		}
		else{
			//não será possível adicionar produto no carrinho
		}

			
			
		Product product = ProductDAO.getProduct(cod);
		List<Product> listProductSession = (List<Product>)request.getSession().getAttribute("carrinhoDeCompras");
		
		if(listProductSession == null){
			List<Product> listProduct = new ArrayList<Product>();
			listProduct.add(product);
			request.getSession().setAttribute("carrinhoDeCompras", listProduct);
		}
		else{
			listProductSession.add(product);
			request.getSession().setAttribute("carrinhoDeCompras", listProductSession);
		}
			

		
		RequestDispatcher view = request.getRequestDispatcher("listaProdutosCarrinho.jsp");
		view.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
