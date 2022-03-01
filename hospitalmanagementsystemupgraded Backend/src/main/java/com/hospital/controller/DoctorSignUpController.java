package com.hospital.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.exception.ResourceNotFoundException;
import com.hospital.model.DoctorSignUp;
import com.hospital.service.DoctorSignUpService;
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class DoctorSignUpController {
	@Autowired
	DoctorSignUpService doctorsignupService;
//http://localhost:8080/api/v1/alldoctors
	@GetMapping("/doctors")
	public List<DoctorSignUp> getDoctors() {
		List<DoctorSignUp> dspList = doctorsignupService.fetchDoctors();
		return dspList;
	}

	// http://localhost:8080/api/v1/doctors/45 
	@GetMapping("/doctors/{d_id}")
	public ResponseEntity<DoctorSignUp> getDoctorById(@PathVariable("d_id") int d_id)
			throws ResourceNotFoundException {
		DoctorSignUp d = doctorsignupService.getDoctor(d_id);
		return ResponseEntity.ok().body(d);
	}

	// http://localhost:8080/api/v1/doctors
	@PostMapping("/doctors")
	public DoctorSignUp addDoctorSignUp(@RequestBody DoctorSignUp d) {
		DoctorSignUp doctorsignup = doctorsignupService.saveDoctor(d);
		return doctorsignup;
	}

	// http://localhost:8080/api/v1/doctors/2
	@PutMapping("/doctors/{d_id}")
	public ResponseEntity<DoctorSignUp> updateDoctorSignUp(@PathVariable("d_id") int d_id,
			@RequestBody DoctorSignUp doctorsignupDetails) throws ResourceNotFoundException {
		DoctorSignUp d = doctorsignupService.getDoctor(d_id);
		d.setD_name(doctorsignupDetails.getD_name());
		d.setGender(doctorsignupDetails.getGender());
		d.setUsername(doctorsignupDetails.getUsername());
		d.setPassword(doctorsignupDetails.getPassword());
		d.setContact_no(doctorsignupDetails.getContact_no());
		d.setAddress(doctorsignupDetails.getAddress());
		d.setSpecialization(doctorsignupDetails.getSpecialization());
		final DoctorSignUp updatedDoctor = doctorsignupService.saveDoctor(d);
		return ResponseEntity.ok(updatedDoctor);
	}

//http://localhost:8080/api/v1/doctors/1
	@DeleteMapping(value = "/doctors/{d_id}")
	public ResponseEntity<Object> deleteDoctor(@PathVariable("d_id") int d_id) {

		doctorsignupService.deleteDoctor(d_id);
		return new ResponseEntity<>("Doctor deleted successsfully", HttpStatus.OK);
	}
	
}
