package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/")
	public String adminLogin(@RequestParam String email, @RequestParam String password)
	{
		if(adminService.verifyAdmin(email, password))
		{
			return "Login Successfull";
		}
		else
		{
			return "Login Failed";
		}
	}
	
	@PostMapping("/changePassword/{id}&{newPassword}")
	public String changePassword(@PathVariable int id, @PathVariable String newPassword)
	{
		adminService.changePassword(id, newPassword);
		return "Password Changed Successfully";
	}
}
