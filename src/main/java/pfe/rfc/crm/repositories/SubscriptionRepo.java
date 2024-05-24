package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.Subscription;
import pfe.rfc.crm.entities.User;

import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
    @Query("SELECT s.deal.idDeal, COUNT(s) FROM Subscription s GROUP BY s.deal.idDeal")
    List<Object[]> countSubscriptionsPerDeal();

    List<Subscription> findByDeal(Deal deal);

    List<Subscription> findByUserAndDeal(User user, Deal deal);
}
