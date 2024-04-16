package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Deal;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IDealService;
import pfe.rfc.crm.repositories.DealRepo;
import pfe.rfc.crm.repositories.UserRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
}
