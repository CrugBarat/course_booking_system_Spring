package com.codeclan.CourseBookingSystem.controllers;
import com.codeclan.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity getCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
