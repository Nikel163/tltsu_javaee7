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

    public T findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        T result = em.find(cl, id);
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

    public T update(T entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        T result = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public void delete(T entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        if (!em.contains(entity)) {
            return;
        }
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Integer id) {
        T entity = findById(id);
        delete(entity);
    }

    public void createNativeQuery(String query) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery(query).executeUpdate();
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
