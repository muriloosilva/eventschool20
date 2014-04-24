package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Usuario;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet(name = "acessoAdministrador", urlPatterns = { "/acessoAdministrador" })
public class LoginAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario user = (Usuario)session.getAttribute("usuario");
		
		if(user == null){
			
			String name = request.getParameter("e-mail");
			String passwd = request.getParameter("senha");
			
			Usuario usuario = new Usuario();
			usuario.setEmail(name);
			usuario.setSenha(passwd);
			
			System.out.println("oi " + request.getParameter("cod"));
	 		System.out.println("oih " + request.getAttribute("cod"));
			
			usuario = ControleLogin.loginAdministrador(usuario);
			if(usuario != null){
				if(usuario.isLogado()){
					request.getSession().setAttribute("usuario", usuario);
					RequestDispatcher view = request.getRequestDispatcher("/admin/eventos.jsp");
					view.forward(request, response);
				}
				else{
					request.setAttribute("msg","Usuário ou senha inválido");
					RequestDispatcher view = request.getRequestDispatcher("loginAdministrador.jsp");
					view.forward(request, response);
				}
			}
			else{
				if(name!=null){
					request.setAttribute("msg","Usuário ou senha inválido");
					RequestDispatcher view = request.getRequestDispatcher("loginAdministrador.jsp");
					view.forward(request, response);
				}
				else{
					request.setAttribute("msg","Para acessar o sistema é necessário realizar login");
					RequestDispatcher view = request.getRequestDispatcher("loginAdministrador.jsp");
					view.forward(request, response);
				}
			}
		}
		else{
			if(user.isLogado()){
				request.getSession().setAttribute("usuario", user);
				RequestDispatcher view = request.getRequestDispatcher("/admin/eventos.jsp");
				view.forward(request, response);
			}
			else{
				request.setAttribute("msg","Usuário ou senha inválido");
				RequestDispatcher view = request.getRequestDispatcher("loginParticipante.jsp");
				view.forward(request, response);
			}
		}
	}

}
