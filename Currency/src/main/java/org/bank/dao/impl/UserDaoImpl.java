package org.bank.dao.impl;

import org.bank.dao.UserDao;
import org.bank.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    private final EntityManager em;

    public UserDaoImpl(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Integer save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user.getId();
        } catch (Throwable tr) {
            em.getTransaction().rollback();
            tr.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            em.getTransaction().begin();
            List<User> users = em.createQuery("from User", User.class).getResultList();
            em.getTransaction().commit();
            return users;
        } catch (Throwable th) {
            em.getTransaction().rollback();
            th.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer integer) {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class , integer);
            em.getTransaction().commit();
            return user;
        } catch (Throwable th) {
            em.getTransaction().rollback();
            th.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, integer);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Throwable th) {
            em.getTransaction().rollback();
            th.printStackTrace();
        }
    }

    @Override
    public User update(User user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return user;
        } catch (Throwable throwable) {
            em.getTransaction().rollback();
            throwable.printStackTrace();
        }
        return null;
    }
}
