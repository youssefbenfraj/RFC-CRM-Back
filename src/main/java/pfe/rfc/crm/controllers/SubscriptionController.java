package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.services.DealService;
import pfe.rfc.crm.services.SubscriptionService;
import pfe.rfc.crm.services.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@AllArgsConstructor
@CrossOrigin
public class SubscriptionController {
    private SubscriptionService subscriptionService;
    private final UserService userService;
    private final DealService dealService;



    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping
    public ResponseEntity<?> createSubscription(@RequestParam Long dealId, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        Deal deal = dealService.getDealById(dealId);

        // Check if a subscription already exists for the given user and deal
        List<Subscription> existingSubscriptions = subscriptionService.getSubscriptionsByUserAndDeal(user, deal);
        if (!existingSubscriptions.isEmpty()) {
            return new ResponseEntity<>("User is already subscribed to this deal", HttpStatus.BAD_REQUEST);
        }

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setDeal(deal);
        subscription.setSubscriptionDate(LocalDate.now());

        return new ResponseEntity<>(subscriptionService.saveSubscription(subscription), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
}