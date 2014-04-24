package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Product;

public class CategoryDAO {
	public static void addCategory(Category category){
		
		String sql = "insert into categorias " +
				"(descricaocategoria)" +
				" values (?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,category.getNome());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Category> getCategories(){
		
		PreparedStatement stmt;
		List<Category> categories = new ArrayList<Category>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from categorias");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				Category category = new Category();
				category.setId(rs.getInt("idcategoria"));
				category.setNome(rs.getString("descricaocategoria"));
				categories.add(category);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(categories.isEmpty())
			return null;
		else
			return categories;
		
	}
	
	public static Category getCategory(int id){
		
		PreparedStatement stmt;
		Category category = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from categorias where idcategoria = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				category = new Category();
				category.setId(rs.getInt("idcategoria"));
				category.setNome(rs.getString("descricaocategoria"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return category;
		
	}
//	
//	public static void changeProduto(Product product){
//		
//		String sql = "update produto set nome=?, descricao=?, valor_unitario=?," +
//				"unidade=? where cod_produto=?";
//		try {
//			Connection con = ConnectionMannager.getConnetion();
//			PreparedStatement stmt = con.prepareStatement(sql);
//			
//			// seta os valores
//			stmt.setString(1,product.getNome());
//			stmt.setString(2,product.getDescricao());
//			stmt.setDouble(3,product.getValorUnitario());
//			stmt.setString(4, product.getUnidade());
//			stmt.setInt(5, product.getCod());
//			stmt.execute();
//			stmt.close();
//			con.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//
//		
//	}
//	
//	public static void deleteProduto(Product product){
//		
//		try {
//			Connection con = ConnectionMannager.getConnetion();
//			PreparedStatement stmt = con.prepareStatement("delete " +" from product where cod_produto=?");
//			stmt.setLong(1, product.getCod());
//			stmt.execute();
//			stmt.close();
//			con.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//	}	
	
}
