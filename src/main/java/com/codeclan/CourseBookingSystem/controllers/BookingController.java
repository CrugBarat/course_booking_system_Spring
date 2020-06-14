package com.codeclan.CourseBookingSystem.controllers;
import com.codeclan.CourseBookingSystem.models.Booking;
import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getBookings(
            @RequestParam(name ="date", required = false) String date,
            @RequestParam(name ="courseName", required = false) String courseName,
            @RequestParam(name ="customerName", required = false) String customerName
    ){
        if(date != null && courseName != null) {
            return new ResponseEntity(bookingRepository.findByDateAndCourseNameIgnoreCase(date, courseName), HttpStatus.OK);
        }
        if(customerName != null && courseName != null) {
            return new ResponseEntity(bookingRepository.findByCustomerNameIgnoreCaseAndCourseNameIgnoreCase(customerName, courseName), HttpStatus.OK);
        }
        if(date != null) {
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        if(courseName != null) {
            return new ResponseEntity(bookingRepository.findByCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        if(customerName != null) {
            return new ResponseEntity(bookingRepository.findByCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id) {
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity(booking, HttpStatus.CREATED);
    }

    @PutMapping(value="/bookings/{id}")
    public ResponseEntity updateBooking(@PathVariable(value = "id") Long id, @RequestBody Booking booking) {
        booking.setId(id);
        bookingRepository.save(booking);
        return new ResponseEntity(booking, HttpStatus.OK);
    }

    @DeleteMapping(value="/bookings/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}
