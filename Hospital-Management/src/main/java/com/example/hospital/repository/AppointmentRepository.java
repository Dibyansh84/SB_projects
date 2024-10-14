package com.example.hospital.repository;

import com.example.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
    //Custom methods for doctors and patients.

    //Get list of appointments by doctor id.
    List<Appointment> findByDoctorId(Long doctorId);

    //Get the list of appointments by patient id.
    List<Appointment> findByPatientId(Long patientId);
}
