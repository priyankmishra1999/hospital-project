package com.hospital.controller;

import com.hospital.doctor.handler.DoctorException;
import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/createDoctor")
    public ResponseEntity<Object> createDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor doctorData = doctorService.createDoctor(doctor);
            return new ResponseEntity<>(doctorData, HttpStatusCode.valueOf(200));
        } catch (DoctorException e) {
            throw new DoctorException(e.getMessage());
        }
    }

    @GetMapping("/")
    public String getAllDoctors() {
        return "List of doctors";
    }

    @GetMapping("/details/{_id}")
    public ResponseEntity<Object> getDoctorDetails(@PathVariable("_id") String id) {
        Optional<Doctor> doctorData = doctorService.getDoctorDetailById(id);
        Doctor doctor = doctorData.orElseThrow(() -> new RuntimeException("Doctor not found"));
        return new ResponseEntity<>(doctor, HttpStatusCode.valueOf(200));
    }
}
