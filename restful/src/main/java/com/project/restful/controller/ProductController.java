package com.project.restful.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.restful.entity.Product;
import com.project.restful.repository.ProductJpaRepository;



@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	private ProductJpaRepository productJpaRepository;
	
	
	 @Autowired
	public ProductController(ProductJpaRepository productJpaRepository) {
		super();
		this.productJpaRepository = productJpaRepository;
	}







	public ProductController() {
		super();
	}







	@GetMapping("/getAll")
	public List<Product> getAll() {
		return this.productJpaRepository.findAll();
	}
	
	@PostMapping("/add")
	public Product add(@RequestBody Product product) {
		return productJpaRepository.save(product);

	}
	@PutMapping("/{productId}/{clientId}")
	public Product updateOneProduct (@PathVariable Long productId,@PathVariable Long clientId, @RequestBody Product products) {
		Optional<Product> product = productJpaRepository.findById(productId);
				if(product.isPresent()) {
					Product foundProduct = product.get();
					if(foundProduct.getClientId()==clientId)
					{
					foundProduct.setProductName(products.getProductName());
					foundProduct.setClientId(clientId);
					foundProduct.setId(productId);
					foundProduct.setProductPrice(products.getProductPrice());
					productJpaRepository.save(foundProduct);
					return foundProduct;
					}
					else return null;
				}
				
				else
					return null;
	}
	
	@DeleteMapping("/{productId}/{clientId}")
	
	public void deleteOneProduct(@PathVariable Long productId, @PathVariable Long clientId) {
		
		Optional<Product> product = productJpaRepository.findById(productId);
		if(product.isPresent()) {
			Product foundProduct = product.get();
			if(foundProduct.getClientId()==clientId)
			{
	productJpaRepository.deleteById(productId);
	
	}
		}
}
}

