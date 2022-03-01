package com.hospital.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Admin;
import com.hospital.model.AuthenticationStatus;
import com.hospital.model.DoctorLogin;
import com.hospital.service.DoctorLoginService;
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class DoctorLoginController {
	@Autowired
	DoctorLoginService doctorloginService;
	
	@PostMapping("/doctorlogin")
	public ResponseEntity<AuthenticationStatus> validateDoctorLogin(@RequestBody DoctorLogin doctorlogin) 		
	{
			System.out.println(doctorlogin.getUsername()+" "+doctorlogin.getPassword());
			AuthenticationStatus status = doctorloginService.validateDoctorLogin(doctorlogin.getUsername(), doctorlogin.getPassword());
			return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
			
		}
	}
