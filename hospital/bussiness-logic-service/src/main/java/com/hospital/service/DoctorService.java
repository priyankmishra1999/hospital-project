package com.hospital.service;

import com.hospital.model.Doctor;

import java.util.Optional;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);

    Optional<Doctor> getDoctorDetailById(String id);
}
