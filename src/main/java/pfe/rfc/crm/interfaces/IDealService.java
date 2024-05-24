package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;

import java.util.List;
import java.util.Map;

public interface IDealService {
    Deal createOrUpdateDeal(Deal deal);

    List<Deal> getAllDeals();

    Deal getDealById(Long id);

    void deleteDeal(Long id);

    Deal createDealForUser(Deal deal, Long userId);

    Map<Long, List<Subscription>> getSubscriptionsPerDeal();
}
