package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Product;
import models.SubCategory;

public class SubCategoryDAO {
	public static void addSubCategory(SubCategory subCategory){
		
		String sql = "insert into subcategorias " +
				"(descricaosubcategoria, idcategoria)" +
				" values (?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,subCategory.getNome());
			stmt.setInt(2, subCategory.getCategory().getId());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<SubCategory> getSubCategories(int idCategoria){
		
		Category category = CategoryDAO.getCategory(idCategoria);
		
		PreparedStatement stmt;
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from subcategorias where idcategoria="+idCategoria);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				SubCategory subCategory = new SubCategory();
				subCategory.setId(rs.getInt("idsubcategoria"));
				subCategory.setNome(rs.getString("descricaosubcategoria"));
				subCategory.setCategory(category);
				subCategories.add(subCategory);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(subCategories.isEmpty())
			return null;
		else
			return subCategories;
		
	}
	
	public static SubCategory getSubCategory(int id){
		
		PreparedStatement stmt;
		SubCategory subCategory = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from subcategorias where idsubcategoria = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				subCategory = new SubCategory();
				subCategory.setId(rs.getInt("idsubcategoria"));
				subCategory.setNome(rs.getString("descricaosubcategoria"));
				Category category = CategoryDAO.getCategory(rs.getInt("idcategoria"));
				subCategory.setCategory(category);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subCategory;
		
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
