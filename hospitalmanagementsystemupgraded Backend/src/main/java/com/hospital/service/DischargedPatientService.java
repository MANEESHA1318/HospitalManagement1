package com.hospital.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.dao.DischargedPatientRepository;
import com.hospital.model.DischargedPatient;
@Service
public class DischargedPatientService {
	@Autowired
	DischargedPatientRepository dischargedpatientRepository;
	
	@Transactional
	public List<DischargedPatient> fetchDischargedPatients() {
		List<DischargedPatient> dischargedpatientList=dischargedpatientRepository.findAll();
		return dischargedpatientList;
	}
	@Transactional
	public DischargedPatient saveDischargedPatient(DischargedPatient dischargedpatient) {
		return dischargedpatientRepository.save(dischargedpatient);
	}
		@Transactional 
	  public DischargedPatient getDischargedPatient(int id) { 
	  Optional<DischargedPatient> optional= dischargedpatientRepository.findById(id);
	  DischargedPatient dischargedpatient=optional.get();
	  return dischargedpatient;
	}
	@Transactional
	public void updateDischargedPatient(DischargedPatient dischargedpatient) {
		dischargedpatientRepository.save(dischargedpatient);
	}
	@Transactional
	public void deleteDischargedPatient(int dpId) {
		System.out.println("service method called");
		dischargedpatientRepository.deleteById(dpId);
	}
}
