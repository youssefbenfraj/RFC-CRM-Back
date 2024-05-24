package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat, Long> {
  /*  List<Chat> findBySenderAndReceiverOrReceiverAndSenderOrderByTimestampAsc(User sender, User receiver, User receiverAlt, User senderAlt);
    List<Chat> findBySenderOrReceiverOrderByTimestampDesc(User sender, User receiver);
*/
    List<Chat> findBySenderOrReceiver(User sender, User receiver);
    List<Chat> findBySenderAndReceiver(User sender, User receiver);

    @Query("SELECT c FROM Chat c WHERE (c.sender.idUser = :userId1 AND c.receiver.idUser = :userId2) OR (c.sender.idUser = :userId2 AND c.receiver.idUser = :userId1)")
    List<Chat> findChatByUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    Object findByReceiver(User receiver);

    Object findBySender(User sender);
}
