package blue.crud.demo;

import blue.crud.demo.dao.ApplicationDAO;
import blue.crud.demo.entity.Instructor;
import blue.crud.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetails(appDAO, 2);
			//findInstructorDetails(appDAO, 3);
			deleteInstructorDetail(appDAO, 7);
		};
	}

	private void deleteInstructorDetail(ApplicationDAO appDAO, int id) {
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetails(ApplicationDAO appDAO, int id) {
		InstructorDetail instructorDetail = appDAO.findDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void findInstructor(ApplicationDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findById(id);
		System.out.println(tempInstructor);;
	}



	private void createInstructor(ApplicationDAO appDAO) {
		Instructor tempInstructor = new Instructor("John", "Doe", "youtube.com");
		InstructorDetail tempInstructorDetaul = new InstructorDetail(
				"youtube.com",
				"piano");

		tempInstructor.setInstructorDetail(tempInstructorDetaul);
		appDAO.save(tempInstructor);
	}

	private void deleteInstructor(ApplicationDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
		System.out.println("removed. ");
	}
}
