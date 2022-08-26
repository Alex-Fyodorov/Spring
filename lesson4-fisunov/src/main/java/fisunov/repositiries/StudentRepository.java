package fisunov.repositiries;

import fisunov.data.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(List.of(
                new Student(1L, "Bob", 80),
                new Student(2L, "Michael", 80),
                new Student(3L, "John", 80)
        ));
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public Student findById(Long id) {
        return students.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found."));
    }

    public void add(Student student) {
        students.add(student);
    }

    public void deleteById(Long id) {
        students.removeIf(p -> p.getId().equals(id));
    }
}
