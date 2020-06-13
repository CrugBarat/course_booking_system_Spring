package com.codeclan.CourseBookingSystem.repositories;
import com.codeclan.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String courseName);
    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);
    List<Customer> findAllByTownAndAgeGreaterThanAndBookingsCourseName(String town, int age, String courseName);
}
