package com.codeclan.CourseBookingSystem.models;
import javax.persistence.*;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "star_rating")
    private int starRating;

    public Course(String name, String town, int rating) {
        this.name = name;
        this.town = town.toLowerCase();
        this.starRating = rating;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

}
