package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.Obligatory;
import exadel.budgetify.Budgetify.repo.ObligatoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObligatoryService {

    private final ObligatoryRepo obligatoryRepo;

    @Autowired
    public ObligatoryService(ObligatoryRepo obligatoryRepo) {
        this.obligatoryRepo = obligatoryRepo;
    }

    public Obligatory addObligatory(Obligatory obligatory){
        return obligatoryRepo.save(obligatory);
    }

    public List<Obligatory> findAllObligatorys(){
        return obligatoryRepo.findAll();
    }

    public Obligatory updateObligatory(Obligatory obligatory){
        return obligatoryRepo.save(obligatory);
    }

    public void deleteObligatory(Long id){
        obligatoryRepo.deleteById(id);
    }
}
