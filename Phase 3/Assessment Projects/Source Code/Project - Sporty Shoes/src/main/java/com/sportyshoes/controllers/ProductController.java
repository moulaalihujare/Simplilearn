package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.Product;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product obj= productService.addProduct(product);
		return new ResponseEntity<Product>(obj,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable int productId)
	{
		productService.deleteProduct(productId);
		return "Product Deleted";
	}
	
	@PostMapping("/update/")
	public String updateProduct(@RequestBody Product product)
	{
		int productId = product.getId();
		if(productService.updateProduct(productId, product))
		{
			return productService.searchProduct(productId).toString();
		}
		else
		{
			return "No such Product exists";
		}
	}
	
	@GetMapping("/")
	public List<Product> getProducts()
	{
		List<Product> prods = productService.getAllProducts();
		return prods;
	}
}
