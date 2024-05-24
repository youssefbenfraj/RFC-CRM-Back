package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.ISubscriptionService;
import pfe.rfc.crm.repositories.SubscriptionRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService implements ISubscriptionService {
    private final SubscriptionRepo subscriptionRepo;


    public List<Subscription> getSubscriptionsByUserAndDeal(User user, Deal deal) {
        return subscriptionRepo.findByUserAndDeal(user, deal);
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepo.deleteById(id);
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepo.findAll();
    }
}
