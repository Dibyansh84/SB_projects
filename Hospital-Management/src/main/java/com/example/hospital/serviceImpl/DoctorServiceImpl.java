package com.example.hospital.serviceImpl;

import com.example.hospital.DTO.DoctorDTO;
import com.example.hospital.Exception.ResourceNotFoundException;
import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService
{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO)
    {
        Doctor doctor = convertDtoToEntity(doctorDTO);
        doctor = doctorRepository.save(doctor);
        return convertEntityToDto(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors()
    {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id)
    {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        return convertEntityToDto(doctor);
    }

    @Override
    public void deleteDoctor(Long id)
    {
        doctorRepository.deleteById(id);
    }

    //Helper methods for mapping or converting DTO to entity or vice versa.
    //Convert DTO to entity.
    private Doctor convertDtoToEntity(DoctorDTO doctorDTO)
    {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        return doctor;
    }

    //Converting entity to DTO.
    private DoctorDTO convertEntityToDto(Doctor doctor)
    {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        return doctorDTO;
    }
}
