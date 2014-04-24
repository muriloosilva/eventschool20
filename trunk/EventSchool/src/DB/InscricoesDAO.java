package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Atividade;
import models.Inscricao;
import models.User;
import models.Usuario;

public class InscricoesDAO {
	public static boolean adicionarInscricao(Inscricao inscricao){
		
		String sql = "insert into inscricao " +
				"(usuario_pk, atividade_pk)" +
				" values (?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,inscricao.getParticipante().getIdUsuario());
			stmt.setInt(2,inscricao.getAtividade().getIdAtividade());
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
	
	
	public static boolean cancelarInscricao(Inscricao inscricao){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete from inscricao where "
					+ "atividade_pk=?");
			stmt.setInt(1, inscricao.getAtividade().getIdAtividade());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			}
		return true;
	}	
	
	public static boolean verificarInscricao(Atividade a, Usuario u){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("select * from inscricao where atividade_pk=" + a.getIdAtividade() + 
					" and usuario_pk =" +  u.getIdUsuario());
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				rs.close();
				stmt.close();
				con.close();
				return true;
			}
			else{
				return false;
			}
			
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			}
	}
	
}
