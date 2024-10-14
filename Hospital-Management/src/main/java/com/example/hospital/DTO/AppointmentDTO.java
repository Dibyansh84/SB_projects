package com.example.hospital.DTO;

import com.example.hospital.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO
{
    /*The fields in the AppointmentDTO are different from the Appointment entity.
  This is because DTOs (Data Transfer Objects) are meant to simplify data exchange between the client and the server.
  In this case, the AppointmentDTO has fields for doctorId and patientId, instead of embedding the entire Doctor and Patient objects.
  This design simplifies the API and ensures the client only needs to send the doctor and patient IDs when booking an appointment,
  rather than the entire doctor and patient details.*/

    private Long id;

    private String appointmentDate;

    private Long doctorId;

    private Long patientId;

    //The doctorId and patientId are enough to reference the respective doctor and patient when booking or retrieving appointments.

}
