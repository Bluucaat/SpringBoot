package blue.crud.demo.dao;

import blue.crud.demo.entity.Instructor;

import blue.crud.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DAOImpl implements ApplicationDAO{
    private EntityManager entityManager;

    @Autowired
    public DAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public InstructorDetail findDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}
