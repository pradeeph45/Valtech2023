package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface ProductDAO {

	void deleteProduct(int id);

	void updateProduct(Product product);

	void createProduct(Product product);

	List<Product> getAllProducts();

	Product getProduct();

	long countProduct();

}