package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;
import pfe.rfc.crm.interfaces.IDealService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deals")
@AllArgsConstructor
@CrossOrigin
public class DealController {
    IDealService dealService;

    @GetMapping("/getAllDeals")
    public List<Deal> retrieveAllDeals() {
        return dealService.getAllDeals();
    }

    @PostMapping("/addDeal")
    public Deal addDeal(@RequestBody Deal deal) {
        return dealService.createOrUpdateDeal(deal);
    }

    @DeleteMapping("/deleteDeal/{id}")
    public void removeDeal(@PathVariable Long id) {
        dealService.deleteDeal(id);
    }

    @GetMapping("/getDealById/{id}")
    public Deal retrieveDeal(@PathVariable Long id) {
        return dealService.getDealById(id);
    }

    ////////////////////////////////
    @PostMapping("/addDeal/{userId}")
    public Deal addDeal(@RequestBody Deal deal, @PathVariable Long userId) {
        return dealService.createDealForUser(deal, userId);
    }

    @GetMapping("/subscriptions")
    public Map<Long, List<Subscription>> getSubscriptionsPerDeal() {
        return dealService.getSubscriptionsPerDeal();
    }
}
