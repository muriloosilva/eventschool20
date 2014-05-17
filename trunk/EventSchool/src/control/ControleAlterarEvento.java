package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.Evento;
import models.Usuario;
import DB.AtividadeDAO;
import DB.EventoDAO;
import DB.UsuarioDAO;


@WebServlet(name = "alterarEvento", urlPatterns = { "/alterarEvento" })
public class ControleAlterarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cod = Integer.parseInt(request.getParameter("cod"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String local = request.getParameter("local");
		String dataInicio = request.getParameter("inicio");
		String dataFim = request.getParameter("fim");
		String dataInicioInscricoes = request.getParameter("inicioInscricoes");
		String dataFimInscricoes = request.getParameter("fimInscricoes");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		
		Evento eventoalterar = new Evento();
		eventoalterar.setId_evento(cod);
		eventoalterar.setNome(nome);
		eventoalterar.setDescricao(descricao);
		eventoalterar.setLocal(local);
		
		try {
			eventoalterar.setDataInicio(new Date(new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio).getTime()));
			eventoalterar.setDataFim(new Date(new SimpleDateFormat("dd/MM/yyyyy").parse(dataFim).getTime()));
			eventoalterar.setDataInicioInscricoes(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioInscricoes).getTime()));
			eventoalterar.setDataFimInscricoes(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(dataFimInscricoes).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eventoalterar.setTelefone(telefone);
		eventoalterar.setEmail(email);
		
		EventoDAO.alterarEvento(eventoalterar);
		RequestDispatcher view = request.getRequestDispatcher("/admin/eventos.jsp");
		view.forward(request, response);
		
	}

}
