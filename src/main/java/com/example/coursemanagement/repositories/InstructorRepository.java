package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor(1L, "Nguyễn Văn A", "nva@example.com"));
        instructors.add(new Instructor(2L, "Trần Thị B", "ttb@example.com"));
    }

    public List<Instructor> findAll() {
        return instructors;
    }
}