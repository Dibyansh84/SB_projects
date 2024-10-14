package com.example.hospital.service;

import com.example.hospital.DTO.DoctorDTO;

import java.util.List;

public interface DoctorService
{
    //add a doctor
    DoctorDTO addDoctor(DoctorDTO doctorDTO);

    //get all doctors
    List<DoctorDTO> getAllDoctors();

    //get doctor by id
    DoctorDTO getDoctorById(Long id);

    //delete a doctor
    void deleteDoctor(Long id);
}
