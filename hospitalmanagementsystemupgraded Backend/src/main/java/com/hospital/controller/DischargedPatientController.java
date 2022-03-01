package com.hospital.controller;
import java.util.List;//import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hospital.model.DischargedPatient;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.service.DischargedPatientService;

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class DischargedPatientController {
	@Autowired
	DischargedPatientService dischargedpatientService;

//http://localhost:8088/api/v1/getAllPatientDischargeDetails
	@GetMapping("/dischargedpatientdetails")
	public List<DischargedPatient> getDischargedPatients() {
		List<DischargedPatient> dischargedpatientList = dischargedpatientService.fetchDischargedPatients();

		return dischargedpatientList;
	}
	@GetMapping("/dischargedpatient/{dpId}")
	public ResponseEntity<DischargedPatient> getDischargedPatientById(@PathVariable("dpId") int dpId)
			throws ResourceNotFoundException {
		DischargedPatient dischargedpatient = dischargedpatientService.getDischargedPatient(dpId);
		return ResponseEntity.ok().body(dischargedpatient);
	}
	// http://localhost:8088/api/v1/PatientDischargeDetails
		@PostMapping("/dischargedpatientdetails")
		public DischargedPatient addDischargedPatient(@RequestBody DischargedPatient dischargedpatient) {

			DischargedPatient dischargepatient1 = dischargedpatientService.saveDischargedPatient(dischargedpatient);

			// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
			return  dischargepatient1;
		}
		// http://localhost:8088/api/v1/updateinvice/2
		@PutMapping("/dischargedpatient/{id}")
		public ResponseEntity<DischargedPatient> updateDischargedPatient(@PathVariable("id") int dpId,
				@RequestBody DischargedPatient dischargedpatientDetails) throws ResourceNotFoundException {
		        DischargedPatient dischargedpatient = dischargedpatientService.getDischargedPatient(dpId);
			dischargedpatient.setP_Id(dischargedpatientDetails.getP_Id());
			dischargedpatient.setDisease(dischargedpatientDetails.getDisease());
			dischargedpatient.setDischargeDate(dischargedpatientDetails.getDischargeDate());
			dischargedpatient.setAmountPaid(dischargedpatientDetails.getAmountPaid());
			

			final DischargedPatient updatedDischargedPatient = dischargedpatientService.saveDischargedPatient(dischargedpatient);
			return ResponseEntity.ok(updatedDischargedPatient);
		}

		//http://localhost:8088/api/v1/deleteinvoice/1
			@DeleteMapping(value = "/dischargedpatient/{dpId}")
			public ResponseEntity<Object> deleteDischargedPatient(@PathVariable("dpId") int dpId) {

				dischargedpatientService.deleteDischargedPatient(dpId);
				return new ResponseEntity<>("patient details deleted successsfully", HttpStatus.OK);
			}


}
