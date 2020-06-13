package com.codeclan.CourseBookingSystem.components;
import com.codeclan.CourseBookingSystem.models.Booking;
import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Professional Software Development", "Glasgow",5);
        Course course2 = new Course("Web Development", "Glasgow",3);
        Course course3 = new Course("Data Analysis", "Highlands",4);
        Course course4 = new Course("JavaScript Summer Course", "Highlands",4);
        Course course5 = new Course("UX Design Fundamentals", "Edinburgh",3);
        Course course6 = new Course("Python for Data Analysis", "Edinburgh",5);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);

        Customer customer1 = new Customer("Jane Doe", "Glasgow", 27);
        Customer customer2 = new Customer("John Smith", "Edinburgh", 35);
        Customer customer3 = new Customer("Susan Dickson", "Highlands", 48);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("11-01-2020", course1, customer1);
        Booking booking2 = new Booking("16-06-2020", course2, customer1);
        Booking booking3 = new Booking("17-01-2020", course3, customer2);
        Booking booking4  = new Booking("29-04-2020", course4, customer2);
        Booking booking5 = new Booking("07-05-2020", course5, customer3);
        Booking booking6  = new Booking("02-06-2020", course6, customer3);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);

    }
}
