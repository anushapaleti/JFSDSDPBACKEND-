package com.klu.User_persistence.Service;

import com.klu.User_persistence.Repository.AppointmentRepository;
import com.klu.User_persistence.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Book a new appointment
    public Appointment bookAppointment(Appointment appointment) {
        // Check if the selected date is in the past
        if (appointment.getDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot select past date");
        }

        // Check if the selected time is in the past (if the date is today)
        if (appointment.getDate().equals(LocalDate.now()) && appointment.getTime().isBefore(LocalTime.now())) {
            throw new RuntimeException("Cannot select past time");
        }

        return appointmentRepository.save(appointment);
    }

    // Get all appointments for a specific patient
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
