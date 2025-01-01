package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.Transaction;
import org.example.petwalk.services.interfaces.ITransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class TransactionRestController {

    private final ITransactionService transactionService;

    @GetMapping("/get-all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @PutMapping("/update")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/delete")
    public void deleteTransaction(@RequestBody Transaction transaction) {
        transactionService.deleteTransaction(transaction);
    }
}
