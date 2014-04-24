package control;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

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
import DB.UsuarioDAO;


@WebServlet(name = "cadastrar", urlPatterns = { "/cadastrar" })
public class ControleCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("e-mail");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String nascimento = request.getParameter("nascimento");
		String senha1 = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		
		Usuario usuarioCadastro = new Usuario();
		
		usuarioCadastro.setEmail(email);
		usuarioCadastro.setCpf(cpf);
		usuarioCadastro.setNome(nome);
		try {
			usuarioCadastro.setDataNascimento(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(nascimento).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usuarioCadastro.setSenha(senha1);
		
		if(!senha1.equals(senha2)){
			request.setAttribute("msg", "As senhas inseridas não estão iguais. Verifique.");
			RequestDispatcher view = request.getRequestDispatcher("/cadastrar.jsp");
			view.forward(request, response);
		}
		else if(UsuarioDAO.pegarParticipante(usuarioCadastro) != null){
			request.setAttribute("msg", "E-mail já cadastrado.");
			RequestDispatcher view = request.getRequestDispatcher("/cadastrar.jsp");
			view.forward(request, response);
		}
		else{
			
			UsuarioDAO.adicionarUsuario(usuarioCadastro);
			RequestDispatcher view = request.getRequestDispatcher("/loginParticipante.jsp");
			view.forward(request, response);
			
		}
	}

}
