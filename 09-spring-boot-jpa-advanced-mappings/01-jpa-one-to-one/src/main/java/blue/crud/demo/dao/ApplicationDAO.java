package blue.crud.demo.dao;

import blue.crud.demo.entity.Instructor;

public interface ApplicationDAO {
    void save(Instructor instructor);

    Instructor findById(int id);
    void deleteById(int id);
}
