package com.example.hospital.serviceImpl;

import com.example.hospital.DTO.AppointmentDTO;
import com.example.hospital.Exception.ResourceNotFoundException;
import com.example.hospital.entity.Appointment;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointServiceImpl implements AppointmentService
{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO)
    {
        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId()).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));

        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("Patient not found"));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointment = appointmentRepository.save(appointment);
        return convertEntityToDto(appointment);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDoctor(Long doctorId)
    {
        //List of appointments by doctor id.
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);

        List<AppointmentDTO> listOfApp = new ArrayList<>();
        for(Appointment appointment: appointments)
        {
            listOfApp.add(convertEntityToDto(appointment));
        }
        return listOfApp;
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByPatient(Long patientId)
    {
    //List of appointments by patient id.
       List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);

       List<AppointmentDTO> listOfApp = new ArrayList<>();
       for(Appointment appointment: appointments)
       {
           listOfApp.add(convertEntityToDto(appointment));
       }
        return listOfApp;
    }

    @Override
    public void cancelAppointment(Long id)
    {
        appointmentRepository.deleteById(id);
    }

    //Helper method to convert Appointment entity to DTO.
    private AppointmentDTO convertEntityToDto(Appointment appointment)
    {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setDoctorId(appointment.getDoctor().getId());
        appointmentDTO.setPatientId(appointment.getPatient().getId());
        return appointmentDTO;
    }
}
