# Course Booking System

This exercise was tasked to me by CodeClan, Glasgow where I studied towards a PDA Level 8 in Professional Software Development. The exercise brief can be found below.

## Brief

For this lab, we will build a simple course booking back-end. At the end of the lab we should have a RESTful API that allows connected clients to create course bookings and find useful information about the bookings created.

The API should be built from scratch with Spring using Spring Boot Initialiser.

### MVP

The course booking API needs to be built with three models with the following properties:

**Course:**
- name
- town
- rating

**Booking:**
- date

**Customer:**
- name
- town
- age

The relationships should be:
- A Course has many Bookings
- A Booking has a Course
- A Customer has many bookings
- A booking has a customer

**Queries + Custom Routes**

Write queries using the derived method we’ve shown. Connect these to suitable RESTful endpoints.

- Get all courses with a given rating
- Get all customers for a given course
- Get all courses for a given customer
- Get all bookings for a given date

### Extensions

- Get all customers in a given town for a given course
- Get all customers over a certain age in a given town for a given course

### Additional Extensions

- Correctly handle case-insensitive routes with Spring RestController or the IgnoreCase in derived queries
