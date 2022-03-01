package com.hospitalmanagementsystem.hospitalmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.dao.DischargedPatientRepository;
import com.hospital.model.DischargedPatient;
import com.hospital.dao.FeedbackRepository;
import com.hospital.model.Feedback;
//import com.hospital.dao.AdminSignUpRepository;
//import com.hospital.model.AdminSignUp;
import com.hospital.dao.AppointmentRepository;
import com.hospital.model.Appointment;
import com.hospital.dao.PatientSignUpRepository;
import com.hospital.model.PatientSignUp;
import com.hospital.dao.DoctorSignUpRepository;
import com.hospital.model.DoctorSignUp;
import com.hospital.model.Invoice;
import com.hospital.dao.InvoiceRepository;
@SpringBootTest
class HospitalmanagementsystemApplicationTests {
	@Autowired
	DischargedPatientRepository dischargedpatientRepository;

	@Test
	
	public void addDischargedPatient() {
		DischargedPatient dischargedpatient = new DischargedPatient();
		dischargedpatient.setDpId(11);
		dischargedpatient.setP_Id(63);
		dischargedpatient.setDisease("toothache");
		dischargedpatient.setDischargeDate(null);
		dischargedpatient.setAmountPaid(1200);
		assertNotNull(dischargedpatientRepository.findById(11).get());
	}
	@Test
	public void AllDischargedPatient() {
		List<DischargedPatient> list = dischargedpatientRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void DischargedPatient() {
		DischargedPatient dischargedpatient = dischargedpatientRepository.findById(11).get();
		assertEquals(11, dischargedpatient.getDpId());


}
	@Autowired
	FeedbackRepository feedbackRepository;

	@Test
	
	public void addFeedback() {
		Feedback feedback = new Feedback();
		feedback.setFeedback_id(1);
		feedback.setP_id(4);
		feedback.setP_comments("good treatment");
		
		assertNotNull(feedbackRepository.findById(1).get());
	}
	@Test
	public void AllFeedback() {
		List<Feedback> list = feedbackRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void Feedback() {
		Feedback feedback = feedbackRepository.findById(1).get();
		assertEquals(1, feedback.getFeedback_id());


}
		@Autowired
	AppointmentRepository appointmentRepository;

    @Test
	public void addAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAp_id(8);
		appointment.setDisease("toothache");
		appointment.setAddress("1-20,thirupathi");
            appointment.setAp_status("");
            appointment.setAp_time(null);
             appointment.setAp_date(null);
             appointment.setD_id(67); 
             appointment.setP_id(63); 

		
		assertNotNull(appointmentRepository.findById(8).get());
	}
	@Test
	public void AllAppointment() {
		List<Appointment> list = appointmentRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void Appointment() {
		Appointment appointment = appointmentRepository.findById(8).get();
		assertEquals(8, appointment.getAp_id());
}

	@Autowired
	PatientSignUpRepository patientsignupRepository;
	@Test
	
	public void addPatientSignUp() {
		PatientSignUp patientsignup = new PatientSignUp();
		 patientsignup.setP_id(10);
		 patientsignup.setP_contact_no("239078453");
         patientsignup.setP_gender("female");
         patientsignup.setP_name("d.sudha");
         patientsignup.setPassword("sudhad");
         patientsignup.setUsername("dsudha");
		assertNotNull(patientsignupRepository.findById(10).get());
	}
	@Test
	public void AllPatientSignUp() {
		List<PatientSignUp> list = patientsignupRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void PatientSignUp() {
		PatientSignUp patientsignup = patientsignupRepository.findById(10).get();
		assertEquals(10,patientsignup.getP_id());


}
	@Autowired
	DoctorSignUpRepository doctorsignupRepository;

	@Test
	
	public void addDoctorSignUp() {
		DoctorSignUp doctorsignup= new DoctorSignUp();
		doctorsignup.setD_id(3);
		doctorsignup.setD_name("Dr.harshitha");
	    doctorsignup.setGender("female");
        doctorsignup.setUsername("harshi");
		doctorsignup.setPassword("drharshi");
        doctorsignup.setContact_no("712378901");
        doctorsignup.setAddress("12/12-1,k-t road ,tirupathi");
        doctorsignup.setSpecialization("Dentist");
		assertNotNull(doctorsignupRepository.findById(3).get());
	}
	@Test
	public void AllDoctorSignUp() {
		List<DoctorSignUp> list = doctorsignupRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void DoctorSignUp() {
		DoctorSignUp doctorsignup = doctorsignupRepository.findById(3).get();
		assertEquals(3, doctorsignup.getD_id());


}
	@Autowired
	InvoiceRepository invoiceRepository;

	@Test
	
	public void addInvoice() {
	      Invoice invoice = new Invoice();
		invoice.setId(9);
		invoice.setPId(63);
		invoice.setMedicineCost(800);
		invoice.setRoomCharges(0);
        invoice.setDoctorCharges(400);
        invoice.setTotalAmount(1200);
		assertNotNull(invoiceRepository.findById(9).get());
	}
	@Test
	public void AllInvoice() {
		List<Invoice> list = invoiceRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void Invoice() {
        Invoice invoice = invoiceRepository.findById(9).get();
		assertEquals(9, invoice.getId());


}
}
