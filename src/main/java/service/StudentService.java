package service;

import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentService extends EntityService<Student> {

    public StudentService() {
        init(Student.class);
    }

    public List<Student> findStudentsByGroupId(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT student FROM Student student WHERE student.group.id = :id")
                .setParameter("id", id);
        List<Student> result = (List<Student>) query.getResultList();
        em.close();
        return result;
    }

    public List<Student> findStudentsByCourseId(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT student FROM Student student WHERE student.course.id = :id")
                .setParameter("id", id);
        List<Student> result = (List<Student>) query.getResultList();
        em.close();
        return result;
    }
}
