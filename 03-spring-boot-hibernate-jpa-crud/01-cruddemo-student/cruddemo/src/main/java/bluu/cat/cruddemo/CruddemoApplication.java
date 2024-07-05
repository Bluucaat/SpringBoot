package bluu.cat.cruddemo;

import bluu.cat.cruddemo.dao.StudentDAO;
import bluu.cat.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
              readStudent(studentDAO);

//            queryForStudents(studentDAO);
//
//            queryForStudentsByLastName(studentDAO);
//
              updateStudent(studentDAO, 1);
//
//            deleteStudent(studentDAO, 1);

//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println(studentDAO.clearTable());
    }

    private void deleteStudent(StudentDAO studentDAO, Integer id) {
        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO, Integer id) {
        Student myStudent = studentDAO.findById(id);
        myStudent.setFirstName("Scoop");
        studentDAO.update(myStudent);
        System.out.println("upadted the student, new name: " + myStudent.getFirstName() + " " + myStudent.getLastName());
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findByLastName("Duck");

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.getAllStudents();

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Jane", "Brown", "jane@mailsystem.com");
        studentDAO.save(tempStudent);
        int tempId = tempStudent.getId();
        System.out.println("Saved student with id: " + tempId);
        Student myStudent = studentDAO.findById(tempId);
        System.out.println("Student info: " + myStudent);

    }
}
