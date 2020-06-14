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
    public ResponseEntity getCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customerName", required = false) String customerName,
            @RequestParam(name = "name", required = false) String name
    ){
        if(rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if(customerName != null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }
        if(name != null){
            return new ResponseEntity(courseRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

}
