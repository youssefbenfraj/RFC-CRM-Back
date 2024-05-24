package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.LikePost;
import pfe.rfc.crm.interfaces.ILikeService;
import pfe.rfc.crm.repositories.LikeRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeService implements ILikeService{
    private final LikeRepo likeRepo;

    @Override
    public LikePost saveLike(LikePost likePost) {
        return likeRepo.save(likePost);
    }

    @Override
    public void deleteLike(Long id) {
        likeRepo.deleteById(id);
    }

    @Override
    public LikePost getLikeById(Long id) {
        return likeRepo.findById(id).orElse(null);
    }

    @Override
    public List<LikePost> getAllLikes() {
        return likeRepo.findAll();
    }
}
