package com.project.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restful.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{

	
}