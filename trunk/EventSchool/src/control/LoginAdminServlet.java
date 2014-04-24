package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet(name = "loginAdmin", urlPatterns = { "/loginAdmin" })
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String passwd = request.getParameter("password");
		
		User user = new User();
		user.setLogin(name);
		user.setPasswd(passwd);
		
		//user = ControleLogin.loginAdmin(user);
		
		if(user != null && user.isLogged()){
			request.getSession().setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("/admin/indexAdmin.jsp");
			view.forward(request, response);
		}
		else{
			request.setAttribute("msg","Usuário ou senha inválido");
			RequestDispatcher view = request.getRequestDispatcher("loginAdmin.jsp");
			view.forward(request, response);
		}
	}

}
