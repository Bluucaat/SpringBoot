package blue.crud.demo.dao;

import blue.crud.demo.entity.Course;
import blue.crud.demo.entity.Instructor;
import blue.crud.demo.entity.InstructorDetail;

import java.util.List;

public interface ApplicationDAO {
    void save(Instructor instructor);

    Instructor findById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    Course findCourseById(int id);
    void updateCourse(Course course);
}
