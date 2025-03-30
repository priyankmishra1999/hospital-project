package com.hospital.doctor.repo;

import com.hospital.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface DoctorRepository extends MongoRepository<Doctor, UUID> {
}
