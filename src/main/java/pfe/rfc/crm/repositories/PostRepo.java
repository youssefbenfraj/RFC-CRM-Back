package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {


    List<Post> findByUser(User user);
}
