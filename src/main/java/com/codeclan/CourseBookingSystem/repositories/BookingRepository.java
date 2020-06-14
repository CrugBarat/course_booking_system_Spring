package com.codeclan.CourseBookingSystem.repositories;
import com.codeclan.CourseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(String date);
    List<Booking> findByDateAndCourseNameIgnoreCase(String date, String courseName);
    List<Booking> findByCourseNameIgnoreCase(String courseName);
    List<Booking> findByCustomerNameIgnoreCase(String customerName);
    List<Booking> findByCustomerNameIgnoreCaseAndCourseNameIgnoreCase(String customerName, String courseName);
}
