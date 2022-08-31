package com.project.SportyShoesPhase3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SportyShoesPhase3.entity.Categories;
import com.project.SportyShoesPhase3.entity.Product;
import com.project.SportyShoesPhase3.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	public ProductRepository prodrepo;
	
	public List<Product> listAll()
	{
		return prodrepo.findAll();
	}
	
	public void save(Product product)
	{
		prodrepo.save(product);
	}

}
