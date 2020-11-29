package service;

import javax.persistence.*;
import java.util.List;

public abstract class EntityService<T> {

    protected final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jdbc/tltsuDB");

    private Class<T> cl;

    public void init(Class<T> cl) {
        this.cl = cl;
    }

    public List<T> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("FROM " + this.cl.getName() + " obj");
        List<T> result = (List<T>) query.getResultList();
        em.close();
        return result;
    }

    public void create(T entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void clearTable() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM " + this.cl.getName()).executeUpdate();
        em.getTransaction().commit();
    }
}
