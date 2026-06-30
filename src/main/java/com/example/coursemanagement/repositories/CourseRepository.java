package com.example.coursemanagement.repositories;
import com.example.coursemanagement.models.Course;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CourseRepository {
    private List<Course> data = new ArrayList<>(Arrays.asList(
            new Course(101L, "Java Spring", "Active", 1L),
            new Course(102L, "ReactJS", "Upcoming", 2L)
    ));
    public List<Course> findAll() { return data; }
    public Course findById(Long id) { return data.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null); }
    public void create(Course c) { data.add(c); }
    public void update(Course c) {
        Course ex = findById(c.getId());
        if (ex != null) { ex.setTitle(c.getTitle()); ex.setStatus(c.getStatus()); ex.setInstructorId(c.getInstructorId()); }
    }
    public void deleteById(Long id) { data.removeIf(c -> c.getId().equals(id)); }
}