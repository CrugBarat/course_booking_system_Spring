package com.codeclan.CourseBookingSystem.models;
import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Booking(String date, Course course) {
        this.date = date;
        this.course = course;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
