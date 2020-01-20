package com.app.dao;

import java.util.List;
import com.app.pojos.Product;

public interface IProductDao {

	public List<Product> getAllProducts();
	
	public List<Product> retrieveProductsBySeller(int sellerId);
	
	public List<Product> retrieveProductsByCategory(int categoryId);

	public Product getProduct(int productId);

	public boolean addProduct(Product product);

	public boolean deleteProduct(int productId);
	
	public boolean updateProduct(int id,Product product);

	
}
