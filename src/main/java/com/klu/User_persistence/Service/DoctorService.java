package com.klu.User_persistence.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.klu.User_persistence.Repository.DoctorRepository;
import com.klu.User_persistence.model.Doctor;

	@Service
	public class DoctorService {
	    @Autowired
	    private DoctorRepository doctorRepository;

	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    public String addDoctor(Doctor doctor) {
	         doctorRepository.save(doctor);
	         return "Doctor added successfully";
	    }

	    public Optional<Doctor> getDoctorById(int id) {
	        return doctorRepository.findById(id);
	    }

	    public Doctor updateDoctor(Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }

	    public void deleteDoctor(int id) {
	        doctorRepository.deleteById(id);
	    }

	    public Doctor loginDoctor(String email, String password) {
	        return doctorRepository.findByEmailAndPassword(email, password);
	    }
	    
	    public Doctor checkdoctorlogin(String email ,String password) {
	        
	    	  System.out.println(doctorRepository.checkdoctorlogin(email, password));
	    	    return doctorRepository.checkdoctorlogin(email, password);
	    	    
	    
	}
	}
