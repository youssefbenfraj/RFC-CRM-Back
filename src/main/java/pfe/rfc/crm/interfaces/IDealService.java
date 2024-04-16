package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Deal;

import java.util.List;

public interface IDealService {
    Deal createOrUpdateDeal(Deal deal);

    List<Deal> getAllDeals();

    Deal getDealById(Long id);

    void deleteDeal(Long id);

    Deal createDealForUser(Deal deal, Long userId);
}
