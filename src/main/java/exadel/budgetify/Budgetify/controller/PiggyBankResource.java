package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.PiggyBank;
import exadel.budgetify.Budgetify.service.PiggyBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piggy")
public class PiggyBankResource {

    private final PiggyBankService piggyBankService;

    public PiggyBankResource(PiggyBankService piggyBankService) {
        this.piggyBankService = piggyBankService;
    }


    @PostMapping("/add")
    public ResponseEntity<PiggyBank> addPiggyBank(@RequestBody PiggyBank PiggyBank) {
        PiggyBank newPiggyBank = piggyBankService.addPiggyBank(PiggyBank);
        return new ResponseEntity<>(newPiggyBank, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PiggyBank> updatePiggyBank(@RequestBody PiggyBank piggyBank) {
        PiggyBank updatePiggyBank = piggyBankService.updatePiggyBank(piggyBank);
        return new ResponseEntity<>(updatePiggyBank, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePiggyBank(@PathVariable("id") Long id) {
        piggyBankService.deletePiggyBank(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
