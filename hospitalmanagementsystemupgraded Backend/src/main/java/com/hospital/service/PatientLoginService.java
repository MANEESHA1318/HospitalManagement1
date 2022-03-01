package com.hospital.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.dao.PatientLoginRepository;
import com.hospital.model.AuthenticationStatus;
import com.hospital.model.DoctorLogin;
import com.hospital.model.PatientLogin;
@Service
public class PatientLoginService {

	@Autowired
	PatientLoginRepository patientloginRepository;
		public AuthenticationStatus validatePatientLogin(String username, String password) {
			AuthenticationStatus status = null;
			PatientLogin patientlogin = patientloginRepository.validatePatientLogin(username, password);
			if(patientlogin!=null) {
				status = new AuthenticationStatus(patientlogin.getUsername(), patientlogin.getPassword(), true);
			}
			else {
				status = new AuthenticationStatus(null, null, false);
			}
			return status;
		}
}