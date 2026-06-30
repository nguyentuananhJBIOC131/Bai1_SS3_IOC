package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(101L, "Java Spring Boot", "Active", 1L));
        courses.add(new Course(102L, "Cấu trúc dữ liệu", "Upcoming", 2L));
    }

    public List<Course> findAll() {
        return courses;
    }
}