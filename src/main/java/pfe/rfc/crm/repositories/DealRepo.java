package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.Deal;

@Repository
public interface DealRepo extends JpaRepository<Deal,Long> {
}
