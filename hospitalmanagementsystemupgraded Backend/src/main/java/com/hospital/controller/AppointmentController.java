package com.hospital.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.exception.ResourceNotFoundException;
import com.hospital.model.Appointment;
import com.hospital.service.AppointmentService;
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class AppointmentController {
	@Autowired
	AppointmentService aService;

//http://localhost:8088/api/v1/appointments
	@GetMapping("/appointments")
	public List<Appointment> getAppointments() {
		List<Appointment> aList = aService.fetchAppointments();

		return aList;

	}

	// http://localhost:8088/api/v1/appointments/1
	@GetMapping("/appointments/{AP_ID}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("AP_ID") int AP_ID)
			throws ResourceNotFoundException {
		Appointment a = aService.getAppointment(AP_ID);
		return ResponseEntity.ok().body(a);
	}

	// http://localhost:8088/api/v1/appointments
	@PostMapping("/appointments")
	public Appointment addAppointment(@RequestBody Appointment a) {

		Appointment appointment = aService.saveAppointment(a);

		// return new ResponseEntity<>("appointments added successsfully", HttpStatus.OK);
		return appointment;
	}

	@PutMapping("/appointments/{AP_ID}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable("AP_ID") int AP_Id,
			@RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
		Appointment app = aService.getAppointment(AP_Id);

		app.setP_id(appointmentDetails.getP_id());
		app.setDisease(appointmentDetails.getDisease());
		app.setD_id(appointmentDetails.getD_id());
		app.setAp_date(appointmentDetails.getAp_date());
		app.setAp_time(appointmentDetails.getAp_time());
		app.setAddress(appointmentDetails.getAddress());
		app.setAp_status(appointmentDetails.getAp_status());
		
		final Appointment updatedAppointment = aService.saveAppointment(app);
		return ResponseEntity.ok(updatedAppointment);
	}

//http://localhost:8088/api/v1/appointment/1
	@DeleteMapping(value = "/appointments/{AP_ID}")
	public ResponseEntity<Object> deleteAppointment(@PathVariable("AP_ID") int AP_ID) {

		aService.deleteAppointment(AP_ID);
		return new ResponseEntity<>("Appointment deleted successsfully", HttpStatus.OK);
	}
}
