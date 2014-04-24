package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.Usuario;
import DB.AtividadeDAO;
import DB.EventoDAO;
import DB.UsuarioDAO;


@WebServlet(name = "cadastrarAtividade", urlPatterns = { "/cadastrarAtividade" })
public class ControleCadastroAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idEvento = Integer.parseInt(request.getParameter("cod"));
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		String data = request.getParameter("data");
		String horaInicio = request.getParameter("horaInicio");
		String horaFim = request.getParameter("horaFim");
		int vagas = Integer.parseInt(request.getParameter("vagas"));
		
		Atividade atividadeCadastro = new Atividade();
		
		atividadeCadastro.setEvento(EventoDAO.pegarEvento(idEvento));
		

		atividadeCadastro.setNome(nome);
		atividadeCadastro.setDescricao(descricao);
		atividadeCadastro.setTipo(tipo);
		
		try {
			atividadeCadastro.setData(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(data).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			atividadeCadastro.setHoraInicio(new Time(new SimpleDateFormat("HH:mm").parse(horaInicio).getTime()));
			atividadeCadastro.setHoraFim(new Time(new SimpleDateFormat("HH:mm").parse(horaFim).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		atividadeCadastro.setVagas(vagas);
		
		AtividadeDAO.adicionarAtividade(atividadeCadastro);
		RequestDispatcher view = request.getRequestDispatcher("/admin/gerencia.jsp");
		view.forward(request, response);
		
	}

}
