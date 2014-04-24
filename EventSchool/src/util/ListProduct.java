package util;
import java.util.List;
import java.util.ArrayList;

import models.Product;


public class ListProduct{
	private List<Product> listProduct = new ArrayList<Product>();
	private static ListProduct listProductInstance;
	
	public void addProduct(Product product){
		listProduct.add(product);
	}
	
	public List<Product> getListProduct(){
		return listProduct;
	}
	
	//Singleton
	public static ListProduct getListProductInstance(){
		if(listProductInstance == null){
			listProductInstance = new ListProduct();
		}
		return listProductInstance;
		
	}
	
}