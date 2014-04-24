package DB;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.Base64;

import models.Imagem;
import models.Product;
import models.ProductWebService;

public class ProductDAO {
	public static void addProduct(Product product){
		
		String sql = "insert into produtos " +
				"(descricaoproduto,valorproduto,destaqueproduto," +
				"valoranteriorproduto,qtdestoqueproduto,imagemproduto," +
				"idsubcategoria)" +
				" values (?,?,?,?,?,?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,product.getDescricao());
			stmt.setDouble(2,product.getValorAtual());
			stmt.setBoolean(3,product.isEmDestaque());
			stmt.setDouble(4,product.getValorAnterior());
			stmt.setInt(5,product.getQuantidadeEmEstoque());
			stmt.setBinaryStream(6,product.getImagem().getImagem(),product.getImagem().getTamanhoImagem());
			stmt.setInt(7,product.getSubCategory().getId());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Product> getProducts(){
		
		PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				Product product = new Product();
				product.setCod(rs.getInt("idproduto"));
				product.setDescricao(rs.getString("descricaoproduto"));
				product.setValorAtual(rs.getDouble("valorproduto"));
				product.setEmDestaque(rs.getBoolean("destaqueproduto"));
				product.setValorAnterior(rs.getDouble("valoranteriorproduto"));
				product.setQuantidadeEmEstoque(rs.getInt("qtdestoqueproduto"));
				
				Imagem imagem = new Imagem();	
				imagem.setImagem(rs.getBinaryStream("imagemproduto"));
				imagem.setTamanhoImagem((int)rs.getBytes("imagemproduto").length);
				
				product.setImagem(imagem);
				product.setSubCategory(SubCategoryDAO.getSubCategory((rs.getInt("idsubcategoria"))));
				products.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(products.isEmpty())
			return null;
		else
			return products;
		
	}
	
	public static int getNumberPagesProductsCategory(int codCategory, int quantidadeProdutoPagina){
    	PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		try {
			
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos p " +
										"inner join subcategorias s on " +
										"p.idsubcategoria = s.idsubcategoria " +
										"inner join categorias c on " +
										"c.idcategoria = s.idcategoria " +
										"where c.idcategoria = " + codCategory +";");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//Apenas para contar a quantidade de registros retornados
				Product product = new Product();
				products.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(products.isEmpty())
			return 0;
		else{
			int quantidadeDeProdutos = products.size();
			int quantidadePaginas = 0;
			if(quantidadeDeProdutos%quantidadeProdutoPagina == 0)
				quantidadePaginas = quantidadeDeProdutos/quantidadeProdutoPagina;
			else
				quantidadePaginas = (quantidadeDeProdutos/quantidadeProdutoPagina) +1; 
			return quantidadePaginas;
		}
    }
	
    public static List<Product> getProductsCategory(int codCategory, int limit, int offSet){
		
		PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		try {
			
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos p " +
										"inner join subcategorias s on " +
										"p.idsubcategoria = s.idsubcategoria " +
										"inner join categorias c on " +
										"c.idcategoria = s.idcategoria " +
										"where c.idcategoria = " + codCategory +
										" order by idproduto LIMIT "+limit+" OFFSET "+offSet+";");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				Product product = new Product();
				product.setCod(rs.getInt("idproduto"));
				product.setDescricao(rs.getString("descricaoproduto"));
				product.setValorAtual(rs.getDouble("valorproduto"));
				product.setEmDestaque(rs.getBoolean("destaqueproduto"));
				product.setValorAnterior(rs.getDouble("valoranteriorproduto"));
				product.setQuantidadeEmEstoque(rs.getInt("qtdestoqueproduto"));
				
				Imagem imagem = new Imagem();	
				imagem.setImagem(rs.getBinaryStream("imagemproduto"));
				imagem.setTamanhoImagem((int)rs.getBytes("imagemproduto").length);
				
				product.setImagem(imagem);
				product.setSubCategory(SubCategoryDAO.getSubCategory((rs.getInt("idsubcategoria"))));
				products.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(products.isEmpty())
			return null;
		else
			return products;
		
	}
    
    public static int getNumberPagesProductsSubCategory(int codSubCategory, int quantidadeProdutoPagina){
    	PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		try {
			
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos where idsubcategoria = " + codSubCategory +";");
			
			ResultSet rs = stmt.executeQuery();
			rs.getFetchSize();
			while (rs.next()) {
				//Apenas para contar a quantidade de registros retornados
				Product product = new Product();
				products.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(products.isEmpty())
			return 0;
		else{
			int quantidadeDeProdutos = products.size();
			int quantidadePaginas = 0;
			if(quantidadeDeProdutos%quantidadeProdutoPagina == 0)
				quantidadePaginas = quantidadeDeProdutos/quantidadeProdutoPagina;
			else
				quantidadePaginas = (quantidadeDeProdutos/quantidadeProdutoPagina) +1; 
			return quantidadePaginas;
		}
    }
    
    public static List<Product> getProductsSubCategory(int codSubCategory, int limit, int offSet){
		
		PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		try {
			
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos where idsubcategoria = " + codSubCategory +
					" order by idproduto LIMIT "+limit+" OFFSET "+offSet+";");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				Product product = new Product();
				product.setCod(rs.getInt("idproduto"));
				product.setDescricao(rs.getString("descricaoproduto"));
				product.setValorAtual(rs.getDouble("valorproduto"));
				product.setEmDestaque(rs.getBoolean("destaqueproduto"));
				product.setValorAnterior(rs.getDouble("valoranteriorproduto"));
				product.setQuantidadeEmEstoque(rs.getInt("qtdestoqueproduto"));
				
				Imagem imagem = new Imagem();	
				imagem.setImagem(rs.getBinaryStream("imagemproduto"));
				imagem.setTamanhoImagem((int)rs.getBytes("imagemproduto").length);
				
				product.setImagem(imagem);
				product.setSubCategory(SubCategoryDAO.getSubCategory((rs.getInt("idsubcategoria"))));
				products.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(products.isEmpty())
			return null;
		else
			return products;
		
	}
	
	public static Product getProduct(int cod){
		
		PreparedStatement stmt;
		Product product = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos where idproduto = "+ cod);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				product = new Product();
				product.setCod(rs.getInt("idproduto"));
				product.setDescricao(rs.getString("descricaoproduto"));
				product.setValorAtual(rs.getDouble("valorproduto"));
				product.setEmDestaque(rs.getBoolean("destaqueproduto"));
				product.setValorAnterior(rs.getDouble("valoranteriorproduto"));
				product.setQuantidadeEmEstoque(rs.getInt("qtdestoqueproduto"));
				
				Imagem imagem = new Imagem();	
				imagem.setImagem(rs.getBinaryStream("imagemproduto"));
				imagem.setTamanhoImagem((int)rs.getBytes("imagemproduto").length);
				
				product.setImagem(imagem);
				product.setSubCategory(SubCategoryDAO.getSubCategory((rs.getInt("idsubcategoria"))));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	public static ProductWebService getProductWebService(int cod){
		
		PreparedStatement stmt;
		ProductWebService product = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from produtos where idproduto = "+ cod);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				product = new ProductWebService();
				product.setCod(rs.getInt("idproduto"));
				product.setDescricao(rs.getString("descricaoproduto"));
				product.setValorAtual(rs.getDouble("valorproduto"));
				product.setEmDestaque(rs.getBoolean("destaqueproduto"));
				product.setValorAnterior(rs.getDouble("valoranteriorproduto"));
				product.setQuantidadeEmEstoque(rs.getInt("qtdestoqueproduto"));
				
				//Imagem imagem = new Imagem();	
				//imagem.setImagem(rs.getBinaryStream("imagemproduto"));
				//imagem.setTamanhoImagem((int)rs.getBytes("imagemproduto").length);
				
				
				String encodedImage2 = Base64.encode(rs.getBytes("imagemproduto"));
				
				product.setImagem(encodedImage2);
				product.setSubCategory(SubCategoryDAO.getSubCategory((rs.getInt("idsubcategoria"))));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
		
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
