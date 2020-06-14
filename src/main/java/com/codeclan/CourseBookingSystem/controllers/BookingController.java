package com.codeclan.CourseBookingSystem.controllers;
import com.codeclan.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getBookings(
            @RequestParam(name ="date", required = false) String date,
            @RequestParam(name ="courseName", required = false) String courseName
    ){
        if(date != null) {
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        if(courseName != null) {
            return new ResponseEntity(bookingRepository.findByCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

}
