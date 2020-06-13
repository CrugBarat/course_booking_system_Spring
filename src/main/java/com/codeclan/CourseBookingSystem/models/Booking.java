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

    public Booking(String date) {
        this.date = date;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
