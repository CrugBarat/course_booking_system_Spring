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
	public void canFindCustomerByCourseName__CorrectCase(){
		List<Customer> found = customerRepository.findByBookingsCourseNameIgnoreCase("Web Development");
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByCourseName__LowerCase(){
		List<Customer> found = customerRepository.findByBookingsCourseNameIgnoreCase("web development");
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCoursesByCustomerName__CorrectCase(){
		List<Course> found = courseRepository. findByBookingsCustomerNameIgnoreCase("John Smith");
		assertEquals(5L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCoursesByCustomerName__LowerCase(){
		List<Course> found = courseRepository. findByBookingsCustomerNameIgnoreCase("john smith");
		assertEquals(5L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> found = bookingRepository.findByDate("02-06-2020");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndCourseName__CorrectCase(){
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Highlands", "Data Analysis");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndCourseName__LowerCase(){
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("highlands", "data analysis");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndOverACertainAgeAndByCourseName__WithCustomerCorrectCase(){
		List<Customer> found = customerRepository.findAllByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseNameIgnoreCase("Edinburgh", 34,  "Python for Data Analysis");
		assertEquals(2L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndOverACertainAgeAndByCourseName__WithCustomerLowerCase(){
		List<Customer> found = customerRepository.findAllByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseNameIgnoreCase("edinburgh", 34,  "python for data analysis");
		assertEquals(2L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndOverACertainAgeAndByCourseName__WithOutCustomer(){
		List<Customer> found = customerRepository.findAllByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseNameIgnoreCase("Edinburgh", 36,  "Python for Data Analysis");
		assertEquals(0, found.size());
	}

	@Test
	public void canFindBookingsByCourseName__CorrectCase() {
		List<Booking> found = bookingRepository.findByCourseNameIgnoreCase("Python for Data Analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingsByCourseName__LowerCase() {
		List<Booking> found = bookingRepository.findByCourseNameIgnoreCase("python for data analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingsByCustomerName__CorrectCase() {
		List<Booking> found = bookingRepository.findByCustomerNameIgnoreCase("Susan Dickson");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindBookingsByCustomerName__LowerCase() {
		List<Booking> found = bookingRepository.findByCustomerNameIgnoreCase("susan dickson");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindBookingsByCustomerNameAndCourseName__CorrectCase() {
		List<Booking> found = bookingRepository.findByCustomerNameIgnoreCaseAndCourseNameIgnoreCase("John Smith", "UX Design Fundamentals");
		assertEquals(5L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingsByCustomerNameAndCourseName__LowerCase() {
		List<Booking> found = bookingRepository.findByCustomerNameIgnoreCaseAndCourseNameIgnoreCase("john smith", "ux design fundamentals");
		assertEquals(5L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingsByDateAndCourseName__CorrectCase() {
		List<Booking> found = bookingRepository.findByDateAndCourseNameIgnoreCase("02-06-2020", "Python for Data Analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingsByDateAndCourseName__LowerCase() {
		List<Booking> found = bookingRepository.findByDateAndCourseNameIgnoreCase("02-06-2020", "python for data analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCourseByName__CorrectCase() {
		List<Course> found = courseRepository.findByNameIgnoreCase("Python for Data Analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCourseByName__LowerCase() {
		List<Course> found = courseRepository.findByNameIgnoreCase("python for data analysis");
		assertEquals(6L, found.get(0).getId().longValue());
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCourseByTown__CorrectCase() {
		List<Course> found = courseRepository.findByTownIgnoreCase("Highlands");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCourseByTown__LowerCase() {
		List<Course> found = courseRepository.findByTownIgnoreCase("highlands");
		assertEquals(3L, found.get(0).getId().longValue());
		assertEquals(2, found.size());
	}

}
