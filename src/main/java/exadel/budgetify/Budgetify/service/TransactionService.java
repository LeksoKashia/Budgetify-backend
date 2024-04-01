package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.exception.UserNotFoundException;
import exadel.budgetify.Budgetify.model.Account;
import exadel.budgetify.Budgetify.model.Image;
import exadel.budgetify.Budgetify.model.Transaction;
import exadel.budgetify.Budgetify.model.TransactionCategories;
import exadel.budgetify.Budgetify.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    public List<TransactionCategories> getTransactionCategories(Long transactionId) {
        Optional<Transaction> optionalAccount = transactionRepo.findById(transactionId);
        if (optionalAccount.isPresent()) {
            Transaction transaction = optionalAccount.get();
            return transaction.getTransactionCategories();
        } else {
            throw new UserNotFoundException("Transaction not found with id: " + transactionId);
        }
    }

    public List<Image> getImages(Long transactionId) {
        Optional<Transaction> optionalAccount = transactionRepo.findById(transactionId);
        if (optionalAccount.isPresent()) {
            Transaction transaction = optionalAccount.get();
            return transaction.getImages();
        } else {
            throw new UserNotFoundException("Transaction not found with id: " + transactionId);
        }
    }

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
