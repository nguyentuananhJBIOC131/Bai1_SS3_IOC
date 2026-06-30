package com.example.coursemanagement.controllers;
import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService service;
    @Autowired
    public InstructorController(InstructorService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getById(@PathVariable Long id) {
        Instructor i = service.getById(id);
        return i != null ? ResponseEntity.ok(i) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor i) {
        service.create(i);
        return ResponseEntity.status(HttpStatus.CREATED).body(i);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Long id, @RequestBody Instructor i) {
        i.setId(id);
        service.update(i);
        return ResponseEntity.ok(i);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}