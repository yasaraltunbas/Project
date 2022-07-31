package com.project.restful;

import java.lang.ModuleLayer.Controller;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.project.restful.controller.ProductController;
import com.project.restful.entity.Product;
import com.project.restful.repository.ProductJpaRepository;

@SpringBootTest
class RestfulApplicationTests {

	private ProductJpaRepository jpaRepository;
	
	
	
	@Test
	void ProductControllerTest() {
		
		
		ProductJpaRepository productJpaRepository = jpaRepository;
		
		
				
		 ProductController productController = new ProductController(productJpaRepository);
		 
		 Product product = new Product() ;
		product.setProductName("masa");
		product.setClientId((long)4);
		product.setProductPrice(100);
		
		
		 Product response = productController.updateOneProduct((long)13,(long) 2, product);
		 List<Product> products = productController.getAll() ;		 
		
	}

}
