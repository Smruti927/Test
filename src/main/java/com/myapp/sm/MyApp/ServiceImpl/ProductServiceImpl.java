package com.myapp.sm.MyApp.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.sm.MyApp.Model.Product;
import com.myapp.sm.MyApp.Repo.ProductRepository;
import com.myapp.sm.MyApp.Service.ProductService;


@Service  
@Transactional  
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
			
	
	@Override
	public String save(Product product) {
		repo.save(product);
		return "SUCCESS";
	}
	

}
