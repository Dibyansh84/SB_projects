package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient
{
    //Create the Patient entity to represent a patient in the system.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Integer age;

    @OneToMany(mappedBy = "patient", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

}
