package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Transaction;
import exadel.budgetify.Budgetify.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {

    private final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction Transaction) {
        Transaction newTransaction = transactionService.addTransaction(Transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        Transaction updateTransaction = transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(updateTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
