package com.codeclan.CourseBookingSystem;

import com.codeclan.CourseBookingSystem.models.Booking;
import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void canFindAllCourses(){
		List<Course> found = courseRepository.findAll();
		assertEquals(6, found.size());
	}

	@Test
	public void canFindAllCustomers(){
		List<Customer> found = customerRepository.findAll();
		assertEquals(3, found.size());
	}

	@Test
	public void canFindAllBookings(){
		List<Booking> found = bookingRepository.findAll();
		assertEquals(6, found.size());
	}

}
