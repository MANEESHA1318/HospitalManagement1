package com.hospital.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.dao.DoctorLoginRepository;
import com.hospital.model.Admin;
import com.hospital.model.AuthenticationStatus;
import com.hospital.model.DoctorLogin;
@Service
public class DoctorLoginService {

	@Autowired
	DoctorLoginRepository doctorloginRepository;
	public AuthenticationStatus validateDoctorLogin(String username, String password) {
		AuthenticationStatus status = null;
		DoctorLogin doctorlogin = doctorloginRepository.validateDoctorLogin(username, password);
		if(doctorlogin!=null) {
			status = new AuthenticationStatus(doctorlogin.getUsername(), doctorlogin.getPassword(), true);
		}
		else {
			status = new AuthenticationStatus(null, null, false);
		}
		return status;
	}
	
}