package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Subscription;

import java.util.List;

public interface ISubscriptionService {
    Subscription saveSubscription(Subscription subscription);

    void deleteSubscription(Long id);

    Subscription getSubscriptionById(Long id);

    List<Subscription> getAllSubscriptions();
}
