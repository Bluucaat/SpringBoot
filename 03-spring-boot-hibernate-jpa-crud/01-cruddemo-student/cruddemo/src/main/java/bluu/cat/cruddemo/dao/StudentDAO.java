package bluu.cat.cruddemo.dao;

import bluu.cat.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> getAllStudents();
}
