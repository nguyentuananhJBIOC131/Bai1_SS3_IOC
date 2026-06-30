package com.example.coursemanagement.repositories;
import com.example.coursemanagement.models.Instructor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InstructorRepository {
    private List<Instructor> data = new ArrayList<>(Arrays.asList(
            new Instructor(1L, "Nguyễn Văn A", "a@example.com"),
            new Instructor(2L, "Trần Thị B", "b@example.com")
    ));
    public List<Instructor> findAll() { return data; }
    public Instructor findById(Long id) { return data.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null); }
    public void create(Instructor i) { data.add(i); }
    public void update(Instructor i) {
        Instructor ex = findById(i.getId());
        if (ex != null) { ex.setName(i.getName()); ex.setEmail(i.getEmail()); }
    }
    public void deleteById(Long id) { data.removeIf(i -> i.getId().equals(id)); }
}