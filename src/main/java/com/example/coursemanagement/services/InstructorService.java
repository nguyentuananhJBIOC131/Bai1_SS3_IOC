package com.example.coursemanagement.services;
import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repo;
    @Autowired
    public InstructorService(InstructorRepository repo) { this.repo = repo; }

    public List<Instructor> getAll() { return repo.findAll(); }
    public Instructor getById(Long id) { return repo.findById(id); }
    public void create(Instructor i) { repo.create(i); }
    public void update(Instructor i) { repo.update(i); }
    public void delete(Long id) { repo.deleteById(id); }
}