package blue.crud.demo;

import blue.crud.demo.dao.ApplicationDAO;
import blue.crud.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationDAO appDAO) {
        return runner -> {
            //createCourseAndStudents(appDAO);
            //findCourseAndStudents(appDAO);
            //findStudentAndCourses(appDAO);
            //addMoreCoursesForStudent(appDAO);
            //deleteCourseById(appDAO);
            deleteStudentById(appDAO);

        };
    }

    private void deleteStudentById(ApplicationDAO appDAO) {
        int id = 1;
        appDAO.deleteStudentById(id);

    }

    private void addMoreCoursesForStudent(ApplicationDAO appDAO) {
        int id = 1;
        Student tempStudent = appDAO.findStudentAndCourseByStudentId(2);
        Course tempCourse1 = new Course("third random course");
        Course tempCourse2 = new Course("another random course");
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);
        System.out.println("Saving upated student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());
        appDAO.updateStudent(tempStudent);
    }

    private void findStudentAndCourses(ApplicationDAO appDAO) {
        int studentId = 1;
        Student tempStudent = appDAO.findStudentAndCourseByStudentId(studentId);
        System.out.println("Loaded student: " + tempStudent);
        System.out.println("Associated courses: " + tempStudent.getCourses());
    }

    private void findCourseAndStudents(ApplicationDAO appDAO) {
        int courseId = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(courseId);
        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Associated students: " + tempCourse.getStudents());
    }

    private void createCourseAndStudents(ApplicationDAO appDAO) {
        Course course = new Course("Pacman - how to score 1M points");
        Student student1 = new Student("John", "Doe", "john@gmail.com");
        Student student2 = new Student("Mary", "Smith", "mary@gmail.com");
        course.addStudent(student1);
        course.addStudent(student2);
        System.out.println("saved course: " + course);
        System.out.println("Associated students: " + course.getStudents());
        appDAO.saveCourse(course);



    }

    private void retrieveCourseAndReviews(ApplicationDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course + ", reviews:\n" + course.getReviews());
    }

    private void createCourseAndReviews(ApplicationDAO appDAO) {
        Course course = new Course("okay really the last course that i'll add");
        course.addReview(new Review("ok course, kinda helpful"));
        course.addReview(new Review("good course, learned new stuff"));
        course.setInstructor(new Instructor("its", "me", "email.com"));
        appDAO.saveCourse(course);
    }

    private void updateCourse(ApplicationDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseById(id);
        course.setTitle("Edited course");
        appDAO.updateCourse(course);
    }

    private void updateInstructor(ApplicationDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findById(id);
        instructor.setEmail("newmail.com");
        appDAO.updateInstructor(instructor);
    }

    private void findInstructorWithCoursesJoinFetch(ApplicationDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructor(ApplicationDAO appDAO) {
        int id = 1;
        Instructor tempInstructor = appDAO.findById(id);
        System.out.println(tempInstructor + " courses: " + appDAO.findCoursesByInstructorId(id));

        //alternatively:

        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        tempInstructor.setCourses(courses);
        System.out.println(tempInstructor.getCourses());

    }

    private void findInstructorWithCourses(ApplicationDAO appDAO) {
        int id = 1;
        Instructor tempInstructor = appDAO.findById(id);
        System.out.println(tempInstructor + " courses: " + tempInstructor.getCourses());
    }

    private void createInstructorWithCourses(ApplicationDAO appDAO) {
        Instructor instructor = new Instructor("John", "NotDoe", "email@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "games");
        instructor.setInstructorDetail(instructorDetail);
        Course course = new Course("Java");
        Course course2 = new Course("Python");
        instructor.add(course, course2);
        appDAO.saveCourse(instructor);
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
        System.out.println(tempInstructor);
        ;
    }


    private void createInstructor(ApplicationDAO appDAO) {
        Instructor tempInstructor = new Instructor("John", "Doe", "youtube.com");
        InstructorDetail tempInstructorDetaul = new InstructorDetail(
                "youtube.com",
                "piano");

        tempInstructor.setInstructorDetail(tempInstructorDetaul);
        appDAO.saveCourse(tempInstructor);
    }

    private void deleteInstructor(ApplicationDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
        System.out.println("removed. ");
    }

    private void deleteCourseById(ApplicationDAO appDAO) {
        int id = 13;
        appDAO.deleteCourseById(id);
    }
}
