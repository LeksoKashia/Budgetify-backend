package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Obligatory;
import exadel.budgetify.Budgetify.service.ObligatoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obligatory")
public class ObligatoryResource {

    private final ObligatoryService obligatoryService;

    public ObligatoryResource(ObligatoryService obligatoryService) {
        this.obligatoryService = obligatoryService;
    }


    @PostMapping("/add")
    public ResponseEntity<Obligatory> addObligatory(@RequestBody Obligatory Obligatory) {
        Obligatory newObligatory = obligatoryService.addObligatory(Obligatory);
        return new ResponseEntity<>(newObligatory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Obligatory> updateObligatory(@RequestBody Obligatory obligatory) {
        Obligatory updateObligatory = obligatoryService.updateObligatory(obligatory);
        return new ResponseEntity<>(updateObligatory, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteObligatory(@PathVariable("id") Long id) {
        obligatoryService.deleteObligatory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
