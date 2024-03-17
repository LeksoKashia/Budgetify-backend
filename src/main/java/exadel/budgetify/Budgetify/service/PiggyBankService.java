package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.PiggyBank;
import exadel.budgetify.Budgetify.repo.PiggyBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiggyBankService {

    private final PiggyBankRepo piggyBankRepo;

    @Autowired
    public PiggyBankService(PiggyBankRepo piggyBankRepo) {
        this.piggyBankRepo = piggyBankRepo;
    }

    public PiggyBank addPiggyBank(PiggyBank piggyBank){
        return piggyBankRepo.save(piggyBank);
    }

    public List<PiggyBank> findAllPiggyBanks(){
        return piggyBankRepo.findAll();
    }

    public PiggyBank updatePiggyBank(PiggyBank piggyBank){
        return piggyBankRepo.save(piggyBank);
    }

    public void deletePiggyBank(Long id){
        piggyBankRepo.deleteById(id);
    }
}
