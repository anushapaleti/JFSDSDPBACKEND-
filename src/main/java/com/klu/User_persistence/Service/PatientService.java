package com.klu.User_persistence.Service;

import com.klu.User_persistence.Repository.PatientRepository;
import com.klu.User_persistence.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Register a new patient (sign-up)
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Patient login
    public Patient loginPatient(String email, String password) {
        Patient existingPatient = patientRepository.findByEmail(email);
        if (existingPatient != null && existingPatient.getPassword().equals(password)) {
            return existingPatient; // Login successful
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

    // Get patient details by id
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}
