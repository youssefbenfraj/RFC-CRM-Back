package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.LikePost;

import java.util.List;

public interface ILikeService {
    LikePost saveLike(LikePost likePost);

    void deleteLike(Long id);

    LikePost getLikeById(Long id);

    List<LikePost> getAllLikes();
}
