package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.Transaction;
import exadel.budgetify.Budgetify.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Transaction addTransaction(Transaction transaction){
        return transactionRepo.save(transaction);
    }

    public List<Transaction> findAllTransactions(){
        return transactionRepo.findAll();
    }

    public Transaction updateTransaction(Transaction transaction){
        return transactionRepo.save(transaction);
    }

    public void deleteTransaction(Long id){
        transactionRepo.deleteById(id);
    }
}
