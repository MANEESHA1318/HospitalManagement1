package com.hospital.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Admin;
import com.hospital.model.AuthenticationStatus;
import com.hospital.service.AdminService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/adminlogin")
	public ResponseEntity<AuthenticationStatus> validateAdminLogin(@RequestBody Admin adminlogin)		
	{
		System.out.println(adminlogin.getUsername()+" "+adminlogin.getPassword());
		AuthenticationStatus status = adminService.validateAdminLogin(adminlogin.getUsername(), adminlogin.getPassword());
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
		
	}
}
