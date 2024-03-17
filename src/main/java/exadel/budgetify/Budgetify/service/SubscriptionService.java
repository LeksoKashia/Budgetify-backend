package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.Subscription;
import exadel.budgetify.Budgetify.repo.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    @Autowired
    public SubscriptionService(SubscriptionRepo subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }

    public Subscription addSubscription(Subscription subscription){
        return subscriptionRepo.save(subscription);
    }

    public List<Subscription> findAllSubscriptions(){
        return subscriptionRepo.findAll();
    }

    public Subscription updateSubscription(Subscription subscription){
        return subscriptionRepo.save(subscription);
    }

    public void deleteSubscription(Long id){
        subscriptionRepo.deleteById(id);
    }
}
