package com.sportyshoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entities.Product;
import com.sportyshoes.repo.ProductRepository;
import com.sportyshoes.response.ProductResponse;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(int id)
	{
		productRepository.deleteById(id);
	}
	
	public Boolean updateProduct(int id, Product product)
	{
		Product prod = productRepository.findById(id).get();
		if(prod.getId()==0)
		{
			return false;
		}
		else
		{
			prod = product;
			productRepository.save(prod);
			return true;
		}
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> prods = productRepository.findAll();
		return prods;
	}
	
	public ProductResponse searchProduct(int id)
	{
		ProductResponse pr = new ProductResponse();
		Optional<Product> searchedProduct = productRepository.findById(id);
		if(searchedProduct.isPresent())
		{
			Product prod = searchedProduct.get();
			pr.setId(prod.getId());
			pr.setName(prod.getName());
			pr.setPrice(prod.getPrice());
			pr.setCategory(prod.getCategory());
		}
		return pr;
	}
}
