package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entities.Admin;
import com.sportyshoes.repo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Boolean verifyAdmin(String email, String password)
	{
		List<Admin> admins = adminRepository.findAll();
		
		for(Admin admin : admins)
		{
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public void changePassword(int id, String newPassword)
	{
		Admin admin = adminRepository.findById(id).get();
		
		admin.setPassword(newPassword);
		
		adminRepository.save(admin);
		
		System.out.println("Password Changed Successfully");
	}
}
