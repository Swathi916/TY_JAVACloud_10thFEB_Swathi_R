package com.tyss.springboot.asg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_img")
	private String productImgUrl;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_price")
	private Double productPrice;


	public Product() {
		
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductImgUrl() {
		return productImgUrl;
	}


	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImgUrl=" + productImgUrl
				+ ", productDescription=" + productDescription + ", productPrice=" + productPrice + "]";
	}


	public Product(int productId, String productName, String productImgUrl, String productDescription,
			Double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productImgUrl = productImgUrl;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	
}











