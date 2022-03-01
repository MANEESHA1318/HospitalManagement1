package com.hospital.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hospital.model.PatientLogin;
public interface PatientLoginRepository extends JpaRepository<PatientLogin, String>{
	@Query("SELECT pl FROM PatientLogin pl WHERE pl.username =?1 and pl.password=?2")
	public PatientLogin validatePatientLogin(String username,String password);
}
