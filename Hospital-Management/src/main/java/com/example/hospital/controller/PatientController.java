package com.example.hospital.controller;

import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO)
    {
        PatientDTO patientCreated = patientService.addPatient(patientDTO);
        return new ResponseEntity<>(patientCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id)
    {
        PatientDTO patientDTO = patientService.getPatientById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id)
    {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient info deleted successfully");
    }
}
