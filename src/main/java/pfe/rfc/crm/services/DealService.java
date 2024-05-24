package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IDealService;
import pfe.rfc.crm.repositories.DealRepo;
import pfe.rfc.crm.repositories.SubscriptionRepo;
import pfe.rfc.crm.repositories.UserRepo;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DealService implements IDealService {
    DealRepo dealRepo;
    UserRepo userRepo;

    @Override
    public Deal createOrUpdateDeal(Deal deal) {
        return dealRepo.save(deal);
    }

    @Override
    public List<Deal> getAllDeals() {
        return dealRepo.findAll();
    }

    @Override
    public Deal getDealById(Long id) {
        return dealRepo.findById(id).get();
    }

    @Override
    public void deleteDeal(Long id) {
        dealRepo.deleteById(id);
    }

    ///////////////////////////

    @Override
    public Deal createDealForUser(Deal deal, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        deal.setUser(user);
        return dealRepo.save(deal);
    }


    /////////////////
    private final SubscriptionRepo subscriptionRepo;

    public Map<Long, Long> getSubscriptionsCountPerDeal() {
        List<Object[]> results = subscriptionRepo.countSubscriptionsPerDeal();
        Map<Long, Long> subscriptionsCountPerDeal = new HashMap<>();
        for (Object[] result : results) {
            subscriptionsCountPerDeal.put((Long) result[0], (Long) result[1]);
        }
        return subscriptionsCountPerDeal;
    }
    public Map<Long, List<Subscription>> getSubscriptionsPerDeal() {
        List<Deal> deals = getAllDeals();
        Map<Long, List<Subscription>> subscriptionsPerDeal = new HashMap<>();
        for (Deal deal : deals) {
            List<Subscription> subscriptions = subscriptionRepo.findByDeal(deal);
            subscriptionsPerDeal.put(deal.getIdDeal(), subscriptions);
        }
        return subscriptionsPerDeal;
    }

}
