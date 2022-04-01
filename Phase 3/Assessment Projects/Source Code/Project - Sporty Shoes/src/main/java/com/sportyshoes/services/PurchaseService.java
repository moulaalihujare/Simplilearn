package com.sportyshoes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entities.Purchase;
import com.sportyshoes.repo.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public Purchase addPurchase(Purchase purchase)
	{
		return purchaseRepository.save(purchase);
	}
	
	public List<Purchase> getAllProducts()
	{
		List<Purchase> purchases = purchaseRepository.findAll();
		return purchases;
	} 
	
	public List<Purchase> getProductsByCategory(int categoryId)
	{
		List<Purchase> purchase = purchaseRepository.findAll();
		List<Purchase> purchasedByCategory = new ArrayList<>();
		for(Purchase pur : purchase)
		{
			if(pur.getProduct().getCategory().getId()==categoryId)
			{
				purchasedByCategory.add(pur);
			}
		}
		return purchasedByCategory;
	}
}
