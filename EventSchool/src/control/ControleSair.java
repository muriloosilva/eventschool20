package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Atividade;
import models.Inscricao;
import models.Usuario;
import DB.AtividadeDAO;
import DB.InscricoesDAO;


@WebServlet(name = "sair", urlPatterns = { "/sair" })
public class ControleSair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		session.removeAttribute("usuario");
		
		RequestDispatcher view = request.getRequestDispatcher("/");
		view.forward(request, response);
	}

}
