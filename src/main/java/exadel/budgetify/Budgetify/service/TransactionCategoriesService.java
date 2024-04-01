package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.TransactionCategories;
import exadel.budgetify.Budgetify.repo.TransactionCategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionCategoriesService {

    private final TransactionCategoriesRepo transactionCategoriesRepo;

    @Autowired
    public TransactionCategoriesService(TransactionCategoriesRepo transactionCategoriesRepo) {
        this.transactionCategoriesRepo = transactionCategoriesRepo;
    }

    public TransactionCategories addTransactionCategories(TransactionCategories transactionCategories){
        return transactionCategoriesRepo.save(transactionCategories);
    }

    public List<TransactionCategories> findAllTransactionCategoriess(){
        return transactionCategoriesRepo.findAll();
    }

    public TransactionCategories updateTransactionCategories(TransactionCategories transactionCategories){
        return transactionCategoriesRepo.save(transactionCategories);
    }

    public void deleteTransactionCategories(Long id){
        transactionCategoriesRepo.deleteById(id);
    }
}
