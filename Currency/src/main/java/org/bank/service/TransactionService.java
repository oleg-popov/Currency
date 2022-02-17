package org.bank.service;

import org.bank.dao.impl.TransactionDaoImpl;
import org.bank.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDaoImpl transactionDao;

    public TransactionService(TransactionDaoImpl transactionDao) {
        this.transactionDao = transactionDao;
    }
    public void addTransaction(Transaction transaction){

        transactionDao.save(transaction);
    }

}
