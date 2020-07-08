package com.myapp.sm.MyApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.sm.MyApp.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
