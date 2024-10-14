package com.example.hospital.controller;

import com.example.hospital.DTO.AppointmentDTO;
import com.example.hospital.entity.Appointment;
import com.example.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> bookAppointment(@RequestBody AppointmentDTO appointmentDTO)
    {
        return new ResponseEntity<>(appointmentService.bookAppointment(appointmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentDTO> getAppointmentsByDoctor(@PathVariable Long doctorId)
    {
        return appointmentService.getAppointmentsByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<AppointmentDTO> getAppointmentsByPatient(@PathVariable Long patientId)
    {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id)
    {
        appointmentService.cancelAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
