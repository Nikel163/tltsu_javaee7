package service;

import entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentGroupService extends EntityService<StudentGroup> {

    public StudentGroupService() {
        init(StudentGroup.class);
    }

    public List<StudentGroup> findGroupsBySpecialtyId(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT stGroup FROM StudentGroup stGroup WHERE stGroup.specialty.id = :id")
                .setParameter("id", id);
        List<StudentGroup> result = (List<StudentGroup>) query.getResultList();
        em.close();
        return result;
    }

//    public StudentGroup findGroupWithStudentsById(Integer id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        StudentGroup result = em.find(StudentGroup.class, id);
//        result.getStudentSet().size();
//        em.getTransaction().commit();
//        em.close();
//        return result;
//    }
}
