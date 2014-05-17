package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Atividade;

public class AtividadeDAO {
	
	public static boolean adicionarAtividade(Atividade atividade){
		
		String sql = "insert into atividade " +
				"(evento_pk, data, hora_inicio, hora_fim, vagas,"
				+ "tipo, nome, descricao)" +
				" values (?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, atividade.getEvento().getId_evento());
			stmt.setDate(2, atividade.getData());
			stmt.setTime(3, atividade.getHoraInicio());
			stmt.setTime(4, atividade.getHoraFim());
			stmt.setInt(5, atividade.getVagas());
			stmt.setString(6, atividade.getTipo());
			stmt.setString(7, atividade.getNome());
			stmt.setString(8,atividade.getDescricao());
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
	
	public static List<Atividade> listaDeAtividades(){
		
		PreparedStatement stmt;
		List<Atividade> atividades = new ArrayList<Atividade>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from atividade");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Atividade atividade = new Atividade();
				atividade.setIdAtividade(rs.getInt("atividade_pk"));
				atividade.setEvento(EventoDAO.pegarEvento(rs.getInt("evento_pk")));
				atividade.setData(rs.getDate("data"));
				atividade.setHoraInicio(rs.getTime("hora_inicio"));
				atividade.setHoraFim(rs.getTime("hora_fim"));
				atividade.setVagas(rs.getInt("vagas"));
				atividade.setTipo(rs.getString("tipo"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividades.add(atividade);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(atividades.isEmpty())
			return null;
		else
			return atividades;
		
	}
	
	public static List<Atividade> listaDePalestrasEvento(int id){
		
		PreparedStatement stmt;
		List<Atividade> atividades = new ArrayList<Atividade>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from atividade where evento_pk="+id+" and tipo='palestra'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Atividade atividade = new Atividade();
				atividade.setIdAtividade(rs.getInt("atividade_pk"));
				atividade.setEvento(EventoDAO.pegarEvento(rs.getInt("evento_pk")));
				atividade.setData(rs.getDate("data"));
				atividade.setHoraInicio(rs.getTime("hora_inicio"));
				atividade.setHoraFim(rs.getTime("hora_fim"));
				atividade.setVagas(rs.getInt("vagas"));
				atividade.setTipo(rs.getString("tipo"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividades.add(atividade);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(atividades.isEmpty())
			return null;
		else
			return atividades;
		
	}
	
	public static List<Atividade> listaDeMinicursoEvento(int id){
		
		PreparedStatement stmt;
		List<Atividade> atividades = new ArrayList<Atividade>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from atividade where evento_pk="+id+" and tipo='minicurso'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Atividade atividade = new Atividade();
				atividade.setIdAtividade(rs.getInt("atividade_pk"));
				atividade.setEvento(EventoDAO.pegarEvento(rs.getInt("evento_pk")));
				atividade.setData(rs.getDate("data"));
				atividade.setHoraInicio(rs.getTime("hora_inicio"));
				atividade.setHoraFim(rs.getTime("hora_fim"));
				atividade.setVagas(rs.getInt("vagas"));
				atividade.setTipo(rs.getString("tipo"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividades.add(atividade);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(atividades.isEmpty())
			return null;
		else
			return atividades;
		
	}
	
public static List<Atividade> listaDeOficinaEvento(int id){
		
		PreparedStatement stmt;
		List<Atividade> atividades = new ArrayList<Atividade>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from atividade where evento_pk="+id+" and tipo='oficina'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Atividade atividade = new Atividade();
				atividade.setIdAtividade(rs.getInt("atividade_pk"));
				atividade.setEvento(EventoDAO.pegarEvento(rs.getInt("evento_pk")));
				atividade.setData(rs.getDate("data"));
				atividade.setHoraInicio(rs.getTime("hora_inicio"));
				atividade.setHoraFim(rs.getTime("hora_fim"));
				atividade.setVagas(rs.getInt("vagas"));
				atividade.setTipo(rs.getString("tipo"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividades.add(atividade);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(atividades.isEmpty())
			return null;
		else
			return atividades;
		
	}
	
	public static Atividade pegarAtividade(int id){
		
		PreparedStatement stmt;
		Atividade atividade = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from atividade where atividade_pk = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				atividade = new Atividade();
				atividade.setIdAtividade(rs.getInt("atividade_pk"));
				atividade.setEvento(EventoDAO.pegarEvento(rs.getInt("evento_pk")));
				atividade.setData(rs.getDate("data"));
				atividade.setHoraInicio(rs.getTime("hora_inicio"));
				atividade.setHoraFim(rs.getTime("hora_fim"));
				atividade.setVagas(rs.getInt("vagas"));
				atividade.setTipo(rs.getString("tipo"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return atividade;
		
	}
	
	public static boolean alterarAtividade(Atividade atividade){
		
		String sql = "update atividade set data=?, hora_inicio=?, hora_fim=?," +
				"vagas=?, tipo=?, nome=?, descricao=?,"
				+ " where atividade_pk=?";
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setDate(2, atividade.getData());
			stmt.setTime(3, atividade.getHoraInicio());
			stmt.setTime(4, atividade.getHoraFim());
			stmt.setInt(5, atividade.getVagas());
			stmt.setString(6, atividade.getTipo());
			stmt.setString(7, atividade.getNome());
			stmt.setString(8,atividade.getDescricao());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

		
	}
	
	public static boolean deletarAtividade(Atividade atividade){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete from atividade where "
					+ "atividade_pk=?");
			stmt.setInt(1, atividade.getIdAtividade());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				return false;
			}
		return true;
	}	
	
}
