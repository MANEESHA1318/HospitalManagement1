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

import com.hospital.model.AuthenticationStatus;
import com.hospital.model.DoctorLogin;
import com.hospital.model.PatientLogin;
import com.hospital.service.PatientLoginService;
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class PatientLoginController {
	@Autowired
	PatientLoginService patientloginService;
	
	@PostMapping("/patientlogin")
	public ResponseEntity<AuthenticationStatus> validatePatientLogin(@RequestBody PatientLogin patientlogin) 		
	{
		System.out.println(patientlogin.getUsername()+" "+patientlogin.getPassword());
		AuthenticationStatus status = patientloginService.validatePatientLogin(patientlogin.getUsername(), patientlogin.getPassword());
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
				
			}
		}
