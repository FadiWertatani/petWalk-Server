package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.Transaction;
import org.example.petwalk.repository.ITransactionRepo;
import org.example.petwalk.services.interfaces.ITransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionImpl implements ITransactionService {

    private final ITransactionRepo transactionRepo;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction existingTransaction = transactionRepo.findById(transaction.getId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        existingTransaction.setMontant(transaction.getMontant());
        existingTransaction.setModePaiement(transaction.getModePaiement());
        existingTransaction.setTimestamp(transaction.getTimestamp());
        existingTransaction.setReservation(transaction.getReservation());
        return transactionRepo.save(existingTransaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        Transaction existingTransaction = transactionRepo.findById(transaction.getId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactionRepo.delete(existingTransaction);
    }
}
