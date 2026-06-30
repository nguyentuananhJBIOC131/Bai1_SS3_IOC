package com.example.coursemanagement.controllers;
import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;
    @Autowired
    public CourseController(CourseService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Course>> getAll() { return ResponseEntity.ok(service.getAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        Course c = service.getById(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course c) {
        service.create(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course c) {
        c.setId(id);
        service.update(c);
        return ResponseEntity.ok(c);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}