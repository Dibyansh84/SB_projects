package com.example.hospital.service;

import com.example.hospital.DTO.AppointmentDTO;

import java.util.List;

public interface AppointmentService
{
    /*bookAppointment(): Accepts an appointment booking request and returns the booked appointment.*/
    AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO);

    //getAppointmentsByDoctor(): Retrieves all appointments for a specific doctor.
    List<AppointmentDTO> getAppointmentsByDoctor(Long doctorId);

    //getAppointmentsByPatient(): Retrieves all appointments for a specific patient.
    List<AppointmentDTO> getAppointmentsByPatient(Long patientId);

    //cancelAppointment(): Cancels an appointment by its ID.
    void cancelAppointment(Long id);
}
