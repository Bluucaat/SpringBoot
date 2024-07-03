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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//readStudent(studentDAO);

			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.getAllStudents();

		for(Student student : studentList){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Daffy", "Duck", "daffy@mailsystem.com");
		studentDAO.save(tempStudent);
		int tempId = tempStudent.getId();
		System.out.println("Saved student with id: " + tempId);
		Student myStudent = studentDAO.findById(tempId);
		System.out.println("Student info: " + myStudent);

	}
}
