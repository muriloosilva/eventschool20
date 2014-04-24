package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDAO {
	public static boolean adicionarUsuario(Usuario usuario){
		
		String sql = "insert into usuario " +
				"(nome, cpf, email, data_nascimento, senha, papel)" +
				" values (?,?,?,?,?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,usuario.getNome());
			stmt.setString(2,usuario.getCpf());
			stmt.setString(3,usuario.getEmail());
			stmt.setDate(4,usuario.getDataNascimento());
			stmt.setString(5,usuario.getSenha());
			stmt.setString(6,"participante");
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
//	public static List<Evento> listaDeEventos(){
//		
//		PreparedStatement stmt;
//		List<Evento> eventos = new ArrayList<Evento>();
//		try {
//			Connection con = ConnectionMannager.getConnetion();
//			stmt = con.prepareStatement("select * from evento");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				
//				Evento evento = new Evento();
//				evento.setId_evento(rs.getInt("evento_pk"));
//				evento.setNome(rs.getString("nome"));
//				evento.setDescricao(rs.getString("descricao"));
//				evento.setLocal(rs.getString("local"));
//				evento.setDataInicio(rs.getDate("data_inicio"));
//				evento.setDataFim(rs.getDate("data_fim"));
//				evento.setDataInicioInscricoes(rs.getDate("data_inicio_inscricoes"));
//				evento.setDataFimInscricoes(rs.getDate("data_fim_inscricoes"));
//				evento.setTelefone(rs.getString("telefone"));
//				evento.setEmail(rs.getString("email"));
//				eventos.add(evento);
//			}
//			rs.close();
//			stmt.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if(eventos.isEmpty())
//			return null;
//		else
//			return eventos;
//		
//	}
	
	public static Usuario pegarUsuario(int id){
		
		PreparedStatement stmt;
		Usuario usuario = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuario where usuario_pk = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("usuario_pk"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataNascimento(rs.getDate("data_nascimento"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPapel(rs.getString("papel"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return usuario;
		
	}
	
	public static Usuario pegarParticipante(Usuario usu){
		
		PreparedStatement stmt;
		Usuario usuario = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuario " +
					"where email = ? and papel = 'participante'");
			stmt.setString(1,usu.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("usuario_pk"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataNascimento(rs.getDate("data_nascimento"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPapel(rs.getString("papel"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return usuario;
		
	}
	
	public static Usuario pegarAdministrador(Usuario usu){
		
		PreparedStatement stmt;
		Usuario usuario = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuario " +
					"where email = ? and papel = 'administrador'");
			stmt.setString(1,usu.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("usuario_pk"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataNascimento(rs.getDate("data_nascimento"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPapel(rs.getString("papel"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return usuario;
		
	}
	
	public static boolean alterarUsuario(Usuario usuario){
		
		String sql = "update usuario set nome=?, cpf=?, email=?," +
				"data_nascimento=?, senha=? where usuario_pk=?";
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,usuario.getNome());
			stmt.setString(2,usuario.getCpf());
			stmt.setString(3,usuario.getEmail());
			stmt.setDate(4,usuario.getDataNascimento());
			stmt.setString(5,usuario.getSenha());
			stmt.setInt(6, usuario.getIdUsuario());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

		
	}
	
	public static boolean deletarUsuario(Usuario usuario){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete * from usuario where "
					+ "usuario_pk=?");
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				return false;
			}
		return true;
	}	
	
}
