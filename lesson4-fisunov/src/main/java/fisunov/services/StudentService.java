package fisunov.services;

import fisunov.data.Student;
import fisunov.repositiries.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    public void changeScore(Long id, Integer delta) {
        Student student = studentRepository.findById(id);
        student.setScore(student.getScore() + delta);
    }
}
