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


@WebServlet(name = "cancelar", urlPatterns = { "/cancelar" })
public class ControleCancelarInscricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entrouuuu");
		
		int idAtividade = Integer.parseInt(request.getParameter("at"));
		Atividade atividade = AtividadeDAO.pegarAtividade(idAtividade);
		
		Inscricao inscricao = new Inscricao();
		inscricao.setAtividade(atividade);
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		inscricao.setParticipante(usuario);
		
		System.out.println(usuario.getNome());
		
		InscricoesDAO.cancelarInscricao(inscricao);
		
		RequestDispatcher view = request.getRequestDispatcher("/participante/evento.jsp");
		view.forward(request, response);
	}

}
