package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Post;

import java.util.List;

public interface IPostService {
    Post createOrUpdatePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void deletePost(Long id);

    Post createPostForUser(Post post, Long userId);

    List<Post> getPostsByUserId(Long userId);
}
