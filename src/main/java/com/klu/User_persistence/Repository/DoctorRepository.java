package com.klu.User_persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klu.User_persistence.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmailAndPassword(String email, String password);
    
    @Query("select d from Doctor d where d.email=?1 and d.password=?2")
    public Doctor checkdoctorlogin(String email,String password);
}
