package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.Chat;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
}
