package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Obligatory;
import exadel.budgetify.Budgetify.model.TransactionCategories;
import exadel.budgetify.Budgetify.service.TransactionCategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionCategories")
public class TransactionCategoriesResource {

    private final TransactionCategoriesService transactionCategoriesService;

    public TransactionCategoriesResource(TransactionCategoriesService transactionCategoriesService) {
        this.transactionCategoriesService = transactionCategoriesService;
    }

    @GetMapping("/allCategories")
    public ResponseEntity<List<TransactionCategories>> getAllCategories() {
        List<TransactionCategories> categories = transactionCategoriesService.findAllTransactionCategoriess();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TransactionCategories> addTransactionCategories(@RequestBody TransactionCategories TransactionCategories) {
        TransactionCategories newTransactionCategories = transactionCategoriesService.addTransactionCategories(TransactionCategories);
        return new ResponseEntity<>(newTransactionCategories, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransactionCategories(@PathVariable("id") Long id) {
        transactionCategoriesService.deleteTransactionCategories(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
