package com.hospital.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.dao.PatientSignUpRepository;
import com.hospital.model.PatientSignUp;
@Service
public class PatientSignUpService {
	@Autowired
	PatientSignUpRepository patientsignupRepository;
	
	@Transactional
	public List<PatientSignUp> fetchPatients() {
		List<PatientSignUp> patientsignupList=patientsignupRepository.findAll();
		return patientsignupList;
		
	}
	
	@Transactional
	public PatientSignUp savePatient(PatientSignUp patientsignup) {
		return patientsignupRepository.save(patientsignup);
		
	}
	
	@Transactional
	public void update(PatientSignUp p) {
		patientsignupRepository.save(p);	
	
	}
	
	@Transactional
	public void deletePatient(int p_id) {	
		System.out.println("service method called");
		patientsignupRepository.deleteById(p_id);
	
	}
	
	@Transactional 
	  public PatientSignUp getPatient(int p_id) { 
	  Optional<PatientSignUp> optional= patientsignupRepository.findById(p_id);
	  PatientSignUp p=optional.get();
	  return p;
	  }
	
}
