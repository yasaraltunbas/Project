package com.project.restful.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="projectdb")

public class Product {

		@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name ="product_name")
	private String ProductName;
	
	@Column(name ="product_price")

	private int ProductPrice;
	
	@Column(name="client_id")
	private Long ClientId;


	public Product(Long id, String productName, int productPrice,Long clientId) {
		super();
		Id = id;
		ProductName = productName;
		ProductPrice = productPrice;
		ClientId = clientId;
	}
	
public Product() {
	
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getProductName() {
	return ProductName;
}

public void setProductName(String productName) {
	ProductName = productName;
}

public int getProductPrice() {
	return ProductPrice;
}

public void setProductPrice(int productPrice) {
	ProductPrice = productPrice;
}

public Long getClientId() {
	return ClientId;
}

public void setClientId(Long clientId) {
	ClientId = clientId;
}

@Override
public int hashCode() {
	return Objects.hash(ClientId, Id, ProductName, ProductPrice);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	return Objects.equals(ClientId, other.ClientId) && Objects.equals(Id, other.Id)
			&& Objects.equals(ProductName, other.ProductName) && ProductPrice == other.ProductPrice;
}
	

	









	
	
	
	
}
