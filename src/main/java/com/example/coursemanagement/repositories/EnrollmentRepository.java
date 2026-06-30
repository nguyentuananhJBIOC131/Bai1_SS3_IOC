package com.example.coursemanagement.repositories;
import com.example.coursemanagement.models.Enrollment;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> data = new ArrayList<>(Arrays.asList(
            new Enrollment(1001L, "Lê Văn C", 101L),
            new Enrollment(1002L, "Phạm Thị D", 102L)
    ));
    public List<Enrollment> findAll() { return data; }
    public Enrollment findById(Long id) { return data.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null); }
    public void create(Enrollment e) { data.add(e); }
    public void update(Enrollment e) {
        Enrollment ex = findById(e.getId());
        if (ex != null) { ex.setStudentName(e.getStudentName()); ex.setCourseId(e.getCourseId()); }
    }
    public void deleteById(Long id) { data.removeIf(e -> e.getId().equals(id)); }
}