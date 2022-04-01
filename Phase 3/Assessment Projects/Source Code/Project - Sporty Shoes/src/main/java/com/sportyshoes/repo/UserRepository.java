package com.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
