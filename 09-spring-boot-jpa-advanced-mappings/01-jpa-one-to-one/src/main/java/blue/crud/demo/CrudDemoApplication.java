package blue.crud.demo;

import blue.crud.demo.dao.ApplicationDAO;
import blue.crud.demo.dao.DAOImpl;
import blue.crud.demo.entity.Instructor;
import blue.crud.demo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(ApplicationDAO appDAO) {
		Instructor tempInstructor = new Instructor("John", "Doe", "youtube.com");
		InstructorDetail tempInstructorDetaul = new InstructorDetail(
				"youtube.com",
				"piano");

		tempInstructor.setInstructorDetail(tempInstructorDetaul);
		appDAO.save(tempInstructor);
	}
}
