package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findBymail(String mail);

    Optional<User> findByFirstName(String firstName);
}
