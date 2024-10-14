package com.example.hospital.service;

import com.example.hospital.DTO.PatientDTO;

import java.util.List;

public interface PatientService
{
    //Create patient.
    PatientDTO addPatient(PatientDTO patientDTO);

    //get all patients
    List<PatientDTO> getAllPatients();

    //get patient by id
    PatientDTO getPatientById(Long id);

    //delete patient
    void deletePatient(Long id);
}
