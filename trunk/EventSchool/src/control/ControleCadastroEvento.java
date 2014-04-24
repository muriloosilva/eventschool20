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


@WebServlet(name = "cadastrarEvento", urlPatterns = { "/cadastrarEvento" })
public class ControleCadastroEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String local = request.getParameter("local");
		String dataInicio = request.getParameter("inicio");
		String dataFim = request.getParameter("fim");
		String dataInicioInscricoes = request.getParameter("inicioInscricoes");
		String dataFimInscricoes = request.getParameter("fimInscricoes");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		
		Evento eventoCadastro = new Evento();
		
		eventoCadastro.setNome(nome);
		eventoCadastro.setDescricao(descricao);
		eventoCadastro.setLocal(local);
		
		try {
			eventoCadastro.setDataInicio(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(dataInicio).getTime()));
			eventoCadastro.setDataFim(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(dataFim).getTime()));
			eventoCadastro.setDataInicioInscricoes(new Timestamp(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dataInicioInscricoes).getTime()));
			eventoCadastro.setDataFimInscricoes(new Timestamp(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dataFimInscricoes).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eventoCadastro.setTelefone(telefone);
		eventoCadastro.setEmail(email);
		
		EventoDAO.adicionarEvento(eventoCadastro);
		RequestDispatcher view = request.getRequestDispatcher("/admin/eventos.jsp");
		view.forward(request, response);
		
	}

}
