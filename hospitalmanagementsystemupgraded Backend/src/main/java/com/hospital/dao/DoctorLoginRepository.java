package com.hospital.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hospital.model.DoctorLogin;
public interface DoctorLoginRepository extends JpaRepository<DoctorLogin, String>{
	@Query("SELECT dl FROM DoctorLogin dl WHERE dl.username =?1 and dl.password=?2")
	public DoctorLogin validateDoctorLogin(String username,String password);

}
