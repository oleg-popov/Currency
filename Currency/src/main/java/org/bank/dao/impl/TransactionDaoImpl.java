package org.bank.dao.impl;

import org.bank.dao.TransactionDao;
import org.bank.entity.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class TransactionDaoImpl implements TransactionDao {

    private final EntityManager em;

    public TransactionDaoImpl(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Integer save(Transaction transaction) {
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
            return transaction.getId();
        } catch (Throwable tr) {
            em.getTransaction().rollback();
            tr.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        try {
            em.getTransaction().begin();
            List<Transaction> transactions = em.createQuery("from Transaction", Transaction.class).getResultList();
            em.getTransaction().commit();
            return transactions;
        } catch (Throwable th) {
            em.getTransaction().rollback();
            th.printStackTrace();
        }
        return null;
    }

    @Override
    public Transaction findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Transaction update(Transaction data) {
        return null;
    }
}
