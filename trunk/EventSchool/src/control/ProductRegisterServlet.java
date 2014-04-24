package control;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Product;
import DB.ProductDAO;
import DB.SubCategoryDAO;

/**
 * Servlet implementation class Horas
 */
@WebServlet("/registerProduct")
public class ProductRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		out.println("<html><body>"+today+"</body></html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product produto = new Product();
		 
		//boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// Create a factory for disk-based file items
		 DiskFileItemFactory factory = new DiskFileItemFactory();

		 // Configure a repository (to ensure a secure temp location is used)
		 ServletContext servletContext = this.getServletConfig().getServletContext();
		 File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		 factory.setRepository(repository);

		 // Create a new file upload handler
		 ServletFileUpload upload = new ServletFileUpload(factory);

		 List<FileItem> items = null;
		 // Parse the request
		 try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Process the uploaded items
		 Iterator<FileItem> iter = items.iterator();
		 while (iter.hasNext()) {
		     FileItem item = iter.next();

		     if (item.isFormField()) {
		    	 verificaCampos(item, produto);
		     } else {
		    	 InputStream is = item.getInputStream();
		    	 produto.getImagem().setTamanhoImagem((int)item.getSize());
		    	 produto.getImagem().setImagem(is);
		     }
		 }
		
		ProductDAO.addProduct(produto);
				
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}
	
	private void verificaCampos(FileItem item, Product produto){
		
		switch (item.getFieldName()) {
		case "descricao":
			produto.setDescricao(item.getString());		
			break;
		case "valorAtual":
			produto.setValorAtual(Double.parseDouble(item.getString()));
			break;
		case "valorAnterior":
			produto.setValorAnterior(Double.parseDouble(item.getString()));
			break;
		case "quantidadeEstoque":
			produto.setQuantidadeEmEstoque(Integer.parseInt(item.getString()));	
			break;
		case "caixaSubCategoria":
			produto.setSubCategory(SubCategoryDAO.getSubCategory(Integer.parseInt(item.getString())));
			break;
		case "emDestaque":
			produto.setEmDestaque(item.getString().equals("on")?true:false);	
			break;

		default:
			break;
		}
		
	}

}
