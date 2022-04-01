package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.Purchase;
import com.sportyshoes.services.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/")
	public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase)
	{
		Purchase obj= purchaseService.addPurchase(purchase);
		return new ResponseEntity<Purchase>(obj,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public List<Purchase> getAllProduct()
	{
		return purchaseService.getAllProducts();
	}
	
	@GetMapping("/byCategory/{categoryId}")
	public List<Purchase> getAllProductByCategory(@PathVariable int categoryId)
	{
		return purchaseService.getProductsByCategory(categoryId);
	}
}
