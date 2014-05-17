package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.Inscricao;
import DB.AtividadeDAO;
import DB.InscricoesDAO;


@WebServlet(name = "excluirAtividade", urlPatterns = { "/excluirAtividade" })
public class ControleExcluirAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idAtividade = Integer.parseInt(request.getParameter("at"));
		int codEvento = Integer.parseInt(request.getParameter("cod"));
		Atividade atividade = AtividadeDAO.pegarAtividade(idAtividade);
		
		AtividadeDAO.deletarAtividade(atividade);
		
		Inscricao inscricao = new Inscricao();
		inscricao.setAtividade(atividade);
		
		InscricoesDAO.cancelarInscricao(inscricao);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/admin/gerencia.jsp?cod="+codEvento);
		view.forward(request, response);
	}

}
