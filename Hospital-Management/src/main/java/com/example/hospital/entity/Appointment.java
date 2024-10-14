package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private String appointmentDate;
    private String appointmentDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    //The doctor field is a Doctor object that holds a reference to the actual doctor in the database.
    //The patient field is a Patient object that holds a reference to the actual patient in the database.

    //Each Appointment is linked to a single Doctor and a single Patient, ensuring the proper relationship between these entities.
    //both doctors and patients are tied together via appointments.
}
