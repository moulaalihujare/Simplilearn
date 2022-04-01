package com.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
