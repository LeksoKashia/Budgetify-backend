
package exadel.budgetify.Budgetify.controller;

import exadel.budgetify.Budgetify.model.*;
import exadel.budgetify.Budgetify.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    private final AccountService accountService;

    public PaymentResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<List<PiggyBank>> getAccountPiggyBanks(@PathVariable("accountId") Long accountId) {
        List<PiggyBank> piggyBanks = accountService.getAccountPiggyBanks(accountId);
        return new ResponseEntity<>(piggyBanks, HttpStatus.OK);
    }

    @GetMapping("/accounts/transactions/{accountId}")
    public ResponseEntity<List<Transaction>> getAccountTransactions(@PathVariable("accountId") Long accountId) {
        List<Transaction> transactions = accountService.getAccountTransactions(accountId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/accounts/subscriptions/{accountId}")
    public ResponseEntity<List<Subscription>> getAccountSubscriptions(@PathVariable("accountId") Long accountId) {
        List<Subscription> subscriptions = accountService.getAccountSubscriptions(accountId);
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @GetMapping("/accounts/obligatories/{accountId}")
    public ResponseEntity<List<Obligatory>> getAccountObligatories(@PathVariable("accountId") Long accountId) {
        List<Obligatory> obligatories = accountService.getAccountObligatories(accountId);
        return new ResponseEntity<>(obligatories, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account Account) {
        Account newAccount = accountService.addAccount(Account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account updateAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    
}
