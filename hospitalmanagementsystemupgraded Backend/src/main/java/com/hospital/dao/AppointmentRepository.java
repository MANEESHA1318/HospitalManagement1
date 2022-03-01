package com.hospital.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospital.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
