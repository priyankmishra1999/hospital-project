package com.hospital.serviceImpl;

//import com.hospital.SecurityConfig;
import com.hospital.doctor.repo.DoctorRepository;
import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;


//    private SecurityConfig config;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;

    }

//    protected DoctorServiceImpl() {
//    }

    @Override
    @Transactional
    public Doctor createDoctor(Doctor doctor) {
        try {
            Doctor doctorEntity = new Doctor(
                    doctor.getFirstName(), doctor.getLastName(),
                    doctor.getEmail(), doctor.getPhone(), doctor.getSpeciality(),
                    doctor.getYearsOfExperience(), doctor.getStatus(), doctor.getPassword());
            Doctor doctorData = doctorRepository.save(doctorEntity);
            return doctorData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Doctor> getDoctorDetailById(String id) {
        try {
            Optional<Doctor> doctorData = doctorRepository.findById(UUID.fromString(id));
            return doctorData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
