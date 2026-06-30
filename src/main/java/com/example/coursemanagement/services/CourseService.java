package com.example.coursemanagement.services;
import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;
    @Autowired
    public CourseService(CourseRepository repo) { this.repo = repo; }
    public List<Course> getAll() { return repo.findAll(); }
    public Course getById(Long id) { return repo.findById(id); }
    public void create(Course c) { repo.create(c); }
    public void update(Course c) { repo.update(c); }
    public void delete(Long id) { repo.deleteById(id); }
}