package com.codeclan.CourseBookingSystem.repositories;
import com.codeclan.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);
    List<Customer> findByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseNameIgnoreCase(String town, int age, String courseName);
    List<Customer> findByNameIgnoreCase(String name);
}
