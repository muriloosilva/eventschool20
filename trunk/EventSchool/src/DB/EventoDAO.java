package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Evento;

public class EventoDAO {
	public static boolean adicionarEvento(Evento evento){
		
		String sql = "insert into evento " +
				"(nome, descricao, local, data_inicio, data_fim, data_inicio_inscricoes,"
				+ "data_fim_inscricoes, telefone, email)" +
				" values (?,?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,evento.getNome());
			stmt.setString(2,evento.getDescricao());
			stmt.setString(3,evento.getLocal());
			stmt.setDate(4,evento.getDataInicio());
			stmt.setDate(5,evento.getDataFim());
			stmt.setTimestamp(6,evento.getDataInicioInscricoes());
			stmt.setTimestamp(7,evento.getDataFimInscricoes());
			stmt.setString(8,evento.getTelefone());
			stmt.setString(9,evento.getEmail());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public static List<Evento> listaDeEventos(){
		
		PreparedStatement stmt;
		List<Evento> eventos = new ArrayList<Evento>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from evento");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Evento evento = new Evento();
				evento.setId_evento(rs.getInt("evento_pk"));
				evento.setNome(rs.getString("nome"));
				evento.setDescricao(rs.getString("descricao"));
				evento.setLocal(rs.getString("local"));
				evento.setDataInicio(rs.getDate("data_inicio"));
				evento.setDataFim(rs.getDate("data_fim"));
				evento.setDataInicioInscricoes(rs.getTimestamp("data_inicio_inscricoes"));
				evento.setDataFimInscricoes(rs.getTimestamp("data_fim_inscricoes"));
				evento.setTelefone(rs.getString("telefone"));
				evento.setEmail(rs.getString("email"));
				eventos.add(evento);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(eventos.isEmpty())
			return null;
		else
			return eventos;
		
	}
	
	public static Evento pegarEvento(int id){
		
		PreparedStatement stmt;
		Evento evento = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from evento where evento_pk = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				evento = new Evento();
				evento.setId_evento(rs.getInt("evento_pk"));
				evento.setNome(rs.getString("nome"));
				evento.setDescricao(rs.getString("descricao"));
				evento.setLocal(rs.getString("local"));
				evento.setDataInicio(rs.getDate("data_inicio"));
				evento.setDataFim(rs.getDate("data_fim"));
				evento.setDataInicioInscricoes(rs.getTimestamp("data_inicio_inscricoes"));
				evento.setDataFimInscricoes(rs.getTimestamp("data_fim_inscricoes"));
				evento.setTelefone(rs.getString("telefone"));
				evento.setEmail(rs.getString("email"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return evento;
		
	}
	
	public static boolean alterarEvento(Evento evento){
		
		String sql = "update evento set nome=?, descricao=?, local=?," +
				"data_inicio=?, data_fim=?, data_inicio_inscricoes=?"
				+ ", data_fim_inscricoes=?, telefone=?, email=?"
				+ " where evento_pk=?";
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,evento.getNome());
			stmt.setString(2,evento.getDescricao());
			stmt.setString(3,evento.getLocal());
			stmt.setDate(4,evento.getDataInicio());
			stmt.setDate(5,evento.getDataFim());
			stmt.setTimestamp(6,evento.getDataInicioInscricoes());
			stmt.setTimestamp(7,evento.getDataFimInscricoes());
			stmt.setString(8,evento.getTelefone());
			stmt.setString(9,evento.getEmail());
			stmt.setInt(10, evento.getId_evento());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;

		
	}
	
	public static boolean deletarEvento(Evento evento){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete * from evento where "
					+ "evento_pk=?");
			stmt.setInt(1, evento.getId_evento());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				return false;
			}
		return true;
	}	
	
}
