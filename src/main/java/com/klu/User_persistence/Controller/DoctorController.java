package com.klu.User_persistence.Controller;

import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.klu.User_persistence.Service.DoctorService;
import com.klu.User_persistence.model.Doctor;

@RestController
@RequestMapping("/api")

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

//    // Welcome endpoint
//    @GetMapping("/appointments")
//    public String home() {
//        return "Welcome to the Doctor Management API!";
//    }
//
//    // Retrieve all doctors
//    @GetMapping("/doctors")
//    public List<Doctor> getAllDoctors() {
//        return doctorService.getAllDoctors();
//    }
//
//    // Add a new doctor
//    @PostMapping("/signup")
//    public String addDoctor(@RequestBody Doctor doctor) {
//        return doctorService.addDoctor(doctor);
//    }
//    @GetMapping("/Login")
//    @ResponseBody
//    public Doctor getLogin(@RequestParam String email , @RequestParam String password) {
//        return doctorService.loginDoctor(email , password);
//    }
// 
//    // Get a doctor by ID
//    @GetMapping("/doctors/{id}")
//    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {
//        return doctorService.getDoctorById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Update a doctor's details
//    @PutMapping("/doctors/{id}")
//    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
//        if (doctorService.getDoctorById(id).isPresent()) {
//            doctor.setId(id);
//            return ResponseEntity.ok(doctorService.updateDoctor(doctor));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    // Delete a doctor by ID
//    @DeleteMapping("/doctors/{id}")
//    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
//        if (doctorService.getDoctorById(id).isPresent()) {
//            doctorService.deleteDoctor(id);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
    
    @PostMapping("checkdoctorlogin")
    public Doctor checkdoctorlogin(@RequestBody Doctor request)
    {
      String email=request.getEmail();
      String password=request.getPassword();
      //System.out.println(email);
      //System.out.println(password);
      Doctor doctor=doctorService.checkdoctorlogin(email, password);
      System.out.println(doctor);
      return doctor;
    }
}
