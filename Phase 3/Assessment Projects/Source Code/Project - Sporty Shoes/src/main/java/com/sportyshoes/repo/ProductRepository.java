package com.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
