package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1001L, "Lê Văn C", 101L));
        enrollments.add(new Enrollment(1002L, "Phạm Thị D", 102L));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }
}