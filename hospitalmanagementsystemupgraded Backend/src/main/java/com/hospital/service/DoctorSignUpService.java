package com.hospital.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.dao.DoctorSignUpRepository;
import com.hospital.model.DoctorSignUp;
@Service
public class DoctorSignUpService {
	@Autowired
	DoctorSignUpRepository doctorsignupRepository;
	@Transactional
	public List<DoctorSignUp> fetchDoctors() {
		List<DoctorSignUp> doctorsignupList=doctorsignupRepository.findAll();
		return doctorsignupList;
		
	}
	@Transactional
	public DoctorSignUp saveDoctor(DoctorSignUp doctorsignup) {
		
		return doctorsignupRepository.save(doctorsignup);
		
	}
	@Transactional
	public void updateDoctor(DoctorSignUp d) {
		doctorsignupRepository.save(d);	
	
	}
	@Transactional
	public void deleteDoctor(int d_Id) {
		
		System.out.println("service method called");
		doctorsignupRepository.deleteById(d_Id);
	
	}
	@Transactional 
	  public DoctorSignUp getDoctor(int d_Id) { 
	  Optional<DoctorSignUp> optional= doctorsignupRepository.findById(d_Id);
	  DoctorSignUp d=optional.get();
	  return d;
	  }
	

}
