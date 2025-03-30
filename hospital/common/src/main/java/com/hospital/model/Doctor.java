package com.hospital.model;

import com.hospital.enums.DoctorStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;
import java.util.UUID;

@Document
public class Doctor implements Serializable {
    private static final Long serialVersion = 1L;
    @Id
    @Field(targetType = FieldType.STRING)
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String speciality;
    private Integer yearsOfExperience;
    private DoctorStatus status;
    private String password;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String email, String phone, String speciality, Integer yearsOfExperience, DoctorStatus status, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
        this.yearsOfExperience = yearsOfExperience;
        this.status = status;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
