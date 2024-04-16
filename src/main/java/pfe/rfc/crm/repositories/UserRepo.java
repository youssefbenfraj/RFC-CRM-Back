package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
