package com.dao;

import java.util.List;

import com.model.*;
public interface Productdao {

	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID(int pid);
}
