package com.hospital.doctor.handler.advice;

import com.hospital.doctor.handler.DoctorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoctorControllerAdvice {

    @ExceptionHandler(DoctorException.class)
    public ResponseEntity<Object> badRequest(DoctorException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
