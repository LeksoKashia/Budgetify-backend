package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Subscription;
import exadel.budgetify.Budgetify.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionResource {

    private final SubscriptionService subscriptionService;

    public SubscriptionResource(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription Subscription) {
        Subscription newSubscription = subscriptionService.addSubscription(Subscription);
        return new ResponseEntity<>(newSubscription, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updateSubscription = subscriptionService.updateSubscription(subscription);
        return new ResponseEntity<>(updateSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable("id") Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
