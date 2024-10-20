package blue.crud.demo.dao;

import blue.crud.demo.entity.Instructor;
import blue.crud.demo.entity.InstructorDetail;

public interface ApplicationDAO {
    void save(Instructor instructor);

    Instructor findById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findDetailById(int id);
    void deleteInstructorDetailById(int id);
}
