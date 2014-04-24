package control;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
@WebServlet("/carregaFoto")
public class PictureLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codProduto = Integer.parseInt(request.getParameter("codProduto"));
		
		Product p = ProductDAO.getProduct(codProduto);
		
		ServletOutputStream out = response.getOutputStream();      
	            
	     byte[] buffer = new byte[ p.getImagem().getTamanhoImagem()];       
	     int bytesread = 0;    
	     while((bytesread = p.getImagem().getImagem().read(buffer))!=-1){    
	         out.write(buffer,0,bytesread);    
	     }    
	     out.flush();    
	     out.close();    
	     p.getImagem().getImagem().close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 
	}

}
