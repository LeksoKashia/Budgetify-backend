
package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.exception.UserNotFoundException;
import exadel.budgetify.Budgetify.model.*;
import exadel.budgetify.Budgetify.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    public List<Transaction> getAccountTransactions(Long accountId) {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account.getTransactions();
        } else {
            throw new UserNotFoundException("Account not found with id: " + accountId);
        }
    }
    public List<PiggyBank> getAccountPiggyBanks(Long accountId) {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account.getPiggyBanks();
        } else {
            throw new UserNotFoundException("Account not found with id: " + accountId);
        }
    }

    public List<Subscription> getAccountSubscriptions(Long accountId) {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account.getSubscriptions();
        } else {
            throw new UserNotFoundException("Account not found with id: " + accountId);
        }
    }

    public List<Obligatory> getAccountObligatories(Long accountId) {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account.getObligatories();
        } else {
            throw new UserNotFoundException("Account not found with id: " + accountId);
        }
    }

    public List<Category> getAccountCategories(Long accountId) {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account.getCategories();
        } else {
            throw new UserNotFoundException("Account not found with id: " + accountId);
        }
    }

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account addAccount(Account account){
        return accountRepo.save(account);
    }

    public List<Account> findAllAccounts(){
        return accountRepo.findAll();
    }

    public Account updateAccount(Account account){
        return accountRepo.save(account);
    }

    public void deleteAccount(Long id){
        accountRepo.deleteById(id);
    }

}
