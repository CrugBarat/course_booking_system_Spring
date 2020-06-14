package com.codeclan.CourseBookingSystem.controllers;
import com.codeclan.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomers(
            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "name", required = false) String name
    ){
        if(courseName != null && town != null && age != null) {
            return new ResponseEntity(customerRepository.findByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseNameIgnoreCase(town, age, courseName), HttpStatus.OK);
        }
        if(courseName != null && town != null) {
            return new ResponseEntity(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if(courseName != null) {
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        if(name != null) {
            return new ResponseEntity(customerRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }
        if(town != null) {
            return new ResponseEntity(customerRepository.findByTownIgnoreCase(town), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

}
