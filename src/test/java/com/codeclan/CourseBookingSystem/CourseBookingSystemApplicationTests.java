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

	@Test
	public void canFindCourseBYRating(){
		List<Course> found = courseRepository.findByRating(5);
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCustomerByCourseName(){
		List<Customer> found = customerRepository.findByBookingsCourseName("Web Development");
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCoursesByCustomerName(){
		List<Course> found = courseRepository.findByBookingsCustomerName("John Smith");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> found = bookingRepository.findByDate("02-06-2020");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndCourseName(){
		List<Customer> found = customerRepository.findByTownAndBookingsCourseName("Highlands", "Data Analysis");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndOverACertainAgeAndByCourseName__WithCustomer(){
		List<Customer> found = customerRepository.findAllByTownAndAgeGreaterThanAndBookingsCourseName("Edinburgh", 34,  "Python for Data Analysis");
		assertEquals(2L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndOverACertainAgeAndByCourseName__WithOutCustomer(){
		List<Customer> found = customerRepository.findAllByTownAndAgeGreaterThanAndBookingsCourseName("Edinburgh", 36,  "Python for Data Analysis");
		assertEquals(0, found.size());
	}

}
