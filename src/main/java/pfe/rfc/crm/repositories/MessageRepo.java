package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.rfc.crm.entities.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
