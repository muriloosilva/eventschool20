package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.Usuario;

public class FiltroSegurancaAdministrador implements Filter{ 
	public void init(FilterConfig config) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario!=null && usuario.isLogado() && usuario.getPapel().equals(Usuario.papelAdmin)){
			chain.doFilter(req, res);
			
		}else{
			req.setAttribute("msg","Você não está logado no sistema!");
			RequestDispatcher view = req.getRequestDispatcher("../loginAdministrador.jsp");
			view.forward(req, res);
		}
	}	 
	public void destroy() {
	}
}
