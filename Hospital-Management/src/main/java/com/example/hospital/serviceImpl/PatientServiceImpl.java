package com.example.hospital.serviceImpl;

import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.Exception.ResourceNotFoundException;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO)
    {
        //Convert DTO to entity.
        Patient patient = convertDtoToEntity(patientDTO);
        patient = patientRepository.save(patient);
        //Convert entity to DTO.
        return convertEntityToDto(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients()
    {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id)
    {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not found"));
        return convertEntityToDto(patient);
    }

    @Override
    public void deletePatient(Long id)
    {
        patientRepository.deleteById(id);
    }

    //Helper method to convert dto to entity.
    private Patient convertDtoToEntity(PatientDTO patientDTO)
    {
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        return patient;
    }
    //Helper method to convert entity to dto.
    private PatientDTO convertEntityToDto(Patient patient)
    {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setAge(patient.getAge());
        return patientDTO;
    }
}
