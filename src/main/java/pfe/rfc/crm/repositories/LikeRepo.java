package pfe.rfc.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.rfc.crm.entities.LikePost;

@Repository
public interface LikeRepo extends JpaRepository<LikePost, Long> {
    int countByPostIdPost(Long postId);
}
