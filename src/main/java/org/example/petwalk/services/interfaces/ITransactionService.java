package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactions();

    Transaction addTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Transaction transaction);
}
