package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;
import models.Usuario;
import DB.ConnectionMannager;
import DB.UsuarioDAO;

public class ControleLogin {
	
	public static Usuario loginParticipante(Usuario usuario){
		Usuario usuarioBD = UsuarioDAO.pegarParticipante(usuario);
		if(usuarioBD != null){
			if(usuarioBD.getEmail().equals(usuario.getEmail()) 
					&& usuarioBD.getSenha().equals(usuario.getSenha())){
				usuarioBD.setLogado(true);
			}
			else
				usuarioBD.setLogado(false);
		}
		return usuarioBD;
	}
	
	public static Usuario loginAdministrador(Usuario usuario){
		Usuario usuarioBD = UsuarioDAO.pegarAdministrador(usuario);
		if(usuarioBD != null){
			if(usuarioBD.getEmail().equals(usuario.getEmail()) 
					&& usuarioBD.getSenha().equals(usuario.getSenha())){
				usuarioBD.setLogado(true);
			}
			else
				usuarioBD.setLogado(false);
		}
		return usuarioBD;
	}
	
	public static void teste(){
		PreparedStatement stmt;
		User userBD = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuarios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				userBD = new User();
				System.out.println(rs.getInt("idusuario"));
				System.out.println(rs.getString("nomeusuario"));
				System.out.println(rs.getString("loginusuario"));
				System.out.println(rs.getString("senhausuario"));
				System.out.println(rs.getString("papelusuario"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
